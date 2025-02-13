package com.bikash.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bikash.entity.EnquiryDetails;
import com.bikash.entity.UserAccount;


public interface EnquiryDetailsRepo extends JpaRepository<EnquiryDetails, Integer> {
	
	public UserAccount findByUserAcccount(UserAccount account);
}
