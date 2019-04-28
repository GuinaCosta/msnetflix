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
    private Integer usuario_id;

    /**
     * Descrição do chamado de Help Desk
     */
    private String descricao;

    public Integer getUsuarioId(){
        return usuario_id;
    }
    public void setUsuarioId(Integer usuario_Id){
        this.usuario_id = usuario_Id;
    }

    public String getDescricao(){
        return descricao;
    }

    public void setDescricao(String descricao){
        this.descricao = descricao;
    }
}
