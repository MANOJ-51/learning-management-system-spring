package com.bridgelabz.learningmanagementsystem.service;

import com.bridgelabz.learningmanagementsystem.dto.CandidateDTO;
import com.bridgelabz.learningmanagementsystem.exception.CustomExceptions;
import com.bridgelabz.learningmanagementsystem.model.AdminModel;
import com.bridgelabz.learningmanagementsystem.model.CandidateModel;
import com.bridgelabz.learningmanagementsystem.model.TechStackModel;
import com.bridgelabz.learningmanagementsystem.repository.IAdminRepository;
import com.bridgelabz.learningmanagementsystem.repository.ICandidateRepository;
import com.bridgelabz.learningmanagementsystem.repository.ITechStackRepository;
import com.bridgelabz.learningmanagementsystem.util.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class CandidateService implements ICandidateService {
    @Autowired
    ICandidateRepository iCandidateRepository;
    @Autowired
    TokenUtil tokenUtil;
    @Autowired
    IAdminRepository iAdminRepository;

    @Autowired
    ITechStackRepository iTechStackRepository;

    @Override
    public CandidateModel addCandidate(String token, Long techId, CandidateDTO candidateDTO) {
        Long adminId = tokenUtil.decodeToken(token);
        Optional<AdminModel> isAdminPresent = iAdminRepository.findById(adminId);
        if (isAdminPresent.isPresent()){
            CandidateModel candidateModel = new CandidateModel(candidateDTO);
            candidateModel.setCreatedStamp(LocalDateTime.now());
            Optional<TechStackModel> isTechPresent = iTechStackRepository.findById(techId);
            candidateModel.setTechStackModel(isTechPresent.get());
            iCandidateRepository.save(candidateModel);
            return candidateModel;
        }
        throw new CustomExceptions(400,"Invalid Token");
    }

    @Override
    public CandidateModel editCandidate(String token, Long id, Long techId, CandidateDTO candidateDTO) {
        Long adminId = tokenUtil.decodeToken(token);
        Optional<AdminModel> isAdminPresent = iAdminRepository.findById(adminId);
        if (isAdminPresent.isPresent()){
            Optional<CandidateModel> isIdPresent = iCandidateRepository.findById(id);
            if (isIdPresent.isPresent()){
                isIdPresent.get().setCicId(candidateDTO.getCicId());
                isIdPresent.get().setFullName(candidateDTO.getFullName());
                isIdPresent.get().setEmail(candidateDTO.getEmail());
                isIdPresent.get().setMobileNumber(candidateDTO.getMobileNumber());
                isIdPresent.get().setHireDate(candidateDTO.getHireDate());
                isIdPresent.get().setDegree(candidateDTO.getDegree());
                isIdPresent.get().setAggregatePercentage(candidateDTO.getAggregatePercentage());
                isIdPresent.get().setCity(candidateDTO.getCity());
                isIdPresent.get().setState(candidateDTO.getState());
                isIdPresent.get().setPreferredJobLocation(candidateDTO.getPreferredJobLocation());
                isIdPresent.get().setStatus(candidateDTO.getStatus());
                isIdPresent.get().setPassedOutYear(candidateDTO.getPassedOutYear());
                isIdPresent.get().setCreatorUser(candidateDTO.getCreatorUser());
                isIdPresent.get().setCandidateStatus(candidateDTO.getCandidateStatus());
                isIdPresent.get().setUpdatedStamp(LocalDateTime.now());
                isIdPresent.get().setTechStackModel(iTechStackRepository.getReferenceById(techId));
                iCandidateRepository.save(isIdPresent.get());
                return isIdPresent.get();
            }
        }
        throw new CustomExceptions(400,"Invalid Token");
    }

    @Override
    public List<CandidateModel> viewList(String token) {
        Long adminId = tokenUtil.decodeToken(token);
        Optional<AdminModel> isAdminPresent = iAdminRepository.findById(adminId);
        if (isAdminPresent.isPresent()){
            List<CandidateModel> getList = iCandidateRepository.findAll();
            if (getList.size()>0){
                return getList;
            }
        }
        throw new CustomExceptions(400,"Invalid Token");
    }

    @Override
    public CandidateModel removeCandidate(String token, Long id) {
        Long adminId = tokenUtil.decodeToken(token);
        Optional<AdminModel> isAdminPresent = iAdminRepository.findById(adminId);
        if (isAdminPresent.isPresent()){
            Optional<CandidateModel> isIdPresent = iCandidateRepository.findById(id);
            if (isIdPresent.isPresent()){
                iCandidateRepository.delete(isIdPresent.get());
                return isIdPresent.get();
            }
        }
        throw new CustomExceptions(400,"Invalid Token");
    }

    @Override
    public Long getCount(String userChoice, String token) {
        Long adminId = tokenUtil.decodeToken(token);
        Optional<AdminModel> isAdminPresent = iAdminRepository.findById(adminId);
        if (isAdminPresent.isPresent()) {
            return iCandidateRepository.statusCount(userChoice);
        }
        throw new CustomExceptions(400,"Invalid Token");
    }

}
