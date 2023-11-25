package com.tech.m2s10.dto;

import com.tech.m2s10.model.Jornalista;
import com.tech.m2s10.model.Revisor;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class RevisorResponse {
    private Long id;
    private String nome;
    private Double salario;
    private String nivelCargo;
    private Long idUsuario;

    public static RevisorResponse makeDTO(Revisor revisor){
        return new RevisorResponse(
                revisor.getId(),
                revisor.getNome(),
                revisor.getSalario(),
                revisor.getNivelCargo(),
                revisor.getIdUsuario()
        );
    }
}
