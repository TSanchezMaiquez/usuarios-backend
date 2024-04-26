package com.kreitek.mantenimientousuarios.usuarios.infraestructure.rest;

import com.kreitek.mantenimientousuarios.usuarios.application.dto.UsuarioDto;
import com.kreitek.mantenimientousuarios.usuarios.application.service.UsuarioService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UsuarioRestController {

    private final UsuarioService usuarioService;

    public UsuarioRestController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }
    @CrossOrigin
    @GetMapping(value = "/usuarios/{usuarioId}", produces = "application/json")
    public ResponseEntity <UsuarioDto> obtenerUsuarioPorId(@PathVariable Long usuarioId){
        return usuarioService
                .getUserById(usuarioId)
                .map(usuarioDto -> new ResponseEntity<>(usuarioDto, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));

    }
    @CrossOrigin
    @PostMapping(value = "/usuarios", produces = "application/json")
    public ResponseEntity<UsuarioDto> insertUser(@RequestBody UsuarioDto usuarioDto) {
        usuarioDto = usuarioService.saveUser(usuarioDto);
        return new ResponseEntity<>(usuarioDto, HttpStatus.CREATED);
    }
    @CrossOrigin
    @PatchMapping(value = "/usuarios/{usuarioId}", produces = "application/json", consumes = "application/json")
    public ResponseEntity<UsuarioDto> updateUser(@PathVariable Long usuarioId, @RequestBody UsuarioDto usuarioDto) {
        usuarioDto = usuarioService.saveUser(usuarioDto);
        return new ResponseEntity<>(usuarioDto, HttpStatus.OK);
    }
    @CrossOrigin
    @DeleteMapping(value = "/usuarios/{userId}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long userId) {
        usuarioService.deleteUser(userId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @CrossOrigin
    @GetMapping(value = "/usuarios", produces = "application/json")
    public ResponseEntity<Page<UsuarioDto>> getUsersByCriteriaPaged(
            @RequestParam(value = "filter", required = false) String filter,
            Pageable pageable,
            @RequestParam(value = "rolUsuarioFiltro", required = false) String rolUsuarioFiltro) {
        
        Page<UsuarioDto> usuarios = usuarioService.getUsersByCriteriaStringPaged(pageable,filter);

        Page<UsuarioDto> usuariosFiltrados = null;
        if(rolUsuarioFiltro!=null){
           usuariosFiltrados = usuarioService.filtrarPorRol(usuarios, rolUsuarioFiltro);
            return new ResponseEntity<>(usuariosFiltrados, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(usuarios, HttpStatus.OK);
        }
    }

}
