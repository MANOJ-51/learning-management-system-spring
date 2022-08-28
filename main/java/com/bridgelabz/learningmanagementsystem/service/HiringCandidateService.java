package com.bridgelabz.learningmanagementsystem.service;

import com.bridgelabz.learningmanagementsystem.dto.HiringCandidateDTO;
import com.bridgelabz.learningmanagementsystem.exception.CustomExceptions;
import com.bridgelabz.learningmanagementsystem.model.AdminModel;
import com.bridgelabz.learningmanagementsystem.model.BankDetailsModel;
import com.bridgelabz.learningmanagementsystem.model.HiringCandidateModel;
import com.bridgelabz.learningmanagementsystem.repository.IAdminRepository;
import com.bridgelabz.learningmanagementsystem.repository.IBankDetailsRepository;
import com.bridgelabz.learningmanagementsystem.repository.IHiringCandidateRepository;
import com.bridgelabz.learningmanagementsystem.util.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

/**
 * Purpose:Creating Service for HiringCandidate
 * @author Manoj
 * @Param business logic is present here
 * Version 1.0
 */
@Service
public class HiringCandidateService implements IHiringCandidateService{
    @Autowired
    IHiringCandidateRepository iHiringCandidateRepository;
    @Autowired
    TokenUtil tokenUtil;
    @Autowired
    IAdminRepository iAdminRepository;

    @Autowired
    IBankDetailsRepository iBankDetailsRepository;

    /**
     * Purpose:Creating method to add hiring candidate
     * @author Manoj
     * @Param hiringCandidateDto,token,bankID,
     */
    @Override
    public HiringCandidateModel addHiringCandidate(String token, Long bankId, HiringCandidateDTO hiringCandidateDTO) {
        Long adminId = tokenUtil.decodeToken(token);
        Optional<AdminModel> isAdminPresent = iAdminRepository.findById(adminId);
        if (isAdminPresent.isPresent()){
            HiringCandidateModel hiringCandidateModel = new HiringCandidateModel(hiringCandidateDTO);
            hiringCandidateModel.setCreatedStamp(LocalDateTime.now());
            Optional<BankDetailsModel> isBankPresent = iBankDetailsRepository.findById(bankId);
            hiringCandidateModel.setBankDetailsModel(isBankPresent.get());
            iHiringCandidateRepository.save(hiringCandidateModel);
            return hiringCandidateModel;
        }
        throw new CustomExceptions(400,"Invalid Token");
    }

    /**
     * Purpose:Creating method to Update Hiring candidate
     * @author Manoj
     * @Param HiringCandidateDto ,id ,token,bankID
     */
    @Override
    public HiringCandidateModel editHiringCandidate(String token, Long id, Long bankId, HiringCandidateDTO hiringCandidateDTO) {
        Long adminId = tokenUtil.decodeToken(token);
        Optional<AdminModel> isAdminPresent = iAdminRepository.findById(adminId);
        if (isAdminPresent.isPresent()){
            Optional<HiringCandidateModel> isIdPresent = iHiringCandidateRepository.findById(id);
            if (isIdPresent.isPresent()){
                isIdPresent.get().setCicId(hiringCandidateDTO.getCicId());
                isIdPresent.get().setFullName(hiringCandidateDTO.getFullName());
                isIdPresent.get().setEmail(hiringCandidateDTO.getEmail());
                isIdPresent.get().setMobileNumber(hiringCandidateDTO.getMobileNumber());
                isIdPresent.get().setHireDate(hiringCandidateDTO.getHireDate());
                isIdPresent.get().setDegree(hiringCandidateDTO.getDegree());
                isIdPresent.get().setAggregatePercentage(hiringCandidateDTO.getAggregatePercentage());
                isIdPresent.get().setCity(hiringCandidateDTO.getCity());
                isIdPresent.get().setState(hiringCandidateDTO.getState());
                isIdPresent.get().setJobLocation(hiringCandidateDTO.getJobLocation());
                isIdPresent.get().setStatus(hiringCandidateDTO.getStatus());
                isIdPresent.get().setPassedOutYear(hiringCandidateDTO.getPassedOutYear());
                isIdPresent.get().setCreatorUser(hiringCandidateDTO.getCreatorUser());
                isIdPresent.get().setCandidateStatus(hiringCandidateDTO.getCandidateStatus());
                isIdPresent.get().setUpdatedStamp(LocalDateTime.now());
                Optional<BankDetailsModel> isBankPresent = iBankDetailsRepository.findById(bankId);
                isIdPresent.get().setBankDetailsModel(isBankPresent.get());
                iHiringCandidateRepository.save(isIdPresent.get());
                return isIdPresent.get();
            }
        }
        throw new CustomExceptions(400,"Invalid Token");
    }

    /**
     * Purpose:Creating method to get List of Hiring candidate
     * @author Manoj
     * @Param  token
     */
    @Override
    public List<HiringCandidateModel> viewList(String token) {
        Long adminId = tokenUtil.decodeToken(token);
        Optional<AdminModel> isAdminPresent = iAdminRepository.findById(adminId);
        if (isAdminPresent.isPresent()){
            List<HiringCandidateModel> getList = iHiringCandidateRepository.findAll();
            if (getList.size()>0){
                return getList;
            }
        }
        throw new CustomExceptions(400,"Invalid Token");
    }

    /**
     * Purpose:Creating method to Delete Hiring Candidate
     * @author Manoj
     * @Param  token,id
     */
    @Override
    public HiringCandidateModel removeHiringCandidate(String token, Long id) {
        Long adminId = tokenUtil.decodeToken(token);
        Optional<AdminModel> isAdminPresent = iAdminRepository.findById(adminId);
        if (isAdminPresent.isPresent()){
            Optional<HiringCandidateModel> isIdPresent = iHiringCandidateRepository.findById(id);
            if (isIdPresent.isPresent()){
                iHiringCandidateRepository.delete(isIdPresent.get());
                return isIdPresent.get();
            }
        }
        throw new CustomExceptions(400,"Invalid Token");
    }
}
