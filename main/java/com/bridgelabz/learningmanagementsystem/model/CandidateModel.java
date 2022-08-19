package com.bridgelabz.learningmanagementsystem.model;

import com.bridgelabz.learningmanagementsystem.dto.CandidateDTO;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "candidate_details")
public class CandidateModel {
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
    private String preferredJobLocation;
    private String status;
    private String passedOutYear;
    private String creatorUser;
    private String candidateStatus;
    private LocalDateTime createdStamp;
    private LocalDateTime updatedStamp;

    public CandidateModel(CandidateDTO candidateDTO) {
        this.cicId = candidateDTO.getCicId();
        this.fullName = candidateDTO.getFullName();
        this.email = candidateDTO.getEmail();
        this.mobileNumber = candidateDTO.getMobileNumber();
        this.hireDate = candidateDTO.getHireDate();
        this.degree = candidateDTO.getDegree();
        this.aggregatePercentage =candidateDTO.getAggregatePercentage();
        this.city = candidateDTO.getCity();
        this.state = candidateDTO.getState();
        this.preferredJobLocation = candidateDTO.getPreferredJobLocation();
        this.status = candidateDTO.getStatus();
        this.passedOutYear = candidateDTO.getPassedOutYear();
        this.creatorUser = candidateDTO.getCreatorUser();
        this.candidateStatus = candidateDTO.getCandidateStatus();
    }

    public CandidateModel() {
    }
}
