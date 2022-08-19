package com.bridgelabz.learningmanagementsystem.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus
@Data
@AllArgsConstructor
public class CustomExceptions  extends RuntimeException{
    private int statusCode;
    private String statusMessage;
}
