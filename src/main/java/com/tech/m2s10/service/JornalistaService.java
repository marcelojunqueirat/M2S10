package com.tech.m2s10.service;

import com.tech.m2s10.repository.JornalistaRepository;
import org.springframework.stereotype.Service;

@Service
public class JornalistaService {
    private final JornalistaRepository jornalistaRepo;

    public JornalistaService(JornalistaRepository jornalistaRepository) {
        jornalistaRepo = jornalistaRepository;
    }
}
