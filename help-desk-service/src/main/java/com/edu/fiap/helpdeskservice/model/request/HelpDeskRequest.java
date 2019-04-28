package com.edu.fiap.helpdeskservice.model.request;

import java.io.Serializable;

/**
 * Request para cadastro de registro de Help Desk
 */
public class HelpDeskRequest implements Serializable {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;

    /**
     * ID do ususário
     */
    private Integer usuarioId;

    /**
     * Descrição do chamado de Help Desk
     */
    private String descricao;

    public Integer getUsuarioId(){
        return usuarioId;
    }
    public void setUsuarioId(Integer usuarioId){
        this.usuarioId = usuarioId;
    }

    public String getDescricao(){
        return descricao;
    }

    public void setDescricao(String descricao){
        this.descricao = descricao;
    }
}
