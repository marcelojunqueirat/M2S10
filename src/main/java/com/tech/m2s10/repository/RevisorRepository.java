package com.tech.m2s10.repository;

import com.tech.m2s10.model.Revisor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RevisorRepository extends JpaRepository<Revisor, Long> {
}
