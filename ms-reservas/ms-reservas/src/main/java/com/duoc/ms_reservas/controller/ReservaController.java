package com.duoc.ms_reservas.controller;

import com.duoc.ms_reservas.dto.ReservaDTO;
import com.duoc.ms_reservas.dto.ReservaRequestDTO;
import com.duoc.ms_reservas.service.ReservaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class ReservaController {

    private final ReservaService reservaService;

    @GetMapping("/reservas")
    public ResponseEntity<?> findAll() {
        // agregado: listar todas las reservas
        return ResponseEntity.ok(reservaService.findAll());
    }

    @GetMapping("/reservas/{id}")
    public ResponseEntity<ReservaDTO> findById(@PathVariable Integer id) {
        // agregado: buscar reserva por id
        return ResponseEntity.ok(reservaService.findById(id));
    }

    @PostMapping("/reservas")
    public ResponseEntity<ReservaDTO> save(@Valid @RequestBody ReservaRequestDTO requestDTO) {
        // agregado: crear nueva reserva
        ReservaDTO reservaCreada = reservaService.save(requestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(reservaCreada);
    }

    @PutMapping("/reservas/{id}")
    public ResponseEntity<ReservaDTO> update(
            @PathVariable Integer id,
            @Valid @RequestBody ReservaRequestDTO requestDTO) {

        // agregado: actualizar reserva
        return ResponseEntity.ok(reservaService.update(id, requestDTO));
    }

    @DeleteMapping("/reservas/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        // agregado: eliminar reserva
        reservaService.delete(id);
        return ResponseEntity.noContent().build();
    }

    // agregado: endpoint para JPQL solicitado en la pauta
    @GetMapping("/reservas/desde-fecha")
    public ResponseEntity<?> findByFechaInicioDesde(
            @RequestParam
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
            LocalDate fecha) {

        return ResponseEntity.ok(reservaService.findByFechaInicioDesde(fecha));
    }
}
