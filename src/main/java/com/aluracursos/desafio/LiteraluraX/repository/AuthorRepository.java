package com.aluracursos.desafio.LiteraluraX.repository; // Especifica el paquete donde está la interfaz.

import com.aluracursos.desafio.LiteraluraX.model.Author; // Importa el modelo Author.
import org.springframework.data.jpa.repository.JpaRepository; // Importa JpaRepository.

import java.util.List; // Importa List.

public interface AuthorRepository extends JpaRepository<Author, Long> { // Extiende JpaRepository para manejar la entidad Author.


    List<Author> findByBirthYearLessThanEqualAndDeathYearGreaterThanEqual(int year1, int year2);
}
