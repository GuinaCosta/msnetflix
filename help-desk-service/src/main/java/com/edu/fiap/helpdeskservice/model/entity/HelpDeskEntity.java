package com.edu.fiap.helpdeskservice.model.entity;

import com.edu.fiap.helpdeskservice.model.request.HelpDeskRequest;

import javax.persistence.*;
import java.time.DateTimeException;
import java.util.Date;

@Table(name = "tbHelpDesk")
@Entity(name = "tbHelpDesk")
public class HelpDeskEntity {
    /**
     * ID do chamado de Help Desk
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    /**
     * ID do usuário que criou o chamado de Help Desk
     */
    @Column(name = "usuario_id")
    private Integer usuarioId;

    /**
     * Data de criação do chamado
     */
    @Column(name = "dataCriacao")
    private Date dataCriacao;
    /**
     * Data de conclusão do chamado
     */
    @Column(name = "dataConclusao")
    private Date dataConclusao;

    /**
     * Descrição do problema
     */
    @Column(name = "descricao")
    private String descricao;

    /**
     * Solução para o problema
     */
    @Column(name = "solucao")
    private String solucao;

    public Integer getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Integer usuarioId) {
        this.usuarioId = usuarioId;
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

    @Override
    @SuppressWarnings("Duplicates")
    public String toString(){
        final StringBuilder sb = new StringBuilder("HelpDeskEntity{");
        sb.append("id=").append(id);
        sb.append(", usuarioId=").append(usuarioId);
        sb.append(", dataCriacao=").append(dataCriacao);
        sb.append(", dataConclusao=").append(dataConclusao);
        sb.append(", descricao='").append(descricao).append('\'');
        sb.append(", solucao='").append(solucao).append('\'');
        sb.append('}');
        return sb.toString();
    }

    @SuppressWarnings("Duplicates")
    public static HelpDeskEntity createFromHelpDeskRequest(HelpDeskRequest helpDeskRequest){
        HelpDeskEntity helpDeskEntity = new HelpDeskEntity();

        helpDeskEntity.setUsuarioId(helpDeskRequest.getUsuarioId());
        helpDeskEntity.setDescricao(helpDeskRequest.getDescricao());
        helpDeskEntity.setDataCriacao(new Date());
        return helpDeskEntity;
    }

}
