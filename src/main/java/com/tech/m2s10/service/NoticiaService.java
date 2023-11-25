package com.tech.m2s10.service;

import com.tech.m2s10.model.Noticia;
import com.tech.m2s10.repository.NoticiaRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class NoticiaService {
    private final NoticiaRepository noticiaRepo;

    public NoticiaService(NoticiaRepository noticiaRepository) {
        noticiaRepo = noticiaRepository;
    }

    @Transactional
    public List<Noticia> listar(){
        return noticiaRepo.findAll();
    }

    @Transactional
    public Noticia salvar(Noticia noticia){
        return noticiaRepo.save(noticia);
    }

    @Transactional
    public void delete(Long id) {
        this.noticiaRepo.deleteById(id);
    }

    @Transactional
    public Noticia update(Long id, Noticia noticiaAtualizada) {
        Noticia noticia = this.noticiaRepo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Noticia com id informado não encontrada, id: " + id));
        noticia.setTitulo(noticiaAtualizada.getTitulo());
        noticia.setTextoNoticia(noticiaAtualizada.getTextoNoticia());
        noticia.setDataCriacao(noticiaAtualizada.getDataCriacao());
        noticia.setDataAtualizacao(noticiaAtualizada.getDataAtualizacao());
        noticia.setIdRevisor(noticiaAtualizada.getIdRevisor());
        noticia.setIdJornalista(noticiaAtualizada.getIdJornalista());

        return noticia;
    }
}
