package com.tech.m2s10.gateway;

import com.tech.m2s10.dto.JornalistaResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name="jornalista-feign",url = "http://localhost:8080/jornalistas")
public interface JornalistaFeign {

    @GetMapping
    List<JornalistaResponse> listar();
}
