package com.bridgelabz.learningmanagementsystem.service;

import com.bridgelabz.learningmanagementsystem.dto.AdminDTO;
import com.bridgelabz.learningmanagementsystem.dto.temp.ChangePasswordDTO;
import com.bridgelabz.learningmanagementsystem.exception.CustomExceptions;
import com.bridgelabz.learningmanagementsystem.model.AdminModel;
import com.bridgelabz.learningmanagementsystem.repository.IAdminRepository;
import com.bridgelabz.learningmanagementsystem.util.ResponseClass;
import com.bridgelabz.learningmanagementsystem.util.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class AdminService implements IAdminService{

    @Autowired
    IAdminRepository iAdminRepository;

    @Autowired
    TokenUtil tokenUtil;

    @Autowired
    MailService mailService;

    @Override
    public AdminModel editAdmin(Long id, AdminDTO adminDTO, String token) {
        Long adminId = tokenUtil.decodeToken(token);
        Optional<AdminModel> isAdminIdPresent = iAdminRepository.findById(adminId);
        if (isAdminIdPresent.isPresent()) {
            Optional<AdminModel> isAdminPresent = iAdminRepository.findById(id);
            if (isAdminPresent.isPresent()) {
                isAdminPresent.get().setFirstName(adminDTO.getFirstName());
                isAdminPresent.get().setLastName(adminDTO.getLastName());
                isAdminPresent.get().setMobileNumber(adminDTO.getMobileNumber());
                isAdminPresent.get().setEmailId(adminDTO.getEmailId());
                isAdminPresent.get().setPassword(adminDTO.getPassword());
                isAdminPresent.get().setProfilePath(adminDTO.getProfilePath());
                isAdminPresent.get().setUpdatedStamp(LocalDateTime.now());
                iAdminRepository.save(isAdminPresent.get());
                String body = "Admin Update Is Successful with id :-"+isAdminPresent.get().getId()+"\n"+isAdminPresent.get();
                String subject = "Admin update Success";
                mailService.send(adminDTO.getEmailId(), body,subject);
                return isAdminPresent.get();
            }
        }
        throw new CustomExceptions(400,"Admin Not Found");
    }

    @Override
    public AdminModel createAdmin(AdminDTO adminDTO) {
        AdminModel adminModel = new AdminModel(adminDTO);
        adminModel.setCreatorStamp(LocalDateTime.now());
        iAdminRepository.save(adminModel);
        String body = "Admin Registration Is Successful with id :-"+adminDTO.getId()+"\n"+adminDTO;
        String subject = "Admin Registration Success";
        mailService.send(adminDTO.getEmailId(), body,subject);
        return adminModel;
    }

    @Override
    public List<AdminModel> viewList(String token) {
        Long adminId = tokenUtil.decodeToken(token);
        Optional<AdminModel> isAdmin = iAdminRepository.findById(adminId);
        if (isAdmin.isPresent()) {
            List<AdminModel> isList = iAdminRepository.findAll();
            if (isList.size() > 0) {
                return isList;
            }
        }
        throw new CustomExceptions(400,"No Data Found");
    }

    @Override
    public AdminModel removeAdmin(Long id, String token) {
        Long adminId = tokenUtil.decodeToken(token);
        Optional<AdminModel> isAdminIdPresent = iAdminRepository.findById(adminId);
        if (isAdminIdPresent.isPresent()) {
            Optional<AdminModel> isAdminPresent = iAdminRepository.findById(id);
            if (isAdminPresent.isPresent()) {
                iAdminRepository.delete(isAdminPresent.get());
                String body = "Admin Deletion Is Successful with id :-"+isAdminPresent.get().getId()+"\n"+isAdminPresent.get();
                String subject = "Admin Deletion Success";
                mailService.send(isAdminPresent.get().getEmailId(), body,subject);
                return isAdminPresent.get();
            }
        }
        throw new CustomExceptions(400,"No Admin Found");
    }

    @Override
    public ResponseClass loginToken(String emailId, String password) {
        Optional<AdminModel> isEmailPresent = iAdminRepository.findByEmailId(emailId);
        if (isEmailPresent.isPresent()){
            if (isEmailPresent.get().getPassword().equals(password)) {
                String token = tokenUtil.createToken(isEmailPresent.get().getId());
                return new ResponseClass(200,"Login Success",token);
            }else {
                throw new CustomExceptions(400,"Password is Wrong");
            }
        }
        throw new CustomExceptions(400,"No Details Matched");
    }

    @Override
    public ResponseClass resetAdminPassword(String email) {
        Optional<AdminModel> isEmailPresent = iAdminRepository.findByEmailId(email);
        if (isEmailPresent.isPresent()){
            String token = tokenUtil.createToken(isEmailPresent.get().getId());
            String url = "http:localhost:8080/adminAPIS/changeAdminPassword"+token;
            String subject = "Admin reset Success";
            mailService.send(isEmailPresent.get().getEmailId(),url,subject);
        }
        throw new CustomExceptions(400,"Invalid Email");
    }

    @Override
    public AdminModel changePassword(String token, ChangePasswordDTO changePasswordDTO) {
        Long adminId = tokenUtil.decodeToken(token);
        Optional<AdminModel> isAdminIdPresent = iAdminRepository.findById(adminId);
        if (isAdminIdPresent.isPresent()){
            isAdminIdPresent.get().setPassword(changePasswordDTO.getNewPassword());
            iAdminRepository.save(isAdminIdPresent.get());
            String body = "Admin Change Password Is Successful with id :-"+isAdminIdPresent.get().getId()+"\n"+isAdminIdPresent.get();
            String subject = "Admin Change Password Success";
            mailService.send(isAdminIdPresent.get().getEmailId(), body,subject);
            return isAdminIdPresent.get();
        }
        throw new CustomExceptions(400,"Invalid Token");
    }
}
