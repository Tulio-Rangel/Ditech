package com.tulio.backenduserservice.controller;

import com.tulio.backenduserservice.model.User;
import com.tulio.backenduserservice.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador REST para la gestión de usuarios.
 * Provee endpoints para realizar operaciones CRUD sobre usuarios.
 */
@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    /**
     * Constructor que inyecta el servicio de usuarios.
     * @param userService Servicio para gestionar usuarios
     */
    public UserController(UserService userService) {
        this.userService = userService;
    }

    /**
     * Endpoint para obtener todos los usuarios.
     * @return Lista de usuarios en el sistema
     */
    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    /**
     * Endpoint para obtener un usuario por ID.
     * @param id ID del usuario a buscar
     * @return Usuario encontrado
     */
    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        User user = userService.getUserById(id);
        return ResponseEntity.ok(user);
    }

    /**
     * Endpoint para crear un nuevo usuario.
     * @param user Datos del usuario a crear
     * @return Usuario creado
     */
    @PostMapping
    public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.saveUser(user));
    }

    /**
     * Endpoint para eliminar un usuario por ID.
     * @param id ID del usuario a eliminar
     * @return Respuesta vacía con estado HTTP 204
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }
}
