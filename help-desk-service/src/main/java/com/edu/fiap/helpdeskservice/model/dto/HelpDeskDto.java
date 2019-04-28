package com.edu.fiap.helpdeskservice.model.dto;

import java.util.Date;

public class HelpDeskDto {
    /**
     * ID do chamado de Help Desk
     */
    private Integer id;

    /**
     * ID do usuário que criou o chamado de Help Desk
     */
    private Integer usuario_id;

    /**
     * Data de criação do chamado
     */
    private Date dataCriacao;
    /**
     * Data de conclusão do chamado
     */
    private Date dataConclusao;

    /**
     * Descrição do problema
     */
    private String descricao;

    /**
     * Solução para o problema
     */
    private String solucao;

    public Integer getUsuarioId() {
        return usuario_id;
    }

    public void setUsuarioId(Integer usuario_id) {
        this.usuario_id = usuario_id;
    }

    public Date getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(Date dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getSolucao() {
        return solucao;
    }

    public void setSolucao(String solucao) {
        this.solucao = solucao;
    }

    public Date getDataConclusao() {
        return dataCriacao;
    }

    public void setDataConclusao(Date dataConclusao) {
        this.dataConclusao = dataConclusao;
    }
}
