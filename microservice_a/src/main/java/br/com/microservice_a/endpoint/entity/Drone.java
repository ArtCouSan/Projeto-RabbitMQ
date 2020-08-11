package br.com.microservice_a.endpoint.entity;

public class Drone {

    private String id_drone;

    private Double longitude;

    private Double latitude;

    private Double temperatura;

    private Integer umidade;
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

    public Drone(
            String id_drone,
            Double longitude,
            Double latitude,
            Double temperatura,
            Integer umidade,
            Boolean rastreando) {
        this.id_drone = id_drone;
        this.longitude = longitude;
        this.latitude = latitude;
        this.temperatura = temperatura;
        this.umidade = umidade;
        this.rastreando = rastreando;
    }
}
