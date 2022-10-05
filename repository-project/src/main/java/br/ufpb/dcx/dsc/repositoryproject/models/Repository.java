package br.ufpb.dcx.dsc.repositoryproject.models;

import java.time.LocalDateTime;

public class Repository {

    private String nome;
    private Long userId;

    private String privacidade;


    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    private LocalDateTime deadline;
    private final Long id;

    private static Long IdSequenceCounter = 0L;

    public Repository(Long userId, String nome, String privacidade, LocalDateTime deadline){
        this.userId = userId;
        this.nome = nome;
        this.privacidade = privacidade;
        this.deadline = deadline;
        this.id = Repository.IdSequenceCounter++;

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDateTime getDeadline() {
        return deadline;
    }

    public void setDeadline(LocalDateTime deadline) {
        this.deadline = deadline;
    }

    public Long getId() {
        return id;
    }

    public String getPrivacidade() {
        return privacidade;
    }

    public void setPrivacidade(String privacidade) {
        this.privacidade = privacidade;
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