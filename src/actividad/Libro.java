package actividad;

import java.io.Serializable;

/**
 * Clase que representa un libro en la biblioteca.
 */
public class Libro implements Serializable {
	private static final long serialVersionUID = 1L;
	private String titulo;
	private String autor;
	private String isbn;
	private boolean disponible;

	/**
	 * Constructor para crear un nuevo libro.
	 *
	 * @param titulo - El título del libro.
	 * @param autor  - El autor del libro.
	 * @param isbn   - El ISBN del libro.
	 */
	public Libro(String titulo, String autor, String isbn) {
		this.titulo = titulo;
		this.autor = autor;
		this.isbn = isbn;
		this.disponible = true;
	}

	/**
	 * Obtiene el título del libro.
	 *
	 * @return El título del libro.
	 */
	public String getTitulo() {
		return titulo;
	}

	/**
	 * Establece el título del libro.
	 *
	 * @param titulo - El título a establecer.
	 */
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	/**
	 * Obtiene el autor del libro.
	 *
	 * @return El autor del libro.
	 */
	public String getAutor() {
		return autor;
	}

	/**
	 * Establece el autor del libro.
	 *
	 * @param autor - El autor a establecer.
	 */
	public void setAutor(String autor) {
		this.autor = autor;
	}

	/**
	 * Obtiene el ISBN del libro.
	 *
	 * @return El ISBN del libro.
	 */
	public String getIsbn() {
		return isbn;
	}

	/**
	 * Establece el ISBN del libro.
	 *
	 * @param isbn - El ISBN a establecer.
	 */
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	/**
	 * Verifica si el libro está disponible.
	 *
	 * @return true si el libro está disponible; de lo contrario, false.
	 */
	public boolean isDisponible() {
		return disponible;
	}

	/**
	 * Establece la disponibilidad del libro.
	 *
	 * @param disponible - true si el libro está disponible; de lo contrario, false.
	 */
	public void setDisponible(boolean disponible) {
		this.disponible = disponible;
	}

	/**
	 * Compara si dos libros son iguales por su ISBN.
	 *
	 * @param obj - El objeto a comparar con este libro.
	 * @return true si los libros tienen el mismo ISBN; de lo contrario, false.
	 */
	public boolean equals(Object obj) {
		if (obj instanceof Libro) {
			Libro libro = (Libro) obj;
			return this.isbn.equals(libro.getIsbn());
		}
		return false;
	}

}
