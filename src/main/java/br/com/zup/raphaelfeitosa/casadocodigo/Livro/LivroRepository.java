package br.com.zup.raphaelfeitosa.casadocodigo.Livro;

import org.springframework.data.jpa.repository.JpaRepository;

public interface LivroRepository extends JpaRepository<LivroModel, Long> {
}
