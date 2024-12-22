// Paquete: service
package com.aluracursos.desafio.LiteraluraX.service;

import com.aluracursos.desafio.LiteraluraX.model.Book;
import com.aluracursos.desafio.LiteraluraX.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service // Marca esta clase como un servicio que será gestionado por Spring
public class BookService {

    private final BookRepository bookRepository;

    // Inyección de dependencia de BookRepository a través del constructor
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    // Método para guardar un libro en la base de datos
    public Book saveBook(Book book) {
        return bookRepository.save(book);
    }

    // Método para obtener todos los libros
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    // Método para obtener un libro por su ID
    public Optional<Book> getBookById(Long id) {
        return bookRepository.findById(id);
    }

    // Método para eliminar un libro por su ID
    public void deleteBookById(Long id) {
        bookRepository.deleteById(id);
    }
}
