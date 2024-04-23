package com.kreitek.mantenimientousuarios.usuarios.infraestructure.rest;

import com.kreitek.mantenimientousuarios.usuarios.application.dto.UsuarioDto;
import com.kreitek.mantenimientousuarios.usuarios.application.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UsuarioRestController {

    private final UsuarioService usuarioService;
    @Autowired
    public UsuarioRestController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }
    @CrossOrigin
    @GetMapping(value = "/usuarios", produces = "application/json")
    public ResponseEntity<List<UsuarioDto>> obtenerUsuarios(){
        var usuarios = usuarioService.getAllUsers();
        return new ResponseEntity<>(usuarios, HttpStatus.OK);
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
    @PatchMapping(value = "/usuarios/{usuarioId}", produces = "application/json")
    public ResponseEntity<UsuarioDto> updateUser(@PathVariable Long usuarioId,
                                                 @RequestBody UsuarioDto usuarioDto) {
        usuarioDto.setId(usuarioId);
        usuarioDto = usuarioService.saveUser(usuarioDto);
        return new ResponseEntity<>(usuarioDto, HttpStatus.OK);
    }
    @CrossOrigin
    @DeleteMapping(value = "/usuarios/{userId}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long userId) {
        usuarioService.deleteUser(userId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
