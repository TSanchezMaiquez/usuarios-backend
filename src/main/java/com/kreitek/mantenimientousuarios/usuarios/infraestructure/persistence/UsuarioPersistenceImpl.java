package com.kreitek.mantenimientousuarios.usuarios.infraestructure.persistence;

import com.kreitek.mantenimientousuarios.usuarios.domain.entity.Usuario;
import com.kreitek.mantenimientousuarios.usuarios.domain.persistence.UsuarioPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public class UsuarioPersistenceImpl implements UsuarioPersistence {

    private final UsuarioRepository usuarioRepository;
    @Autowired
    public UsuarioPersistenceImpl(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public List<Usuario> getAllUsers() {
        return usuarioRepository.findAll();
    }

    @Override
    public Optional<Usuario> getUserById(Long usuarioId) {
        return usuarioRepository.findById(usuarioId);
    }

    @Override
    public Usuario saveUser(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    @Override
    public void deleteUser(Long usuarioId) {
        usuarioRepository.deleteById(usuarioId);
    }
}
