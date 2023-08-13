package com.first.learnspring.error;

import com.first.learnspring.entity.ErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(DepartmentNotFound.class)
    public ResponseEntity<ErrorMessage>  departmentNotFoundException(DepartmentNotFound departmentNotFound, WebRequest webRequest)
    {
        ErrorMessage errorMessage=new ErrorMessage(HttpStatus.NOT_FOUND,departmentNotFound.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
    }
}
