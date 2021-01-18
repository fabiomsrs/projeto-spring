package com.zup.loteria.validation.emailDuplicado;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Documented
@Constraint(validatedBy = NumeroDuplicadoValidator.class)
@Target({ ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
public @interface NumeroDuplicadoConstraint {
	String message() default "Voce gerou um numero repetido, tente novamente";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
