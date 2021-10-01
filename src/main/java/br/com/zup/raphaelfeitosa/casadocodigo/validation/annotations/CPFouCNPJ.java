package br.com.zup.raphaelfeitosa.casadocodigo.validation.annotations;

import org.hibernate.validator.constraints.CompositionType;
import org.hibernate.validator.constraints.ConstraintComposition;
import org.hibernate.validator.constraints.br.CNPJ;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.ReportAsSingleViolation;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = {})
@ConstraintComposition(CompositionType.OR)
@ReportAsSingleViolation
@CPF
@CNPJ
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface CPFouCNPJ {
    String message() default "O Documento está em um formato invalido";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
