package com.bridgelabz.learningmanagementsystem.repository;

import com.bridgelabz.learningmanagementsystem.model.TechStackModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITechStackRepository extends JpaRepository<TechStackModel,Long> {
}
