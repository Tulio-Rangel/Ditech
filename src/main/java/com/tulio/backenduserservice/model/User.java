package com.tulio.backenduserservice.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

/**
 * Entidad JPA que representa un usuario en el sistema.
 * Contiene la información básica del usuario: id, nombre de usuario, email y estado activo.
 */
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "Username is mandatory")
    private String username;
    @NotBlank(message = "Email is mandatory")
    @Email(message = "Email should be valid")
    private String email;
    @Column(name = "is_active")
    @NotNull(message = "Active status is mandatory")
    private Boolean active;

    /** Obtiene el ID único del usuario */
    public Long getId() {
        return id;
    }

    /** Establece el ID único del usuario */
    public void setId(Long id) {
        this.id = id;
    }

    /** Obtiene el nombre de usuario */
    public String getUsername() {
        return username;
    }

    /** Establece el nombre de usuario */
    public void setUsername(String username) {
        this.username = username;
    }

    /** Obtiene el email del usuario */
    public String getEmail() {
        return email;
    }

    /** Establece el email del usuario */
    public void setEmail(String email) {
        this.email = email;
    }

    /** Obtiene el estado activo del usuario */
    public Boolean getActive() {
        return active;
    }

    /** Establece el estado activo del usuario */
    public void setActive(Boolean active) {
        this.active = active;
    }
}
