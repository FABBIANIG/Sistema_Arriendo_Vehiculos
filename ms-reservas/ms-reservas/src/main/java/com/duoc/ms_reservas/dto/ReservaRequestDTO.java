package com.duoc.ms_reservas.dto;


import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.math.BigDecimal;
import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ReservaRequestDTO {

    @NotNull(message = "El id del cliente es obligatorio")
    @Min(value = 1, message = "El id del cliente debe ser mayor o igual a 1")
    private Integer clienteId;

    @NotNull(message = "El id del vehículo es obligatorio")
    @Min(value = 1, message = "El id del vehículo debe ser mayor o igual a 1")
    private Integer vehiculoId;

    @NotNull(message = "La fecha de inicio es obligatoria")
    @FutureOrPresent(message = "La fecha de inicio no puede ser pasada")
    private LocalDate fechaInicio;

    @NotNull(message = "La fecha de fin es obligatoria")
    @FutureOrPresent(message = "La fecha de fin no puede ser pasada")
    private LocalDate fechaFin;

    @NotNull(message = "La cantidad de días es obligatoria")
    @Min(value = 1, message = "La cantidad de días debe ser mayor o igual a 1")
    private Integer cantidadDias;

    @NotNull(message = "El monto total es obligatorio")
    @DecimalMin(value = "0.0", inclusive = false, message = "El monto total debe ser mayor a 0")
    private BigDecimal montoTotal;

    @NotBlank(message = "La observación es obligatoria")
    @Size(min = 3, max = 150, message = "La observación debe tener entre 3 y 150 caracteres")
    private String observacion;

    @NotNull(message = "El estado activo de la reserva es obligatorio")
    private Boolean activa;

    @NotNull(message = "El estado de reserva es obligatorio")
    @Min(value = 1, message = "El id del estado de reserva debe ser mayor o igual a 1")
    private Integer estadoReservaId;

}
