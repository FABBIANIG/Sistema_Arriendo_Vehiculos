package com.duoc.msvehiculos.dto;



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
public class CategoriaDTO {

    private Integer id;
    private String nombre;
    private String descripcion;
    private BigDecimal tarifaBase;
    private Integer capacidadPasajeros;
    private Boolean activa;
    private LocalDate fechaCreacion;
}
