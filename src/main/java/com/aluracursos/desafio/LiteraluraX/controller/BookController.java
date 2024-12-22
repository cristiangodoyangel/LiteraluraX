package com.aluracursos.desafio.LiteraluraX.controller;

import com.aluracursos.desafio.LiteraluraX.model.Book;
import com.aluracursos.desafio.LiteraluraX.service.BookService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    private final BookService bookService;

    // Constructor para inyectar el servicio
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    /**
     * Endpoint para obtener todos los libros.
     *
     * @return Lista de libros.
     */
    @GetMapping
    public List<Book> getAllBooks() {
        return bookService.getAllBooks(); // Llama al servicio
    }

    /**
     * Endpoint para guardar un libro.
     *
     * @param book Objeto Book enviado en el cuerpo de la solicitud.
     * @return Libro guardado.
     */
    @PostMapping
    public Book saveBook(@RequestBody Book book) {
        return bookService.saveBook(book); // Llama al servicio
    }
}
