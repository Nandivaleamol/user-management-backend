package com.elite.evince.task.exception;

import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    public ProblemDetail onException(RuntimeException exception){
        var problemDetail = ProblemDetail.forStatus(404);
        problemDetail.setDetail(exception.getMessage());
        problemDetail.setTitle("Not Found Exception");
        return problemDetail;
    }
}
