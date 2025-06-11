package br.academic.utils.validations;

import br.academic.core.App;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import jakarta.validation.constraints.Pattern; 
import java.util.Set;

public class CpfValidation {

    public static class CpfWrapper {

        @Pattern(regexp = "\\d{11}", message = "CPF must contain exactly 11 numbers.")
        private String cpf;

        public CpfWrapper(String cpf) {
            this.cpf = cpf;
        }

        public String getCpf() {
            return cpf;
        }
    }

    private static final ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
    private static final Validator validator = factory.getValidator();


    public static String getValidCpfInput() {
        String cpf;
        do {
            
            cpf = App.sc.nextLine();

            Set<ConstraintViolation<CpfWrapper>> violations = validator.validate(new CpfWrapper(cpf));

            if(!violations.isEmpty()) {

                for(ConstraintViolation<CpfWrapper> violation : violations) {
                    System.err.print("Error: " + violation.getMessage() + "Digit again: ");
                }
            } else 
                break;

        } while (true); 

        return cpf; 
    }

    
    public static boolean isCpfFormatValid(String cpf) {
        
        Set<ConstraintViolation<CpfWrapper>> violations = validator.validate(new CpfWrapper(cpf));
        return violations.isEmpty(); 
    }
}

