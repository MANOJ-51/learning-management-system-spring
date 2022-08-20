package com.bridgelabz.learningmanagementsystem.exception;

import lombok.Data;

@Data
public class CustomValidation extends RuntimeException{
    private int errorCode;
    private String errorMessage;

    public CustomValidation() {
    }
}
