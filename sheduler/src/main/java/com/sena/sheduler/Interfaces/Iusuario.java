package com.sena.sheduler.Interfaces;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sena.sheduler.Model.usuario;

@Repository
public interface Iusuario extends CrudRepository<usuario, String> {

	@Query("SELECT u FROM usuario u WHERE "
			+ "u.numeroDocumento LIKE %?1% OR "
			+ "u.correo LIKE %?1%")
		List<usuario>filtroUsuario(String filtro);
		
		@Query("SELECT u FROM usuario u WHERE DATEDIFF(CURRENT_DATE, u.fechaNacimiento) >= 6570 AND u.tipoDocumento = 'TI'")
		List<usuario>enviarRecordatorioActualizacion();
		
		@Query("SELECT u FROM usuario u WHERE DATEDIFF(CURRENT_DATE, u.fechaUltimaActualizacionContrasena) >= 90")
		List<usuario>enviarNotificacionCambioContrasena();
		
		
		@Query("SELECT u FROM usuario u WHERE DATEDIFF(CURRENT_DATE,u.fechaUltimoInicioSesion) >= 30")
	    List<usuario>enviarRecordatorioSesion();
}