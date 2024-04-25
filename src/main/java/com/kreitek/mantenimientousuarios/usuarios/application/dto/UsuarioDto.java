package com.kreitek.mantenimientousuarios.usuarios.application.dto;

import com.kreitek.mantenimientousuarios.usuarios.domain.type.RolUsuario;


import java.io.Serializable;

public class UsuarioDto implements Serializable {

    private Long id;
    private String nombre;
    private String apellidos;
    private String email;
    private RolUsuario rolUsuario;



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public RolUsuario getRolUsuario() {
        return rolUsuario;
    }

    public void setRolUsuario(RolUsuario rolUsuario) {
        this.rolUsuario = rolUsuario;
    }

    @Override
    public String toString() {
        return "UsuarioDto{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", email='" + email + '\'' +
                ", rolUsuario=" + rolUsuario +
                '}';
    }
}
