package com.aluracursos.desafio.LiteraluraX.controller;

import com.aluracursos.desafio.LiteraluraX.model.Author;
import com.aluracursos.desafio.LiteraluraX.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/authors")
public class AuthorController {

    private final AuthorService authorService;

    // Constructor para inyectar el servicio
    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    /**
     * Endpoint para obtener todos los autores.
     *
     * @return Lista de autores.
     */
    @GetMapping
    public List<Author> getAllAuthors() {
        return authorService.getAllAuthors(); // Llama al servicio
    }

    /**
     * Endpoint para guardar un autor.
     *
     * @param author Objeto Author enviado en el cuerpo de la solicitud.
     * @return Autor guardado.
     */
    @PostMapping
    public Author saveAuthor(@RequestBody Author author) {
        return authorService.saveAuthor(author); // Llama al servicio
    }


    // Endpoint para listar autores vivos en un año específico
    @GetMapping("/alive-in-year")
    public List<Author> listAuthorsAliveInYear(@RequestParam int year) {
        return authorService.getAuthorsAliveInYear(year);
    }

    @GetMapping("/search")
    public Author findAuthorByName(@RequestParam String name) {
        return authorService.getAuthorByName(name)
                .orElseThrow(() -> new RuntimeException("Author not found"));
    }

    @GetMapping("/alive-in-range")
    public List<Author> listAuthorsAliveInRange(@RequestParam int startYear, @RequestParam int endYear) {
        return authorService.getAuthorsAliveBetweenYears(startYear, endYear);
    }



}
