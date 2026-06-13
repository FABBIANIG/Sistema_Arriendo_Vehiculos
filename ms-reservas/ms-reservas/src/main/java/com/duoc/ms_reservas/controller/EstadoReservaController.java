package com.duoc.ms_reservas.controller;

import com.duoc.ms_reservas.dto.EstadoReservaDTO;
import com.duoc.ms_reservas.dto.EstadoReservaRequestDTO;
import com.duoc.ms_reservas.service.EstadoReservaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class EstadoReservaController {

    private final EstadoReservaService estadoReservaService;

    @GetMapping("/estados-reserva")
    public ResponseEntity<?> findAll() {
        // agregado: listar todos los estados de reserva
        return ResponseEntity.ok(estadoReservaService.findAll());
    }

    @GetMapping("/estados-reserva/{id}")
    public ResponseEntity<EstadoReservaDTO> findById(@PathVariable Integer id) {
        // agregado: buscar estado de reserva por id
        return ResponseEntity.ok(estadoReservaService.findById(id));
    }

    @PostMapping ("/estados-reserva")
    public ResponseEntity<EstadoReservaDTO> save(@Valid @RequestBody EstadoReservaRequestDTO requestDTO) {
        // agregado: crear estado de reserva
        EstadoReservaDTO estadoCreado = estadoReservaService.save(requestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(estadoCreado);
    }

    @PutMapping("/estados-reserva/{id}")
    public ResponseEntity<EstadoReservaDTO> update(
            @PathVariable Integer id,
            @Valid @RequestBody EstadoReservaRequestDTO requestDTO) {

        // agregado: actualizar estado de reserva
        return ResponseEntity.ok(estadoReservaService.update(id, requestDTO));
    }

    @DeleteMapping("/estados-reserva/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        // agregado: eliminar estado de reserva
        estadoReservaService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
