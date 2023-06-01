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

    @Autowired
    TurnoService turnoController;

    @GetMapping(value = "/all")
    public List<Turno> getAllturnos(@RequestHeader(value = "token") String token) throws Exception {
        return turnoController.obtenerTurnos(token);
    }

    @GetMapping(value = "/turno/{id}")
    public Turno obetnerTurnoId(@PathVariable Long id) {
        return turnoController.obetenerTurnoId(id);
    }

    @GetMapping("/{name}/{clave}")
    public Turno logearTurno(@PathParam(value = "name") String name, @PathParam(value = "clave") String clave) throws Exception {
        return turnoController.login(name, clave);
    }
}
