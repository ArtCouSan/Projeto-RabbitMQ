package br.com.microservice_b.endpoint.validate;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class ValidateUmidadeOptional {

    public static void validarUmidade(Integer umidade) {

        if (umidade < 0 || umidade > 100) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Umidade invalida");
        }

    }

}
