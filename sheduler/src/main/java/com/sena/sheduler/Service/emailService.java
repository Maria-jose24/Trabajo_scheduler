package com.sena.sheduler.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.sena.sheduler.Model.usuario;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Service
public class emailService {
	@Autowired
	private JavaMailSender javaMailSender;

	//Metodo de envio del correo para la actualizacion del documento
	public String enviarRecordatorioActualizacion(usuario usuario) {
		try {
			//String destinatario=usuario.getCorreo();
			String asunto = "Es hora de actualizar tu tipo de documento de Identidad";
			String cuerpo = "<div style=\"background-color: #007BFF; padding: 20px; font-family: Arial, sans-serif; color: white; border-radius: 10px;\">"
			               + "<h1 style=\"font-size: 24px; font-weight: bold; margin-bottom: 20px;\">Cordial Saludo,</h1>"
			               + "<p style=\"font-size: 16px; margin-bottom: 20px;\">Queremos recordarte que es el momento de actualizar tu tipo de documento de identidad "
			               + "ya que has cumplido 18 años. Es un proceso muy rápido y sencillo.</p>"
			               + "<p style=\"font-size: 16px; margin-bottom: 20px;\">Por favor, actualiza tu Tarjeta de Identidad a Cédula de Ciudadanía.</p>"
			               + "<p style=\"font-size: 16px; margin-bottom: 20px;\">Si ya has actualizado tu documento, por favor ignora este mensaje.</p>"
			               + "<p style=\"font-size: 16px;\">Gracias por tu colaboración.</p>"
			               + "<div style=\"text-align: center; margin-top: 20px;\">"
			               + "<a href=\"#\" style=\"font-size: 14px; color: #000000; text-decoration: none;\">Términos y condiciones</a> | "
			               + "<a href=\"#\" style=\"font-size: 14px; color: #000000; text-decoration: none;\">Política de privacidad</a>"
			               + "</div>"
			               + "</div>";


			var retorno=enviarCorreo(usuario.getCorreo(),asunto,cuerpo);
			if(retorno) {
				return "Se envió correctamente";
			}else {
				return "No se pudo envíar";
			}

		}catch (Exception e) {
			return "Erro al envíar "+e.getMessage();
		}
	}


	//Tarea de la atualizacion de contraseña
	public String enviarNotificacionCambioContrasena(usuario usuario) {
		try {
			//String destinatario=usuario.getCorreo();
			String asunto = "Actualización de la Contraseña";
			String cuerpo = "<div style=\"background-color: #007BFF; padding: 20px; font-family: Arial, sans-serif; color: white; border-radius: 10px;\">"
			               + "<h1 style=\"font-size: 24px; font-weight: bold; margin-bottom: 20px;\">Estimado Usuario,</h1>"
			               + "<p style=\"font-size: 16px; margin-bottom: 20px;\">Han pasado más de 30 días desde la última actualización de tu contraseña.</p>"
			               + "<p style=\"font-size: 16px; margin-bottom: 20px;\">Por razones de seguridad, te solicitamos que cambies tu contraseña lo antes posible para proteger tu cuenta.</p>"
			               + "<p style=\"font-size: 16px; margin-bottom: 20px;\">Si ya has cambiado tu contraseña, por favor ignora este mensaje.</p>"
			               + "<p style=\"font-size: 16px;\">Gracias por tu atención y cooperación.</p>"
			               + "<div style=\"text-align: center; margin-top: 20px;\">"
			               + "<a href=\"#\" style=\"font-size: 14px; color: #000000; text-decoration: none;\">Términos y condiciones</a> | "
			               + "<a href=\"#\" style=\"font-size: 14px; color: #000000; text-decoration: none;\">Política de privacidad</a>"
			               + "</div>"			               
			               + "</div>";


			var retorno=enviarCorreo(usuario.getCorreo(),asunto,cuerpo);
			if(retorno) {
				return "Se envió correctamente";
			}else {
				return "No se pudo envíar";
			}

		}catch (Exception e) {
			return "Erro al envíar "+e.getMessage();
		}
	}


	//envio del correo al momento de registrarse 
	public String enviarCorreoConfirmacion(usuario usuario) {
		try {
			//String destinatario=usuario.getCorreo();
			String asunto = "Confirmación de Registro Exitoso";
			String cuerpo = "<div style=\"background-color: #007BFF; padding: 20px; font-family: Arial, sans-serif; color: white; border-radius: 10px;\">"
			               + "<h1 style=\"font-size: 24px; font-weight: bold; margin-bottom: 20px;\">¡Bienvenido a Nuestra Plataforma!</h1>"
			               + "<p style=\"font-size: 16px; margin-bottom: 20px;\">Estimado usuario,</p>"
			               + "<p style=\"font-size: 16px; margin-bottom: 20px;\">Gracias por registrarte en nuestra plataforma. Nos complace informarte que tu registro ha sido exitoso.</p>"
			               + "<p style=\"font-size: 16px; margin-bottom: 20px;\">Si tienes alguna pregunta o necesitas asistencia, no dudes en ponerte en contacto con nuestro equipo de soporte.</p>"
			               + "<p style=\"font-size: 16px;\">Saludos cordiales,</p>"
			               + "<div style=\"text-align: center; margin-top: 20px;\">"
			               + "<a href=\"#\" style=\"font-size: 14px; color: #000000; text-decoration: none;\">Términos y condiciones</a> | "
			               + "<a href=\"#\" style=\"font-size: 14px; color: #000000; text-decoration: none;\">Política de privacidad</a>"
			               + "</div>"			               
			               + "</div>";


			var retorno=enviarCorreo(usuario.getCorreo(),asunto,cuerpo);
			if(retorno) {
				return "Se envió correctamente el correo de confirmación";
			}else {
				return "No se pudo envíar el correo de confirmación";
			}

		}catch (Exception e) {
			return "Erro al envíar el correo "+e.getMessage();
		}
	}
	
	//inicio de sesion
	public String enviarRecordatorioSesion(usuario usuario) {
	    try {
	        //String destinatario = usuario.getCorreo();
	        
	        String asunto = "Recordatorio: Inicia Sesión para Mantener Activa tu Cuenta";
	        String cuerpo = "<div style=\"background-color: #007BFF; padding: 20px; font-family: Arial, sans-serif; color: white; border-radius: 10px;\">"
	                       + "<h1 style=\"font-size: 24px; font-weight: bold; margin-bottom: 20px;\">Importante: Recordatorio de Inicio de Sesión</h1>"
	                       + "<p style=\"font-size: 16px;\">Estimado usuario,</p>"
	                       + "<p style=\"font-size: 16px; margin-bottom: 20px;\">Notamos que no has iniciado sesión en tu cuenta durante los últimos 30 días. Para evitar el bloqueo de tu cuenta y garantizar su acceso continuo, te recomendamos iniciar sesión a la brevedad posible.</p>"
	                       + "<p style=\"font-size: 16px; margin-bottom: 20px;\">Si ya has iniciado sesión recientemente, por favor, ignora este mensaje.</p>"
	                       + "<p style=\"font-size: 16px;\">Agradecemos tu pronta atención a este asunto.</p>"
	                       + "<p style=\"font-size: 16px; font-weight: bold; margin-top: 20px;\">Atentamente,</p>"
	                       + "<div style=\"text-align: center; margin-top: 20px;\">"
			               + "<a href=\"#\" style=\"font-size: 14px; color: #000000; text-decoration: none;\">Términos y condiciones</a> | "
			               + "<a href=\"#\" style=\"font-size: 14px; color: #000000; text-decoration: none;\">Política de privacidad</a>"
			               + "</div>"	                       
			               + "</div>";

	        var retorno = enviarCorreo(usuario.getCorreo(), asunto, cuerpo);
	        if (retorno) {
	            return "Se envió correctamente";
	        } else {
	            return "No se pudo enviar";
	        }

	    } catch (Exception e) {
	        return "Error al enviar " + e.getMessage();
	    }
	}
	

	public boolean enviarCorreo(String destinatario,String asunto,String cuerpo) throws MessagingException {
		try {
			MimeMessage message=javaMailSender.createMimeMessage();
			MimeMessageHelper helper=new MimeMessageHelper(message,true);

			helper.setTo(destinatario);
			helper.setSubject(asunto);
			helper.setText(cuerpo,true);

			javaMailSender.send(message);
			return true;
		}catch (Exception e) {
			return false;
		}

	}
	
}