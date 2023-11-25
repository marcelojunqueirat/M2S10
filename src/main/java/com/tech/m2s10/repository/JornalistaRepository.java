package com.tech.m2s10.repository;

import com.tech.m2s10.model.Jornalista;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JornalistaRepository extends JpaRepository<Jornalista, Long> {
}
