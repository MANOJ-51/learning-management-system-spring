package com.bridgelabz.learningmanagementsystem.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;


@Data
public class AdminDTO {
    @NotNull(message = "First Name Should Not be Null")
    private String firstName;
    @NotNull(message = "Last Name Should Not be Null")
    private String lastName;
    @NotNull(message = "Mobile Number Should Not be Null")
    private Long mobileNumber;
    @NotNull(message = "Email id  Should Not be Null")
    private String emailId;
    @NotNull(message = "Password Should Not be Null")
    private String password;
}
