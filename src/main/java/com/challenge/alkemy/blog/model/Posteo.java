package com.challenge.alkemy.blog.model;


import java.time.LocalDateTime;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;


import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Posteo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	
	@NotEmpty
	private String titulo;
	
	private String contenido;
	
	private String imagen;
	
	private String categoria;
	
	@DateTimeFormat(pattern = "yyyy/MM/dd HH:mm:ss")
	private LocalDateTime  fecha;
	
	@PrePersist
	public void prePersist() {
		fecha =LocalDateTime.now();
	}
	
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
	
	
	public Posteo() {}
	
	public Posteo(Long id, String titulo, String contenido, String imagen, String categoria, LocalDateTime fecha) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.contenido = contenido;
		this.imagen = imagen;
		this.categoria = categoria;
		this.fecha = fecha;
	}
	@Override
	public String toString() {
		return "Posteo [id=" + id + ", titulo=" + titulo + ", contenido=" + contenido + ", imagen=" + imagen
				+ ", categoria=" + categoria + ", fecha=" + fecha + "]";
	}
	
	
}
