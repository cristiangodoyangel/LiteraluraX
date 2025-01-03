package com.aluracursos.desafio.LiteraluraX.api;

import com.aluracursos.desafio.LiteraluraX.model.Book;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

// Clase para deserializar la respuesta de la API Gutendex
public class GutendexResponse {

    private int count; // Total de resultados
    private String next; // URL de la siguiente página
    private String previous; // URL de la página anterior

    @JsonProperty("results") // Mapear la clave "results" del JSON
    private List<Book> books; // Lista de libros

    // Getters y Setters
    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getNext() {
        return next;
    }

    public void setNext(String next) {
        this.next = next;
    }

    public String getPrevious() {
        return previous;
    }

    public void setPrevious(String previous) {
        this.previous = previous;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
}
