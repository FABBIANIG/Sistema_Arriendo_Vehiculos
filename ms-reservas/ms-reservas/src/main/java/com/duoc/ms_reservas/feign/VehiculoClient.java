package com.duoc.ms_reservas.feign;

import com.duoc.ms_reservas.dto.VehiculoDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

// agregado: comunicación con ms-vehiculos
@FeignClient(name = "ms-vehiculos", url = "http://localhost:8082")
public interface VehiculoClient {

    @GetMapping("/api/v1/vehiculos/{id}")
    VehiculoDTO obtenerVehiculoPorId(@PathVariable Integer id);
}