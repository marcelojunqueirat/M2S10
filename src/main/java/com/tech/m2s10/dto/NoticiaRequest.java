package com.tech.m2s10.dto;

import com.tech.m2s10.model.Jornalista;
import com.tech.m2s10.model.Noticia;
import com.tech.m2s10.model.Revisor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class NoticiaRequest {
    private String titulo;
    private String textoNoticia;
    private LocalDateTime dataCriacao;
    private LocalDateTime dataAtualizacao;
    private Long idRevisor;
    private Long idJornalista;

    public Noticia makeDTO(){
        return new Noticia(titulo, textoNoticia, dataCriacao, dataAtualizacao, idRevisor, idJornalista);
    }
}
