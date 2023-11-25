package com.tech.m2s10.service;

import com.tech.m2s10.repository.RevisorRepository;
import org.springframework.stereotype.Service;

@Service
public class RevisorService {
    private final RevisorRepository revisorRepo;

    public RevisorService(RevisorRepository revisorRepository){
        revisorRepo = revisorRepository;
    }
}
