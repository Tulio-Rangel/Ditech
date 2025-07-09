package com.tulio.backenduserservice.repository;

import com.tulio.backenduserservice.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repositorio para operaciones de persistencia de usuarios.
 * Extiende JpaRepository para proveer operaciones CRUD estándar (crear, leer, actualizar, eliminar)
 * sobre la entidad User con tipo de clave primaria Long.
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // Hereda métodos como save(), findById(), findAll(), deleteById(), etc.
}
