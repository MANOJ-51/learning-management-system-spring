package com.bridgelabz.learningmanagementsystem.service;

import com.bridgelabz.learningmanagementsystem.dto.AdminDTO;
import com.bridgelabz.learningmanagementsystem.model.AdminModel;
import com.bridgelabz.learningmanagementsystem.util.ResponseClass;

import java.util.List;

public interface IAdminService {
     AdminModel editAdmin(Long id, AdminDTO adminDTO, String token);
    AdminModel createAdmin(AdminDTO adminDTO);

    List<AdminModel> viewList(String token);

    AdminModel removeAdmin(Long id, String token);

    ResponseClass loginToken(String emailId, String password);

    ResponseClass resetAdminPassword(String email);

    AdminModel changePassword(String token, String newPassword);

    AdminModel setProfilePath(String token, String profilePath);
}
