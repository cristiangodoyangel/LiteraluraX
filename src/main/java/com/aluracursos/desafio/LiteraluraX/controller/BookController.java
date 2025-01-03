package com.aluracursos.desafio.LiteraluraX.controller;

import com.aluracursos.desafio.LiteraluraX.model.Book;
import com.aluracursos.desafio.LiteraluraX.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // Define que esta clase es un controlador REST.
@RequestMapping("/books") // Base URL para todas las solicitudes relacionadas con libros.
public class BookController {

    private final BookService bookService;

    @Autowired // Inyección de dependencia de BookService.
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    /**
     * Sincroniza los libros desde la API de Gutendex.
     *
     * @param query Consulta para buscar libros.
     * @return Mensaje indicando el resultado de la sincronización.
     */
    @GetMapping("/sync-books")
    public ResponseEntity<String> syncBooks(@RequestParam String query) {
        try {
            bookService.fetchAndSaveBooks(query); // Llama al servicio para sincronizar los libros.
            return ResponseEntity.ok("Books synchronized successfully!");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error synchronizing books: " + e.getMessage());
        }
    }

    /**
     * Lista todos los libros disponibles en la base de datos.
     *
     * @return Lista de libros.
     */
    @GetMapping
    public List<Book> listBooks() {
        return bookService.getAllBooks(); // Llama al servicio para obtener todos los libros.
    }
}
