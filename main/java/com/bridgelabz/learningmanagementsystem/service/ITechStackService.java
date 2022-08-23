package com.bridgelabz.learningmanagementsystem.service;

import com.bridgelabz.learningmanagementsystem.dto.TechStackDTO;
import com.bridgelabz.learningmanagementsystem.model.TechStackModel;

import java.util.List;

/**
 * Purpose:Creating Interface for techStack service
 * @author Manoj
 * @Param  all service Methods
 * Version 1.0
 */
public interface ITechStackService {
    TechStackModel addTech(String token, TechStackDTO techStackDTO);

    TechStackModel editTech(String token, Long id, TechStackDTO techStackDTO);

    List<TechStackModel> viewList(String token);

    TechStackModel removeTech(String token, Long id);

    TechStackModel addPath(String token, Long techId, String path);
}
