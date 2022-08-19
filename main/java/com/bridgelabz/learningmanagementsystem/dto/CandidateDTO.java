package com.bridgelabz.learningmanagementsystem.dto;

import lombok.Data;

@Data
public class CandidateDTO {
    private Long id;
    private String cicId;
    private String fullName;
    private String email;
    private String mobileNumber;
    private String hireDate;
    private String degree;
    private String aggregatePercentage;
    private String city;
    private String state;
    private String preferredJobLocation;
    private String status;
    private String passedOutYear;
    private String creatorUser;
    private String candidateStatus;
}
