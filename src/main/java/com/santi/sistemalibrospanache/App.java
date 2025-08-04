package com.santi.sistemalibrospanache;

import com.santi.sistemalibrospanache.entities.Libro;
import io.quarkus.runtime.QuarkusApplication;
import io.quarkus.runtime.annotations.QuarkusMain;
import jakarta.transaction.Transactional;

import java.util.List;

@QuarkusMain
public class App implements QuarkusApplication {

    @Override
    @Transactional
    public int run(String... args) {

        // Insertar primer libro
        Libro libro1 = new Libro();
        libro1.titulo = "Cien Años de Soledad";
        libro1.persist();
        System.out.println("Libro '" + libro1.titulo + "' insertado con ID: " + libro1.id);

        // Insertar segundo libro
        Libro libro2 = new Libro();
        libro2.titulo = "Rayuela";
        libro2.persist();
        System.out.println("Libro '" + libro2.titulo + "' insertado con ID: " + libro2.id);

        // Listar todos los libros
        System.out.println("\nListado de libros:");
        listarTodos();

        // Buscar libro por ID
        Libro encontradoPorId = Libro.findById(libro1.id);
        System.out.println("\nBúsqueda por ID:");
        if (encontradoPorId != null) {
            System.out.println(" - ID: " + encontradoPorId.id + ", Título: " + encontradoPorId.titulo);
        } else {
            System.out.println("No se encontró el libro con ID: " + libro1.id);
        }

        // Buscar libros por título
        System.out.println("\nBúsqueda por título que contenga 'Soledad':");
        List<Libro> encontrados = Libro.buscarPorTitulo("Soledad");
        if (encontrados.isEmpty()) {
            System.out.println("No se encontraron libros con ese texto en el título.");
        } else {
            for (Libro l : encontrados) {
                System.out.println(" - ID: " + l.id + ", Título: " + l.titulo);
            }
        }

        // Eliminar segundo libro
        boolean eliminado2 = Libro.deleteById(libro2.id);
        System.out.println("\nLibro '" + libro2.titulo + "' eliminado: " + eliminado2);

        // Listar nuevamente
        System.out.println("\nListado tras eliminar uno:");
        listarTodos();

        // Eliminar primero
        boolean eliminado1 = Libro.deleteById(libro1.id);
        System.out.println("\nLibro '" + libro1.titulo + "' eliminado: " + eliminado1);

        // Listar final
        System.out.println("\nListado final:");
        listarTodos();

        return 0;
    }

    private void listarTodos() {
        List<Libro> libros = Libro.listAll();
        if (libros.isEmpty()) {
            System.out.println("No hay libros en la base de datos.");
        } else {
            for (Libro l : libros) {
                System.out.println(" - ID: " + l.id + ", Título: " + l.titulo);
            }
        }
    }
}
