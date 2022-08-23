package com.bridgelabz.learningmanagementsystem.controller;

import com.bridgelabz.learningmanagementsystem.dto.HiringCandidateDTO;
import com.bridgelabz.learningmanagementsystem.model.HiringCandidateModel;
import com.bridgelabz.learningmanagementsystem.service.IHiringCandidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Purpose:Creating apis for Hiring candidate Controller
 * @author Manoj
 * @Param Http METHODS
 * Version 1.0
 */
@RestController
@RequestMapping("/hiringCandidateApis")
public class HiringCandidateController {
    @Autowired
    IHiringCandidateService iHiringCandidateService;

    /**
     * Purpose:Creating method to add hiring candidate
     * @author Manoj
     * @Param hiringCandidateDto,token,bankID,
     */
    @PostMapping("/createHiringCandidate")
    public HiringCandidateModel createHiringCandidate(@RequestHeader String token,@RequestParam Long bankId,
                                                               @RequestBody @Valid HiringCandidateDTO hiringCandidateDTO){
        return iHiringCandidateService.addHiringCandidate(token,bankId,hiringCandidateDTO);
    }

    /**
     * Purpose:Creating method to Update Hiring candidate
     * @author Manoj
     * @Param HiringCandidateDto ,id ,token,bankID
     */
    @PutMapping("/updateHiringCandidate/{id}")
    public HiringCandidateModel updateHiringCandidate(@RequestHeader String token,@PathVariable Long id ,@RequestParam Long bankId,
                                          @RequestBody @Valid HiringCandidateDTO hiringCandidateDTO){
        return iHiringCandidateService.editHiringCandidate(token,id,bankId,hiringCandidateDTO);
    }

    /**
     * Purpose:Creating method to get List of Hiring candidate
     * @author Manoj
     * @Param  token
     */
    @GetMapping("/listHiringCandidate")
    public List<HiringCandidateModel> getList (@RequestHeader String token ){
        return iHiringCandidateService.viewList(token);
    }

    /**
     * Purpose:Creating method to Delete Hiring Candidate
     * @author Manoj
     * @Param  token,id
     */
    @DeleteMapping("/deleteHiringCandidate/{id}")
    public HiringCandidateModel deleteHiringCandidate(@RequestHeader String token ,@PathVariable Long id){
        return iHiringCandidateService.removeHiringCandidate(token,id);
    }
}
