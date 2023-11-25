package com.tech.m2s10.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "NOTICIAS")
public class Noticia {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String titulo;
    private String textoNoticia;
    private LocalDateTime dataCriacao;
    private LocalDateTime dataAtualizacao;

    @ManyToOne
    @JoinColumn(name = "ID_REVISOR", referencedColumnName = "ID")
    private Revisor idRevisor;

    @ManyToOne
    @JoinColumn(name = "ID_JORNALISTA", referencedColumnName = "ID")
    private Jornalista idJornalista;
}
