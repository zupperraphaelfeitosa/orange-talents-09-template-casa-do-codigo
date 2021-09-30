package br.com.zup.raphaelfeitosa.casadocodigo.Estados;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EstadoRepository extends JpaRepository<EstadoModel, Long> {

    Optional<EstadoModel> findByNomeAndPaisId(String nomeEstado, Long idPais);
}
