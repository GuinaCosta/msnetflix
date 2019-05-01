package com.edu.fiap.watchlistservice.config;

import com.google.common.base.Predicates;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

/**
 * Classe de configuração do Swagger
 **/
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
            .select()
            .apis(RequestHandlerSelectors.any())
            .paths(Predicates.not(PathSelectors.regex("/error.*")))
            .build()
            .apiInfo(apiInfo())
            .useDefaultResponseMessages(false);
    }

    /**
     * Api Info
     * @return A new ApiInfo
     */
    private ApiInfo apiInfo() {
        return new ApiInfo(
                "Watchlist Service",
                "API para gerenciamento da lista de títulos para assistir",
                "API 1.0.0",
                "Terms of service",
                new Contact("Agnaldo Costa", "www.fiap.com.br", "guinacosta1991@gmail.com"),
                "MIT", "https://gitlab.com/LFrigoDeSouza/msnetflix/blob/master/LICENSE",
                Collections.emptyList());
    }
}
