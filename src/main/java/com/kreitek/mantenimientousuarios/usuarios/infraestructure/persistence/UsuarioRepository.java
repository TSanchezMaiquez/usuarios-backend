package com.kreitek.mantenimientousuarios.usuarios.infraestructure.persistence;

import com.kreitek.mantenimientousuarios.usuarios.domain.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}