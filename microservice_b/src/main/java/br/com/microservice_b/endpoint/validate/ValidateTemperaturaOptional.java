package br.com.microservice_b.endpoint.validate;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class ValidateTemperaturaOptional {

    public static void validarTemperatura(Double temperatura) {

        if (temperatura < -25 || temperatura > 40) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Temperatura invalida");
        }

    }

}
