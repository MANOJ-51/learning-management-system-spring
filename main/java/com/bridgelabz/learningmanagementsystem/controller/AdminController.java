package com.bridgelabz.learningmanagementsystem.controller;

import com.bridgelabz.learningmanagementsystem.dto.AdminDTO;
import com.bridgelabz.learningmanagementsystem.model.AdminModel;
import com.bridgelabz.learningmanagementsystem.service.IAdminService;
import com.bridgelabz.learningmanagementsystem.util.ResponseClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Purpose:Creating apis for Admin Controller
 * @author Manoj
 * @Param Http METHODS
 * Version 1.0
 */
@RestController
@RequestMapping("/adminAPIS")
public class AdminController {
    @Autowired
    IAdminService iAdminService;

    /**
     * Purpose:Creating method to add admin
     * @author Manoj
     * @Param AdminDto
     */
    @PostMapping("/createAdmin")
    public AdminModel createModel (@RequestBody @Valid AdminDTO adminDTO){
        return iAdminService.createAdmin(adminDTO);
    }

    /**
     * Purpose:Creating method to Update Admin
     * @author Manoj
     * @Param AdminDto ,id ,token
     */
    @PutMapping("/updateAdmin/{id}")
    public AdminModel updateAdmin (@RequestHeader String token,@PathVariable Long id,@RequestBody @Valid AdminDTO adminDTO){
        return iAdminService.editAdmin(id,adminDTO,token);
    }

    /**
     * Purpose:Creating method to get List of Admin
     * @author Manoj
     * @Param  token
     */
    @GetMapping("/adminList")
    public List<AdminModel> getList (@RequestHeader String token){
        return iAdminService.viewList(token);
    }

    /**
     * Purpose:Creating method to Delete Admin
     * @author Manoj
     * @Param  token,id
     */
    @DeleteMapping("/deleteAdmin/{id}")
    public AdminModel deleteAdmin(@RequestHeader String token,@PathVariable Long id){
        return iAdminService.removeAdmin(id,token);
    }

    /**
     * Purpose:Creating method Login to  Admin using unique id called token
     * @author Manoj
     * @Param  email,password
     */
    @PostMapping("/loginToken")
    public ResponseClass login(@RequestParam String emailId ,@RequestParam String password){
        return iAdminService.loginToken(emailId,password);
    }

    /**
     * Purpose:Creating method Reset password of Admin
     * @author Manoj
     * @Param  email
     */
    @PostMapping("/resetAdminPassword")
    public ResponseClass resetPassword(@RequestParam String email){
        return iAdminService.resetAdminPassword(email);
    }

    /**
     * Purpose:Creating method change password of Admin
     * @author Manoj
     * @Param  token,newPassword
     */
    @PutMapping("/changeAdminPassword")
    public AdminModel changePassword(@RequestHeader String token , @RequestParam String newPassword){
        return iAdminService.changePassword(token,newPassword);
    }

    /**
     * Purpose:Creating method to add profile path to Admin
     * @author Manoj
     * @Param  token,profilePath
     */
    @PutMapping("/addProfilePath")
    public AdminModel addProfilePath(@RequestHeader String token,@RequestParam String profilePath){
        return iAdminService.setProfilePath(token,profilePath);
    }
}
