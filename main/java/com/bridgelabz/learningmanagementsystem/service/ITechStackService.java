package com.bridgelabz.learningmanagementsystem.service;

import com.bridgelabz.learningmanagementsystem.dto.TechStackDTO;
import com.bridgelabz.learningmanagementsystem.model.TechStackModel;

import java.util.List;

public interface ITechStackService {
    TechStackModel addTech(String token, TechStackDTO techStackDTO);

    TechStackModel editTech(String token, Long id, TechStackDTO techStackDTO);

    List<TechStackModel> viewList(String token);

    TechStackModel removeTech(String token, Long id);

    TechStackModel addPath(String token, Long techId, String path);
}
