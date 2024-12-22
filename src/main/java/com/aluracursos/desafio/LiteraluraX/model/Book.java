package com.aluracursos.desafio.LiteraluraX.model; // Especifica el paquete al que pertenece esta clase.

import jakarta.persistence.*;
@Entity // Indica que esta clase es una entidad de JPA y estará mapeada a una tabla de la base de datos.
public class Book {

    @Id // Marca este campo como la clave primaria.
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Genera el valor automáticamente para la clave primaria.
    private Long id; // Identificador único del libro.

    private String title; // Título del libro.

    private String language; // Idioma principal del libro.

    @Column(name = "download_count") // Especifica el nombre de la columna en la base de datos.
    private int downloadCount; // Cantidad de descargas del libro.

    @ManyToOne(cascade = CascadeType.ALL) // Define una relación de muchos a uno con la entidad Author.
    @JoinColumn(name = "author_id") // Especifica el nombre de la columna de la clave foránea en la base de datos.
    private Author author; // Autor del libro.

    // Constructor vacío requerido por JPA.
    public Book() {}

    // Constructor con parámetros.
    public Book(String title, String language, int downloadCount, Author author) {
        this.title = title; // Asigna el título.
        this.language = language; // Asigna el idioma.
        this.downloadCount = downloadCount; // Asigna la cantidad de descargas.
        this.author = author; // Asigna el autor.
    }

    // Getters y setters para acceder y modificar los atributos.
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

    public int getDownloadCount() {
        return downloadCount;
    }

    public void setDownloadCount(int downloadCount) {
        this.downloadCount = downloadCount;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }
}
