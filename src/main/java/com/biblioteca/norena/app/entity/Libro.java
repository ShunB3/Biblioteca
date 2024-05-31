package com.biblioteca.norena.app.entity;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

		@Entity
		@Table(name = "libro")

	public class Libro {
	    @Id
	    @GeneratedValue( strategy = GenerationType.IDENTITY)
	    private Integer id;	  
	    @NotNull
	    private String titulo;	
	    @NotNull
	    private String autor;	
	    
	    @JoinColumn(name = "usuario_id")
		@ManyToOne
		private Usuario usuario;
	    
	    public Integer getId() {
	        return id;
	    }

	    public void setId(Integer id) {
	        this.id = id;
	    }
	    
	    public String getTitulo() {
	        return titulo;
	    }

	    public void setTitulo(String titulo) {
	        this.titulo = titulo;
	    }
	    public String getAutor() {
	        return autor;
	    }

	    public void setAutor(String autor) {
	        this.autor = autor;
	    }
	    public Usuario getUsuario() {
			return this.usuario;
		}
		
		public void setUsuario(Usuario usuario) {
			this.usuario = usuario;
		}
}
