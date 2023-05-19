package com.pgrrr.onedelivery.exception;

import lombok.extern.slf4j.Slf4j;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.bind.support.WebExchangeBindException;
import org.springframework.web.multipart.MaxUploadSizeExceededException;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    /**
     * 모든 서버 예외 처리
     *
     * @param e 모든 예외
     * @return ResponseEntity
     */
    @ExceptionHandler(Throwable.class)
    public ResponseEntity<String> handleInternalServerError(Throwable e) {
        logException(e);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
    }

    /**
     * Valid 검증 예외는 ExceptionHandler로 처리
     *
     * @param e 유효하지 않는 데이터인 경우 발생
     * @return ResponseEntity 에러 메시지 나열
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<String> validationException(MethodArgumentNotValidException e) {
        BindingResult bindingResult = e.getBindingResult();

        StringBuilder builder = new StringBuilder();
        for (FieldError fieldError : bindingResult.getFieldErrors()) {
            builder.append(fieldError.getDefaultMessage());
            builder.append("/n");
        }
        String message = builder.toString();
        log.error(message);
        return ResponseEntity.badRequest().body(message);
    }

    @ExceptionHandler(DuplicateException.class)
    public ResponseEntity<String> handleDuplicateException(DuplicateException e) {
        logException(e);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }

    @ExceptionHandler(WebExchangeBindException.class)
    public ResponseEntity<String> handleWebExchangeBindException(WebExchangeBindException e) {
        logException(e);
        e.getBindingResult()
                .getAllErrors()
                .forEach(error -> log.error("Error : {}", error.getDefaultMessage()));
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }

    @ExceptionHandler(MaxUploadSizeExceededException.class)
    protected ResponseEntity<ErrorResponse> handleMaxUploadSizeExceededException(
            MaxUploadSizeExceededException e) {
        logException(e);
        ErrorResponse response = ErrorResponse.of(ErrorCode.FILE_SIZE_EXCEED);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }

    private void logException(Throwable e) {
        log.error("{} caught by advice : {}", e.getClass().getName(), e.getMessage(), e);
    }
}
