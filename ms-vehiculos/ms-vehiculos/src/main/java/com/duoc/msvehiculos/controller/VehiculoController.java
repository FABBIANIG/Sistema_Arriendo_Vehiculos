package com.duoc.msvehiculos.controller;

import com.duoc.msvehiculos.dto.VehiculoDTO;
import com.duoc.msvehiculos.dto.VehiculoRequestDTO;
import com.duoc.msvehiculos.service.VehiculoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping("/api/v1/vehiculos")
@RequiredArgsConstructor
public class VehiculoController {

    private final VehiculoService vehiculoService;

    @GetMapping
    public ResponseEntity<?> findAll() {
        return ResponseEntity.ok(vehiculoService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<VehiculoDTO> findById(@PathVariable Integer id) {
        return ResponseEntity.ok(vehiculoService.findById(id));
    }

    @PostMapping
    public ResponseEntity<VehiculoDTO> save(@Valid @RequestBody VehiculoRequestDTO dto) {
        VehiculoDTO vehiculoCreado = vehiculoService.save(dto);

        return ResponseEntity.status(HttpStatus.CREATED).body(vehiculoCreado);
    }

    @PutMapping("/{id}")
    public ResponseEntity<VehiculoDTO> update(
            @PathVariable Integer id,
            @Valid @RequestBody VehiculoRequestDTO dto
    ) {
        VehiculoDTO vehiculoActualizado = vehiculoService.update(id, dto);

        return ResponseEntity.ok(vehiculoActualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        vehiculoService.delete(id);

        return ResponseEntity.noContent().build();
    }

    // agregado: endpoint para la query method requerida
    // ejemplo: GET http://localhost:8082/api/v1/vehiculos/disponibles/precio-menor/50000
    @GetMapping("/disponibles/precio-menor/{precioMaximo}")
    public ResponseEntity<?> buscarDisponiblesPorPrecioMenor(@PathVariable BigDecimal precioMaximo) {
        return ResponseEntity.ok(vehiculoService.buscarDisponiblesPorPrecioMenor(precioMaximo));
    }
}
