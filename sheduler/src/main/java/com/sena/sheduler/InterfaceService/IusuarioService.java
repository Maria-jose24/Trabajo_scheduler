package com.sena.sheduler.InterfaceService;

import java.util.List;
import java.util.Optional;

import com.sena.sheduler.Model.usuario;

public interface IusuarioService {
	
	public String save (usuario usuario);
	public List<usuario>findAll();
	public Optional<usuario>findById(String id);
	public int delete(String id);
	
	List<usuario>filtroUsuario(String filtro);
	List<usuario>enviarRecordatorioActualizacion();
	List<usuario>enviarNotificacionCambioContrasena();
	List<usuario>enviarRecordatorioSesion( );

}