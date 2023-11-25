package com.tech.m2s10.dto;

import com.tech.m2s10.model.Usuario;
import lombok.Getter;

@Getter
public class UsuarioRequest {
    private String username;
    private String password;

    public Usuario makeDTO(){
        return new Usuario(username, password);
    }
}
