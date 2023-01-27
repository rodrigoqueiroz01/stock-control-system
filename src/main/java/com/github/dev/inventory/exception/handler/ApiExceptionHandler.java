package com.github.dev.inventory.exception.handler;

import com.github.dev.inventory.exception.DataAlreadyRegisteredException;
import com.github.dev.inventory.exception.EntityNotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.io.IOException;
import java.util.List;

@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {

    private static final String INVALIDATION_MESSAGE = "One or more fields are invalid! " +
            "Fill in correctly and try again.";

    private static final String GENERIC_ERROR_MESSAGE = "Unexpected condition while processing the request. " +
            "Try again, and if the problem persists, contact your administrator.";

    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        return handleValidationException(ex, headers, status, request);
    }

    protected ResponseEntity<Object> handleBindException(BindException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        return handleValidationException(ex, headers, status, request);
    }

    private ResponseEntity<Object> handleValidationException(Exception ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        List<ApiError.Field> fields = getFieldsWithError(ex);

        var apiError = ApiError.builder()
                .status(status.value())
                .title(INVALIDATION_MESSAGE)
                .detail("Fill in the data that are mandatory, and respect the limit/maximum value of the characters.")
                .fields(fields)
                .build();

        headers.setContentType(MediaType.APPLICATION_PROBLEM_JSON);
        return super.handleExceptionInternal(ex, apiError, headers, status, request);
    }

    private List<ApiError.Field> getFieldsWithError(Exception ex) {
        return ((MethodArgumentNotValidException) ex).getBindingResult().getFieldErrors()
                .stream()
                .map(fieldError -> ApiError.Field.builder()
                        .name(fieldError.getField())
                        .message(fieldError.getDefaultMessage())
                        .build())
                .toList();
    }

    @ExceptionHandler(DataAlreadyRegisteredException.class)
    protected ResponseEntity<Object> handleDataAlreadyRegistered(DataAlreadyRegisteredException ex, WebRequest request) {
        var status = HttpStatus.BAD_REQUEST;

        var apiError = ApiError.builder()
                .error("Bad Request")
                .status(status.value())
                .detail(ex.getMessage())
                .build();

        var headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_PROBLEM_JSON);

        return handleExceptionInternal(ex, apiError, headers, status, request);
    }

    @ExceptionHandler(EntityNotFoundException.class)
    protected ResponseEntity<Object> handleEntityNotFound(EntityNotFoundException ex, WebRequest request) {
        var status = HttpStatus.NOT_FOUND;

        var apiError = ApiError.builder()
                .error("Not Found")
                .status(status.value())
                .detail(ex.getMessage())
                .build();

        var headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_PROBLEM_JSON);

        return handleExceptionInternal(ex, apiError, headers, status, request);
    }

    @ExceptionHandler(Exception.class)
    protected ResponseEntity<Object> handleUncaughtException(Exception ex, WebRequest request) {
        var status = HttpStatus.INTERNAL_SERVER_ERROR;

        var apiError = ApiError.builder()
                .error("Internal Server Error")
                .status(status.value())
                .title(GENERIC_ERROR_MESSAGE)
                .detail(ex.getMessage())
                .build();

        var headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_PROBLEM_JSON);

        return handleExceptionInternal(ex, apiError, headers, status, request);
    }

    @ExceptionHandler(RuntimeException.class)
    protected ResponseEntity<Object> handleRunTime(RuntimeException ex, WebRequest request) {
        var status = HttpStatus.INTERNAL_SERVER_ERROR;

        var apiError = ApiError.builder()
                .error("Internal Server Error")
                .status(status.value())
                .title(GENERIC_ERROR_MESSAGE)
                .detail(ex.getMessage())
                .build();

        var headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_PROBLEM_JSON);

        return handleExceptionInternal(ex, apiError, headers, status, request);
    }

    @ExceptionHandler(NullPointerException.class)
    protected ResponseEntity<Object> handleNullPointer(NullPointerException ex, WebRequest request) {
        var status = HttpStatus.INTERNAL_SERVER_ERROR;

        var apiError = ApiError.builder()
                .title(GENERIC_ERROR_MESSAGE)
                .status(status.value())
                .detail(ex.getMessage())
                .build();

        var headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_PROBLEM_JSON);

        return handleExceptionInternal(ex, apiError, headers, status, request);
    }

    @ExceptionHandler(IOException.class)
    protected ResponseEntity<Object> handleIO(IOException ex, WebRequest request) {
        var status = HttpStatus.INTERNAL_SERVER_ERROR;

        var apiError = ApiError.builder()
                .title(GENERIC_ERROR_MESSAGE)
                .status(status.value())
                .detail(ex.getMessage())
                .build();

        var headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_PROBLEM_JSON);

        return handleExceptionInternal(ex, apiError, headers, status, request);
    }

    @ExceptionHandler(HttpServerErrorException.class)
    protected ResponseEntity<Object> handleHttpServerError(HttpServerErrorException ex, WebRequest request) {
        var status = HttpStatus.INTERNAL_SERVER_ERROR;

        var apiError = ApiError.builder()
                .title(GENERIC_ERROR_MESSAGE)
                .status(status.value())
                .detail(ex.getMessage())
                .build();

        var headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_PROBLEM_JSON);

        return handleExceptionInternal(ex, apiError, headers, status, request);
    }


    protected ResponseEntity<Object> handleExceptionInternal(Exception ex, Object body, HttpHeaders headers, HttpStatus status, WebRequest request) {
        var apiError = ApiError.builder()
                .status(status.value())
                .title(status.getReasonPhrase())
                .build();

        headers.setContentType(MediaType.APPLICATION_PROBLEM_JSON);

        return super.handleExceptionInternal(ex, body, headers, status, request);
    }

}
