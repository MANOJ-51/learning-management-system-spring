package com.bridgelabz.learningmanagementsystem.service;

import com.bridgelabz.learningmanagementsystem.dto.MentorDTO;
import com.bridgelabz.learningmanagementsystem.model.MentorModel;

import java.util.List;

/**
 * Purpose:Creating Interface for Mentor service
 * @author Manoj
 * @Param  all service Methods
 * Version 1.0
 */
public interface IMentorService {
    MentorModel addMentor(String token, MentorDTO mentorDTO);

    MentorModel editMentor(String token, Long id, MentorDTO mentorDTO);

    List<MentorModel> viewList(String token);

    MentorModel removeMentor(String token, Long id);

    MentorModel addPath(String token, Long id, String profilePath);

    MentorModel getListId(String token, Long id);

    Long getCountByType(String token, String userChoice);
}
