package br.com.zup.raphaelfeitosa.casadocodigo.repositories;

import br.com.zup.raphaelfeitosa.casadocodigo.models.AutorModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AutorRepository extends JpaRepository<AutorModel, Long> {

    Optional<AutorModel> findByEmail(String email);
}
