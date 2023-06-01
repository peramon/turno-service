package com.gizlo.turnos.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
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
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nombre_usuario")
    private String nombre;
    @Column(name = "area")
    private String area;
    private String usuario;
    private String clave;
    private String uuid;
    
    @Transient
    private String token;
    
    public String crearString(){
        return id+","+usuario+","+clave+","+uuid;
    }
}
