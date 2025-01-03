package com.aluracursos.desafio.LiteraluraX.repository; // Declaración del paquete.

import com.aluracursos.desafio.LiteraluraX.model.Author; // Importa la clase Author.
import org.springframework.data.jpa.repository.JpaRepository; // Importa JpaRepository.
import org.springframework.stereotype.Repository; // Importa la anotación Repository.

import java.util.Optional; // Importa Optional para métodos específicos.

@Repository // Marca esta interfaz como un componente manejado por Spring.
public interface AuthorRepository extends JpaRepository<Author, Long> { // Extiende JpaRepository.

    // Método personalizado para buscar un autor por su nombre.
    Optional<Author> findByName(String name);
}
