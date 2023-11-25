package com.tech.m2s10.service;

import com.tech.m2s10.model.Revisor;
import com.tech.m2s10.repository.RevisorRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RevisorService {
    private final RevisorRepository revisorRepo;

    public RevisorService(RevisorRepository revisorRepository){
        revisorRepo = revisorRepository;
    }

    @Transactional
    public List<Revisor> listar(){
        return revisorRepo.findAll();
    }

    @Transactional
    public Revisor salvar(Revisor revisor){
        return revisorRepo.save(revisor);
    }

    @Transactional
    public void delete(Long id) {
        this.revisorRepo.deleteById(id);
    }

    @Transactional
    public Revisor update(Long id, Revisor revisorAtualizado) {
        Revisor revisor = this.revisorRepo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Revisor com id informado não encontrado, id: " + id));
        revisor.setNome(revisorAtualizado.getNome());
        revisor.setSalario(revisorAtualizado.getSalario());
        revisor.setNivelCargo(revisorAtualizado.getNivelCargo());
        revisor.setIdUsuario(revisorAtualizado.getIdUsuario());
        return revisor;
    }
}
