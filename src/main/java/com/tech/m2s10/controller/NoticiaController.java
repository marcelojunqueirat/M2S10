package com.tech.m2s10.controller;

import com.tech.m2s10.dto.NoticiaRequest;
import com.tech.m2s10.dto.NoticiaResponse;
import com.tech.m2s10.model.Noticia;
import com.tech.m2s10.service.NoticiaService;
import jakarta.annotation.security.RolesAllowed;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("noticias")
public class NoticiaController {
    public final NoticiaService noticiaService;

    public NoticiaController(NoticiaService noticiaService){
        this.noticiaService = noticiaService;
    }

    @GetMapping
    public ResponseEntity<List<NoticiaResponse>> listar(){
        List<Noticia> noticias = noticiaService.listar();
        var resp = new ArrayList<NoticiaResponse>();
        for (Noticia noticia : noticias){
            NoticiaResponse noticiaDTO = NoticiaResponse.makeDTO(noticia);
            resp.add(noticiaDTO);
        }
        return ResponseEntity.ok(resp);
    }

    @PostMapping
    @RolesAllowed("ADMIN")
    public ResponseEntity<NoticiaResponse> cadastrarNoticia(@RequestBody NoticiaRequest request) {
        Noticia noticia = noticiaService.salvar(request.makeDTO());
        return ResponseEntity.status(HttpStatus.CREATED).body(NoticiaResponse.makeDTO(noticia));
    }

    @PutMapping("/{id}")
    public ResponseEntity<NoticiaResponse> update(@PathVariable("id") Long id, @RequestBody NoticiaRequest request) {
        Noticia noticia = this.noticiaService.update(id, request.makeDTO());
        return ResponseEntity.status(HttpStatus.CREATED).body(NoticiaResponse.makeDTO(noticia));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        this.noticiaService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
