package actividad;

import javax.swing.JFrame;

public class Controlador {

	GestorBiblioteca gb;
	private JFrame[] vistas = new JFrame[10];

	public void inicializar() {


		PaginaPrincipal paginaPrincipal = new PaginaPrincipal(this);
		VistaAddLibro vistaAddLibro = new VistaAddLibro(this, gb);
		VistaPrestarLibro vistaPrestarLibro = new VistaPrestarLibro(this, gb);

		vistas[0] = paginaPrincipal;
		vistas[1] = vistaAddLibro;
		vistas[2] = vistaPrestarLibro;

		
		vistas[0].setVisible(true);
	}

	public void cambiarVista(int anterior, int siguiente) {
		vistas[anterior].setVisible(false);
		vistas[siguiente].setVisible(true);
	}


	public void setGb(GestorBiblioteca gb) {
		
		this.gb = gb;
		
	}

}
