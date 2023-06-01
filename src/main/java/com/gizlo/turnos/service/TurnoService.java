/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gizlo.turnos.service;

import com.gizlo.turnos.model.Turno;
import com.gizlo.turnos.repository.ITurno;
import java.util.List;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Paul
 */
@Service
public class TurnoService {
    @Autowired
    ITurno turnoRepository;
    
    public List<Turno> obtenerTurnos(){
        return turnoRepository.findAll();
    }
    
    public Turno obetenerTurnoId(Long id){
        return turnoRepository.findById(id).orElse(null);
    }
    
    public String obtenerToken(Turno turno){
        String data = turno.crearString();
        return Base64.encodeBase64String(data.getBytes());
    }
    
    
    
    
    
}
