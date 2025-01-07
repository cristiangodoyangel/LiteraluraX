package com.aluracursos.desafio.LiteraluraX.service;

import com.aluracursos.desafio.LiteraluraX.api.GutendexApiClient;
import com.aluracursos.desafio.LiteraluraX.model.Author;
import com.aluracursos.desafio.LiteraluraX.model.Book;
import com.aluracursos.desafio.LiteraluraX.repository.AuthorRepository;
import com.aluracursos.desafio.LiteraluraX.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service // Marca esta clase como un servicio gestionado por Spring.
public class BookService {

    @Autowired
    private GutendexApiClient gutendexApiClient;

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private AuthorRepository authorRepository;

    // Método para sincronizar libros desde la API de Gutendex
    public void fetchAndSaveBooks(String query) {
        // Llamada a la API para buscar libros con el término de consulta
        List<Book> books = gutendexApiClient.searchBooks(query);

        books.forEach(book -> {
            if (book.getAuthorName() != null && book.getTitle() != null) {
                Author author = getOrCreateAuthor(book.getAuthorName());

                if (!bookRepository.existsByTitleAndAuthor_Name(book.getTitle(), author.getName())) {
                    book.setAuthor(author);
                    bookRepository.save(book); // Guarda solo si no existe
                }
            }
        });


    }

    // Método auxiliar para obtener o crear un autor si no existe
    private Author getOrCreateAuthor(String authorName) {
        return authorRepository.findByName(authorName)
                .orElseGet(() -> {
                    Author newAuthor = new Author();
                    newAuthor.setName(authorName);
                    return authorRepository.save(newAuthor);
                });
    }

    // Método para obtener todos los libros de la base de datos
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public List<Book> findBooksByTitle(String title) {
        return bookRepository.findByTitleContainingIgnoreCase(title);
    }

}
