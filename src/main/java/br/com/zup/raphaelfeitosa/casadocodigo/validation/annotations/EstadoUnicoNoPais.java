package br.com.zup.raphaelfeitosa.casadocodigo.validation.annotations;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = {EstadoUnicoNoPaisValidador.class})
@Target({ElementType.METHOD,ElementType.FIELD,ElementType.ANNOTATION_TYPE,ElementType.CONSTRUCTOR,ElementType.PARAMETER,ElementType.TYPE_USE})
@Retention(RetentionPolicy.RUNTIME)
public @interface EstadoUnicoNoPais {

    Class<?> classeDominio();
    String message() default "Cadastro já existe no banco de dados!";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

}
