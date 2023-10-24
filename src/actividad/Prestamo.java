package actividad;

import java.io.Serializable;
import java.time.LocalDate;

public class Prestamo implements Serializable {

	private int id;
	private String usuario;
	private Libro libro;
	private LocalDate fechaIni;
	private LocalDate fechaFin;

	public Prestamo(String usuario, Libro libro, int id) {
		this.usuario = usuario;
		this.libro = libro;
		this.fechaIni = LocalDate.now();
		this.fechaFin = fechaIni.plusDays(15);
	}

	public int getId() {
		return id;
	}


	public String getUsuario() {
		return usuario;
	}

	public Libro getLibro() {
		return libro;
	}

	public LocalDate getFechaIni() {
		return fechaIni;
	}

	public LocalDate getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(LocalDate fechaFin) {
		this.fechaFin = fechaFin;
	}
}
