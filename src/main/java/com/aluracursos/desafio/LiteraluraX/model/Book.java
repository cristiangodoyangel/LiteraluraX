package com.aluracursos.desafio.LiteraluraX.model;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity // Marca esta clase como una entidad de JPA.
public class Book {

    @Id // Define la clave primaria.
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Generación automática del ID.
    private Long id;

    private String title; // Título del libro.

    private String language; // Idioma del libro.

    private Integer downloadCount; // Número de descargas.

    @Transient // Indica que no se persistirá en la base de datos.
    private String authorName; // Nombre del autor, usado solo temporalmente.

    @ManyToOne // Relación muchos a uno con la entidad Author.
    @JsonBackReference // Evita ciclos de referencia en JSON.
    private Author author;

    // Getters y setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public Integer getDownloadCount() {
        return downloadCount;
    }

    public void setDownloadCount(Integer downloadCount) {
        this.downloadCount = downloadCount;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }
}
