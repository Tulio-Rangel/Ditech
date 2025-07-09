package com.tulio.backenduserservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Excepción personalizada para recursos no encontrados.
 * Se lanza cuando se intenta acceder a un recurso que no existe en la base de datos.
 * Devuelve automáticamente HTTP 404 (NOT_FOUND) cuando es lanzada desde un controlador.
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {
    /**
     * Constructor que permite especificar un mensaje de error personalizado.
     * @param message Mensaje descriptivo del error
     */
    public ResourceNotFoundException(String message) {
        super(message);
    }
}
