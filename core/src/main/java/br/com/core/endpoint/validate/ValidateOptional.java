package br.com.core.endpoint.validate;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

public class ValidateOptional {

    public static <T> T validarOptional(Optional<T> value) {

        if (value.isPresent()) {
            return value.get();
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Optional vazio");

    }

}
