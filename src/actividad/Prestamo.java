package actividad;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * Clase que representa un préstamo de un libro en la biblioteca.
 */
public class Prestamo implements Serializable {

	private static final long serialVersionUID = 1L;
	private String usuario;
	private Libro libro;
	private LocalDate fechaIni;
	private LocalDate fechaFin;
	private boolean devuelto;

	/**
	 * Constructor para crear un nuevo préstamo.
	 *
	 * @param usuario - El usuario que pide el préstamo.
	 * @param libro   - El libro prestado.
	 */
	public Prestamo(String usuario, Libro libro) {
		this.usuario = usuario;
		this.libro = libro;
		this.fechaIni = LocalDate.now();
		this.fechaFin = fechaIni.plusDays(15);
		this.devuelto = false;
	}

	/**
	 * Obtiene el usuario que realizó el préstamo.
	 *
	 * @return El nombre del usuario.
	 */
	public String getUsuario() {
		return usuario;
	}

	/**
	 * Obtiene el libro prestado en este préstamo.
	 *
	 * @return El libro prestado.
	 */
	public Libro getLibro() {
		return libro;
	}

	/**
	 * Obtiene la fecha de inicio del préstamo.
	 *
	 * @return La fecha de inicio.
	 */
	public LocalDate getFechaIni() {
		return fechaIni;
	}

	/**
	 * Obtiene la fecha de finalización del préstamo.
	 *
	 * @return La fecha de finalización.
	 */
	public LocalDate getFechaFin() {
		return fechaFin;
	}

	/**
	 * Establece la fecha de finalización del préstamo.
	 *
	 * @param fechaFin - La fecha de finalización a establecer.
	 */
	public void setFechaFin(LocalDate fechaFin) {
		this.fechaFin = fechaFin;
	}

	/**
	 * Verifica si el libro ha sido devuelto.
	 *
	 * @return true si el libro ha sido devuelto; de lo contrario, false.
	 */
	public boolean isDevuelto() {
		return this.devuelto;
	}

	/**
	 * Establece si el libro ha sido devuelto.
	 *
	 * @param devuelto - true si el libro ha sido devuelto; de lo contrario, false.
	 */
	public void setDevuelto(boolean devuelto) {
		this.devuelto = devuelto;
	}
}
