package com.edu.fiap.catalogservice.model.response;

import java.io.Serializable;

/**
 * Catalog Response Class for endpoints
 *
 * @author agnaldo.almeida
 **/
public class CatalogResponse implements Serializable {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;

    /** The catalog id */
    private Integer catalogId;

    public Integer getCatalogId() {
        return catalogId;
    }

    public void setCatalogId(Integer catalogId) {
        this.catalogId = catalogId;
    }

    /**
     * Cto of CatalogResponse
     * */
    public CatalogResponse(Integer catalogId) {
        this.catalogId = catalogId;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("CatalogResponse{");
        sb.append("catalogId=").append(catalogId);
        sb.append('}');
        return sb.toString();
    }
}
