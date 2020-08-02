package br.com.core.endpoint.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "TB_DRONE")
public class Drone implements Serializable {

    private static final long serialVersionUID = -6572815316816024859L;
    @Id
    @Column(name = "ID_DRONE", nullable = false)
    private String id_drone;

    @Column(name = "LONGITUDE", nullable = false)
    private Double longitude;

    @Column(name = "LATITUDE", nullable = false)
    private Double latitude;

    @Column(name = "TEMPERATURA", nullable = false)
    private Double temperatura;

    @Column(name = "UMIDADE", nullable = false)
    private Integer umidade;

    @Column(name = "RASTREANDO", nullable = false)
    private Boolean rastreando;

    public String getId_drone() {
        return id_drone;
    }

    public void setId_drone(String id_drone) {
        this.id_drone = id_drone;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(Double temperatura) {
        this.temperatura = temperatura;
    }

    public Integer getUmidade() {
        return umidade;
    }

    public void setUmidade(Integer umidade) {
        this.umidade = umidade;
    }

    public Boolean getRastreando() {
        return rastreando;
    }

    public void setRastreando(Boolean rastreando) {
        this.rastreando = rastreando;
    }

    public Drone() {
    }


}
