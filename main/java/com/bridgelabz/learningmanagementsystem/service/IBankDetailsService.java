package com.bridgelabz.learningmanagementsystem.service;

import com.bridgelabz.learningmanagementsystem.dto.BankDetailsDTO;
import com.bridgelabz.learningmanagementsystem.model.BankDetailsModel;

import java.util.List;

/**
 * Purpose:Creating Interface for bankDetails service
 * @author Manoj
 * @Param  all service Methods
 * Version 1.0
 */
public interface IBankDetailsService {
    BankDetailsModel addBankDetails(String token, BankDetailsDTO bankDetailsModel);

    BankDetailsModel editBank(String token, Long id, BankDetailsDTO bankDetailsDTO);

    List<BankDetailsModel> viewList(String token);

    BankDetailsModel removeBank(String token, Long id);
}
