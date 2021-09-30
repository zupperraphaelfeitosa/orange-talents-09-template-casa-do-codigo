package br.com.zup.raphaelfeitosa.casadocodigo.validation.annotations;

import br.com.zup.raphaelfeitosa.casadocodigo.Estados.EstadoRepository;
import br.com.zup.raphaelfeitosa.casadocodigo.Estados.EstadoRequest;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class EstadoUnicoNoPaisValidadorComRepository implements ConstraintValidator<EstadoUnicoNoPaisComRepository, EstadoRequest> {

    @Autowired
    private EstadoRepository estadoRepository;

    @Override
    public boolean isValid(EstadoRequest estadoRequest, ConstraintValidatorContext constraintValidatorContext) {
        return estadoRepository.findByNomeAndPaisId(estadoRequest.getNome(), estadoRequest.getIdPais()).isEmpty();
    }
}
