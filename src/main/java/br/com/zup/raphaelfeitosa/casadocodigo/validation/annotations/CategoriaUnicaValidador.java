package br.com.zup.raphaelfeitosa.casadocodigo.validation.annotations;

import br.com.zup.raphaelfeitosa.casadocodigo.Autor.AutorRepository;
import br.com.zup.raphaelfeitosa.casadocodigo.Categoria.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CategoriaUnicaValidador implements ConstraintValidator<CategoriaUnica, String> {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Override
    public boolean isValid(String nome, ConstraintValidatorContext context) {
        return categoriaRepository.findByNome(nome).isEmpty();
    }
}
