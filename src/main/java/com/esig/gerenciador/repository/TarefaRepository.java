package com.esig.gerenciador.repository;


import com.esig.gerenciador.model.Prioridade;
import com.esig.gerenciador.model.Responsavel;
import com.esig.gerenciador.model.Situacao;
import com.esig.gerenciador.model.Tarefa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface TarefaRepository extends JpaRepository<Tarefa , Long> {


    @Query(value = "SELECT * FROM tarefas  WHERE titulo = ?1 or descricao = ?1 " , nativeQuery = true)
    List<Tarefa> findByTitleOrDescription(String titleOrString);

    @Query(value = "SELECT * FROM tarefas where responsavel = ?1" , nativeQuery = true)
    List<Tarefa> findByResponsavel(Long id);

    @Query(value = "SELECT * FROM tarefas  WHERE situacao = ?1" , nativeQuery = true)
    List<Tarefa> findBySituacao(String situacao);



}
