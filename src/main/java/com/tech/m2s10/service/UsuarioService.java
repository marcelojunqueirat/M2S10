package com.tech.m2s10.service;

import com.tech.m2s10.model.Usuario;
import com.tech.m2s10.repository.UsuarioRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {
    private final UsuarioRepository usuarioRepo;

    public UsuarioService(UsuarioRepository usuarioRepository){
        usuarioRepo = usuarioRepository;
    }

    @Transactional
    public List<Usuario> listar(){
        return usuarioRepo.findAll();
    }

    @Transactional
    public Usuario salvar(Usuario usuario){
        return usuarioRepo.save(usuario);
    }

    @Transactional
    public void delete(Long id) {
        this.usuarioRepo.deleteById(id);
    }

    @Transactional
    public Usuario update(Long id, Usuario usuarioAtualizado) {
        Usuario usuario = this.usuarioRepo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Usuário com id informado não encontrado, id: " + id));
        usuario.setUsername(usuarioAtualizado.getUsername());
        usuario.setPassword(usuarioAtualizado.getPassword());
        return usuario;
    }
}
