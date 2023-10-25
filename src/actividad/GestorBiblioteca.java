package actividad;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 * Clase que gestiona los libros y los prestamos
 */
public class GestorBiblioteca {

	private ArrayList<Libro> libros = new ArrayList<Libro>();
	private ArrayList<Prestamo> prestamos = new ArrayList<Prestamo>();
	private ArrayList<Prestamo> historial = new ArrayList<Prestamo>();

	/**
	 * Añade un libro al regsitro de libros
	 * 
	 * @param libro - El libro a añadir
	 */
	public void addLibro(Libro libro) {
		if (!libros.contains(libro)) {
			libros.add(libro);
			guardarLibros();
		}
	}

	/**
	 * Genera un prestamo de un libro
	 * 
	 * @param libro   - El libro para prestar
	 * @param usuario - El usuario que pide el prestamo
	 */
	public void prestarLibro(String usuario, Libro libro) {
		prestamos.add(new Prestamo(usuario, libro));
		guardarPrestamos();
	}

	/**
	 * Guarda los prestamos en el fichero
	 * 
	 * @param libro
	 * @param usuario
	 */
	private void guardarPrestamos() {

		try {
			ObjectOutputStream guarda = new ObjectOutputStream(new FileOutputStream("Prestamos.dat"));
			guarda.writeObject(prestamos);
			guarda.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void cargarPrestamos() {
		try {
			ObjectInputStream carga = new ObjectInputStream(new FileInputStream("Libros.dat"));
			ArrayList<Prestamo> prestamosCargados = (ArrayList<Prestamo>) carga.readObject();
			for (Prestamo prestamo : prestamosCargados) {
					prestamos.add(prestamo);
			}

			carga.close();
		} catch (FileNotFoundException e) {
			System.out.println("Se ha creado el archivo Libros.dat porque no exisitía previamente");
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Actualiza el fichero con los libros guardados en la biblioteca
	 */
	private void guardarLibros() {
		try {
			ObjectOutputStream guarda = new ObjectOutputStream(new FileOutputStream("Libros.dat"));
			guarda.writeObject(libros);
			guarda.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Carga los libros del fichero libros.dat en la aplicación
	 */
	public void cargarLibros() {
		try {
			ObjectInputStream carga = new ObjectInputStream(new FileInputStream("Libros.dat"));
			ArrayList<Libro> librosCargados = (ArrayList<Libro>) carga.readObject();
			for (Libro libro : librosCargados) {
				if (!libros.contains(libro)) {
					libros.add(libro);
				}
			}

			carga.close();
		} catch (FileNotFoundException e) {
			System.out.println("Se ha creado el archivo Libros.dat porque no exisitía previamente");
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Busca los libros que coinciden con el parametro busqueda
	 * 
	 * @param busqueda - El string con el que busca los libros
	 * @return Un DefaultTableModel con los datos de los libros que coinciden
	 */
	public ArrayList<Libro> buscarLibro(String busqueda) {

		ArrayList<Libro> resultados = new ArrayList<Libro>();

		for (Libro libro : libros) {
			if (libro.getTitulo().toLowerCase().contains(busqueda.toLowerCase())
					|| libro.getAutor().toLowerCase().contains(busqueda.toLowerCase())
					|| libro.getIsbn().toLowerCase().contains(busqueda.toLowerCase())) {

				resultados.add(libro);

			}
		}

		return resultados;
	}

	public boolean estaDisponible(String isbn) {
		for (Libro libro : libros) {
			if (libro.getIsbn().equals(isbn) && libro.isDisponible()) {
				return true;
			}
		}
		return false;
	}

}
