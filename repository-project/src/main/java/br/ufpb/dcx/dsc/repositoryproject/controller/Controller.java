package br.ufpb.dcx.dsc.repositoryproject.controller;

import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import br.ufpb.dcx.dsc.repositoryproject.DTO.DTO;
import br.ufpb.dcx.dsc.repositoryproject.models.Repository;
import br.ufpb.dcx.dsc.repositoryproject.services.Service;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path="/api")
public class Controller {

    private final ModelMapper modelMapper;
    private final Services Services;

    public Controller(Services Services, ModelMapper modelMapper) {
        this.Services = Services;
        this.modelMapper = modelMapper;
    }
    
    @GetMapping("/repositories")
    public List<DTO> getFilteredRepository(@RequestParam(name ="idf", required = false) Long id){
        List<Repository> repositories = Services.listRepositorys(id);
        return repositories.stream().map(repository -> convertToDTO(repository)).collect(Collectors.toList());
    }

    @PostMapping("/repositories")
    public DTO createRepository(@RequestBody DTO DTO){
        Repository f = convertToEntity(DTO);
        Repository repositoryCreated = Services.saveRepository(f);
        return convertToDTO(repositoryCreatedCreated);
    }

    @PutMapping("/repositories/{id}")
    public DTO updateRepository(@PathVariable Long id, @RequestBody DTO DTO){
        Repository f = convertToEntity(DTO);
        Repository updateRepository = Services.updateRepository(id, f);
        return convertToDTO(updateRepository);
    }

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("/repositories/{id}")
    public void deleteRepository(@PathVariable Long id){
        Services.deleteRepository(id);
    }

    private DTO convertToDTO(Repository f){
        return modelMapper.map(f, DTO.class);
    }

    private Repository convertToEntity(DTO DTO){
        return modelMapper.map(DTO, Repository.class);
    }

}