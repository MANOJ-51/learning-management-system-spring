package com.bridgelabz.learningmanagementsystem.controller;

import com.bridgelabz.learningmanagementsystem.dto.CandidateDTO;
import com.bridgelabz.learningmanagementsystem.model.CandidateModel;
import com.bridgelabz.learningmanagementsystem.service.ICandidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Purpose:Creating apis for Candidate Controller
 * @author Manoj
 * @Param Http METHODS
 * Version 1.0
 */
@RestController
@RequestMapping("/candidateApis")
public class CandidateController {
    @Autowired
    ICandidateService iCandidateService;

    /**
     * Purpose:Creating method to add candidate
     * @author Manoj
     * @Param candidateDto,token,techID
     */
    @PostMapping("/createCandidate")
    public CandidateModel createCandidate(@RequestHeader String token,@RequestParam Long techId,
                                          @RequestBody @Valid CandidateDTO candidateDTO){
        return iCandidateService.addCandidate(token,techId,candidateDTO);
    }

    /**
     * Purpose:Creating method to Update Candidate
     * @author Manoj
     * @Param CandidateDto ,id ,token,techID
     */
    @PutMapping("/updateCandidate/{id}")
    public CandidateModel updateCandidate(@RequestHeader String token,@PathVariable Long id ,@RequestParam Long techId,
                                          @RequestBody @Valid CandidateDTO candidateDTO){
        return iCandidateService.editCandidate(token,id,techId,candidateDTO);
    }

    /**
     * Purpose:Creating method to get List of Candidate
     * @author Manoj
     * @Param  token
     */
    @GetMapping("/listCandidate")
    public List<CandidateModel> getList (@RequestHeader String token ){
        return iCandidateService.viewList(token);
    }

    /**
     * Purpose:Creating method to Delete Candidate
     * @author Manoj
     * @Param  token,id
     */
    @DeleteMapping("/deleteCandidate/{id}")
    public CandidateModel deleteCandidate(@RequestHeader String token ,@PathVariable Long id){
        return iCandidateService.removeCandidate(token,id);
    }

    /**
     * Purpose:Creating method to get count of Status
     * @author Manoj
     * @Param  token,userChoice
     */
    @GetMapping("/countOfStatus")
    public Long countOfStatus (@RequestHeader String token,@RequestParam String userChoice){
        return iCandidateService.getCount(token,userChoice);
    }
}
