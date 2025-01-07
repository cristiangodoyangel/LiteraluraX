// Paquete: service
package com.aluracursos.desafio.LiteraluraX.service;

import com.aluracursos.desafio.LiteraluraX.model.Author;
import com.aluracursos.desafio.LiteraluraX.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service // Marca esta clase como un servicio que será gestionado por Spring
public class AuthorService {

    private final AuthorRepository authorRepository;

    //Guardar solo si no existe
    public Author saveAuthor(Author author) {
        Optional<Author> existingAuthor = authorRepository.findByName(author.getName());
        if (existingAuthor.isPresent()) {
            return existingAuthor.get(); // Devuelve el autor existente
        }
        return authorRepository.save(author); // Guarda solo si no existe
    }

    // Inyección de dependencia de AuthorRepository a través del constructor
    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
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


    // Método para listar autores vivos en un año específico
        public List<Author> getAuthorsAliveInYear(int year) {
            return authorRepository.findAuthorsAliveInYear(year);
        }


}
