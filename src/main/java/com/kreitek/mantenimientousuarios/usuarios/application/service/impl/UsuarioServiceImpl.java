package com.kreitek.mantenimientousuarios.usuarios.application.service.impl;

import com.kreitek.mantenimientousuarios.usuarios.application.dto.UsuarioDto;
import com.kreitek.mantenimientousuarios.usuarios.application.mapper.UsuarioMapper;
import com.kreitek.mantenimientousuarios.usuarios.application.service.UsuarioService;
import com.kreitek.mantenimientousuarios.usuarios.domain.entity.Usuario;
import com.kreitek.mantenimientousuarios.usuarios.domain.persistence.UsuarioPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
@Service
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioPersistence usuarioPersistence;
    private final UsuarioMapper usuarioMapper;
    @Autowired
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
        Usuario usuario = usuarioMapper.toEntity(usuarioDto);
        usuario = usuarioPersistence.saveUser(usuario);
        return usuarioMapper.toDto(usuario);
    }

    @Override
    @Transactional
    public void deleteUser(Long usuarioId) {
        usuarioPersistence.deleteUser(usuarioId);

    }
}
