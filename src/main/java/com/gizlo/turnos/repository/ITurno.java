package com.gizlo.turnos.repository;

import com.gizlo.turnos.model.Turno;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Paul
 */
public interface ITurno extends JpaRepository<Turno, Long>{
    
}
