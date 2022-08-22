package com.bridgelabz.learningmanagementsystem.controller;

import com.bridgelabz.learningmanagementsystem.dto.HiringCandidateDTO;
import com.bridgelabz.learningmanagementsystem.model.HiringCandidateModel;
import com.bridgelabz.learningmanagementsystem.service.IHiringCandidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/hiringCandidateApis")
public class HiringCandidateController {
    @Autowired
    IHiringCandidateService iHiringCandidateService;

    //create candidate
    @PostMapping("/createHiringCandidate")
    public HiringCandidateModel createHiringCandidate(@RequestHeader String token,@RequestParam Long bankId,
                                                               @RequestBody @Valid HiringCandidateDTO hiringCandidateDTO){
        return iHiringCandidateService.addHiringCandidate(token,bankId,hiringCandidateDTO);
    }

    //update candidate
    @PutMapping("/updateHiringCandidate/{id}")
    public HiringCandidateModel updateHiringCandidate(@RequestHeader String token,@PathVariable Long id ,@RequestParam Long bankId,
                                          @RequestBody @Valid HiringCandidateDTO hiringCandidateDTO){
        return iHiringCandidateService.editHiringCandidate(token,id,bankId,hiringCandidateDTO);
    }

    //List of candidates
    @GetMapping("/listHiringCandidate")
    public List<HiringCandidateModel> getList (@RequestHeader String token ){
        return iHiringCandidateService.viewList(token);
    }

    //Delete candidate
    @DeleteMapping("/deleteHiringCandidate/{id}")
    public HiringCandidateModel deleteHiringCandidate(@RequestHeader String token ,@PathVariable Long id){
        return iHiringCandidateService.removeHiringCandidate(token,id);
    }
}
