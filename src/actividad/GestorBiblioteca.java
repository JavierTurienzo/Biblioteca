package actividad;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

/**
 * Clase que gestiona los libros y los prestamos
 */
public class GestorBiblioteca {

	private ArrayList<Libro> libros = new ArrayList<Libro>();
	private ArrayList<Prestamo> prestamos = new ArrayList<Prestamo>();
	private ArrayList<Prestamo> historial = new ArrayList<Prestamo>();
	private static int idPrestamos;

	/**
	 * Añade un libro al regsitro de libros
	 * 
	 * @param libro - El libro a añadir
	 */
	public void addLibro(Libro libro) {
		if (!libros.contains(libro)) {
			libros.add(libro);
		}
	}

	/**
	 * Genera un prestamo de un libro
	 * 
	 * @param libro   - El libro para prestar
	 * @param usuario - El usuario que pide el prestamo
	 * @return 0 si el prestamo es correcto, -1 si el libro no esta disponible
	 */
	public int prestarLibro(Libro libro, String usuario) {
		if (libro.isDisponible()) {
			prestamos.add(new Prestamo(usuario, libro, idPrestamos));
			libro.setDisponible(false);
			idPrestamos++;
			return 0;
		} else {
			return -1;
		}
	}

	/**
	 * Actualiza el fichero con los libros guardados en la biblioteca
	 */
	public void guardarLibros() {
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

	public DefaultTableModel buscarLibro(String busqueda) {

		String[] columnas = { "Título", "Autor", "ISBN", "Disponible" };
		DefaultTableModel modelo = new DefaultTableModel(columnas, 0);

		for (Libro libro : libros) {
			if (libro.getTitulo().toLowerCase().contains(busqueda.toLowerCase())
					|| libro.getAutor().toLowerCase().contains(busqueda.toLowerCase())
					|| libro.getIsbn().toLowerCase().contains(busqueda.toLowerCase())) {

				String[] fila = { libro.getTitulo(), libro.getAutor(), libro.getIsbn(),
						libro.isDisponible() ? "Sí" : "No" };
				modelo.addRow(fila);

			}
		}

		return modelo;
	}

}
