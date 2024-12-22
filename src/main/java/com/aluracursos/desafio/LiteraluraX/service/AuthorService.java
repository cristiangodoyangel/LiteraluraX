// Paquete: service
package com.aluracursos.desafio.LiteraluraX.service;

import com.aluracursos.desafio.LiteraluraX.model.Author;
import com.aluracursos.desafio.LiteraluraX.repository.AuthorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service // Marca esta clase como un servicio que será gestionado por Spring
public class AuthorService {

    private final AuthorRepository authorRepository;

    // Inyección de dependencia de AuthorRepository a través del constructor
    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    // Método para guardar un autor en la base de datos
    public Author saveAuthor(Author author) {
        return authorRepository.save(author);
    }

    // Método para obtener todos los autores
    public List<Author> getAllAuthors() {
        return authorRepository.findAll();
    }

    // Método para obtener un autor por su ID
    public Optional<Author> getAuthorById(Long id) {
        return authorRepository.findById(id);
    }

    // Método para eliminar un autor por su ID
    public void deleteAuthorById(Long id) {
        authorRepository.deleteById(id);
    }
}
