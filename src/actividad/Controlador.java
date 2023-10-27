package actividad;

import javax.swing.JFrame;

/**
 * Controlador es una clase que maneja las vistas y la lógica de la aplicación.
 */
public class Controlador {

	GestorBiblioteca gb;
	private JFrame[] vistas = new JFrame[10];

	/**
	 * Inicializa la aplicación cargando libros, prestamos y mostrando la vista
	 * principal.
	 */
	public void inicializar() {
		gb.cargarLibros();
		gb.cargarPrestamos();

		// Crear instancias de las vistas
		PaginaPrincipal paginaPrincipal = new PaginaPrincipal(this);
		VistaAddLibro vistaAddLibro = new VistaAddLibro(this, gb);
		VistaPrestarLibro vistaPrestarLibro = new VistaPrestarLibro(this, gb);
		VistaDevolverLibro vistaDevolverLibro = new VistaDevolverLibro(this, gb);

		// Asignar las vistas a su posición en el arreglo
		vistas[0] = paginaPrincipal;
		vistas[1] = vistaAddLibro;
		vistas[2] = vistaPrestarLibro;
		vistas[3] = vistaDevolverLibro;

		// Hacer visible la vista principal
		vistas[0].setVisible(true);
	}

	/**
	 * Cambia de una vista a otra ocultando la vista anterior y mostrando la
	 * siguiente.
	 *
	 * @param anterior  El índice de la vista anterior.
	 * @param siguiente El índice de la vista siguiente.
	 */
	public void cambiarVista(int anterior, int siguiente) {
		vistas[anterior].setVisible(false);
		vistas[siguiente].setVisible(true);
	}

	/**
	 * Establece el GestorBiblioteca utilizado por el controlador.
	 *
	 * @param gb El GestorBiblioteca a establecer.
	 */
	public void setGb(GestorBiblioteca gb) {
		this.gb = gb;
	}
}
