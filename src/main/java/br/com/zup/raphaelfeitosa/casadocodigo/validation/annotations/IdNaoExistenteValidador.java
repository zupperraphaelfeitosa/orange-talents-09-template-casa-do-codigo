package br.com.zup.raphaelfeitosa.casadocodigo.validation.annotations;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class IdNaoExistenteValidador implements ConstraintValidator<IdNaoExistente, Long> {

    @PersistenceContext
    EntityManager entityManager;

    private String classe;

    @Override
    public void initialize(IdNaoExistente constraintAnnotation) {
        classe = constraintAnnotation.classeDominio().getSimpleName();
    }

    @Override
    public boolean isValid(Long id, ConstraintValidatorContext constraintValidatorContext) {

        if (id == null) return true;
        Query query = entityManager.createQuery("SELECT c FROM " + classe + " c WHERE c.id  = :ID");
        query.setParameter("ID", id);
        return !query.getResultList().isEmpty();
    }
}
