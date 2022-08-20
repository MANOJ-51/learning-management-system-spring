package com.bridgelabz.learningmanagementsystem.repository;

import com.bridgelabz.learningmanagementsystem.model.MentorModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface IMentorRepository extends JpaRepository<MentorModel,Long> {
    @Query(value = "select count(id) from mentor_details ",nativeQuery = true)
    Long countId();
    long countByMentorType(String userChoice);
}
