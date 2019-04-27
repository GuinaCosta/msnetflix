package com.edu.fiap.catalogservice.controller;

import com.edu.fiap.catalogservice.facade.CatalogServiceFacade;
import com.edu.fiap.catalogservice.model.request.CatalogRequest;
import com.edu.fiap.catalogservice.model.response.CatalogResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@RestController(ControllerConstants.SERVICE_URL_PREFIX)
public class CatalogServiceController {

    /**
     * service facade
     * */
    @Autowired
    private CatalogServiceFacade catalogServiceFacade;

    /**
     * Saves
     **/
    @PostMapping()
    public CatalogResponse create(@Valid @NotNull @RequestBody CatalogRequest catalogItemRequest) {
        return catalogServiceFacade.saveCatalog(catalogItemRequest);
    }
}
