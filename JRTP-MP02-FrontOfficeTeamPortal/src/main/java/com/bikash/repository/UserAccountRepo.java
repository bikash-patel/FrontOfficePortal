package com.bikash.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bikash.entity.UserAccount;

public interface UserAccountRepo extends JpaRepository<UserAccount, Integer> {
	
	public UserAccount findByMailId(String mail);
	public UserAccount findByMailIdAndPassword(String mail,String password);
}
