package com.tech.m2s10.dto;

import com.tech.m2s10.model.Jornalista;
import com.tech.m2s10.model.Noticia;
import com.tech.m2s10.model.Revisor;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
public class NoticiaResponse {
    private Long id;
    private String titulo;
    private String textoNoticia;
    private LocalDateTime dataCriacao;
    private LocalDateTime dataAtualizacao;
    private Long idRevisor;
    private Long idJornalista;

    public static NoticiaResponse makeDTO(Noticia noticia){
        return new NoticiaResponse(
                noticia.getId(),
                noticia.getTitulo(),
                noticia.getTextoNoticia(),
                noticia.getDataCriacao(),
                noticia.getDataAtualizacao(),
                noticia.getIdRevisor(),
                noticia.getIdJornalista()
        );
    }

}
