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
public class VehiculoRequestDTO {

    @NotBlank(message = "La patente es obligatoria")
    @Size(min = 6, max = 10, message = "La patente debe tener entre 6 y 10 caracteres")
    private String patente;

    @NotBlank(message = "La marca es obligatoria")
    @Size(min = 2, max = 50, message = "La marca debe tener entre 2 y 50 caracteres")
    private String marca;

    @NotBlank(message = "El modelo es obligatorio")
    @Size(min = 2, max = 50, message = "El modelo debe tener entre 2 y 50 caracteres")
    private String modelo;

    @NotNull(message = "El año es obligatorio")
    @Min(value = 1990, message = "El año debe ser igual o mayor a 1990")
    private Integer anio;

    @NotBlank(message = "El color es obligatorio")
    @Size(min = 3, max = 30, message = "El color debe tener entre 3 y 30 caracteres")
    private String color;

    @NotNull(message = "El precio diario es obligatorio")
    @DecimalMin(value = "0.0", inclusive = false, message = "El precio diario debe ser mayor a 0")
    private BigDecimal precioArriendoDiario;

    @NotNull(message = "El kilometraje es obligatorio")
    @Min(value = 0, message = "El kilometraje no puede ser negativo")
    private Integer kilometraje;

    @NotNull(message = "La disponibilidad es obligatoria")
    private Boolean disponible;

    @NotNull(message = "La fecha de ingreso es obligatoria")
    @PastOrPresent(message = "La fecha de ingreso no puede ser futura")
    private LocalDate fechaIngreso;

    @NotNull(message = "El id de la categoría es obligatorio")
    private Integer categoriaId;
}