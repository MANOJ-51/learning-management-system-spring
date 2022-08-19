package com.bridgelabz.learningmanagementsystem.dto;

import lombok.Data;


@Data
public class AdminDTO {
    private Long id ;
    private String firstName;
    private String lastName;
    private Long mobileNumber;
    private String emailId;
    private String password;
    private String profilePath;
}
