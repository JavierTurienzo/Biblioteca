package actividad;

public class Main {
	public static void main(String[] args) {
		// Modelo
		GestorBiblioteca gb = new GestorBiblioteca();

		// Controlador
		Controlador controlador = new Controlador();
		controlador.setGb(gb); // El controlador necesita acceder al modelo
		
		// Arrancar el controlador
		controlador.inicializar();
	}
}
