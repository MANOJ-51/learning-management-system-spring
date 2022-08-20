package com.bridgelabz.learningmanagementsystem.controller;

import com.bridgelabz.learningmanagementsystem.dto.MentorDTO;
import com.bridgelabz.learningmanagementsystem.model.MentorModel;
import com.bridgelabz.learningmanagementsystem.service.IMentorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/mentorController")
public class MentorController {
    @Autowired
    IMentorService iMentorService;

    @PostMapping("/createMentor")
    public MentorModel createMentor (@RequestHeader String token, @RequestBody @Valid MentorDTO mentorDTO){
        return iMentorService.addMentor(token,mentorDTO);
    }

    @PutMapping ("/updateMentor/{id}")
    public MentorModel updateMentor(@RequestHeader String token ,@PathVariable Long id, @RequestBody @Valid MentorDTO mentorDTO){
        return iMentorService.editMentor(token,id,mentorDTO);
    }

    @GetMapping("/mentorsList")
    public List<MentorModel> getList (@RequestHeader String token){
        return iMentorService.viewList(token);
    }

    @DeleteMapping("/deleteMentor/{id}")
    public MentorModel deleteMentor (@RequestHeader String token,@PathVariable Long id){
        return iMentorService.removeMentor(token,id);
    }

    @PostMapping("addProfilePath/{id}")
    public MentorModel addProfile (@RequestHeader String token,@PathVariable Long id,@RequestParam String profilePath){
        return iMentorService.addPath(token,id,profilePath);
    }

    @GetMapping("/countById")
    public Long getCountById (@RequestHeader String token ){
        return iMentorService.getCountId(token);
    }

    @GetMapping("/getCountByType")
    public Long getCountByType (@RequestHeader String token,@RequestParam String userChoice){
        return iMentorService.getCountByType(token,userChoice);
    }
}
