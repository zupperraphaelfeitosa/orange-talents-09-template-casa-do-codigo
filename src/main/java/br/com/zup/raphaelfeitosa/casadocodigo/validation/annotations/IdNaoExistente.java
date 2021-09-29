package br.com.zup.raphaelfeitosa.casadocodigo.validation.annotations;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = {IdNaoExistenteValidador.class})
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface IdNaoExistente {

    Class<?> classeDominio();
    String message() default "Cadastro não existente no banco de dados!";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

}
