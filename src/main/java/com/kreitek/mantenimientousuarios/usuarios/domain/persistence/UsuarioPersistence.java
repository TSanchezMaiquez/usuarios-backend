package com.kreitek.mantenimientousuarios.usuarios.domain.persistence;

import com.kreitek.mantenimientousuarios.usuarios.domain.entity.Usuario;

import java.util.List;
import java.util.Optional;

public interface UsuarioPersistence {
    List<Usuario> getAllUsers();
    Optional<Usuario> getUserById(Long usuarioId);
    Usuario saveUser(Usuario usuario);
    void deleteUser(Long usuarioId);
}
