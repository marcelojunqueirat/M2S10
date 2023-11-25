package com.tech.m2s10.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "REVISORES")
public class Revisor {
    //id, id_usuario, nome, salario, nível de cargo (String).

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nome;
    private Double salario;
    private String nivelCargo;

    @ManyToOne
    @JoinColumn(name = "ID_USUARIO", referencedColumnName = "ID")
    private Usuario idUsuario;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST, mappedBy = "idRevisor")
    private List<Noticia> noticias;
}
