package com.bridgelabz.learningmanagementsystem.repository;

import com.bridgelabz.learningmanagementsystem.model.BankDetailsModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBankDetailsRepository extends JpaRepository<BankDetailsModel,Long> {
}
