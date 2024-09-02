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

	
	 // Tarea programada para enviar recordatorio de actualización de documento cada día a medianoche
    //@Scheduled(cron = "0 0 0 * * ?") // se ejecuta diariamente a medianoche
    @Scheduled(fixedRate = 60000)
    public void sendNotificationRecordatorioActualizacion() {
        var listaUsuario = data.enviarRecordatorioActualizacion();
        for (usuario usuario : listaUsuario) {
            System.out.println("Usuario que requiere actualizar el documento de identidad " + usuario.getId());
            email.enviarRecordatorioActualizacion(usuario);
        }
    }

    // Tarea programada para enviar notificación de cambio de contraseña cada 30 minutos
    //@Scheduled(fixedRate = 1800000) // se ejecuta cada media hora
    @Scheduled(fixedRate = 60000)
    public void sendEnviarNotificacionCambioContrasena() {
        var listaUsuario = data.enviarNotificacionCambioContrasena();
        for (usuario usuario : listaUsuario) {
            System.out.println("Usuario que requiere cambiar la contraseña " + usuario.getId());
            email.enviarNotificacionCambioContrasena(usuario);
        }
    }
   

    // Tarea programada para enviar recordatorio de inicio de sesión cada domingo a medianoche
    //@Scheduled(cron = "0 0 0 * * SUN") // Se ejecuta todos los domingos a medianoche
    @Scheduled(cron = "0 17 14 * * *")
    //@Scheduled(fixedRate = 60000)
    public void enviarRecordatorioSesion() {
        var listaUsuario = data.enviarRecordatorioSesion();
        for (usuario usuario : listaUsuario) {
            System.out.println("Usuario requiere iniciar sesion " + usuario.getId());
            email.enviarRecordatorioSesion(usuario);
        }
    }
}