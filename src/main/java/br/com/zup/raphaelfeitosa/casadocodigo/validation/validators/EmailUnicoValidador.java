package br.com.zup.raphaelfeitosa.casadocodigo.validation.validators;

import br.com.zup.raphaelfeitosa.casadocodigo.repositories.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class EmailUnicoValidador implements ConstraintValidator<EmailUnico, String> {

    @Autowired
    private AutorRepository autorRepository;

    @Override
    public boolean isValid(String email, ConstraintValidatorContext context) {
        return autorRepository.findByEmail(email).isEmpty();
    }
}
