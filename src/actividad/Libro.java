package actividad;

import java.io.Serializable;

public class Libro implements Serializable{


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String titulo;
	private String autor;
	private String isbn;
	private boolean disponible;

	public Libro(String titulo, String autor, String isbn) {
		this.titulo = titulo;
		this.autor = autor;
		this.isbn = isbn;
		this.disponible = true;
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

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public boolean isDisponible() {
		return disponible;
	}

	public void setDisponible(boolean disponible) {
		this.disponible = disponible;
	}

	public boolean equals(Object obj) {
		Libro libro = (Libro) obj;
		if (this.isbn.equals(libro.getIsbn())) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public String toString() {
		return "Libro [titulo=" + titulo + ", autor=" + autor + ", isbn=" + isbn + ", disponible=" + disponible + "]";
	}

}
