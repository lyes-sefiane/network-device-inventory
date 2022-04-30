package com.lyess.network_device_inventory.domain.enums.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author : Lyes Sefiane
 * @mailto : lyes.sefiane@gmail.com
 * @created : 2021-12-25 12:42 p.m.
 */
@Target({ ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = ElementTypeValueValidator.class)
public @interface ElementTypeValidator {

    String message() default "Undefined value. Supported values are : ";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
