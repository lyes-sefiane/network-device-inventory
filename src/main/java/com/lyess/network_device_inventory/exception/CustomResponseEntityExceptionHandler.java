package com.lyess.network_device_inventory.exception;

import com.lyess.network_device_inventory.exception.entities.ExceptionResponse;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.validation.ConstraintViolationException;

/**
 * @author : Lyes Sefiane
 * @mailto : lyes.sefiane@gmail.com
 * @created : 2021-12-26 12:45 p.m.
 */
@RestControllerAdvice
public class CustomResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    /**
     * Handle Network Element Not Found
     *
     * @param ex : RuntimeException
     * @param request : WebRequest
     * @return responseEntity : ResponseEntity<Object>
     */
    @ExceptionHandler(NetworkDeviceNotFoundException.class)
    public final ResponseEntity<Object> handleNetworkDeviceNotFound(RuntimeException ex, WebRequest request) {

        return buildResponseEntity(//
                new ExceptionResponse(//
                        ex.getMessage(), //
                        HttpStatus.NOT_FOUND, //
                        ((ServletWebRequest) request).getRequest().getRequestURI()));
    }

    /**
     * Handle Constraint Violation
     *
     * Thrown when path variable validation fail.
     *
     * @param ex
     * @param request
     * @return responseEntity : ResponseEntity<Object>
     */
    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<Object> handleConstraintViolation(ConstraintViolationException ex, WebRequest request) {

        ExceptionResponse exceptionResponse = new ExceptionResponse(//
                "validation error", //
                HttpStatus.BAD_REQUEST, //
                ((ServletWebRequest) request).getRequest().getRequestURI());

        exceptionResponse.addErrors(ex.getConstraintViolations());

        return buildResponseEntity(exceptionResponse);
    }

    /**
     * Handle Method Argument Not Valid
     *
     *
     * Thrown when bean validation fail.
     *
     * @param ex
     * @param headers
     * @param status
     * @param request
     *
     * @return ResponseEntity<Object>
     */
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                  HttpHeaders headers, HttpStatus status, WebRequest request) {

        ExceptionResponse exceptionResponse = new ExceptionResponse(//
                "validation error", //
                HttpStatus.BAD_REQUEST, //
                ((ServletWebRequest) request).getRequest().getRequestURI());

        exceptionResponse.addFieldErrors(ex.getBindingResult().getFieldErrors());
        exceptionResponse.addGlobalErrors(ex.getBindingResult().getGlobalErrors());

        return buildResponseEntity(exceptionResponse);
    }

    /**
     * Handle Http Request Method Not Supported
     *
     *
     * Thrown when there is no method related to URL.
     *
     * @param ex
     * @param headers
     * @param status
     * @param request
     *
     * @return ResponseEntity<Object>
     */
    @Override
    protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex,
                                                                         HttpHeaders headers, HttpStatus status, WebRequest request) {

        String message = ex.getMethod() + " request method not supported";

        return buildResponseEntity(new ExceptionResponse(message.toString(), //
                HttpStatus.NOT_FOUND, //
                ((ServletWebRequest) request).getRequest().getRequestURI()));
    }

    /**
     * Handle Http MediaType Not Supported
     *
     *
     * Thrown when MediaType is not supported.
     *
     * @param ex
     * @param headers
     * @param status
     * @param request
     *
     * @return ResponseEntity<Object>
     */
    @Override
    public ResponseEntity<Object> handleHttpMediaTypeNotSupported(HttpMediaTypeNotSupportedException ex, //
                                                                  HttpHeaders headers, //
                                                                  HttpStatus status, //
                                                                  WebRequest request) {

        StringBuilder message = new StringBuilder();
        message.append(ex.getContentType())//
                .append(" ")
                .append("mediaType is not supported")//
                .append(". ")
                .append("supported media types are : ")//
                .append(ex.getSupportedMediaTypes());

        return buildResponseEntity(new ExceptionResponse(message.toString(), //
                HttpStatus.UNSUPPORTED_MEDIA_TYPE, //
                ((ServletWebRequest) request).getRequest().getRequestURI()));
    }

    /**
     * Handle Data Integrity Violation
     *
     * Thrown when operation has violated a database integrity constraint.
     *
     * Thrown when deleting
     *
     * @param ex
     * @param request
     * @return ResponseEntity<Object>
     */
    @ExceptionHandler(DataIntegrityViolationException.class)
    protected ResponseEntity<Object> handleDataIntegrityViolation(DataIntegrityViolationException ex,
                                                                  WebRequest request) {
        if (ex.getCause() instanceof ConstraintViolationException) {
            return buildResponseEntity(new ExceptionResponse("database error", //
                    HttpStatus.CONFLICT, //
                    ((ServletWebRequest) request).getRequest().getRequestURI()));
        }
        return buildResponseEntity(new ExceptionResponse("Internal server error", //
                HttpStatus.INTERNAL_SERVER_ERROR, //
                ((ServletWebRequest) request).getRequest().getRequestURI()));
    }

    /**
     * Handle Http Message Not Readable
     *
     * Thrown when request JSON is malformed.
     *
     * @param ex
     * @param request
     * @return ResponseEntity<Object>
     */
    @Override
    public ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex, //
                                                               HttpHeaders headers, //
                                                               HttpStatus status, //
                                                               WebRequest request) {

        return buildResponseEntity(new ExceptionResponse(//
                "malformed json request.", //
                HttpStatus.BAD_REQUEST, //
                ((ServletWebRequest) request).getRequest().getRequestURI()));
    }



    /**
     * Build Response Entity
     *
     * @param exceptionResponse : ExceptionResponse
     * @return responseEntity : ResponseEntity<Object>
     */
    private ResponseEntity<Object> buildResponseEntity(ExceptionResponse exceptionResponse) {
        return new ResponseEntity<>(exceptionResponse, exceptionResponse.getHttpStatus());
    }

}
