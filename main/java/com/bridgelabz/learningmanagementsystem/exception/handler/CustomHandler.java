package com.bridgelabz.learningmanagementsystem.exception.handler;

import com.bridgelabz.learningmanagementsystem.exception.CustomExceptions;
import com.bridgelabz.learningmanagementsystem.exception.CustomValidation;
import com.bridgelabz.learningmanagementsystem.util.ResponseClass;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomHandler{
    @ExceptionHandler(CustomExceptions.class)
    public ResponseEntity<ResponseClass> exceptionHandler(CustomExceptions customException){
        ResponseClass responseClass = new ResponseClass();
        responseClass.setErrorCode(400);
        responseClass.setErrorMessage(customException.getStatusMessage());
        return new ResponseEntity<>(responseClass, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<CustomValidation> customHandler(MethodArgumentNotValidException exception){
        CustomValidation customValidation = new CustomValidation();
        customValidation.setErrorCode(400);
        customValidation.setErrorMessage(exception.getFieldError().getDefaultMessage());
        return new ResponseEntity<>(customValidation,HttpStatus.BAD_REQUEST);
    }
}
