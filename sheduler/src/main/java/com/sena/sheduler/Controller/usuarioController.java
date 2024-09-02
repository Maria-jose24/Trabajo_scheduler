package com.sena.sheduler.Controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sena.sheduler.InterfaceService.IusuarioService;
import com.sena.sheduler.Model.usuario;
import com.sena.sheduler.Service.emailService;

@RequestMapping("/api/v1/usuario")
@RestController
@CrossOrigin
public class usuarioController {

	@Autowired
	private IusuarioService usuarioService;
	
	@Autowired
	private emailService emailService; 

    @PostMapping("/")
    public ResponseEntity<Object> save(@RequestBody usuario usuario) {
        try {
            usuarioService.save(usuario);
            String resultadoCorreo = emailService.enviarCorreoConfirmacion(usuario);
            return ResponseEntity.ok("Usuario registrado con éxito. " + resultadoCorreo);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al registrar el usuario");
        }
    }

	@GetMapping
	public ResponseEntity<Object>findAll(){
		var listaUsuario = usuarioService.findAll();
		return new ResponseEntity<>(listaUsuario, HttpStatus.OK);
	}

	@GetMapping("/busquedafiltro/{filtro}")
	public ResponseEntity<Object>filtroUsuario(@PathVariable String filtro){
		var listaUsuario = usuarioService.filtroUsuario(filtro);
		return new ResponseEntity<>(listaUsuario, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Object>findOne(@PathVariable String id){
		Optional<usuario> usuario = usuarioService.findById(id);
		if (usuario.isPresent()) {
			return new ResponseEntity<>(usuario.get(), HttpStatus.OK);
		}else {
			return new ResponseEntity<>("Usuario no encontrado", HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/eliminar/{id}")
	public ResponseEntity<Object>delete(@PathVariable String id){
		try {
			usuarioService.delete(id);
			return new ResponseEntity<>("Usuario eliminado con éxito", HttpStatus.OK);
		} catch (IllegalArgumentException e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}

	@PutMapping("/{id}")
	public ResponseEntity<Object>update(@PathVariable String id, @RequestBody usuario usuarioUpdate){
		Optional<usuario> usuarioOptional = usuarioService.findById(id);
		if (usuarioOptional.isPresent()) {
			usuario usuario = usuarioOptional.get();
			usuario.setTipoDocumento(usuarioUpdate.getTipoDocumento());
			usuario.setNumeroDocumento(usuarioUpdate.getNumeroDocumento());
			usuario.setFechaNacimiento(usuarioUpdate.getFechaNacimiento());
			usuario.setContrasena(usuarioUpdate.getContrasena());
			usuario.setFechaUltimaActualizacionContrasena(usuarioUpdate.getFechaUltimaActualizacionContrasena());
			usuario.setFechaUltimoInicioSesion(usuario.getFechaUltimoInicioSesion());
			usuario.setEstado(usuarioUpdate.getEstado());
			usuario.setCorreo(usuarioUpdate.getCorreo());
			usuarioService.save(usuario);
			return new ResponseEntity<>(usuario,HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>("Error usuario no encontrado",HttpStatus.BAD_REQUEST);
		}
	}
}