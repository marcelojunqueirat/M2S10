package com.tech.m2s10.dto;

import com.tech.m2s10.model.Jornalista;
import com.tech.m2s10.model.Revisor;
import lombok.Getter;

@Getter
public class RevisorRequest {
    private String nome;
    private Double salario;
    private String nivelCargo;
    private Long idUsuario;

    public Revisor makeDTO(){
        return new Revisor(nome, salario, nivelCargo, idUsuario);
    }
}
