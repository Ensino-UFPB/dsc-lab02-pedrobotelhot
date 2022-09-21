package br.ufpb.dcx.dsc.repositoryproject.services;


import br.ufpb.dcx.dsc.repositoryproject.models.Repository;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

@org.springframework.stereotype.Service
public class Service {


    private final List<Repository> repositoryList = Arrays.asList(
            new Repository(1L, "Pedro", "público", LocalDateTime.now()),
            new Repository(1L, "Carlos","privado", LocalDateTime.now()),
            new Repository(2L, "Henrique", "público", LocalDateTime.now()),
            new Repository(2L, "João", "privado", LocalDateTime.now())
    );

    private int getRepositoryIndexByID(Long id){
        for (int i = 0; i < repositoryList.size(); i++){
            Repository f = repositoryList.get(i);
            if (repositoryList.get(i).getId().equals(id))
                return i;
        }
        throw new NoSuchElementException("Repository Not Found!");
    }

    public Repository getRepository(Long id){
        int index = this.getRepositoryIndexByID(id);
        return repositoryList.get(index);
    }

    public List<Repository> listRepositorys(Long id){
        if (id != null){
            return repositoryList.stream()
                    .filter(repository -> Objects.equals(repository.getId(), id))
                    .collect(Collectors.toList());
        } else {
            return repositoryList;
        }
    }

    public Repository saveRepository(Repository f){
        repositoryList.add(f);
        return f;
    }

    public void deleteRepository(Long id){
        int index = this.getRepositoryIndexByID(id);
        if (index == -1)
            return;
        repositoryList.remove(index);
    }

    public Repository updateRepository(Long id, Repository f){
        int index = this.getRepositoryIndexByID(id);
        Repository toUpdate = repositoryList.get(index);
        toUpdate.setPrivacidade(f.getPrivacidade());
        toUpdate.setNome(f.getNome());
        return toUpdate;
    }

}

