package com.bridgelabz.learningmanagementsystem.exception.handler;

import com.bridgelabz.learningmanagementsystem.exception.CustomExceptions;
import com.bridgelabz.learningmanagementsystem.exception.CustomValidation;
import com.bridgelabz.learningmanagementsystem.util.ResponseClass;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Purpose:Creating Custom Exception Handler for project
 * @author Manoj
 * @Param exceptionHandlers
 * Version 1.0
 */
@ControllerAdvice
public class CustomHandler{

    /**
     * Purpose:Creating method to handle internal Server Error
     * @author Manoj
     * @Param response class
     */
    @ExceptionHandler(CustomExceptions.class)
    public ResponseEntity<ResponseClass> exceptionHandler(CustomExceptions customException){
        ResponseClass responseClass = new ResponseClass();
        responseClass.setErrorCode(400);
        responseClass.setErrorMessage(customException.getStatusMessage());
        return new ResponseEntity<>(responseClass, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    /**
     * Purpose:Creating method to handle MethodArgumentNotValidException
     * @author Manoj
     * @Param custom validation
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<CustomValidation> customHandler(MethodArgumentNotValidException exception){
        CustomValidation customValidation = new CustomValidation();
        customValidation.setErrorCode(400);
        customValidation.setErrorMessage(exception.getBindingResult().getFieldError().getDefaultMessage());
        return new ResponseEntity<>(customValidation,HttpStatus.BAD_REQUEST);
    }
}
