package com.bridgelabz.learningmanagementsystem.service;

import com.bridgelabz.learningmanagementsystem.dto.CandidateDTO;
import com.bridgelabz.learningmanagementsystem.model.CandidateModel;

import java.util.List;

/**
 * Purpose:Creating Interface for Candidate service
 * @author Manoj
 * @Param  all service Methods
 * Version 1.0
 */
public interface ICandidateService {
    CandidateModel addCandidate(String token, Long techId, CandidateDTO candidateDTO);

    CandidateModel editCandidate(String token, Long id, Long techId, CandidateDTO candidateDTO);

    List<CandidateModel> viewList(String token);

    CandidateModel removeCandidate(String token, Long id);

    Long getCount(String userChoice, String token);
}
