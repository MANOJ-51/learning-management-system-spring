package com.bridgelabz.learningmanagementsystem.repository;

import com.bridgelabz.learningmanagementsystem.model.CandidateModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ICandidateRepository extends JpaRepository<CandidateModel,Long> {

    //@Query( value = "select count(status) from learning_management_system_spring status where status.name =:name",nativeQuery = true)
    Long countByStatus (String name);
}
