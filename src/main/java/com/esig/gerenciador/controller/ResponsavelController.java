package com.esig.gerenciador.controller;


import com.esig.gerenciador.model.Responsavel;
import com.esig.gerenciador.model.Tarefa;
import com.esig.gerenciador.repository.ResponsavelRepository;
import com.esig.gerenciador.service.ResponsavelService;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/gerenciadortarefa/responsavel")
@CrossOrigin(origins = "*")
public class ResponsavelController {

    @Autowired
    private ResponsavelService responsavelService;

    @PostMapping("/save")
    public String save (@RequestBody Responsavel responsavel){

        return responsavelService.save(responsavel);

    }


    @GetMapping("/findAll")
    public List<Responsavel> findAll(){
        return responsavelService.findAll();
    }

    @GetMapping("/getName/{id}")
    public String getNome(@PathVariable Long id){

       return responsavelService.getNome(id);
    }


    @GetMapping("/deleteById/{id}")
    public  void deleteById(@PathVariable Long id){
        responsavelService.deleteById(id);
    }

    @PutMapping("/update")
    public void update(@RequestBody Responsavel responsavel){
        responsavelService.update(responsavel);
    }

}
