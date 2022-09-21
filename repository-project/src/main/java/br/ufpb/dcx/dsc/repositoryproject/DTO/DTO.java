package br.ufpb.dcx.dsc.repositoryproject.DTO;

import com.fasterxml.jackson.annotation.JsonFormat;


public class DTO {

    private String nome;
    private String privacidade;
    private Long userId;
    private Long id;

    public DTO(String nome, String privacidade, Long userId, Long id) {
        this.nome = nome;
        this.privacidade = privacidade;
        this.userId = userId;
        this.id = id;
    }

    public DTO(String nome, String privacidade, Long userId) {
        this.nome = nome;
        this.privacidade = privacidade;
        this.userId = userId;
    }

    public DTO() {

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getPrivacidade() {
        return privacidade;
    }

    public void setPrivacidade(String privacidade) {
        this.privacidade = privacidade;
    }

    public Long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "RepositoryDTO{" +
                "nome='" + nome + '\'' +
                ", privacidade='" + privacidade + '\'' +
                ", userId=" + userId +
                ", repositoryId=" + id +
                '}';
    }
}
