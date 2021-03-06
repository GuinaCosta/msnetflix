package com.edu.fiap.catalogsearchservice.controller;

import com.edu.fiap.catalogsearchservice.facade.CatalogSearchFacade;
import com.edu.fiap.catalogsearchservice.model.response.CatalogResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.List;

/**
 * Controller para gerenciar rotas de busca
 *
 * @author agnaldo.almeida
 * */
@RestController
@RequestMapping("catalog/search")
public class CatalogController {

    /**
     * Catalog Search Facade
     **/
    @Autowired
    private CatalogSearchFacade catalogSearchFacade;
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private EurekaClient discoveryClient;
    /**
     * Buscar itens do católogo pelo gênero
     *
     * @param genre nome do gênero para ser buscado
     *
     * @return Lista de filmes com o gênero
     */
    @GetMapping("genre/{genre}")
    public List<CatalogResponse> getByGenre(@PathVariable String genre) {
        return catalogSearchFacade.getCatalogsByGenre(genre);
    }

    /**
     * Buscar itens do católogo pelo gênero
     *
     * @param keyword nome do gênero para ser buscado
     *
     * @return Lista de filmes com o gênero
     */
    @GetMapping("keyword/{keyword}")
    public List<CatalogResponse> getByKeyword(@PathVariable String keyword) {
        return catalogSearchFacade.getByKeyword(keyword);
    }

    /**
     * Buscar itens do católogo pelo gênero
     *
     * @param category nome do gênero para ser buscado
     *
     * @return Lista de filmes com o gênero
     */
    @GetMapping("mostwatched/categoy/{category}")
    public List<CatalogResponse> getMostWatchedByCategory(@PathVariable String category) {
        return catalogSearchFacade.getMostWatchedByCategory(category);
    }

    /**
     * Buscar itens do católogo pelo gênero
     *
     * @param genre nome do gênero para ser buscado
     *
     * @return Lista de filmes com o gênero
     */
    @GetMapping("mostwatched/genre/{genre}")
    public List<CatalogResponse> getMostWatchedByGenre(@PathVariable String genre) {
        return catalogSearchFacade.getMostWatchedByGenre(genre);
    }

    /**
     * Retorna detalhes de um filme do catálogo pelo Id
     * @param id Id do filme
     * @return detalhes do filme
     */
    @GetMapping("detail/{id}")
    public String getDetail(@PathVariable Integer id) {
        String eurekaServiceUrl =  serviceUrl("CATALOG-SERVICE") + "/catalog/{id}";
        String response = restTemplate.exchange(eurekaServiceUrl, HttpMethod.GET, null, new ParameterizedTypeReference<String>() {
        }, id).getBody();
        return response;
    }

    @Bean
    @LoadBalanced
    private RestTemplate restTemplate() {
        return new RestTemplate();
    }

    /**
     * Obtêm a URL de um serviço através do Eureka Server
     * @param serviceName Nome do serviço
     * @return URL do serviço
     */
    private String serviceUrl(String serviceName) {
        InstanceInfo instance = discoveryClient.getNextServerFromEureka(serviceName, false);
        return "http://" + instance.getInstanceId().replace("localhost:", "");
    }

}
