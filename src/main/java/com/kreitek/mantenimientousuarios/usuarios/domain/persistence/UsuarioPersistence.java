package com.kreitek.mantenimientousuarios.usuarios.domain.persistence;

import com.kreitek.mantenimientousuarios.usuarios.domain.entity.Usuario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface UsuarioPersistence {
    List<Usuario> getAllUsers();
    Optional<Usuario> getUserById(Long usuarioId);
    Usuario saveUser(Usuario usuario);
    void deleteUser(Long usuarioId);

    Page<Usuario> findAll(Pageable pageable, String filter);
}
