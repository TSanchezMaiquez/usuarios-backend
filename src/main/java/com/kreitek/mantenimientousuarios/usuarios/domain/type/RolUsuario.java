package com.kreitek.mantenimientousuarios.usuarios.domain.type;

public enum RolUsuario {

    ADMINISTRADOR, CONTRIBUTOR;

    @Override
    public String toString() {
        return name();
    }

    public static RolUsuario fromString(String rol) {
        for (RolUsuario r : RolUsuario.values()) {
            if (r.toString().equalsIgnoreCase(rol)) {
                return r;
            }
        }
        throw new IllegalArgumentException("Rol de usuario no válido: " + rol);
    }
}
