package com.tech.m2s10.controller;

import com.tech.m2s10.dto.JornalistaRequest;
import com.tech.m2s10.dto.JornalistaResponse;
import com.tech.m2s10.model.Jornalista;
import com.tech.m2s10.service.JornalistaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("jornalistas")
public class JornalistaController {
    private final JornalistaService jornalistaService;

    public JornalistaController(JornalistaService jornalistaService) {
        this.jornalistaService = jornalistaService;
    }

    @GetMapping
    public ResponseEntity<List<JornalistaResponse>> listar() {
        List<Jornalista> jornalistas = jornalistaService.listar();
        var resp = new ArrayList<JornalistaResponse>();
        for (Jornalista jornalista : jornalistas) {
            JornalistaResponse jornalistaDTO = JornalistaResponse.makeDTO(jornalista);
            resp.add(jornalistaDTO);
        }
        return ResponseEntity.ok(resp);
    }

    @PostMapping
    public ResponseEntity<JornalistaResponse> cadastrarUsuario(@RequestBody JornalistaRequest request) {
        Jornalista jornalista = jornalistaService.salvar(request.makeDTO());
        return ResponseEntity.status(HttpStatus.CREATED).body(JornalistaResponse.makeDTO(jornalista));
    }

    @PutMapping("/{id}")
    public ResponseEntity<JornalistaResponse> update(@PathVariable("id") Long id, @RequestBody JornalistaRequest request) {
        Jornalista jornalista = this.jornalistaService.update(id, request.makeDTO());
        return ResponseEntity.status(HttpStatus.CREATED).body(JornalistaResponse.makeDTO(jornalista));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        this.jornalistaService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
