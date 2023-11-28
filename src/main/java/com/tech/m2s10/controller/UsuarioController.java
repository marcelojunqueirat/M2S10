package com.tech.m2s10.controller;

import com.tech.m2s10.dto.AutenticacaoRequest;
import com.tech.m2s10.dto.AutenticacaoResponse;
import com.tech.m2s10.dto.UsuarioRequest;
import com.tech.m2s10.dto.UsuarioResponse;
import com.tech.m2s10.model.Usuario;
import com.tech.m2s10.service.AutenticacaoService;
import com.tech.m2s10.service.UsuarioService;
import jakarta.annotation.security.RolesAllowed;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("usuarios")
public class UsuarioController {
    private final UsuarioService usuarioService;

    private AutenticacaoService autenticacaoService;

    public UsuarioController(UsuarioService usuarioService, AutenticacaoService autenticacaoService) {
        this.usuarioService = usuarioService;
        this.autenticacaoService = autenticacaoService;
    }

    @GetMapping
    @RolesAllowed( {"ADMIN","USUARIO"} )
    public ResponseEntity<List<UsuarioResponse>> listar(){
        List<Usuario> usuarios = usuarioService.listar();
        var resp = new ArrayList<UsuarioResponse>();
        for (Usuario usuario : usuarios){
            UsuarioResponse usuarioDTO = UsuarioResponse.makeDTO(usuario);
            resp.add(usuarioDTO);
        }
        return ResponseEntity.ok(resp);
    }

    @PostMapping
    public ResponseEntity<UsuarioResponse> cadastrarUsuario(@RequestBody UsuarioRequest request) {
        Usuario usuario = usuarioService.salvar(request.makeDTO());
        return ResponseEntity.status(HttpStatus.CREATED).body(UsuarioResponse.makeDTO(usuario));
    }

    @PutMapping("/{id}")
    @RolesAllowed("ADMIN")
    public ResponseEntity<UsuarioResponse> update(@PathVariable("id") Long id, @RequestBody UsuarioRequest request) {
        Usuario usuario = this.usuarioService.update(id, request.makeDTO());
        return ResponseEntity.status(HttpStatus.CREATED).body(UsuarioResponse.makeDTO(usuario));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        this.usuarioService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/login")
    public ResponseEntity<AutenticacaoResponse> login(@RequestBody AutenticacaoRequest request) {
        var token = autenticacaoService.autenticar(request.getUsername(), request.getPassword());
        return ResponseEntity.ok(new AutenticacaoResponse(token));
    }
}
