package com.tech.m2s10.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name = "REVISORES")
public class Revisor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nome;
    private Double salario;
    private String nivelCargo;
    private Long idUsuario;

    public Revisor(String nome, Double salario, String nivelCargo, Long idUsuario) {
        this.nome = nome;
        this.salario = salario;
        this.nivelCargo = nivelCargo;
        this.idUsuario = idUsuario;
    }
}
