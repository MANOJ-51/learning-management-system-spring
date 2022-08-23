package com.bridgelabz.learningmanagementsystem.controller;

import com.bridgelabz.learningmanagementsystem.dto.MentorDTO;
import com.bridgelabz.learningmanagementsystem.model.MentorModel;
import com.bridgelabz.learningmanagementsystem.service.IMentorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Purpose:Creating apis for mentor Controller
 * @author Manoj
 * @Param Http METHODS
 * Version 1.0
 */
@RestController
@RequestMapping("/mentorController")
public class MentorController {
    @Autowired
    IMentorService iMentorService;
    /**
     * Purpose:Creating method to add mentor
     * @author Manoj
     * @Param mentorDto,token
     */
    @PostMapping("/createMentor")
    public MentorModel createMentor (@RequestHeader String token, @RequestBody @Valid MentorDTO mentorDTO){
        return iMentorService.addMentor(token,mentorDTO);
    }

    /**
     * Purpose:Creating method to Update mentor
     * @author Manoj
     * @Param MentorDto ,id ,token
     */
    @PutMapping ("/updateMentor/{id}")
    public MentorModel updateMentor(@RequestHeader String token ,@PathVariable Long id, @RequestBody @Valid MentorDTO mentorDTO){
        return iMentorService.editMentor(token,id,mentorDTO);
    }

    /**
     * Purpose:Creating method to get List of mentor
     * @author Manoj
     * @Param  token
     */
    @GetMapping("/mentorsList")
    public List<MentorModel> getList (@RequestHeader String token){
        return iMentorService.viewList(token);
    }

    /**
     * Purpose:Creating method to Delete mentor
     * @author Manoj
     * @Param  token,id
     */
    @DeleteMapping("/deleteMentor/{id}")
    public MentorModel deleteMentor (@RequestHeader String token,@PathVariable Long id){
        return iMentorService.removeMentor(token,id);
    }

    /**
     * Purpose:Creating method to add profile path to mentor
     * @author Manoj
     * @Param  token,profilePath,id
     */
    @PostMapping("addProfilePath/{id}")
    public MentorModel addProfile (@RequestHeader String token,@PathVariable Long id,@RequestParam String profilePath){
        return iMentorService.addPath(token,id,profilePath);
    }

    /**
     * Purpose:Creating method to get list by id of mentor
     * @author Manoj
     * @Param  token,id
     */
    @GetMapping("/listById/{id}")
    public MentorModel getListById (@RequestHeader String token,@PathVariable Long id ){
        return iMentorService.getListId(token,id);
    }

    /**
     * Purpose:Creating method to get count of mentorType
     * @author Manoj
     * @Param  token,userChoice
     */
    @GetMapping("/getCountByType")
    public Long getCountByType (@RequestHeader String token,@RequestParam String userChoice){
        return iMentorService.getCountByType(token,userChoice);
    }
}
