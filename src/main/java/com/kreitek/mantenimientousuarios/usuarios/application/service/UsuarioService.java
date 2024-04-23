package com.kreitek.mantenimientousuarios.usuarios.application.service;

import com.kreitek.mantenimientousuarios.usuarios.application.dto.UsuarioDto;

import java.util.List;
import java.util.Optional;

public interface UsuarioService {
    List<UsuarioDto> getAllUsers();
    Optional<UsuarioDto> getUserById(Long usuarioId);
    UsuarioDto saveUser(UsuarioDto usuarioDto);
    void deleteUser(Long usuarioId);
}
