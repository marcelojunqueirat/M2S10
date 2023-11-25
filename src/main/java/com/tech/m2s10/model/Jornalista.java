package com.tech.m2s10.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
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

    @ManyToOne
    @JoinColumn(name = "ID_USUARIO", referencedColumnName = "ID")
    private Usuario idUsuario;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST, mappedBy = "idJornalista")
    private List<Noticia> noticias;
}
