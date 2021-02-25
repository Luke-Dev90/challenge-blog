package com.challenge.alkemy.blog.model;

import java.sql.Date;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Posteo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private String titulo;
	@Column
	private String contenido;
	@Column
	private String imagen;
	@Column
	private String categoria;
	
	@CreationTimestamp
	@Column
	private LocalDateTime  fecha;
	
	
	public static enum Categoria {
		NOTICIAS("Noticias"),
		ENTRETENIMIENTOS("Entretenimiento"),
		HOBBIES("Hobbies"),
		ESPECTACULOS("Espectaculos");
		
		private final String displayEnum;
		
		Categoria(String displayEnum){
			this.displayEnum = displayEnum;
		}
		
		public String getDisplayEnum() {
			return displayEnum;
		}
		
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getContenido() {
		return contenido;
	}
	public void setContenido(String contenido) {
		this.contenido = contenido;
	}
	public String getImagen() {
		return imagen;
	}
	public void setImagen(String imagen) {
		this.imagen = imagen;
	}
	
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public LocalDateTime getFecha() {
		return fecha;
	}
	public void setFecha(LocalDateTime fecha) {
		this.fecha = fecha;
	}
	
	
	
	
}
