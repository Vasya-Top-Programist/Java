package lab4.validators;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Constraint(validatedBy = DateStartValidator.class)
public @interface FilmStartDate {
    String message() default "{NotOlderThan}";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default  {};
    int yearLimit();
}
