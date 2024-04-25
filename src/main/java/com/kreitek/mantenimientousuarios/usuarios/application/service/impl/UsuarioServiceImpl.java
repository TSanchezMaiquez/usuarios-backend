package com.kreitek.mantenimientousuarios.usuarios.application.service.impl;

import com.kreitek.mantenimientousuarios.usuarios.application.dto.UsuarioDto;
import com.kreitek.mantenimientousuarios.usuarios.application.mapper.UsuarioMapper;
import com.kreitek.mantenimientousuarios.usuarios.application.service.UsuarioService;
import com.kreitek.mantenimientousuarios.usuarios.domain.entity.Usuario;
import com.kreitek.mantenimientousuarios.usuarios.domain.persistence.UsuarioPersistence;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
@Service
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioPersistence usuarioPersistence;
    private final UsuarioMapper usuarioMapper;

    public UsuarioServiceImpl(UsuarioPersistence usuarioPersistence, UsuarioMapper usuarioMapper) {
        this.usuarioPersistence = usuarioPersistence;
        this.usuarioMapper = usuarioMapper;
    }

    @Override
    @Transactional(readOnly = true)
    public List<UsuarioDto> getAllUsers() {
        List<Usuario> usuarios = usuarioPersistence.getAllUsers();
        return usuarioMapper.toDto(usuarios);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<UsuarioDto> getUserById(Long usuarioId) {
        return usuarioPersistence.getUserById(usuarioId).map(usuarioMapper::toDto);
    }

    @Override
    @Transactional
    public UsuarioDto saveUser(UsuarioDto usuarioDto) {

        return usuarioMapper.toDto(usuarioPersistence.saveUser(usuarioMapper.toEntity(usuarioDto)));
    }

    @Override
    @Transactional
    public void deleteUser(Long usuarioId) {
        usuarioPersistence.deleteUser(usuarioId);

    }

    @Override
    @Transactional
    public Page<UsuarioDto> getUsersByCriteriaStringPaged(Pageable pageable, String filter) {

        Page<Usuario> usersPage = this.usuarioPersistence.findAll(pageable, filter);
        return usersPage.map(usuarioMapper::toDto);
    }
}
