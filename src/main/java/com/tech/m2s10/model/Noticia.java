package com.tech.m2s10.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
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
    private Long idRevisor;
    private Long idJornalista;

    public Noticia(String titulo, String textoNoticia, LocalDateTime dataCriacao, LocalDateTime dataAtualizacao, Long idRevisor, Long idJornalista) {
        this.titulo = titulo;
        this.textoNoticia = textoNoticia;
        this.dataCriacao = dataCriacao;
        this.dataAtualizacao = LocalDateTime.now();
        this.idRevisor = idRevisor;
        this.idJornalista =idJornalista;
    }
}
