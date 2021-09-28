package br.com.zup.raphaelfeitosa.casadocodigo.validation.annotations;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = {EmailUnicoValidador.class})
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface EmailUnico {
    String message() default "Já existe um(a) autor(a) com o email informado!";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

}
