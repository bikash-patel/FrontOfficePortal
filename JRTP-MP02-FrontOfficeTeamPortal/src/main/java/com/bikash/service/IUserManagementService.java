package com.bikash.service;

import com.bikash.dto.LoginForm;
import com.bikash.dto.SignUpForm;
import com.bikash.dto.UnlockAccountForm;

public interface IUserManagementService {
	public String login(LoginForm loginForm);
	
	public void logout();
	
	public Boolean signup(SignUpForm signupForm);
	
	public Boolean unlockAccount(UnlockAccountForm unlockForm);
	
	public String forgotPassword(String email);
}
