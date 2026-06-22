package com.duoc.ms_reservas.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.hateoas.RepresentationModel;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true) // Necesario al heredar de RepresentationModel
public class EstadoReservaDTO extends RepresentationModel<EstadoReservaDTO> {

    private Integer id;
    private String nombre;
    private String descripcion;
    private Integer prioridad;
    private boolean activo;
    private LocalDateTime fechaCreacion;

}