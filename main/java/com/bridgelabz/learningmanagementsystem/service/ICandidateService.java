package com.bridgelabz.learningmanagementsystem.service;

import com.bridgelabz.learningmanagementsystem.dto.CandidateDTO;
import com.bridgelabz.learningmanagementsystem.model.CandidateModel;

import java.util.List;

public interface ICandidateService {
    CandidateModel addCandidate(String token, CandidateDTO candidateDTO);

    CandidateModel editCandidate(String token, Long id, CandidateDTO candidateDTO);

    List<CandidateModel> viewList(String token);

    CandidateModel removeCandidate(String token, Long id);

    Long getCount(String userChoice, String token);
}
