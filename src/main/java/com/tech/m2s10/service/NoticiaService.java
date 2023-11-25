package com.tech.m2s10.service;

import com.tech.m2s10.repository.NoticiaRepository;
import org.springframework.stereotype.Service;

@Service
public class NoticiaService {
    private final NoticiaRepository noticiaRepo;

    public NoticiaService(NoticiaRepository noticiaRepository) {
        noticiaRepo = noticiaRepository;
    }
}
