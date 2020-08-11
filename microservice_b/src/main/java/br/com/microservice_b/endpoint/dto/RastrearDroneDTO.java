package br.com.microservice_b.endpoint.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
import java.util.Optional;

@JsonIgnoreProperties(ignoreUnknown = true)
public class RastrearDroneDTO implements Serializable {

    private static final long serialVersionUID = -5135732125935107424L;

    private Optional<String> id_drone;
    private Optional<Boolean> rastreando;

    public Optional<String> getId_drone() {
        return id_drone;
    }

    public void setId_drone(Optional<String> id_drone) {
        this.id_drone = id_drone;
    }

    public Optional<Boolean> getRastreando() {
        return rastreando;
    }

    public void setRastreando(Optional<Boolean> rastreando) {
        this.rastreando = rastreando;
    }

    public RastrearDroneDTO(Optional<String> id_drone, Optional<Boolean> rastreando) {
        this.id_drone = id_drone;
        this.rastreando = rastreando;
    }

    public RastrearDroneDTO() {
        this.id_drone = Optional.empty();
        this.rastreando = Optional.empty();
    }
}
