package com.bridgelabz.learningmanagementsystem.service;

import com.bridgelabz.learningmanagementsystem.dto.TechStackDTO;
import com.bridgelabz.learningmanagementsystem.exception.CustomExceptions;
import com.bridgelabz.learningmanagementsystem.model.AdminModel;
import com.bridgelabz.learningmanagementsystem.model.TechStackModel;
import com.bridgelabz.learningmanagementsystem.repository.IAdminRepository;
import com.bridgelabz.learningmanagementsystem.repository.ITechStackRepository;
import com.bridgelabz.learningmanagementsystem.util.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class TechStackService implements ITechStackService {

    @Autowired
    ITechStackRepository iTechStackRepository;

    @Autowired
    TokenUtil tokenUtil;

    @Autowired
    IAdminRepository iAdminRepository;

    @Override
    public TechStackModel addTech(String token, TechStackDTO techStackDTO) {
        Long adminId = tokenUtil.decodeToken(token);
        Optional<AdminModel> isAdminPresent = iAdminRepository.findById(adminId);
        if (isAdminPresent.isPresent()) {
            TechStackModel techStackModel = new TechStackModel(techStackDTO);
            techStackModel.setCreatedDate(LocalDateTime.now());
            techStackModel.setCreatorUser(isAdminPresent.get());
            iTechStackRepository.save(techStackModel);
            return techStackModel;
        }
        throw new CustomExceptions(400,"Invalid Token");
    }

    @Override
    public TechStackModel editTech(String token, Long id, TechStackDTO techStackDTO) {
        Long adminId = tokenUtil.decodeToken(token);
        Optional<AdminModel> isAdminPresent = iAdminRepository.findById(adminId);
        if (isAdminPresent.isPresent()) {
            Optional<TechStackModel> isTechPresent = iTechStackRepository.findById(id);
            if (isTechPresent.isPresent()){
                isTechPresent.get().setTechName(techStackDTO.getTechName());
                isTechPresent.get().setStatus(techStackDTO.getStatus());
                isTechPresent.get().setUpdatedDate(LocalDateTime.now());
                iTechStackRepository.save(isTechPresent.get());
                return isTechPresent.get();
            }
        }
        throw new CustomExceptions(400,"Invalid Token");
    }

    @Override
    public List<TechStackModel> viewList(String token) {
        Long adminId = tokenUtil.decodeToken(token);
        Optional<AdminModel> isAdminPresent = iAdminRepository.findById(adminId);
        if (isAdminPresent.isPresent()) {
            List<TechStackModel> isTechPresent = iTechStackRepository.findAll();
            if (isTechPresent.size()>0){
                return isTechPresent;
            }
        }
        throw new CustomExceptions(400,"Invalid Token");
    }

    @Override
    public TechStackModel removeTech(String token, Long id) {
        Long adminId = tokenUtil.decodeToken(token);
        Optional<AdminModel> isAdminPresent = iAdminRepository.findById(adminId);
        if (isAdminPresent.isPresent()) {
            Optional<TechStackModel> isTechPresent = iTechStackRepository.findById(id);
            if (isTechPresent.isPresent()){
                iTechStackRepository.delete(isTechPresent.get());
                return isTechPresent.get();
            }
        }
        throw new CustomExceptions(400,"Invalid Token");
    }

    @Override
    public TechStackModel addPath(String token, Long techId, String path) {
        Long adminId = tokenUtil.decodeToken(token);
        Optional<AdminModel> isAdminPresent = iAdminRepository.findById(adminId);
        if (isAdminPresent.isPresent()) {
            Optional<TechStackModel> isTechPresent = iTechStackRepository.findById(techId);
            if (isTechPresent.isPresent()){
                isTechPresent.get().setImagePath(path);
                iTechStackRepository.save(isTechPresent.get());
                return isTechPresent.get();
            }
        }
        throw new CustomExceptions(400,"Invalid Token");
    }
}
