package com.gizlo.turnos.repository;

import com.gizlo.turnos.model.Turno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author Paul
 */
public interface ITurno extends JpaRepository<Turno, Long>{
    
    @Query(value = "select * from turno where turno.usuario = :usuario and turno.clave = :clave;", nativeQuery = true)
    Turno findByUsuarioClave(@Param("usuario") String usuario, @Param("clave") String clave);
}
