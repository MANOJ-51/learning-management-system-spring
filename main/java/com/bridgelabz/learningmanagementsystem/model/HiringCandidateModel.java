package com.bridgelabz.learningmanagementsystem.model;

import com.bridgelabz.learningmanagementsystem.dto.HiringCandidateDTO;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "hiring_candidate_details")
public class HiringCandidateModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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
    private String jobLocation;
    private String status;
    private String passedOutYear;
    private String creatorUser;
    private String candidateStatus;
    private LocalDateTime createdStamp;
    private LocalDateTime updatedStamp;
    @OneToOne
    BankDetailsModel bankDetailsModel;

    public HiringCandidateModel(HiringCandidateDTO hiringCandidateDTO) {
        this.cicId = hiringCandidateDTO.getCicId();
        this.fullName = hiringCandidateDTO.getFullName();
        this.email = hiringCandidateDTO.getEmail();
        this.mobileNumber = hiringCandidateDTO.getMobileNumber();
        this.hireDate = hiringCandidateDTO.getHireDate();
        this.degree = hiringCandidateDTO.getDegree();
        this.aggregatePercentage =hiringCandidateDTO.getAggregatePercentage();
        this.city = hiringCandidateDTO.getCity();
        this.state = hiringCandidateDTO.getState();
        this.jobLocation = hiringCandidateDTO.getJobLocation();
        this.status = hiringCandidateDTO.getStatus();
        this.passedOutYear = hiringCandidateDTO.getPassedOutYear();
        this.creatorUser = hiringCandidateDTO.getCreatorUser();
        this.candidateStatus = hiringCandidateDTO.getCandidateStatus();
    }

    public HiringCandidateModel() {
    }
}
