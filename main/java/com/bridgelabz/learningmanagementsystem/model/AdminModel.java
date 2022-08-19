package com.bridgelabz.learningmanagementsystem.model;

import com.bridgelabz.learningmanagementsystem.dto.AdminDTO;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name ="admin_details")
public class AdminModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id ;
    private String firstName;
    private String lastName;
    private Long mobileNumber;
    private String emailId;
    private String password;
    private String profilePath;
    private LocalDateTime creatorStamp;
    private LocalDateTime updatedStamp;

    public AdminModel(AdminDTO adminDTO) {
        this.firstName = adminDTO.getFirstName();
        this.lastName = adminDTO.getLastName();
        this.mobileNumber = adminDTO.getMobileNumber();
        this.emailId = adminDTO.getEmailId();
        this.password = adminDTO.getPassword();
        this.profilePath = adminDTO.getProfilePath();
    }

    public AdminModel() {
    }
}
