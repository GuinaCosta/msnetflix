package com.edu.fiap.catalogservice.controller;

import com.edu.fiap.catalogservice.facade.CatalogServiceFacade;
import com.edu.fiap.catalogservice.model.request.CatalogRequest;
import com.edu.fiap.catalogservice.model.response.CatalogResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@RestController()
@RequestMapping(ControllerConstants.SERVICE_URL_PREFIX)
public class CatalogServiceController {

    /**
     * service facade
     * */
    @Autowired
    private CatalogServiceFacade catalogServiceFacade;

    /**
     * Saves the catalog item
     * @param catalogItemRequest request object with catalog data
     * @return the new catalog id
     **/
    @PostMapping()
    public CatalogResponse createCatalog(@Valid @NotNull @RequestBody CatalogRequest catalogItemRequest) {
        return catalogServiceFacade.saveCatalog(catalogItemRequest);
    }

    /**
     * Gets the catalog by its name
     **/
    @GetMapping(ControllerConstants.SERVICE_URL_BY_NAME + "/{name}")
    public List<CatalogResponse> getCatalogsByName(@PathVariable String name) {
        return catalogServiceFacade.getCatalogs(name);
    }

    /**
     * Gets the catalog by its id
     **/
    @GetMapping("/{id}")
    public CatalogResponse getCatalogsByName(@PathVariable Integer id) {
        return catalogServiceFacade.getCatalog(id);
    }

    /**
     * deletes the catalog by its id
     **/
    @DeleteMapping("{id}")
    public void deleteCatalog(@PathVariable Integer id) {
        catalogServiceFacade.deleteCatalog(id);
    }
}
