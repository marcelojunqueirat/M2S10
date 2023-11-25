package com.tech.m2s10.service;

import com.tech.m2s10.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {
    private final UsuarioRepository usuarioRepo;

    public UsuarioService(UsuarioRepository usuarioRepository){
        usuarioRepo = usuarioRepository;
    }
}
