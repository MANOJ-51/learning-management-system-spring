package com.bridgelabz.learningmanagementsystem.controller;

import com.bridgelabz.learningmanagementsystem.dto.TechStackDTO;
import com.bridgelabz.learningmanagementsystem.model.TechStackModel;
import com.bridgelabz.learningmanagementsystem.service.ITechStackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/techStackControllerApis")
public class TechStackController {

    @Autowired
    ITechStackService iTechStackService;

    @PostMapping("/createTechStack")
    public TechStackModel createTechStack (@RequestHeader String token, @RequestBody @Valid TechStackDTO techStackDTO){
        return iTechStackService.addTech(token,techStackDTO);
    }

    @PutMapping("/updateTechStack/{id}")
    public TechStackModel updateTech (@RequestHeader String token,@PathVariable Long id ,
                                      @RequestBody @Valid TechStackDTO techStackDTO){
        return iTechStackService.editTech(token,id,techStackDTO);
    }

    @GetMapping("/getTechList")
    public List<TechStackModel> getList (@RequestHeader String token){
        return iTechStackService.viewList (token);
    }

    @DeleteMapping("/deleteTech/{id}")
    public TechStackModel deleteTech (@RequestHeader String token ,@PathVariable Long id){
        return iTechStackService.removeTech(token,id);
    }

    @PostMapping("addProfilePath")
    public TechStackModel setPath (@RequestHeader String token , @RequestParam Long techId ,@RequestParam String path){
        return iTechStackService.addPath(token,techId,path);
    }

}
