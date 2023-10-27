# Documentación del Proyecto - Biblioteca

Este proyecto de biblioteca consta de varias clases que interactúan para gestionar libros y préstamos en una biblioteca. A continuación, se detalla la documentación de las clases principales del proyecto.

## Clase `Controlador`

La clase `Controlador` es la encargada de gestionar las acciones y la navegación entre las diferentes vistas de la aplicación. Contiene métodos para inicializar la aplicación y cambiar entre las vistas principales.

### Métodos Públicos

- `inicializar()`: Inicializa la aplicación y carga los libros y préstamos desde el gestor de biblioteca.
- `cambiarVista(int anterior, int siguiente)`: Cambia la vista actual a la vista siguiente, ocultando la anterior.
- `setGb(GestorBiblioteca gb)`: Establece el gestor de biblioteca para que el controlador pueda acceder a él.

## Clase `GestorBiblioteca`

La clase `GestorBiblioteca` se encarga de gestionar la colección de libros y los préstamos en la biblioteca. Permite agregar libros, prestar y devolver libros, y realizar búsquedas.

### Métodos Públicos

- `addLibro(Libro libro)`: Añade un libro al registro de libros.
- `prestarLibro(String usuario, Libro libro)`: Genera un préstamo de un libro a un usuario.
- `cargarPrestamos()`: Carga los préstamos desde un archivo.
- `guardarPrestamos()`: Guarda los préstamos en un archivo.
- `cargarLibros()`: Carga los libros desde un archivo.
- `guardarLibros()`: Guarda los libros en un archivo.
- `buscarLibro(String busqueda)`: Busca libros que coincidan con un término de búsqueda.
- `estaDisponible(String isbn)`: Verifica si un libro está disponible.
- `actualizarPrestamos()`: Actualiza una tabla con información sobre los préstamos en la biblioteca.
- `devolverLibro(String isbn)`: Marca un préstamo como devuelto.

## Clase `Libro`

La clase `Libro` representa un libro en la biblioteca. Contiene información sobre el título, autor, ISBN y disponibilidad del libro.

### Métodos Públicos

- `equals(Object obj)`: Compara si dos libros son iguales basándose en el ISBN.
- `toString()`: Retorna una representación en cadena del libro.

## Clase `PaginaPrincipal`

La clase `PaginaPrincipal` es una vista principal de la aplicación. Permite al usuario acceder a otras funcionalidades, como agregar libros, prestar libros y devolver libros.

## Clase `VistaAddLibro`

La clase `VistaAddLibro` es una vista que permite al usuario agregar libros a la biblioteca. Requiere que se ingresen el título, el autor y el ISBN del libro.

## Clase `VistaPrestarLibro`

La clase `VistaPrestarLibro` es una vista que permite al usuario buscar libros y realizar préstamos. El usuario debe ingresar su nombre de usuario y el ISBN del libro que desea prestar.

## Clase `VistaDevolverLibro`

La clase `VistaDevolverLibro` es una vista que muestra los préstamos activos y permite al usuario devolver libros ingresando el ISBN del libro prestado.

---

Este proyecto de biblioteca permite a los usuarios gestionar libros y préstamos de manera sencilla. Cada clase cumple una función específica para lograr una gestión eficiente de la biblioteca.
