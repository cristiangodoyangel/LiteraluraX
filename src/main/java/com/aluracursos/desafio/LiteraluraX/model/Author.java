package com.aluracursos.desafio.LiteraluraX.model; // Especifica el paquete al que pertenece esta clase.

import jakarta.persistence.*; // Importa las anotaciones necesarias para la persistencia JPA.
import java.util.ArrayList; // Importa la clase ArrayList para manejar listas.
import java.util.List; // Importa la interfaz List.

@Entity // Indica que esta clase es una entidad de JPA y estará mapeada a una tabla de la base de datos.
public class Author {

    @Id // Marca este campo como la clave primaria.
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Genera el valor automáticamente para la clave primaria.
    private Long id; // Identificador único del autor.

    private String name; // Nombre del autor.

    @Column(name = "birth_year") // Especifica el nombre de la columna en la base de datos.
    private Integer birthYear; // Año de nacimiento del autor.

    @Column(name = "death_year") // Especifica el nombre de la columna en la base de datos.
    private Integer deathYear; // Año de fallecimiento del autor.

    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL) // Define una relación de uno a muchos con la entidad Book.
    private List<Book> books = new ArrayList<>(); // Lista de libros escritos por el autor.

    // Constructor vacío requerido por JPA.
    public Author() {}

    // Constructor con parámetros.
    public Author(String name, Integer birthYear, Integer deathYear) {
        this.name = name; // Asigna el nombre.
        this.birthYear = birthYear; // Asigna el año de nacimiento.
        this.deathYear = deathYear; // Asigna el año de fallecimiento.
    }

    // Getters y setters para acceder y modificar los atributos.
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
}
