package com.tech.m2s10.service;

import com.tech.m2s10.model.Jornalista;
import com.tech.m2s10.repository.JornalistaRepository;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JornalistaService {

    private static final Logger LOGGER = LoggerFactory.getLogger(JornalistaService.class);
    private final JornalistaRepository jornalistaRepo;

    public JornalistaService(JornalistaRepository jornalistaRepository) {
        jornalistaRepo = jornalistaRepository;
    }

    @Transactional
    public List<Jornalista> listar(){
        LOGGER.info("Inciando chamada da listagem de jornalistas....");
        return jornalistaRepo.findAll();
    }

    @Transactional
    public Jornalista salvar(Jornalista jornalista){
        return jornalistaRepo.save(jornalista);
    }

    @Transactional
    public void delete(Long id) {
        this.jornalistaRepo.deleteById(id);
    }

    @Transactional
    public Jornalista update(Long id, Jornalista jornalistaAtualizado) {
        Jornalista jornalista = this.jornalistaRepo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Jornalista com id informado não encontrado, id: " + id));
        LOGGER.debug("Jornalista existe, atualizando informações....");
        jornalista.setNome(jornalistaAtualizado.getNome());
        jornalista.setSalario(jornalistaAtualizado.getSalario());
        jornalista.setNivelCargo(jornalistaAtualizado.getNivelCargo());
        jornalista.setNumeroPublicacoes(jornalistaAtualizado.getNumeroPublicacoes());
        jornalista.setIdUsuario(jornalistaAtualizado.getIdUsuario());
        return jornalista;
    }
}
