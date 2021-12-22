package com.esig.gerenciador.service;


import com.esig.gerenciador.model.Responsavel;
import com.esig.gerenciador.model.Tarefa;
import com.esig.gerenciador.repository.ResponsavelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResponsavelService {

    @Autowired
    private ResponsavelRepository responsavelRepository;

    public String save(Responsavel responsavel){

        responsavelRepository.save(responsavel);
        return "Responsavel Criado com Sucesso!";
    }


    public List<Responsavel> findAll(){
        return responsavelRepository.findAll();
    }


    public  String getNome(Long id){
        return  responsavelRepository.getNome(id);
    }

    public void deleteById(Long id){
        responsavelRepository.deleteById(id);
    }


    public void update(Responsavel responsavel){
        responsavelRepository.save(responsavel);
    }

}
