package br.com.microservice_b.endpoint.controller;

import br.com.microservice_b.endpoint.config.ConfigRabbitMQ;
import br.com.microservice_b.endpoint.dto.CadastrarDroneDTO;
import br.com.microservice_b.endpoint.dto.RastrearDroneDTO;
import br.com.microservice_b.endpoint.entity.Drone;
import br.com.microservice_b.endpoint.services.DroneService;
import com.google.gson.Gson;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/v1/drone")
public class DroneController {

    private final DroneService droneService;
    private final RabbitTemplate rabbitTemplate;

    public DroneController(DroneService droneService, RabbitTemplate rabbitTemplate) {
        this.droneService = droneService;
        this.rabbitTemplate = rabbitTemplate;
    }


    @MessageMapping( "/cadastrar")
    @SendTo("/topic/drones")
    public ResponseEntity<List<Drone>> cadastrarDrone(@RequestBody CadastrarDroneDTO cadastrarDroneDTO) {

        Drone drone = droneService.cadastrarDrone(cadastrarDroneDTO);

        Gson json = new Gson();
        String data = json.toJson(drone);

        rabbitTemplate.convertAndSend(ConfigRabbitMQ.EXCHANGE_NAME, "drone.list", data);

        List<Drone> drones = droneService.listarDrones();

        return new ResponseEntity<List<Drone>>(drones, HttpStatus.OK);

    }

    @MessageMapping( "/rastrear")
    @SendTo("/topic/drones")
    public ResponseEntity<List<Drone>> rastrearDrone(@RequestBody RastrearDroneDTO drone) {

        droneService.rastrearDrone(drone.getId_drone().get(), drone.getRastreando().get());

        List<Drone> drones = droneService.listarDrones();

        return new ResponseEntity<List<Drone>>(drones, HttpStatus.OK);

    }

    @GetMapping()
    public ResponseEntity<List<Drone>> listarDrones() {

        List<Drone> dronesAtivos = droneService.listarDronesAtivos();

        return new ResponseEntity<List<Drone>>(this.droneService.listarDrones(), HttpStatus.OK);
    }

}
