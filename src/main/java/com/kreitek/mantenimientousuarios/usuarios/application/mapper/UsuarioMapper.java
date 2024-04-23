package com.kreitek.mantenimientousuarios.usuarios.application.mapper;

import com.kreitek.mantenimientousuarios.usuarios.application.dto.UsuarioDto;
import com.kreitek.mantenimientousuarios.usuarios.domain.entity.Usuario;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UsuarioMapper extends EntityMapper<UsuarioDto, Usuario> {


}
