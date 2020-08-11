package br.com.microservice_b.endpoint.validate;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class ValidateLocalizacaoOptional {

    public static void validarLatitude(Double latitude) {

        if (latitude < -90 || latitude > 90) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Latitude invalida");
        }


    }

    public static void validarLongitude(Double longitude) {

        if (longitude < -180 || longitude > 180) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Longitude invalida");
        }

    }

}
