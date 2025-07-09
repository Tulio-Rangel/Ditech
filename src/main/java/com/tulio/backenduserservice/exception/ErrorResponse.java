package com.tulio.backenduserservice.exception;

import java.time.LocalDateTime;

/**
 * Clase que representa la estructura de respuesta para errores de la API.
 * Proporciona información detallada sobre el error ocurrido.
 */
public class ErrorResponse {
    private final LocalDateTime timestamp;
    private final int status;
    private final String error;
    private final String message;
    private final String path;

    /**
     * Constructor que crea una respuesta de error con timestamp actual.
     * @param status Código de estado HTTP
     * @param error Tipo de error
     * @param message Mensaje descriptivo del error
     * @param path Ruta del endpoint donde ocurrió el error
     */
    public ErrorResponse(int status, String error, String message, String path) {
        this.timestamp = LocalDateTime.now();
        this.status = status;
        this.error = error;
        this.message = message;
        this.path = path;
    }

    /** Obtiene el timestamp cuando ocurrió el error */
    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    /** Obtiene el código de estado HTTP */
    public int getStatus() {
        return status;
    }

    /** Obtiene el tipo de error */
    public String getError() {
        return error;
    }

    /** Obtiene el mensaje descriptivo del error */
    public String getMessage() {
        return message;
    }

    /** Obtiene la ruta del endpoint donde ocurrió el error */
    public String getPath() {
        return path;
    }
}
