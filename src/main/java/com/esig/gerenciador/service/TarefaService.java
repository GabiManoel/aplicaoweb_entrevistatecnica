package com.esig.gerenciador.service;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esig.gerenciador.model.Situacao;
import com.esig.gerenciador.model.Tarefa;
import com.esig.gerenciador.repository.ResponsavelRepository;
import com.esig.gerenciador.repository.TarefaRepository;

@Service
public class TarefaService {

    @Autowired
    private TarefaRepository tarefaRepository;

    @Autowired
    private ResponsavelRepository responsavelRepository;

    public String save(Tarefa tarefa){

        tarefa.setSituacao(Situacao.EM_ANDAMENTO);

        tarefaRepository.save(tarefa);


        return "Tarefa cadastrada com Sucesso!";

    }

    public List<Tarefa> findAll(){

        List<Tarefa> tarefasNaoConcluidas = new ArrayList<>();

        for(Tarefa t : tarefaRepository.findAll()){
            if (t.getSituacao().equals(Situacao.EM_ANDAMENTO)){
                tarefasNaoConcluidas.add(t);
            }
        }

        return  tarefasNaoConcluidas;
    }

    public List<Optional<Tarefa>> findByIdList(Long id){

        List<Optional<Tarefa>> tarefa = new ArrayList<>();

        tarefa.add(tarefaRepository.findById(id));

        return  tarefa;

    }

    public Tarefa findById(Long id){
        return tarefaRepository.findById(id).get();
    }

    public List<Tarefa> findByTitleOrDescriptionLineLimit(String titleOrString){
        return  tarefaRepository.findByTitleOrDescription( titleOrString);
    }

    public List<Tarefa> findByResponsavel(Long id){
        return  tarefaRepository.findByResponsavel(id);
    }

    public List<Tarefa> findBySituacaoNaoConcluida(String situacao){
        return  tarefaRepository.findBySituacao(situacao);
    }

    public List<Tarefa> findAllConcluida(){

        List<Tarefa> tarefasConcluidas = new ArrayList<>();

        for(Tarefa t : tarefaRepository.findAll()){
            if (!t.getSituacao().equals(Situacao.EM_ANDAMENTO)){
                tarefasConcluidas.add(t);
            }
        }

        return  tarefasConcluidas;

    }

    public void  deleteById(Long id){
        tarefaRepository.deleteById(id);
    }

    public void update (Tarefa tarefa){

        tarefaRepository.save(tarefa);
    }

    public void setSituacao(Long id){
        Tarefa tarefa = findById(id);

        tarefa.setSituacao(Situacao.CONCLUIDA);

        update(tarefa);

    }





}
