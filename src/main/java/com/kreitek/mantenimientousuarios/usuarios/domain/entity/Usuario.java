package com.kreitek.mantenimientousuarios.usuarios.domain.entity;

import com.kreitek.mantenimientousuarios.usuarios.domain.type.RolUsuario;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;

import java.util.Objects;

@Entity
@Table(name = "usuarios")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "usuario_sequence")
    @SequenceGenerator(name = "usuario_sequence")
    private Long id;
    @Column(name = "nombre", nullable = false)
    @Size(min = 3, max = 100)
    private String nombre;

    @Column(name = "apellidos", nullable = false)
    @Size(min = 3, max = 100)
    private String apellidos;

    @Column(name = "email", nullable = false)
    @Size(min = 3, max = 100)
    private String email;

    @Column(name = "rol_usuario", nullable = false, length = 20)
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Usuario usuario)) return false;
        return Objects.equals(id, usuario.id) && Objects.equals(nombre, usuario.nombre) && Objects.equals(apellidos, usuario.apellidos) && Objects.equals(email, usuario.email) && rolUsuario == usuario.rolUsuario;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombre, apellidos, email, rolUsuario);
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", email='" + email + '\'' +
                ", rolUsuario=" + rolUsuario +
                '}';
    }
}
