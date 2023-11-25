package com.tech.m2s10.dto;

import com.tech.m2s10.model.Jornalista;
import com.tech.m2s10.model.Usuario;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class JornalistaResponse {
    private Long id;
    private String nome;
    private Double salario;
    private String nivelCargo;
    private Integer numeroPublicacoes;
    private Long idUsuario;

    public static JornalistaResponse makeDTO(Jornalista jornalista){
        return new JornalistaResponse(
                jornalista.getId(),
                jornalista.getNome(),
                jornalista.getSalario(),
                jornalista.getNivelCargo(),
                jornalista.getNumeroPublicacoes(),
                jornalista.getIdUsuario()
        );
    }
}
