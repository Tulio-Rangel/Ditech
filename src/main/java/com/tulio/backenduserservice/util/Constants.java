package com.tulio.backenduserservice.util;

/**
 * Clase utilitaria que contiene constantes utilizadas en toda la aplicación.
 * Centraliza los mensajes y valores constantes para mantener consistencia.
 */
public final class Constants {

    /** Constructor privado para evitar instanciación de la clase utilitaria */
    private Constants() {
    }

    /** Mensaje de error cuando no se encuentra un usuario por ID */
    public static final String USER_NOT_FOUND_MESSAGE = "User with id %d not found";
}
