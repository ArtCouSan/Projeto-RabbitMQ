package br.com.core.endpoint.services.impl;

import br.com.core.endpoint.dto.CadastrarDroneDTO;
import br.com.core.endpoint.entity.Drone;
import br.com.core.endpoint.repository.DroneRepository;
import br.com.core.endpoint.services.DroneService;
import br.com.core.endpoint.validate.ValidateLocalizacaoOptional;
import br.com.core.endpoint.validate.ValidateOptional;
import br.com.core.endpoint.validate.ValidateTemperaturaOptional;
import br.com.core.endpoint.validate.ValidateUmidadeOptional;
import org.springframework.stereotype.Service;

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

        drone.setRastreando(ValidateOptional.validarOptional(cadastrarDroneDTO.getRastreando()));

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

}
