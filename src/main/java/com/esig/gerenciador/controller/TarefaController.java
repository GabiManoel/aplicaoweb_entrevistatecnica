package com.esig.gerenciador.controller;


import com.esig.gerenciador.model.Tarefa;
import com.esig.gerenciador.service.TarefaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/gerenciadortarefa/tarefa")
@CrossOrigin(origins = "*")
public class TarefaController {

    @Autowired
    private TarefaService tarefaService;

    @PostMapping("/save")
    public String save (@RequestBody Tarefa tarefa ){

        return tarefaService.save(tarefa);

    }

    @PutMapping("/update")
    public void update(@RequestBody Tarefa tarefa){
        tarefaService.update(tarefa);
    }

    @GetMapping("/findAll")
    public List<Tarefa> findAll(){
        return tarefaService.findAll();
    }

    @GetMapping("/findByIdList/{id}")
    public  List<Optional<Tarefa>> findByIdList (@PathVariable Long id){
        return  tarefaService.findByIdList(id);
    }

    @GetMapping("/findById/{id}")
    public Tarefa TarefafindById(@PathVariable Long id){
        return  tarefaService.findById(id);
    }

    @GetMapping ("/findByTitleOrDescription/{titleOrdescription}")
    public List<Tarefa> findByTitleOrDescription(@PathVariable String titleOrdescription){
        return tarefaService.findByTitleOrDescriptionLineLimit(titleOrdescription);
    }

    @GetMapping ("/findByResponsavel/{id}")
    public List<Tarefa> findByResponsavel(@PathVariable Long id){
        return tarefaService.findByResponsavel(id);
    }

    @GetMapping ("/findBySituacaoLineLimit/{situacao}")
    public List<Tarefa> findBySituacao (@PathVariable String  situacao){
        return tarefaService.findBySituacaoNaoConcluida(situacao);
    }


    @GetMapping("/findAllConcluidas")
    public List<Tarefa> findAllConcluidas(){
        return tarefaService.findAllConcluida();
    }

    @GetMapping("/deleteById/{id}")
    public void  deleteById(@PathVariable Long id){
        tarefaService.deleteById(id);
    }


    @GetMapping("/setSituacao/{id}")
    public void setSituacao(@PathVariable Long id){
        tarefaService.setSituacao(id);
    }


}
