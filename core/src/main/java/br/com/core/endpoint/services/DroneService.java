package br.com.core.endpoint.services;

import br.com.core.endpoint.dto.CadastrarDroneDTO;
import br.com.core.endpoint.entity.Drone;

public interface DroneService {

    public Drone cadastrarDrone(CadastrarDroneDTO cadastrarDroneDTO);

}
