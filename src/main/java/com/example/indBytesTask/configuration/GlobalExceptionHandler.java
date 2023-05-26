package com.example.indBytesTask.configuration;

import com.example.indBytesTask.vo.ApiExceptionVo;
import com.example.indBytesTask.vo.ErrorVo;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@RestControllerAdvice
//@Configuration
public class GlobalExceptionHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<ErrorVo>> handlerMethodArgsNotValidException(MethodArgumentNotValidException exception){
        List<ErrorVo> error = exception.getBindingResult().getAllErrors().stream().map(objectError -> ErrorVo.builder()
                        .fieldName(((FieldError) objectError).getField())
                        .message(List.of(Objects.requireNonNull(objectError.getDefaultMessage())))
                        .build())
                .collect(Collectors.toList());
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = {ApiExceptionHandler.class})
    public ResponseEntity<List<ApiExceptionVo>> handleRequestApiException(ApiExceptionHandler e){
        ApiExceptionVo apiExceptionVo = ApiExceptionVo.builder()
                .code(e.getCode())
                .message(e.getMessage())
                .build();
        return ResponseEntity.badRequest().body(List.of(apiExceptionVo));
    }
}
