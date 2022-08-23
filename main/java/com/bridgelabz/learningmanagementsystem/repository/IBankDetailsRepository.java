package com.bridgelabz.learningmanagementsystem.repository;

import com.bridgelabz.learningmanagementsystem.model.BankDetailsModel;
import org.springframework.data.jpa.repository.JpaRepository;
/**
 * Purpose:Creating repository for bankDetails
 * @author Manoj
 * @Param  to save in database
 * Version 1.0
 */
public interface IBankDetailsRepository extends JpaRepository<BankDetailsModel,Long> {
}
