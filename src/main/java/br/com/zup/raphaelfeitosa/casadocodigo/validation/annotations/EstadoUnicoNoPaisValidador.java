package br.com.zup.raphaelfeitosa.casadocodigo.validation.annotations;

import br.com.zup.raphaelfeitosa.casadocodigo.Estados.EstadoRepository;
import br.com.zup.raphaelfeitosa.casadocodigo.Estados.EstadoRequest;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class EstadoUnicoNoPaisValidador implements ConstraintValidator<EstadoUnicoNoPais, EstadoRequest> {

    @PersistenceContext
    EntityManager entityManager;

    private String classe;

    @Override
    public void initialize(EstadoUnicoNoPais constraintAnnotation) {
        classe = constraintAnnotation.classeDominio().getSimpleName();
    }

    @Override
    public boolean isValid(EstadoRequest estadoRequest, ConstraintValidatorContext constraintValidatorContext) {

        Query query = entityManager.createQuery("SELECT e FROM " + classe + " e WHERE e.nome = :nomeEstado AND e.pais.id  = :idPais");
        query.setParameter("nomeEstado", estadoRequest.getNome());
        query.setParameter("idPais", estadoRequest.getIdPais());
        return query.getResultList().isEmpty();
    }
}
