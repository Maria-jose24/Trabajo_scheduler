package com.sena.sheduler.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sena.sheduler.InterfaceService.IusuarioService;
import com.sena.sheduler.Interfaces.Iusuario;
import com.sena.sheduler.Model.usuario;

@Service
public class usuarioService implements IusuarioService {

	@Autowired
	private Iusuario data;
	
    @Override
    public String save(usuario usuario) {
    
    	    if (usuario.getNumeroDocumento() == null || usuario.getNumeroDocumento().isEmpty()) {
    	        throw new IllegalArgumentException("El número de documento no puede ser nulo o vacío.");
    	    }

    	    if (usuario.getFechaNacimiento() == null) {
    	        throw new IllegalArgumentException("La fecha de nacimiento no puede ser nula.");
    	    }

    	    if (usuario.getContrasena() == null || usuario.getContrasena().isEmpty()) {
    	        throw new IllegalArgumentException("La contraseña no puede ser nula o vacía.");
    	    }

    	    if (usuario.getFechaUltimaActualizacionContrasena() == null) {
    	        throw new IllegalArgumentException("La fecha de última actualización de la contraseña no puede ser nula.");
    	    }

    	    if (usuario.getFechaUltimoInicioSesion() == null) {
    	        throw new IllegalArgumentException("La fecha del último inicio de sesión no puede ser nula.");
    	    }

    	    if (usuario.getEstado() == null || usuario.getEstado().isEmpty()) {
    	        throw new IllegalArgumentException("El estado no puede ser nulo o vacío.");
    	    }

    	    if (usuario.getCorreo() == null || usuario.getCorreo().isEmpty()) {
    	        throw new IllegalArgumentException("El correo no puede ser nulo o vacío.");
    	    }
    	data.save(usuario);
    	return "Usuario registrado con exito";
    }

    
    @Override
	public List<usuario> findAll() {
		return (List<usuario>) data.findAll();
	}
   
	
	@Override
	public Optional<usuario> findById(String id) {
	    return data.findById(id);
	}
	
	@Override
	public int delete(String id) {
	    if (data.existsById(id)) {
	        data.deleteById(id);
	        return 1;
	    } else {
	        throw new IllegalArgumentException("Usuario no encontrado");
	    }
	}


	@Override
	public List<usuario> filtroUsuario(String filtro) {
		List<usuario>listaUsuario = data.filtroUsuario(filtro);
		return listaUsuario;
	}


	@Override
	public List<usuario> enviarRecordatorioActualizacion() {
		List<usuario>listaUsuario = data.enviarRecordatorioActualizacion();
		return listaUsuario;
	}


	@Override
	public List<usuario> enviarNotificacionCambioContrasena() {
		List<usuario>listaUsuario = data.enviarNotificacionCambioContrasena();
		return listaUsuario;
	}


	@Override
	public List<usuario> enviarRecordatorioSesion() {
		List<usuario>listaUsuario = data.enviarRecordatorioSesion();
		return listaUsuario;
	}   
}
