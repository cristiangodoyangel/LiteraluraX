package com.aluracursos.desafio.LiteraluraX.repository; // Especifica el paquete donde está la interfaz.

import com.aluracursos.desafio.LiteraluraX.model.Book; // Importa el modelo Book.
import org.springframework.data.jpa.repository.JpaRepository; // Importa JpaRepository.

import java.util.List; // Importa List.

public interface BookRepository extends JpaRepository<Book, Long> { // Extiende JpaRepository para manejar la entidad Book.

    // Método personalizado para buscar libros por idioma.
    List<Book> findByLanguage(String language);

    // Método personalizado para buscar los libros más descargados.
    List<Book> findTop10ByOrderByDownloadCountDesc();
}
