package com.sena.sheduler.Model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity(name="usuario")
public class usuario {
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	@Column(name = "id", nullable = false, length = 36)
    private String id;
    
    @Column(name = "tipoDocumento", nullable = false, length = 3)
    private String tipoDocumento;

    @Column(name = "numeroDocumento", nullable = false, unique = true, length = 10)
    private String numeroDocumento;

    @Column(name = "fechaNacimiento", nullable = false)
    private Date fechaNacimiento;

    @Column(name = "contrasena", nullable = false, length = 50)
    private String contrasena;

    @Column(name = "fechaUltimaActualizacionContrasena", nullable = false)
    private Date fechaUltimaActualizacionContrasena;

    @Column(name= "fechaUltimoInicioSesion", nullable = false)
    private Date fechaUltimoInicioSesion;

    @Column(name = "estado", nullable = false, length = 50)
    private String estado;

    @Column(name = "correo", nullable = false, length = 100, unique = true)
    private String correo;


	public usuario() {
		super();
	}

	public usuario(String id, String tipoDocumento, String numeroDocumento, Date fechaNacimiento,
			String contrasena, Date fechaUltimaActualizacionContrasena, Date fechaUltimoInicioSesion,
			String estado, String correo, boolean notificado) {
		super();
		this.id = id;
		this.tipoDocumento = tipoDocumento;
		this.numeroDocumento = numeroDocumento;
		this.fechaNacimiento = fechaNacimiento;
		this.contrasena = contrasena;
		this.fechaUltimaActualizacionContrasena = fechaUltimaActualizacionContrasena;
		this.fechaUltimoInicioSesion = fechaUltimoInicioSesion;
		this.estado = estado;
		this.correo = correo;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTipoDocumento() {
		return tipoDocumento;
	}

	public void setTipoDocumento(String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	public String getNumeroDocumento() {
		return numeroDocumento;
	}

	public void setNumeroDocumento(String numeroDocumento) {
		this.numeroDocumento = numeroDocumento;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	public Date getFechaUltimaActualizacionContrasena() {
		return fechaUltimaActualizacionContrasena;
	}

	public void setFechaUltimaActualizacionContrasena(Date fechaUltimaActualizacionContrasena) {
		this.fechaUltimaActualizacionContrasena = fechaUltimaActualizacionContrasena;
	}

	public Date getFechaUltimoInicioSesion() {
		return fechaUltimoInicioSesion;
	}

	public void setFechaUltimoInicioSesion(Date fechaUltimoInicioSesion) {
		this.fechaUltimoInicioSesion = fechaUltimoInicioSesion;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}
    
}
