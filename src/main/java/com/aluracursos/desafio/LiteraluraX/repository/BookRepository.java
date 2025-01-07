package com.aluracursos.desafio.LiteraluraX.repository; // Especifica el paquete donde está la interfaz.

import com.aluracursos.desafio.LiteraluraX.model.Book; // Importa el modelo Book.
import org.springframework.data.jpa.repository.JpaRepository; // Importa JpaRepository.
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List; // Importa List.

public interface BookRepository extends JpaRepository<Book, Long> { // Extiende JpaRepository para manejar la entidad Book.

    // Método personalizado para buscar libros por idioma.
    List<Book> findByLanguage(String language);

    // Método personalizado para buscar los libros más descargados.
    List<Book> findTop10ByOrderByDownloadCountDesc();

    @Query("SELECT DISTINCT b.language FROM Book b")
    List<String> findDistinctLanguages();

    boolean existsByTitleAndAuthor_Name(String title, String authorName);

    @Query("SELECT b FROM Book b WHERE LOWER(b.title) LIKE LOWER(CONCAT('%', :title, '%'))")
    List<Book> findByTitleContainingIgnoreCase(@Param("title") String title);


}
