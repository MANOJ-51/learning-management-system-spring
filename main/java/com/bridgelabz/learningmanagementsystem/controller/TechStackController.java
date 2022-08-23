package com.bridgelabz.learningmanagementsystem.controller;

import com.bridgelabz.learningmanagementsystem.dto.TechStackDTO;
import com.bridgelabz.learningmanagementsystem.model.TechStackModel;
import com.bridgelabz.learningmanagementsystem.service.ITechStackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Purpose:Creating apis for techStack Controller
 * @author Manoj
 * @Param Http METHODS
 * Version 1.0
 */
@RestController
@RequestMapping("/techStackControllerApis")
public class TechStackController {

    @Autowired
    ITechStackService iTechStackService;

    /**
     * Purpose:Creating method to add tech
     * @author Manoj
     * @Param techStackDto,token
     */
    @PostMapping("/createTechStack")
    public TechStackModel createTechStack (@RequestHeader String token, @RequestBody @Valid TechStackDTO techStackDTO){
        return iTechStackService.addTech(token,techStackDTO);
    }

    /**
     * Purpose:Creating method to Update tech
     * @author Manoj
     * @Param techStackDto ,id ,token
     */
    @PutMapping("/updateTechStack/{id}")
    public TechStackModel updateTech (@RequestHeader String token,@PathVariable Long id ,
                                      @RequestBody @Valid TechStackDTO techStackDTO){
        return iTechStackService.editTech(token,id,techStackDTO);
    }

    /**
     * Purpose:Creating method to get List of techStack
     * @author Manoj
     * @Param  token
     */
    @GetMapping("/getTechList")
    public List<TechStackModel> getList (@RequestHeader String token){
        return iTechStackService.viewList (token);
    }

    /**
     * Purpose:Creating method to Delete techStack
     * @author Manoj
     * @Param  token,id
     */
    @DeleteMapping("/deleteTech/{id}")
    public TechStackModel deleteTech (@RequestHeader String token ,@PathVariable Long id){
        return iTechStackService.removeTech(token,id);
    }

    /**
     * Purpose:Creating method to add profile path to techStack
     * @author Manoj
     * @Param  token,profilePath,techID
     */
    @PostMapping("addProfilePath")
    public TechStackModel setPath (@RequestHeader String token , @RequestParam Long techId ,@RequestParam String path){
        return iTechStackService.addPath(token,techId,path);
    }

}
