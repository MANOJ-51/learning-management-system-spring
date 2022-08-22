package com.bridgelabz.learningmanagementsystem.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class HiringCandidateDTO {
    @NotNull(message = "cic Id Should Not be Null")
    private String cicId;
    @NotNull(message = "Full Name Should Not be Null")
    private String fullName;
    @NotNull(message = "Email Should Not be Null")
    private String email;
    @NotNull(message = "Mobile Number Should Not be Null")
    private String mobileNumber;
    @NotNull(message = "Hire Date Should Not be Null")
    private String hireDate;
    @NotNull(message = "Degree Should Not be Null")
    private String degree;
    @NotNull(message = "Aggregate Percentage Should Not be Null")
    private String aggregatePercentage;
    @NotNull(message = "City Should Not be Null")
    private String city;
    @NotNull(message = "State Should Not be Null")
    private String state;
    @NotNull(message = "Preferred Location Should Not be Null")
    private String jobLocation;
    @NotNull(message = "Status Should Not be Null")
    private String status;
    @NotNull(message = "Pass out Year Should Not be Null")
    private String passedOutYear;
    @NotNull(message = "Creator User Should Not be Null")
    private String creatorUser;
    @NotNull(message = "Candidate Status Should Not be Null")
    private String candidateStatus;
}
