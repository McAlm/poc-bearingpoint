package org.example.camunda.process.solution.worker;

import io.camunda.connector.api.validation.ValidationProvider;

public class LegacyValidationProvider implements ValidationProvider{

    @Override
    public void validate(Object objectToValidate) {
        System.out.println("Validate " + objectToValidate);
        
    }
    
}
