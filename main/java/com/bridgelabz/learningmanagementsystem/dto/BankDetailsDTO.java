package com.bridgelabz.learningmanagementsystem.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class BankDetailsDTO {
    @NotNull(message = "Account Number Should Not be Null")
    private String accountNumber;
    @NotNull(message = "Ifsc Code Should Not be Null")
    private String ifscCode;
    @NotNull(message = "Mobile Number Should Not be Null")
    private Long mobileNumber;
    @NotNull(message = "Branch Should Not be Null")
    private String branch;
    @NotNull(message = "Account Holder Name Should Not be Null")
    private String accountHolderName;
}
