package com.kreitek.mantenimientousuarios.usuarios.application.service;

import com.kreitek.mantenimientousuarios.usuarios.application.dto.UsuarioDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface UsuarioService {
    List<UsuarioDto> getAllUsers();
    Optional<UsuarioDto> getUserById(Long usuarioId);
    UsuarioDto saveUser(UsuarioDto usuarioDto);
    void deleteUser(Long usuarioId);
    Page<UsuarioDto> getUsersByCriteriaStringPaged(Pageable pageable, String filter);
    Page<UsuarioDto> filtrarPorRol(Page<UsuarioDto> usuarios, String rolUsuarioFiltro);
}
