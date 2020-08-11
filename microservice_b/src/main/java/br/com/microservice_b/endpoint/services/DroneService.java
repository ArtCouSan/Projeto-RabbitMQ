package br.com.microservice_b.endpoint.services;

import br.com.microservice_b.endpoint.dto.CadastrarDroneDTO;
import br.com.microservice_b.endpoint.entity.Drone;

import java.util.List;

public interface DroneService {

    public Drone cadastrarDrone(CadastrarDroneDTO cadastrarDroneDTO);

    public Drone rastrearDrone(String id, Boolean status);

    public List<Drone> listarDrones();

    public List<Drone> listarDronesAtivos();

}
