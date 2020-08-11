package br.com.microservice_b.endpoint.services.impl;

import br.com.microservice_b.endpoint.dto.CadastrarDroneDTO;
import br.com.microservice_b.endpoint.entity.Drone;
import br.com.microservice_b.endpoint.repository.DroneRepository;
import br.com.microservice_b.endpoint.services.DroneService;
import br.com.microservice_b.endpoint.validate.ValidateLocalizacaoOptional;
import br.com.microservice_b.endpoint.validate.ValidateOptional;
import br.com.microservice_b.endpoint.validate.ValidateTemperaturaOptional;
import br.com.microservice_b.endpoint.validate.ValidateUmidadeOptional;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class DroneServiceImpl implements DroneService {

    DroneRepository droneRepository;

    public DroneServiceImpl(DroneRepository droneRepository) {
        this.droneRepository = droneRepository;
    }

    @Override
    public Drone cadastrarDrone(CadastrarDroneDTO cadastrarDroneDTO) {

        Drone drone = new Drone();

        drone.setId_drone(ValidateOptional.validarOptional(cadastrarDroneDTO.getId_drone()));

        drone.setRastreando(false);

        Double temperatura = ValidateOptional.validarOptional(cadastrarDroneDTO.getTemperatura());
        ValidateTemperaturaOptional.validarTemperatura(cadastrarDroneDTO.getTemperatura().get());
        drone.setTemperatura(temperatura);

        Integer umidade = ValidateOptional.validarOptional(cadastrarDroneDTO.getUmidade());
        ValidateUmidadeOptional.validarUmidade(umidade);
        drone.setUmidade(umidade);

        Double latitude = ValidateOptional.validarOptional(cadastrarDroneDTO.getLatitude());
        Double longitude = ValidateOptional.validarOptional(cadastrarDroneDTO.getLongitude());
        ValidateLocalizacaoOptional.validarLatitude(latitude);
        ValidateLocalizacaoOptional.validarLongitude(longitude);

        drone.setLatitude(latitude);
        drone.setLongitude(longitude);

        return droneRepository.save(drone);
    }

    @Override
    public Drone rastrearDrone(String id, Boolean status) {

        Optional<Drone> drone = droneRepository.findById(id);

        if(drone.isPresent()) {

            Drone droneTemp = drone.get();
            droneTemp.setRastreando(status);
            droneRepository.save(droneTemp);

            return droneTemp;

        } else {

            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Drone não encontrado");

        }

    }

    @Override
    public List<Drone> listarDrones() {
        return this.droneRepository.findAll();
    }

    @Override
    public List<Drone> listarDronesAtivos() {

        return this.droneRepository.findByRastreandoIsTrue();

    }

}
