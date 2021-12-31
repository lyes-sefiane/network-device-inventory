package com.lyess.network_device_inventory.exception.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.internal.engine.path.PathImpl;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;

import javax.validation.ConstraintViolation;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * @author : Lyes Sefiane
 * @mailto : lyes.sefiane@gmail.com
 * @created : 2021-12-26 12:39 p.m.
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@Schema(accessMode = Schema.AccessMode.READ_ONLY)
public class ExceptionResponse {

    @JsonIgnore
    private HttpStatus httpStatus;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd hh:mm:ss")
    private LocalDateTime timeStamp;

    private String status;

    private String error;

    private String message;

    private String path;

    @Schema(allOf = {ValidationError.class}, implementation = ErrorResponse.class)
    private List<ErrorResponse> details;


    public ExceptionResponse(String message, HttpStatus httpStatus, String path) {
        this.timeStamp = LocalDateTime.now();
        this.httpStatus = httpStatus;
        this.status = httpStatus.value() + "";
        this.error = httpStatus.getReasonPhrase();
        this.message = message;
        this.path = path;
    }


    private ValidationError buildValidationError(String object, String field, Object rejectedValue, String message) {
        return ValidationError.builder()//
                .object(object)//
                .field(field)//
                .rejectedValue(rejectedValue)//
                .message(message)//
                .build();
    }

    private ValidationError buildValidationError(String object, String message) {
        return ValidationError.builder()//
                .object(object)//
                .message(message)//
                .build();
    }

    private void addError(ErrorResponse error) {
        if (details == null) {
            details = new ArrayList<>();
        }
        details.add(error);
    }

    public void addErrors(Set<ConstraintViolation<?>> constraintViolations) {
        constraintViolations.stream()//
                .map(constraintViolation -> buildValidationError(constraintViolation.getRootBeanClass().getSimpleName(), //
                        ((PathImpl) constraintViolation.getPropertyPath()).getLeafNode().getName(), //
                        constraintViolation.getInvalidValue(), //
                        constraintViolation.getMessage()))//
                .forEach(this::addError);
    }

    public void addFieldErrors(List<FieldError> fieldErrors) {
        fieldErrors.stream()//
                .map(fieldError -> buildValidationError(fieldError.getObjectName(), //
                        fieldError.getField(), //
                        fieldError.getRejectedValue(), //
                        fieldError.getDefaultMessage()))//
                .forEach(this::addError);
    }

    public void addGlobalErrors(List<ObjectError> globalErrors) {
        globalErrors.stream()//
                .map(globalError -> buildValidationError(globalError.getObjectName(), //
                        globalError.getDefaultMessage()))//
                .forEach(this::addError);
    }

}
