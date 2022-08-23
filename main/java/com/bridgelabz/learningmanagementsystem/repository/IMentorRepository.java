package com.bridgelabz.learningmanagementsystem.repository;

import com.bridgelabz.learningmanagementsystem.model.MentorModel;
import org.springframework.data.jpa.repository.JpaRepository;


/**
 * Purpose:Creating repository for Mentor
 * @author Manoj
 * @Param  to save in database
 * Version 1.0
 */
public interface IMentorRepository extends JpaRepository<MentorModel,Long> {
    //@Query(value = "select count(id) from mentor_details ",nativeQuery = true)
    MentorModel getMentorModelById(Long id);
    long countByMentorType(String userChoice);
}
