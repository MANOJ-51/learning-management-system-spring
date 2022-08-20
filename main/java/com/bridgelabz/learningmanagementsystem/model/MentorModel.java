package com.bridgelabz.learningmanagementsystem.model;

import com.bridgelabz.learningmanagementsystem.dto.MentorDTO;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "mentor_details")
public class MentorModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String employeeId;
    private String firstName;
    private String lastName;
    private String mentorType;
    private String mentorRole;
    private String mobileNumber;
    private String emailId;
    private String yearsOfExperience;
    private String preferredTime;
    private LocalDateTime startDate;
    private String status;
    private String mentorDescription;
    private String creatorUser;
    private String supervisorId;
    private String profilePath;
    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;

    public MentorModel(MentorDTO mentorDTO) {
        this.employeeId = mentorDTO.getEmployeeId();
        this.firstName = mentorDTO.getFirstName();
        this.lastName = mentorDTO.getLastName();
        this.mentorType = mentorDTO.getMentorType();
        this.mentorRole = mentorDTO.getMentorRole();
        this.mobileNumber = mentorDTO.getMobileNumber();
        this.emailId = mentorDTO.getEmailId();
        this.yearsOfExperience = mentorDTO.getYearsOfExperience();
        this.preferredTime = mentorDTO.getPreferredTime();
        this.startDate = mentorDTO.getStartDate();
        this.status = mentorDTO.getStatus();
        this.mentorDescription = mentorDTO.getMentorDescription();
        this.creatorUser = mentorDTO.getCreatorUser();
        this.supervisorId = mentorDTO.getSupervisorId();
    }

    public MentorModel() {
    }
}
