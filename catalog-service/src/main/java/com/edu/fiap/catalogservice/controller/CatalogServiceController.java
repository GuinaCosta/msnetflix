package com.edu.fiap.catalogservice.controller;

import com.edu.fiap.catalogservice.facade.CatalogServiceFacade;
import com.edu.fiap.catalogservice.model.request.CatalogRequest;
import com.edu.fiap.catalogservice.model.response.CatalogResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity createCatalog(@Valid @NotNull @RequestBody CatalogRequest catalogItemRequest) {
        return new ResponseEntity(catalogServiceFacade.saveCatalog(catalogItemRequest), HttpStatus.OK);
    }

    /**
     * Gets the catalog by its name
     **/
    @GetMapping(ControllerConstants.SERVICE_URL_BY_NAME + "/{name}")
    public ResponseEntity getCatalogsByName(@PathVariable String name) {
        List<CatalogResponse> catalogResponseList = catalogServiceFacade.getCatalogs(name);

        if (catalogResponseList != null && catalogResponseList.size() > 0) {
            return new ResponseEntity(catalogResponseList, HttpStatus.OK);
        }
        else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Gets the catalog by its id
     **/
    @GetMapping("/{id}")
    public ResponseEntity getCatalogsById(@PathVariable Integer id) {
        CatalogResponse catalogResponse = catalogServiceFacade.getCatalog(id);

        if (catalogResponse != null) {
            return new ResponseEntity(catalogResponse, HttpStatus.OK);
        }
        else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

    /**
     * deletes the catalog by its id
     **/
    @DeleteMapping("{id}")
    public void deleteCatalog(@PathVariable Integer id) {
        catalogServiceFacade.deleteCatalog(id);
    }
}
