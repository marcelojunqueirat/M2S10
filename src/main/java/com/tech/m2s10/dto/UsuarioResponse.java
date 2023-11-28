package com.tech.m2s10.dto;

import com.tech.m2s10.model.Role;
import com.tech.m2s10.model.Usuario;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class UsuarioResponse {
    private Long id;
    private String username;
    private Role role;

    public static UsuarioResponse makeDTO(Usuario usuario){
        return new UsuarioResponse(usuario.getId(), usuario.getUsername(), usuario.getRole());
    }
}
