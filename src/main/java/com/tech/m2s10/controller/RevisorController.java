package com.tech.m2s10.controller;

import com.tech.m2s10.dto.RevisorRequest;
import com.tech.m2s10.dto.RevisorResponse;
import com.tech.m2s10.model.Revisor;
import com.tech.m2s10.service.RevisorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("revisores")
public class RevisorController {
    private final RevisorService revisorService;

    public RevisorController(RevisorService revisorService){
        this.revisorService = revisorService;
    }

    @GetMapping
    public ResponseEntity<List<RevisorResponse>> listar(){
        List<Revisor> revisores = revisorService.listar();
        var resp = new ArrayList<RevisorResponse>();
        for (Revisor revisor : revisores){
            RevisorResponse revisorDTO = RevisorResponse.makeDTO(revisor);
            resp.add(revisorDTO);
        }
        return ResponseEntity.ok(resp);
    }

    @PostMapping
    public ResponseEntity<RevisorResponse> cadastrarUsuario(@RequestBody RevisorRequest request) {
        Revisor revisor = revisorService.salvar(request.makeDTO());
        return ResponseEntity.status(HttpStatus.CREATED).body(RevisorResponse.makeDTO(revisor));
    }

    @PutMapping("/{id}")
    public ResponseEntity<RevisorResponse> update(@PathVariable("id") Long id, @RequestBody RevisorRequest request) {
        Revisor revisor = this.revisorService.update(id, request.makeDTO());
        return ResponseEntity.status(HttpStatus.CREATED).body(RevisorResponse.makeDTO(revisor));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        this.revisorService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
