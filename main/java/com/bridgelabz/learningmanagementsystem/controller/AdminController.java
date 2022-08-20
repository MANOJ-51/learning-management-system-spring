package com.bridgelabz.learningmanagementsystem.controller;

import com.bridgelabz.learningmanagementsystem.dto.AdminDTO;
import com.bridgelabz.learningmanagementsystem.model.AdminModel;
import com.bridgelabz.learningmanagementsystem.service.IAdminService;
import com.bridgelabz.learningmanagementsystem.util.ResponseClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/adminAPIS")
public class AdminController {
    @Autowired
    IAdminService iAdminService;

    //create admin
    @PostMapping("/createAdmin")
    public AdminModel createModel (@RequestBody @Valid AdminDTO adminDTO){
        return iAdminService.createAdmin(adminDTO);
    }

    //Update admin
    @PutMapping("/updateAdmin/{id}")
    public AdminModel updateAdmin (@RequestHeader String token,@PathVariable Long id,@RequestBody @Valid AdminDTO adminDTO){
        return iAdminService.editAdmin(id,adminDTO,token);
    }

    //getList
    @GetMapping("/adminList")
    public List<AdminModel> getList (@RequestHeader String token){
        return iAdminService.viewList(token);
    }

    //delete admin
    @DeleteMapping("/deleteAdmin/{id}")
    public AdminModel deleteAdmin(@RequestHeader String token,@PathVariable Long id){
        return iAdminService.removeAdmin(id,token);
    }

    //Login token
    @PostMapping("/loginToken")
    public ResponseClass login(@RequestParam String emailId ,@RequestParam String password){
        return iAdminService.loginToken(emailId,password);
    }

    //Reset password
    @PostMapping("/resetAdminPassword")
    public ResponseClass resetPassword(@RequestParam String email){
        return iAdminService.resetAdminPassword(email);
    }

    //change admin Password
    @PutMapping("/changeAdminPassword")
    public AdminModel changePassword(@RequestHeader String token , @RequestParam String newPassword){
        return iAdminService.changePassword(token,newPassword);
    }

    @PutMapping("/addProfilePath")
    public AdminModel addProfilePath(@RequestHeader String token,@RequestParam String profilePath){
        return iAdminService.setProfilePath(token,profilePath);
    }
}
