package com.bridgelabz.learningmanagementsystem.controller;

import com.bridgelabz.learningmanagementsystem.dto.CandidateDTO;
import com.bridgelabz.learningmanagementsystem.model.CandidateModel;
import com.bridgelabz.learningmanagementsystem.service.ICandidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/candidateApis")
public class CandidateController {
    @Autowired
    ICandidateService iCandidateService;

    //create candidate
    @PostMapping("/createCandidate")
    public CandidateModel createCandidate(@RequestHeader String token,@RequestParam Long techId,
                                          @RequestBody @Valid CandidateDTO candidateDTO){
        return iCandidateService.addCandidate(token,techId,candidateDTO);
    }

    //update candidate
    @PutMapping("/updateCandidate/{id}")
    public CandidateModel updateCandidate(@RequestHeader String token,@PathVariable Long id ,@RequestParam Long techId,
                                          @RequestBody @Valid CandidateDTO candidateDTO){
        return iCandidateService.editCandidate(token,id,techId,candidateDTO);
    }

    //List of candidates
    @GetMapping("/listCandidate")
    public List<CandidateModel> getList (@RequestHeader String token ){
        return iCandidateService.viewList(token);
    }

    //Delete candidate
    @DeleteMapping("/deleteCandidate/{id}")
    public CandidateModel deleteCandidate(@RequestHeader String token ,@PathVariable Long id){
        return iCandidateService.removeCandidate(token,id);
    }

    //getCount
    @GetMapping("/countOfStatus")
    public Long countOfStatus (@RequestHeader String token,@RequestParam String userChoice){
        return iCandidateService.getCount(token,userChoice);
    }
}
