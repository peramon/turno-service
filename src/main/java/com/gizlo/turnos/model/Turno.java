package com.gizlo.turnos.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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
@Entity
@Table(name="turno")
public class Turno {
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    @Column(name = "nombre_usuario")
    private String nombre;
    @Column(name = "area")
    private String area;
}
