package com.aluracursos.desafio.LiteraluraX.api;

import com.aluracursos.desafio.LiteraluraX.model.Book;
import com.aluracursos.desafio.LiteraluraX.api.GutendexResponse;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import java.util.List;

@Component
public class GutendexApiClient {

    private final RestTemplate restTemplate;

    public GutendexApiClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<Book> searchBooks(String query) {
        String url = "https://gutendex.com/books?search=" + query;

        HttpHeaders headers = new HttpHeaders();
        headers.set("Accept", "application/json"); // Configura el encabezado Accept

        HttpEntity<String> entity = new HttpEntity<>(headers);

        ResponseEntity<GutendexResponse> response = restTemplate.exchange(
                url,
                HttpMethod.GET,
                entity,
                GutendexResponse.class
        );

        return response.getBody().getBooks();
    }
}
