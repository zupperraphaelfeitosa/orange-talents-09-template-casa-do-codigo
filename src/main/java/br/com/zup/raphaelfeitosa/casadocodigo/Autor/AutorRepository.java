package br.com.zup.raphaelfeitosa.casadocodigo.Autor;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AutorRepository extends JpaRepository<AutorModel, Long> {

    Optional<AutorModel> findByEmail(String email);
}
