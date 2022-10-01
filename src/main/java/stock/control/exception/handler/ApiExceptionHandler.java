package stock.control.exception.handler;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import stock.control.exception.DataAlreadyRegisteredException;
import stock.control.exception.DataNotFoundException;
import javax.persistence.NoResultException;
import javax.servlet.http.HttpServletRequest;
import java.time.OffsetDateTime;
import java.util.List;

@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {

    private static final String INVALIDATION_MESSAGE = "Um ou mais campos estão inválidos! " +
            "Faça o preenchimento correto e tente novamente.";

    private static final String GENERIC_ERROR_MESSAGE = "Ops! Houve uma falha inesperada no sistema. " +
            "Tente novamente e, se a falha persistir, entre em contato com o administrador.";

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers,
                                                                  HttpStatus status, WebRequest request) {
        return handleValidationException(ex, headers, status, request);
    }

    @Override
    protected ResponseEntity<Object> handleBindException(BindException ex, HttpHeaders headers,
                                                         HttpStatus status, WebRequest request) {
        return handleValidationException(ex, headers, status, request);
    }

    @Override
    protected ResponseEntity<Object> handleExceptionInternal(Exception ex, Object body, HttpHeaders headers,
                                                             HttpStatus status, WebRequest request) {
        ApiError apiError = ApiError
                .builder()
                .status(status.value())
                .title(status.getReasonPhrase())
                .build();

        headers.setContentType(MediaType.APPLICATION_PROBLEM_JSON);

        return super.handleExceptionInternal(ex, apiError, headers, status, request);
    }

    private ResponseEntity<Object> handleValidationException(Exception ex, HttpHeaders headers,
                                                             HttpStatus status, WebRequest request) {
        List<ApiError.Field> fields = getFieldsWithError(ex);

        var apiError = ApiError
                .builder()
                .dateTime(OffsetDateTime.now())
                .status(status.value())
                .title(INVALIDATION_MESSAGE)
                .type(getErrorDocumentationUrl(request))
                .detail("Preencha os dados que são obrigatórios, e respeite o limite/valor máximo dos caracteres.")
                .fields(fields)
                .build();

        headers.setContentType(MediaType.APPLICATION_PROBLEM_JSON);

        return super.handleExceptionInternal(ex, apiError, headers, status, request);
    }

    @ExceptionHandler(NoResultException.class)
    protected ResponseEntity<Object> handleNoResult(NoResultException ex, WebRequest request) {
        HttpStatus status = HttpStatus.NOT_FOUND;

        var apiError = ApiError
                .builder()
                .dateTime(OffsetDateTime.now())
                .status(status.value())
                .title("Recurso não encontrado.")
                .type(getErrorDocumentationUrl(request))
                .detail(ex.getMessage())
                .build();

        var headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_PROBLEM_JSON);

        return super.handleExceptionInternal(ex, apiError, headers, status, request);
    }

    @ExceptionHandler(DataAlreadyRegisteredException.class)
    protected ResponseEntity<Object> handleDataAlreadyRegistered(DataAlreadyRegisteredException ex, WebRequest request) {
        HttpStatus status = HttpStatus.BAD_REQUEST;

        var apiError = ApiError
                .builder()
                .dateTime(OffsetDateTime.now())
                .status(status.value())
                .title("Dados já cadastrados.")
                .type(getErrorDocumentationUrl(request))
                .detail(ex.getMessage())
                .build();

        var headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_PROBLEM_JSON);

        return super.handleExceptionInternal(ex, apiError, headers, status, request);
    }

    @ExceptionHandler(DataNotFoundException.class)
    protected ResponseEntity<Object> handleDataNotFound(DataNotFoundException ex, WebRequest request) {
        HttpStatus status = HttpStatus.NOT_FOUND;

        var apiError = ApiError
                .builder()
                .dateTime(OffsetDateTime.now())
                .status(status.value())
                .title("Dados não encontrados.")
                .type(getErrorDocumentationUrl(request))
                .detail(ex.getMessage())
                .build();

        var headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_PROBLEM_JSON);

        return super.handleExceptionInternal(ex, apiError, headers, status, request);
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    protected ResponseEntity<Object> handleDataIntegrityViolation(DataIntegrityViolationException ex, WebRequest request) {
        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;

        var apiError = ApiError
                .builder()
                .dateTime(OffsetDateTime.now())
                .status(status.value())
                .title("Violação de integridade de dados.")
                .build();

        var headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_PROBLEM_JSON);

        return super.handleExceptionInternal(ex, apiError, headers, status, request);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleUncaughtException(Exception ex, WebRequest request) {
        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;

        var apiError = ApiError
                .builder()
                .dateTime(OffsetDateTime.now())
                .status(status.value())
                .title(GENERIC_ERROR_MESSAGE)
                .build();

        var headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_PROBLEM_JSON);

        return super.handleExceptionInternal(ex, apiError, headers, status, request);
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<Object> handleRuntimeException(RuntimeException ex, WebRequest request) {
        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;

        var apiError = ApiError
                .builder()
                .dateTime(OffsetDateTime.now())
                .status(status.value())
                .title(GENERIC_ERROR_MESSAGE)
                .build();

        var headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_PROBLEM_JSON);

        return super.handleExceptionInternal(ex, apiError, headers, status, request);
    }

    private List<ApiError.Field> getFieldsWithError(Exception ex) {
        return ((MethodArgumentNotValidException) ex)
                .getBindingResult()
                .getFieldErrors()
                .stream()
                .map(fieldError -> ApiError.Field
                        .builder()
                        .name(fieldError.getField())
                        .message(fieldError.getDefaultMessage())
                        .build())
                .toList();
    }

    private String getErrorDocumentationUrl(WebRequest request) {
        HttpServletRequest servletRequest = ((ServletWebRequest) request).getRequest();

        var requestUrl = servletRequest.getRequestURL().toString();
        var requestUri = servletRequest.getRequestURI();

        var contextPath = servletRequest.getContextPath();

        var documentationUri = contextPath + "/documentation";

        return requestUrl.replace(requestUri, documentationUri);
    }

}
