package com.bridgelabz.learningmanagementsystem.model;

import com.bridgelabz.learningmanagementsystem.dto.BankDetailsDTO;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * Purpose:Creating model for BankDetails
 * @author Manoj
 * @Param all the required variables to save in repository
 * Version 1.0
 */
@Entity
@Data
@Table(name = "bank_details")
public class BankDetailsModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;
    private String accountNumber;
    private String ifscCode;
    private Long mobileNumber;
    private String branch;
    private String accountHolderName;
    @OneToOne
    private AdminModel creatorUser;
    @OneToOne
    private AdminModel updateUser;
    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;

    public BankDetailsModel(BankDetailsDTO bankDetailsDTO) {
        this.accountHolderName = bankDetailsDTO.getAccountHolderName();
        this.accountNumber = bankDetailsDTO.getAccountNumber();
        this.branch = bankDetailsDTO.getBranch();
        this.ifscCode = bankDetailsDTO.getIfscCode();
        this.mobileNumber = bankDetailsDTO.getMobileNumber();
    }

    public BankDetailsModel() {
    }
}
