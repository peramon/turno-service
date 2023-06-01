package com.gizlo.turnos.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author Paul
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TurnoDTO {

    private String nombre;

    private String area;
    private String tramite;
    private String observacion;

    private String usuario;
    private String clave;
}
