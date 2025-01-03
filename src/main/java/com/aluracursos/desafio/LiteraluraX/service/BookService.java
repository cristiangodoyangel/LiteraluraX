// Paquete: service
package com.aluracursos.desafio.LiteraluraX.service;

import com.aluracursos.desafio.LiteraluraX.model.Author;
import com.aluracursos.desafio.LiteraluraX.model.Book;
import com.aluracursos.desafio.LiteraluraX.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.aluracursos.desafio.LiteraluraX.repository.AuthorRepository;

import com.aluracursos.desafio.LiteraluraX.api.GutendexApiClient;

import java.util.List;

import java.util.Optional;

@Service // Marca esta clase como un servicio que será gestionado por Spring
public class BookService {
    @Autowired
    private GutendexApiClient gutendexApiClient;

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private AuthorRepository authorRepository;

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

    public void fetchAndSaveBooks(String query) {
        System.out.println("Fetching books for query: " + query);

        // Llama al cliente para obtener los libros desde la API
        List<Book> books = gutendexApiClient.searchBooks(query);

        System.out.println("Books fetched: " + books.size());

        for (Book book : books) {
            // Validar si el autor es nulo
            if (book.getAuthor() == null) {
                System.out.println("Skipping book with null author: " + book.getTitle());
                continue; // Ignora este libro y pasa al siguiente
            }

            // Buscar si el autor ya existe en la base de datos
            Author author = authorRepository.findByName(book.getAuthor().getName())
                    .orElseGet(() -> authorRepository.save(book.getAuthor()));

            // Asociar el autor al libro y guardar el libro
            book.setAuthor(author);
            bookRepository.save(book);
        }
    }

}
