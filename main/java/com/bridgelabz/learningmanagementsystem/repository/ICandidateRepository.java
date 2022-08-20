package com.bridgelabz.learningmanagementsystem.repository;

import com.bridgelabz.learningmanagementsystem.model.CandidateModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ICandidateRepository extends JpaRepository<CandidateModel,Long> {

    @Query( value = "select count(status) from candidate_details  where status =:name",nativeQuery = true)
    //countByStatus
    Long statusCount(String name);
}
