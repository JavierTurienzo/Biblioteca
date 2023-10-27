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

La clase `Libro` representa un libro en la biblioteca. Cada instancia de esta clase contiene información sobre el título, autor, ISBN y disponibilidad del libro.

### Atributos

- `titulo` (tipo `String`): El título del libro.
- `autor` (tipo `String`): El autor del libro.
- `isbn` (tipo `String`): El ISBN del libro, que sirve como identificador único.
- `disponible` (tipo `boolean`): Indica si el libro está disponible para préstamo.

### Constructor

- `Libro(String titulo, String autor, String isbn)`: Este constructor se utiliza para crear un nuevo libro. Toma el título, autor e ISBN como parámetros y establece inicialmente el libro como disponible.

### Métodos Públicos

- `getTitulo()`: Retorna el título del libro.
- `setTitulo(String titulo)`: Permite establecer el título del libro.
- `getAutor()`: Retorna el autor del libro.
- `setAutor(String autor)`: Permite establecer el autor del libro.
- `getIsbn()`: Retorna el ISBN del libro.
- `setIsbn(String isbn)`: Permite establecer el ISBN del libro.
- `isDisponible()`: Verifica si el libro está disponible. Retorna `true` si el libro está disponible y `false` si no lo está.
- `setDisponible(boolean disponible)`: Permite establecer la disponibilidad del libro.
- `equals(Object obj)`: Compara si dos libros son iguales basándose en el ISBN. Retorna `true` si los libros tienen el mismo ISBN y `false` en caso contrario.

### Notas Adicionales

- El ISBN se utiliza como un identificador único para cada libro en la biblioteca.
- La disponibilidad del libro se puede cambiar con el método `setDisponible`.

La clase `Libro` es esencial para mantener un registro de los libros en la biblioteca, lo que facilita la gestión de préstamos y la disponibilidad de los libros para los usuarios.

## Clase `Prestamo`

La clase `Prestamo` representa un préstamo de un libro en la biblioteca. Cada instancia de esta clase contiene información sobre el usuario que realizó el préstamo, el libro prestado y las fechas de inicio y finalización del préstamo. Además, registra si el libro ha sido devuelto.

### Atributos

- `usuario` (tipo `String`): El nombre del usuario que pidió el préstamo.
- `libro` (tipo `Libro`): El libro prestado.
- `fechaIni` (tipo `LocalDate`): La fecha de inicio del préstamo.
- `fechaFin` (tipo `LocalDate`): La fecha de finalización del préstamo.
- `devuelto` (tipo `boolean`): Indica si el libro ha sido devuelto.

### Constructor

- `Prestamo(String usuario, Libro libro)`: Este constructor se utiliza para crear un nuevo préstamo. Toma el nombre del usuario y el libro prestado como parámetros, establece la fecha de inicio como la fecha actual y calcula automáticamente la fecha de finalización a 15 días a partir de la fecha de inicio. Inicialmente, el préstamo se registra como no devuelto.

### Métodos Públicos

- `getUsuario()`: Retorna el nombre del usuario que realizó el préstamo.
- `getLibro()`: Retorna el libro prestado en este préstamo.
- `getFechaIni()`: Retorna la fecha de inicio del préstamo.
- `getFechaFin()`: Retorna la fecha de finalización del préstamo.
- `setFechaFin(LocalDate fechaFin)`: Permite establecer la fecha de finalización del préstamo.
- `isDevuelto()`: Verifica si el libro ha sido devuelto. Retorna `true` si el libro ha sido devuelto y `false` en caso contrario.
- `setDevuelto(boolean devuelto)`: Permite establecer si el libro ha sido devuelto o no.

### Notas Adicionales

- Un préstamo se inicia con la fecha de inicio actual y se establece una fecha de finalización predeterminada de 15 días a partir de la fecha de inicio.
- El estado de devolución del libro se puede cambiar con el método `setDevuelto`.

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
