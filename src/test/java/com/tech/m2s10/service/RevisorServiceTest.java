package com.tech.m2s10.service;

import com.tech.m2s10.model.Revisor;
import com.tech.m2s10.repository.RevisorRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class RevisorServiceTest {


    @Mock
    RevisorRepository revisorRepo;

    @InjectMocks
    RevisorService revisorService;

    @Test
    void getUsers() {
        List<Revisor> revisores = List.of(
                new Revisor("Marcelo", 4500.0, "PLENO", 1l),
                new Revisor("Fulano", 7500.0, "SENIOR", 5l)
        );

        when(revisorRepo.findAll()).thenReturn(revisores);

        List<Revisor> resultado = revisorService.listar();

        assertNotNull(resultado); // Valida se o resultado não é null
        assertEquals(revisores.get(0).getNome(), resultado.get(0).getNome());
    }

    @Test
    void saveRevisores() {
        Revisor revisor = new Revisor("Juma", 2500.0, "JUNIOR", 1l);

        when(revisorRepo.save(any())).thenReturn(revisor);

        Revisor resultado = revisorService.salvar(revisor);

        assertNotNull(resultado); // Valida se o resultado não é null
        assertEquals(revisor.getNome(), resultado.getNome());
    }

}
