package com.duoc.ms_clientes.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class ClienteRequestDTO {
    @NotBlank
    @Size(min = 9, max = 12)
    private String rut;

    @NotBlank
    @Size(min = 2, max = 100)
    private String nombre;

    @NotBlank
    @Size(min = 2, max = 100)
    private String apellido;

    @NotBlank
    @Email
    @Size(min = 2, max = 100)
    private String email;

    @NotNull
    @Positive
    private Integer telefono;

    @NotNull
    private Boolean activo;

    @NotNull
    @PastOrPresent
    private LocalDate fechaRegistro;
//
}
