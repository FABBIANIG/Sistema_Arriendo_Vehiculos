package com.duoc.msvehiculos.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CategoriaRequestDTO {

    @NotBlank(message = "El nombre de la categoría es obligatorio")
    @Size(min = 2, max = 100, message = "El nombre debe tener entre 2 y 100 caracteres")
    private String nombre;

    @NotBlank(message = "La descripción es obligatoria")
    @Size(min = 5, max = 200, message = "La descripción debe tener entre 5 y 200 caracteres")
    private String descripcion;

    @NotNull(message = "La tarifa base es obligatoria")
    @DecimalMin(value = "0.0", inclusive = false, message = "La tarifa base debe ser mayor a 0")
    private BigDecimal tarifaBase;

    @NotNull(message = "La capacidad de pasajeros es obligatoria")
    @Min(value = 1, message = "La capacidad debe ser mínimo 1")
    private Integer capacidadPasajeros;

    @NotNull(message = "El estado activo es obligatorio")
    private Boolean activa;

    @NotNull(message = "La fecha de creación es obligatoria")
    @PastOrPresent(message = "La fecha de creación no puede ser futura")
    private LocalDate fechaCreacion;
}