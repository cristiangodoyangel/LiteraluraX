package com.aluracursos.desafio.LiteraluraX.controller;

import com.aluracursos.desafio.LiteraluraX.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/sync-books")
    public ResponseEntity<?> syncBooks(@RequestParam String query) {
        try {
            bookService.fetchAndSaveBooks(query);
            return ResponseEntity.ok("Books synchronized successfully!");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error synchronizing books: " + e.getMessage());
        }
    }
}