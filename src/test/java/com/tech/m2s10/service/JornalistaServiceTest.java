package com.tech.m2s10.service;

import com.tech.m2s10.model.Jornalista;
import com.tech.m2s10.repository.JornalistaRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class JornalistaServiceTest {

    @Mock
    JornalistaRepository jornalistaRepo;

    @InjectMocks
    JornalistaService jornalistaService;

    @Test
    void getUsers() {
        List<Jornalista> jornalistas = List.of(
                new Jornalista("Marcelo", 6500.0, "SENIOR", 15, 1L),
                new Jornalista("Maria", 7500.0, "SENIOR", 18, 2L)
        );

        when(jornalistaRepo.findAll()).thenReturn(jornalistas);

        List<Jornalista> resultado = jornalistaService.listar();

        assertNotNull(resultado); // Valida se o resultado não é null
        assertEquals(jornalistas.get(0).getNome(), resultado.get(0).getNome());
    }

    @Test
    void saveJornalistas() {
        Jornalista jornalista = new Jornalista("Marcelo", 4500.0, "PLENO", 15, 1L);

        when(jornalistaRepo.save(any())).thenReturn(jornalista);

        Jornalista resultado = jornalistaService.salvar(jornalista);

        assertNotNull(resultado); // Valida se o resultado não é null
        assertEquals(jornalista.getNome(), resultado.getNome());
    }

}
