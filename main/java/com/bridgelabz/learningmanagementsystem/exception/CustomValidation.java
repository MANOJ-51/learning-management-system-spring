package com.bridgelabz.learningmanagementsystem.exception;

import lombok.Data;

/**
 * Purpose:Creating Custom validation class
 * @author Manoj
 * @Param errorCode ,errorMessage
 * Version 1.0
 */
@Data
public class CustomValidation extends RuntimeException{
    private int errorCode;
    private String errorMessage;

    public CustomValidation() {
    }
}
