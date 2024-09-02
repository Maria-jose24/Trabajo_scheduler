package com.sena.sheduler.TaskSheduler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.sena.sheduler.Model.usuario;
import com.sena.sheduler.Service.emailService;
import com.sena.sheduler.Service.usuarioService;

@Component
public class Task {
	
	@Autowired
	private usuarioService data;

	@Autowired
	private emailService email;

	@Scheduled(cron = "0 0 0 * * ?") //se ejecuta diariamente a medianoche
	public void sendNotificationRecordatorioActualizacion() {
		var listaUsuario = data.enviarRecordatorioActualizacion();
		for (usuario usuario : listaUsuario) {
			System.out.println("Usuario que requiere actualizar el documento de identidad " + usuario.getId());
			email.enviarRecordatorioActualizacion(usuario);
		}
	}
	
	@Scheduled(fixedRate = 1800000) //se ejecuta cada media hora
	public void sendEnviarNotificacionCambioContrasena() {
		var listaUsuario = data.enviarNotificacionCambioContrasena();
		for (usuario usuario : listaUsuario) {
			System.out.println("Usuario que requiere cambiar la Contraseña " + usuario.getId());
			email.enviarNotificacionCambioContrasena(usuario);
		}
	}
	
	
	@Scheduled(cron = "0 0 0 * * SUN") // Se ejecuta todos los domingos a medianoche
    public void enviarRecordatorioSesion() {
        var listaUsuario = data.enviarRecordatorioSesion();
        for (usuario usuario : listaUsuario) {
                System.out.println("Recordatorio enviado" + usuario.getId());
                email.enviarRecordatorioSesion(usuario);
        }
	}
}
