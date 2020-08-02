package br.com.core.endpoint.controller;

import br.com.core.endpoint.dto.CadastrarDroneDTO;
import br.com.core.endpoint.entity.Drone;
import br.com.core.endpoint.services.DroneService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/v1/drone")
public class DroneController {

    DroneService droneService;

    public DroneController(DroneService droneService) {
        this.droneService = droneService;
    }

    @PostMapping
    public ResponseEntity<Drone> cadastrarDrone(@RequestBody CadastrarDroneDTO cadastrarDroneDTO) {

        Drone drone = droneService.cadastrarDrone(cadastrarDroneDTO);

        return new ResponseEntity<Drone>(drone, HttpStatus.OK);

    }

}
