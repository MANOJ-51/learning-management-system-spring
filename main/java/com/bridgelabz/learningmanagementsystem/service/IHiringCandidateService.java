package com.bridgelabz.learningmanagementsystem.service;

import com.bridgelabz.learningmanagementsystem.dto.HiringCandidateDTO;
import com.bridgelabz.learningmanagementsystem.model.HiringCandidateModel;

import java.util.List;

/**
 * Purpose:Creating Interface for HiringCandidate service
 * @author Manoj
 * @Param  all service Methods
 * Version 1.0
 */
public interface IHiringCandidateService {
    HiringCandidateModel addHiringCandidate(String token, Long bankId, HiringCandidateDTO hiringCandidateDTO);

    HiringCandidateModel editHiringCandidate(String token, Long id, Long bankId, HiringCandidateDTO hiringCandidateDTO);

    List<HiringCandidateModel> viewList(String token);

    HiringCandidateModel removeHiringCandidate(String token, Long id);
}
