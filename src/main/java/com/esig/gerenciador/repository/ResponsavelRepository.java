package com.esig.gerenciador.repository;


import com.esig.gerenciador.model.Responsavel;
import com.esig.gerenciador.model.Tarefa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ResponsavelRepository  extends JpaRepository<Responsavel , Long> {


    @Query(value = "select nome from responsaveis where id = ?1" , nativeQuery = true)
    String getNome(Long id);

}
