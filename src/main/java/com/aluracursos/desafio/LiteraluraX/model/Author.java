package com.aluracursos.desafio.LiteraluraX.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity // Indica que esta clase es una entidad JPA.
public class Author {

    @Id // Define el identificador único.
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Autogenera el valor del ID.
    private Long id;

    private String name; // Nombre del autor.

    @Column(name = "birth_year") // Nombre de la columna en la base de datos.
    private Integer birthYear;

    @Column(name = "death_year") // Nombre de la columna en la base de datos.
    private Integer deathYear;

    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL, orphanRemoval = true) // Relación uno-a-muchos con `Book`.
    @JsonBackReference // Evita referencias cíclicas al serializar JSON.
    private List<Book> books = new ArrayList<>();

    // Constructor vacío requerido por JPA.
    public Author() {}

    // Constructor con parámetros para inicializar la clase.
    public Author(String name, Integer birthYear, Integer deathYear) {
        this.name = name;
        this.birthYear = birthYear;
        this.deathYear = deathYear;
    }

    // Getters y setters.
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(Integer birthYear) {
        this.birthYear = birthYear;
    }

    public Integer getDeathYear() {
        return deathYear;
    }

    public void setDeathYear(Integer deathYear) {
        this.deathYear = deathYear;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    @Override
    public String toString() {
        return "Author{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", birthYear=" + birthYear +
                ", deathYear=" + deathYear +
                '}';
    }
}
