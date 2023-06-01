package com.gizlo.turnos.controller;

import com.gizlo.turnos.model.Turno;
import com.gizlo.turnos.service.TurnoService;
import jakarta.websocket.server.PathParam;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Paul
 */
@RestController
@RequestMapping(value = "/turnos")
public class TurnoController {

    private String token;
    
    @Autowired
    TurnoService turnoController;

    @GetMapping("/{name}/{clave}")
    public Turno logearTurno(@PathParam(value = "name") String name, @PathParam(value = "clave") String clave) throws Exception {
        Turno turnoToken = turnoController.login(name, clave);
        token = turnoToken.getToken();
        return turnoToken;
    }
    
    @GetMapping(value = "/all")
    public List<Turno> getAllturnos() throws Exception {
        return turnoController.obtenerTurnos(this.token);
    }

    @GetMapping(value = "/turno/{id}")
    public Turno obetnerTurnoId(@PathVariable Long id) throws Exception {
        return turnoController.obetenerTurnoId(id, this.token);
    }

    
}
