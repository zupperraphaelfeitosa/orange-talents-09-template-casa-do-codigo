package br.com.zup.raphaelfeitosa.casadocodigo.validation.annotations;

import br.com.zup.raphaelfeitosa.casadocodigo.Cliente.ClienteRequest;
import br.com.zup.raphaelfeitosa.casadocodigo.Estados.EstadoModel;
import br.com.zup.raphaelfeitosa.casadocodigo.Estados.EstadoRequest;
import br.com.zup.raphaelfeitosa.casadocodigo.Pais.PaisModel;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class EstadoPertencenteAPaisValidador implements ConstraintValidator<EstadoPertencenteAPais, ClienteRequest> {

    @PersistenceContext
    EntityManager entityManager;

    private String classe;

    @Override
    public void initialize(EstadoPertencenteAPais constraintAnnotation) {
        classe = constraintAnnotation.classeDominio().getSimpleName();
    }

    @Override
    public boolean isValid(ClienteRequest clienteRequest, ConstraintValidatorContext constraintValidatorContext) {
        if (clienteRequest.getIdEstado() != null) {
            PaisModel pais = entityManager.find(PaisModel.class, clienteRequest.getIdPais());
            EstadoModel estado = entityManager.find(EstadoModel.class, clienteRequest.getIdEstado());
            if (estado == null) {
                return true;
            }
            return estado.pertenceAPais(pais);
        }
        return true;
    }
}
