package com.tulio.backenduserservice.service;

import com.tulio.backenduserservice.exception.ResourceNotFoundException;
import com.tulio.backenduserservice.model.User;
import com.tulio.backenduserservice.repository.UserRepository;
import com.tulio.backenduserservice.util.Constants;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Servicio para la gestión de usuarios que contiene la lógica de negocio.
 * Realiza operaciones CRUD sobre la entidad User, interactuando con el repositorio.
 */
@Service
public class UserService {
    private final UserRepository userRepository;

    /**
     * Constructor que inyecta el repositorio de usuarios.
     * @param userRepository Repositorio para realizar operaciones CRUD
     */
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     * Guarda un usuario en la base de datos.
     * @param user El usuario a guardar
     * @return El usuario guardado
     */
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    /**
     * Recupera todos los usuarios de la base de datos.
     * @return Lista de todos los usuarios
     */
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    /**
     * Busca un usuario por su ID.
     * @param id ID del usuario
     * @return El usuario encontrado
     * @throws ResourceNotFoundException si el usuario no existe
     */
    public User getUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(String.format(Constants.USER_NOT_FOUND_MESSAGE, id)));
    }

    /**
     * Elimina un usuario por su ID.
     * @param id ID del usuario a eliminar
     * @throws ResourceNotFoundException si el usuario no existe
     */
    public void deleteUser(Long id) {
        if (!userRepository.existsById(id)) {
            throw new ResourceNotFoundException(String.format(Constants.USER_NOT_FOUND_MESSAGE, id));
        }
        userRepository.deleteById(id);
    }
}
