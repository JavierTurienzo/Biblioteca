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
 * Clase que gestiona los libros y los préstamos en una biblioteca.
 */
public class GestorBiblioteca {

	private ArrayList<Libro> libros = new ArrayList<Libro>();
	private ArrayList<Prestamo> prestamos = new ArrayList<Prestamo>();

	/**
	 * Añade un libro al registro de libros.
	 *
	 * @param libro - El libro a añadir.
	 */
	public void addLibro(Libro libro) {
		if (!libros.contains(libro)) {
			libros.add(libro);
			guardarLibros();
		}
	}

	/**
	 * Genera un préstamo de un libro.
	 *
	 * @param usuario - El usuario que pide el préstamo.
	 * @param libro   - El libro para prestar.
	 */
	public void prestarLibro(String usuario, Libro libro) {
		prestamos.add(new Prestamo(usuario, libro));
		guardarPrestamos();
		for (Libro l : libros) {
			if (libro.getIsbn().equals(l.getIsbn())) {
				libro.setDisponible(false);
			}
			guardarLibros();
		}
	}

	/**
	 * Guarda los préstamos en el archivo "Prestamos.dat".
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

	/**
	 * Carga los préstamos desde el archivo "Prestamos.dat" en la aplicación.
	 */
	public void cargarPrestamos() {
		try {
			ObjectInputStream carga = new ObjectInputStream(new FileInputStream("Prestamos.dat"));
			ArrayList<Prestamo> prestamosCargados = (ArrayList<Prestamo>) carga.readObject();
			for (Prestamo prestamo : prestamosCargados) {
				prestamos.add(prestamo);
			}
			carga.close();
		} catch (FileNotFoundException e) {
			System.out.println("Se ha creado el archivo Prestamos.dat porque no existía previamente");
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Actualiza el archivo con los libros guardados en la biblioteca.
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
	 * Carga los libros desde el archivo "Libros.dat" en la aplicación.
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
			System.out.println("Se ha creado el archivo Libros.dat porque no existía previamente");
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Busca los libros que coinciden con el parámetro de búsqueda.
	 *
	 * @param busqueda - El string con el que se buscan los libros.
	 * @return Una lista de libros que coinciden con la búsqueda.
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

	/**
	 * Verifica si un libro con el ISBN dado está disponible.
	 *
	 * @param isbn - El ISBN del libro a verificar.
	 * @return true si el libro está disponible; de lo contrario, false.
	 */
	public boolean estaDisponible(String isbn) {
		for (Libro libro : libros) {
			if (libro.getIsbn().equals(isbn) && libro.isDisponible()) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Actualiza un DefaultTableModel con los préstamos registrados.
	 *
	 * @return El DefaultTableModel con los datos de los préstamos.
	 */
	public DefaultTableModel actualizarPrestamos() {
		String[] columnas = { "Usuario", "Título", "Autor", "ISBN", "Inicio", "Fin", "Devuelto" };
		DefaultTableModel modelo = new DefaultTableModel(columnas, 0) {
			@Override
			public boolean isCellEditable(int row, int column) {
				// Las celdas no son editables
				return false;
			}
		};

		for (Prestamo prestamo : prestamos) {
			String[] fila = { prestamo.getUsuario(), prestamo.getLibro().getTitulo(), prestamo.getLibro().getAutor(),
					prestamo.getLibro().getIsbn(), prestamo.getFechaIni().toString(), prestamo.getFechaFin().toString(),
					prestamo.isDevuelto() ? "Sí" : "No" };

			modelo.addRow(fila);
		}

		return modelo;
	}

	/**
	 * Marca un libro como devuelto y lo vuelve disponible.
	 *
	 * @param isbn - El ISBN del libro a devolver.
	 */
	public void devolverLibro(String isbn) {
		for (Prestamo prestamo : prestamos) {
			if (prestamo.getLibro().getIsbn().equals(isbn)) {
				prestamo.setDevuelto(true);
			}
		}

		for (Libro libro : libros) {
			if (libro.getIsbn().equals(isbn))
				libro.setDisponible(true);
		}
		guardarLibros();
		guardarPrestamos();
	}
}
