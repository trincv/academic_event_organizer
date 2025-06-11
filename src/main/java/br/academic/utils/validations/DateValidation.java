package br.academic.utils.validations;

import br.academic.core.App; 
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;
import java.util.Set;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;


public class DateValidation {

    @Target({ FIELD, PARAMETER }) 
    @Retention(RUNTIME)
    @Constraint(validatedBy = ValidDateFormatValidator.class)
    @Documented 
    public @interface ValidDateFormat {
        String message() default "Invalid date format (dd/mm/yyyy) or non-existent date.";
        Class<?>[] groups() default {};
        Class<? extends Payload>[] payload() default {};
    }

    public static class ValidDateFormatValidator implements ConstraintValidator<ValidDateFormat, String> {
        private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        @Override
        public void initialize(ValidDateFormat constraintAnnotation) {
            
        }

        @Override
        public boolean isValid(String dateStr, ConstraintValidatorContext context) {
            if (dateStr == null || dateStr.trim().isEmpty()) {
                return false; 
            }
            try {

                LocalDate.parse(dateStr, DATE_FORMATTER);
                return true; 
            } catch (DateTimeParseException e) {
                return false; 
            }
        }
    }

    public static class DateWrapper {
        @ValidDateFormat 
        private String date;

        public DateWrapper(String date) {
            this.date = date;
        }

        public String getDate() {
            return date;
        }
    }

    private static final ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
    private static final Validator validator = factory.getValidator();

    public static String getValidDateInput() {
        String date;
        do {
            date = App.sc.nextLine(); 

            Set<ConstraintViolation<DateWrapper>> violations = validator.validate(new DateWrapper(date));

            if (!violations.isEmpty()) {

                for (ConstraintViolation<DateWrapper> violation : violations) {
                    System.err.println("Error: " + violation.getMessage()); 
                }
                System.err.print("Correct the input and try again: "); 
            } else {
                
                break; 
            }
        } while (true); 

        return date; 
    }

    public static boolean isDateFormatValid(String date) {
        Set<ConstraintViolation<DateWrapper>> violations = validator.validate(new DateWrapper(date));
        return violations.isEmpty(); 
    }
}