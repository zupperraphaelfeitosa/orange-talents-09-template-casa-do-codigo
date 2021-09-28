package br.com.zup.raphaelfeitosa.casadocodigo.validation.annotations;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = {CategoriaUnicaValidador.class})
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface CategoriaUnica {
    String message() default "Já existe uma categoria cadastrada com esse nome!";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

}
