package com.bridgelabz.learningmanagementsystem.service;

import com.bridgelabz.learningmanagementsystem.dto.BankDetailsDTO;
import com.bridgelabz.learningmanagementsystem.exception.CustomExceptions;
import com.bridgelabz.learningmanagementsystem.model.AdminModel;
import com.bridgelabz.learningmanagementsystem.model.BankDetailsModel;
import com.bridgelabz.learningmanagementsystem.repository.IAdminRepository;
import com.bridgelabz.learningmanagementsystem.repository.IBankDetailsRepository;
import com.bridgelabz.learningmanagementsystem.util.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class BankDetailsService implements IBankDetailsService{
    @Autowired
    IBankDetailsRepository iBankDetailsRepository;

    @Autowired
    TokenUtil tokenUtil;

    @Autowired
    IAdminRepository iAdminRepository;

    @Override
    public BankDetailsModel addBankDetails(String token,BankDetailsDTO bankDetailsDTO) {
        Long adminId = tokenUtil.decodeToken(token);
        Optional<AdminModel> isAdminPresent = iAdminRepository.findById(adminId);
        if (isAdminPresent.isPresent()) {
            BankDetailsModel bankDetailsModel = new BankDetailsModel(bankDetailsDTO);
            bankDetailsModel.setCreatorUser(isAdminPresent.get());
            bankDetailsModel.setCreatedDate(LocalDateTime.now());
            iBankDetailsRepository.save(bankDetailsModel);
            return bankDetailsModel;
        }
        throw new CustomExceptions(400,"Invalid Token");
    }

    @Override
    public BankDetailsModel editBank(String token, Long id, BankDetailsDTO bankDetailsDTO) {
        Long adminId = tokenUtil.decodeToken(token);
        Optional<AdminModel> isAdminPresent = iAdminRepository.findById(adminId);
        if (isAdminPresent.isPresent()) {
            Optional<BankDetailsModel> isBankPresent = iBankDetailsRepository.findById(id);
            if (isBankPresent.isPresent()){
                isBankPresent.get().setAccountHolderName(bankDetailsDTO.getAccountHolderName());
                isBankPresent.get().setAccountNumber(bankDetailsDTO.getAccountNumber());
                isBankPresent.get().setIfscCode(bankDetailsDTO.getIfscCode());
                isBankPresent.get().setBranch(bankDetailsDTO.getBranch());
                isBankPresent.get().setMobileNumber(bankDetailsDTO.getMobileNumber());
                isBankPresent.get().setUpdateUser(isAdminPresent.get());
                iBankDetailsRepository.save(isBankPresent.get());
                return isBankPresent.get();
            }
        }
        throw new CustomExceptions(400,"Invalid Token");
    }

    @Override
    public List<BankDetailsModel> viewList(String token) {
        Long adminId = tokenUtil.decodeToken(token);
        Optional<AdminModel> isAdminPresent = iAdminRepository.findById(adminId);
        if (isAdminPresent.isPresent()) {
            List<BankDetailsModel> getList = iBankDetailsRepository.findAll();
            if (getList.size()>0){
                return getList;
            }
        }
        throw new CustomExceptions(400,"Invalid Token");
    }

    @Override
    public BankDetailsModel removeBank(String token, Long id) {
        Long adminId = tokenUtil.decodeToken(token);
        Optional<AdminModel> isAdminPresent = iAdminRepository.findById(adminId);
        if (isAdminPresent.isPresent()) {
            Optional<BankDetailsModel> isBankPresent = iBankDetailsRepository.findById(id);
            if (isBankPresent.isPresent()){
                iBankDetailsRepository.delete(isBankPresent.get());
                return isBankPresent.get();
            }
        }
        throw new CustomExceptions(400,"Invalid Token");
    }
}
