package br.com.microservice_b.endpoint.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Optional;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CadastrarDroneDTO implements Serializable {

    private static final long serialVersionUID = 8967560817220124739L;

    private Optional<String> id_drone;
    private Optional<Double> longitude;
    private Optional<Double> latitude;
    private Optional<Double> temperatura;
    private Optional<Integer> umidade;

    public Optional<String> getId_drone() {
        return id_drone;
    }

    public void setId_drone(Optional<String> id_drone) {
        this.id_drone = id_drone;
    }

    public Optional<Double> getLongitude() {
        return longitude;
    }

    public void setLongitude(Optional<Double> longitude) {
        this.longitude = longitude;
    }

    public Optional<Double> getLatitude() {
        return latitude;
    }

    public void setLatitude(Optional<Double> latitude) {
        this.latitude = latitude;
    }

    public Optional<Double> getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(Optional<Double> temperatura) {
        this.temperatura = temperatura;
    }

    public Optional<Integer> getUmidade() {
        return umidade;
    }

    public void setUmidade(Optional<Integer> umidade) {
        this.umidade = umidade;
    }

    public CadastrarDroneDTO(Optional<String> id_drone, Optional<Double> longitude, Optional<Double> latitude, Optional<Double> temperatura, Optional<Integer> umidade) {
        this.id_drone = id_drone;
        this.longitude = longitude;
        this.latitude = latitude;
        this.temperatura = temperatura;
        this.umidade = umidade;
    }

    public CadastrarDroneDTO() {
        this.id_drone = Optional.empty();
        this.longitude = Optional.empty();
        this.latitude = Optional.empty();
        this.temperatura = Optional.empty();
        this.umidade = Optional.empty();
    }
}
