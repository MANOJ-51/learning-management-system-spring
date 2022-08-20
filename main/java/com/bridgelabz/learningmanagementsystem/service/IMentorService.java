package com.bridgelabz.learningmanagementsystem.service;

import com.bridgelabz.learningmanagementsystem.dto.MentorDTO;
import com.bridgelabz.learningmanagementsystem.model.MentorModel;

import java.util.List;

public interface IMentorService {
    MentorModel addMentor(String token, MentorDTO mentorDTO);

    MentorModel editMentor(String token, Long id, MentorDTO mentorDTO);

    List<MentorModel> viewList(String token);

    MentorModel removeMentor(String token, Long id);

    MentorModel addPath(String token, Long id, String profilePath);

    Long getCountId(String token);

    Long getCountByType(String token, String userChoice);
}
