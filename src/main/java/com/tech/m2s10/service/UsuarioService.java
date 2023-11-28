package com.tech.m2s10.service;

import com.tech.m2s10.model.Usuario;
import com.tech.m2s10.repository.UsuarioRepository;
import jakarta.transaction.Transactional;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService implements UserDetailsService {
    private final UsuarioRepository usuarioRepo;
    private PasswordEncoder passwordEncoder;

    public UsuarioService(UsuarioRepository usuarioRepository, PasswordEncoder passwordEncoder){
        usuarioRepo = usuarioRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Transactional
    public List<Usuario> listar(){
        return usuarioRepo.findAll();
    }

    @Transactional
    public Usuario salvar(Usuario usuario){
        String senhaCriptografada = passwordEncoder.encode(usuario.getPassword());
        usuario.setPassword(senhaCriptografada);
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

    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {
        Optional<Usuario> usuarioOpt = usuarioRepo.findByUsername(username);
        if (usuarioOpt.isEmpty())
            throw new UsernameNotFoundException("User not found");
        return usuarioOpt.get();
    }
}
