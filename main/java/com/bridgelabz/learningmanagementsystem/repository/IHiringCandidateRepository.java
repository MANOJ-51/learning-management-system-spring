package com.bridgelabz.learningmanagementsystem.repository;

import com.bridgelabz.learningmanagementsystem.model.HiringCandidateModel;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Purpose:Creating repository for HiringCandidate
 * @author Manoj
 * @Param  to save in database
 * Version 1.0
 */
public interface IHiringCandidateRepository extends JpaRepository<HiringCandidateModel,Long> {
}
