package com.esig.gerenciador.model;


import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "tarefas")
public class Tarefa {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String titulo;


    @Column(columnDefinition="text" , nullable = false)
    private String descricao;

    @JoinColumn(name="responsavel")
    @OneToOne (cascade = CascadeType.MERGE)
    private Responsavel responsavel;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Situacao situacao;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Prioridade prioridade;

    @Column(nullable = false)
    private LocalDate deadline;



}
