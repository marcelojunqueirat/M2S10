package com.tech.m2s10.dto;

import com.tech.m2s10.model.Jornalista;
import com.tech.m2s10.model.Usuario;
import lombok.Getter;

@Getter
public class JornalistaRequest {
    private String nome;
    private Double salario;
    private String nivelCargo;
    private Integer numeroPublicacoes;
    private Long idUsuario;

    public Jornalista makeDTO(){
        return new Jornalista(nome, salario, nivelCargo, numeroPublicacoes, idUsuario);
    }
}
