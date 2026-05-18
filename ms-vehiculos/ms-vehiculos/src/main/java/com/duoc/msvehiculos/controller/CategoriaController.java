package com.duoc.msvehiculos.controller;


import com.duoc.msvehiculos.dto.CategoriaDTO;
import com.duoc.msvehiculos.dto.CategoriaRequestDTO;
import com.duoc.msvehiculos.service.CategoriaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class CategoriaController {

    private final CategoriaService categoriaService;

    @GetMapping("/categorias")
    public ResponseEntity<?> findAll() {
        return ResponseEntity.ok(categoriaService.findAll());
    }

    @GetMapping("/categorias/{id}")
    public ResponseEntity<CategoriaDTO> findById(@PathVariable Integer id) {
        return ResponseEntity.ok(categoriaService.findById(id));
    }

    @PostMapping("/categorias")
    public ResponseEntity<CategoriaDTO> save(@Valid @RequestBody CategoriaRequestDTO dto) {
        CategoriaDTO categoriaCreada = categoriaService.save(dto);

        return ResponseEntity.status(HttpStatus.CREATED).body(categoriaCreada);
    }

    @PutMapping("/categorias/{id}")
    public ResponseEntity<CategoriaDTO> update(
            @PathVariable Integer id,
            @Valid @RequestBody CategoriaRequestDTO dto
    ) {
        CategoriaDTO categoriaActualizada = categoriaService.update(id, dto);

        return ResponseEntity.ok(categoriaActualizada);
    }

    @DeleteMapping("/categorias/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        categoriaService.delete(id);

        return ResponseEntity.noContent().build();
    }
}