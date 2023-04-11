package com.employeemanagement.advice;

import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import static org.springframework.validation.DefaultBindingErrorProcessor.MISSING_FIELD_ERROR_CODE;

public class FieldBindingErrors {

    public static BindingResult fieldError(BindingResult result, Object field, String message){
        String fixedField = result.getNestedPath() + field;
        String[] codes = result.resolveMessageCodes(MISSING_FIELD_ERROR_CODE, fixedField);
        FieldError error = new FieldError(result.getObjectName(), "", field, true,
                codes, null, message);
        result.addError(error);
        return result;
    }
}
