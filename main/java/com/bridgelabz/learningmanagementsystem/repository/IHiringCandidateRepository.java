package com.bridgelabz.learningmanagementsystem.repository;

import com.bridgelabz.learningmanagementsystem.model.HiringCandidateModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IHiringCandidateRepository extends JpaRepository<HiringCandidateModel,Long> {
}
