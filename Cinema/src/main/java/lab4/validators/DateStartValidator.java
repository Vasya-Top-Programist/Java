package lab4.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDate;
import java.time.Period;

public class DateStartValidator  implements ConstraintValidator<FilmStartDate, LocalDate> {
    private int yearLimit;

    @Override
    public void initialize(FilmStartDate filmStartDate) {
        yearLimit = filmStartDate.yearLimit();
    }

    @Override
    public boolean isValid(LocalDate dateStart, ConstraintValidatorContext context) {
        return Period.between(dateStart, LocalDate.now()).getYears() < yearLimit;
    }
}
