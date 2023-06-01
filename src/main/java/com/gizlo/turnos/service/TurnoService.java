/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gizlo.turnos.service;

import com.gizlo.turnos.model.Turno;
import com.gizlo.turnos.repository.ITurno;
import java.util.List;
import java.util.UUID;
import org.apache.tomcat.util.codec.binary.Base64;
import static org.hibernate.query.sqm.tree.SqmNode.log;
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
    
    public List<Turno> obtenerTurnos(String token) throws Exception{
        if(!validTurno(token)){
            throw new Exception("ERRO EN CONSULTA");
        }
        return turnoRepository.findAll();
    }
    
    public Turno obetenerTurnoId(Long id, String token) throws Exception{
        if(!validTurno(token)){
            throw new Exception("ERRO EN CONSULTA");
        }
        return turnoRepository.findById(id).orElse(null);
    }
    
    // User validation
    public Turno login(String usuario, String clave) throws Exception{
        Turno turno = turnoRepository.findByUsuarioClave(usuario, clave);
        log.warn("USUARIO" + turno);
        if(turno == null){
            throw new Exception("ERROR DE USUARIO");
        }
        
        turno.setUuid(UUID.randomUUID().toString());
        turnoRepository.save(turno);
        turno.setToken(obtenerToken(turno));
        return turno;
    }
    
    public void validarToken(){
        Turno turno = turnoRepository.findById(1L).get();
        String token = obtenerToken(turno);
        log.warn("token: "+token);
        boolean valid = validTurno(token);
        log.warn("valid: " + valid);
    }
    public String obtenerToken(Turno turno){
        String data = turno.crearString();
        return Base64.encodeBase64String(data.getBytes());
    }
    
    public boolean validTurno(String base64){
        String input = new String(Base64.decodeBase64(base64));
        Long id = Long.valueOf(input.split(",")[0]);
        Turno turno = turnoRepository.findById(id).get();
        String valid = turno.crearString();
        return input.equals(valid);
    }
     
}
