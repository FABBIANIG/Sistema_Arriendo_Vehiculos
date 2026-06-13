package com.duoc.ms_clientes.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class DireccionRequestDTO {



    @NotBlank
    @Size(min = 2, max = 100)
    private String calle;

    @NotNull
    @Positive
    private Integer numero;

    @NotBlank
    @Size(min = 2, max = 100)
    private String comuna;

    @NotBlank
    @Size(min = 2, max = 150)
    private String ciudad;

    @NotBlank
    @Size(min = 2, max = 150)
    private String referencia;

    @NotNull
    private Boolean principal;

    @NotNull
    @PastOrPresent
    private LocalDate fechaRegistro;

    @NotNull
    @Positive
    private Integer clienteId;
//
}