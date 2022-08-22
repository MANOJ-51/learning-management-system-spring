package com.bridgelabz.learningmanagementsystem.model;

import com.bridgelabz.learningmanagementsystem.dto.TechStackDTO;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "tech_stack")

public class TechStackModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;
    private String techName;
    private String status;
    private String imagePath;
    @OneToOne
    AdminModel creatorUser;
    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;

    public TechStackModel(TechStackDTO techStackDTO) {
        this.techName = techStackDTO.getTechName();
        this.status = techStackDTO.getStatus();
    }

    public TechStackModel() {
    }
}
