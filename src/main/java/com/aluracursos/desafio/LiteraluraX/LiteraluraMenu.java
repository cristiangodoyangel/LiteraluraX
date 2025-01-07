package com.aluracursos.desafio.LiteraluraX;

import com.aluracursos.desafio.LiteraluraX.service.AuthorService;
import com.aluracursos.desafio.LiteraluraX.service.BookService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class LiteraluraMenu implements CommandLineRunner {

    private final BookService bookService;
    private final AuthorService authorService;

    public LiteraluraMenu(BookService bookService, AuthorService authorService) {
        this.bookService = bookService;
        this.authorService = authorService;
    }

    @Override
    public void run(String... args) {
        Scanner scanner = new Scanner(System.in);
        int option;

        do {
            System.out.println("\n--- LiteraluraX Menu ---");
            System.out.println("1. Sincronizar libros desde la API");
            System.out.println("2. Listar libros por idioma");
            System.out.println("3. Mostrar el top 10 de libros más descargados");
            System.out.println("4. Buscar un autor por nombre");
            System.out.println("5. Listar autores vivos en un año específico");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opción: ");

            option = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea

            switch (option) {
                case 1:
                    System.out.print("Ingrese el término de búsqueda para sincronizar libros: ");
                    String query = scanner.nextLine();
                    bookService.fetchAndSaveBooks(query);
                    System.out.println("Libros sincronizados exitosamente.");
                    break;
                case 2:
                    System.out.print("Ingrese el idioma (ejemplo: en): ");
                    String language = scanner.nextLine();
                    bookService.getBooksByLanguage(language).forEach(System.out::println);
                    break;
                case 3:
                    System.out.println("Top 10 libros más descargados:");
                    bookService.getTopDownloadedBooks().forEach(System.out::println);
                    break;
                case 4:
                    System.out.print("Ingrese el nombre del autor: ");
                    String authorName = scanner.nextLine();
                    try {
                        System.out.println(authorService.getAuthorByName(authorName).orElseThrow(() ->
                                new RuntimeException("Autor no encontrado")));
                    } catch (RuntimeException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 5:
                    System.out.print("Ingrese el año: ");
                    int year = scanner.nextInt();
                    scanner.nextLine();
                    authorService.getAuthorsAliveInYear(year).forEach(System.out::println);
                    break;
                case 6:
                    System.out.println("¡Gracias por usar LiteraluraX!");
                    break;
                default:
                    System.out.println("Opción inválida, intente de nuevo.");
            }
        } while (option != 6);

        scanner.close();
    }
}
