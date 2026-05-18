package com.duoc.ms_reservas.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EstadoReservaDTO {

    private Integer id;
    private String nombre;
    private String descripcion;
    private Integer prioridad;
    private boolean activo;
    private LocalDateTime fechaCreacion;

}
