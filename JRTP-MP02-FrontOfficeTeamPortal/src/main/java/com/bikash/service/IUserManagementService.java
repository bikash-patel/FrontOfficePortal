//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.bikash.service;

import com.bikash.dto.LoginForm;
import com.bikash.dto.SignUpForm;
import com.bikash.dto.UnlockAccountForm;

public interface IUserManagementService {
    String login(LoginForm loginForm);

    void logout();

    Boolean signup(SignUpForm signupForm);

    Boolean unlockAccount(UnlockAccountForm unlockForm);

    String forgotPassword(String email);
}
