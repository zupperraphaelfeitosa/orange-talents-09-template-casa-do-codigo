package br.com.zup.raphaelfeitosa.casadocodigo.validation.annotations;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = {EstadoPertencenteAPaisValidador.class})
@Target({ElementType.METHOD,ElementType.FIELD,ElementType.ANNOTATION_TYPE,ElementType.CONSTRUCTOR,ElementType.PARAMETER,ElementType.TYPE_USE})
@Retention(RetentionPolicy.RUNTIME)
public @interface EstadoPertencenteAPais {

    Class<?> classeDominio();
    String message() default "Estado não pertence a esse pais";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

}
