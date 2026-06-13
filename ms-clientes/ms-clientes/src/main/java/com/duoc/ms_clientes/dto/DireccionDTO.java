package com.duoc.ms_clientes.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DireccionDTO {

    private Integer id;

    private String calle;

    private Integer numero;

    private String comuna;

    private String ciudad;

    private String referencia;

    private Boolean principal;

    private LocalDate fechaRegistro;

    private Integer clienteId;
    //
}