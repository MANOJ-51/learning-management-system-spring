package com.bridgelabz.learningmanagementsystem.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Purpose:Creating Custom Exception class
 * @author Manoj
 * @Param StatusCode ,StatusMessage
 * Version 1.0
 */
@ResponseStatus
@Data
@AllArgsConstructor
public class CustomExceptions  extends RuntimeException{
    private int statusCode;
    private String statusMessage;
}
