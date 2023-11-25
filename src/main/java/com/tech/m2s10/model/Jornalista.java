package com.tech.m2s10.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name = "JORNALISTAS")
public class Jornalista {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nome;
    private Double salario;
    private String nivelCargo;
    private Integer numeroPublicacoes;
    private Long idUsuario;

    public Jornalista(String nome, Double salario, String nivelCargo, Integer numeroPublicacoes, Long idUsuario) {
        this.nome = nome;
        this.salario = salario;
        this.nivelCargo = nivelCargo;
        this.numeroPublicacoes = numeroPublicacoes;
        this.idUsuario = idUsuario;
    }

    public Jornalista(Long id, String nome, Double salario, String nivelCargo, Integer numeroPublicacoes, Long idUsuario) {
        this.id = id;
        this.nome = nome;
        this.salario = salario;
        this.nivelCargo = nivelCargo;
        this.numeroPublicacoes = numeroPublicacoes;
        this.idUsuario = idUsuario;
    }
}
