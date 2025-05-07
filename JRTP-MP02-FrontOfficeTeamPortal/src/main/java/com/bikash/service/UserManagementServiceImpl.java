//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.bikash.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bikash.dto.LoginForm;
import com.bikash.dto.SignUpForm;
import com.bikash.dto.UnlockAccountForm;
import com.bikash.entity.UserAccount;
import com.bikash.repository.UserAccountRepo;
import com.bikash.utils.DefaultPasswordGenerator;
import com.bikash.utils.MailsUtils;

import jakarta.servlet.http.HttpSession;

@Service
public class UserManagementServiceImpl implements IUserManagementService {
    @Autowired
    private UserAccountRepo userRepo;
    @Autowired
    private MailsUtils mail;
    @Autowired
    private HttpSession session;

    public UserManagementServiceImpl() {
    }

    public String login(LoginForm loginForm) {
        UserAccount account = this.userRepo.findByMailIdAndPassword(loginForm.getUserName(), loginForm.getPassword());
        if (account != null) {
            if (account.getAccountStatus().equals("UNLOCKED")) {
                this.session.setAttribute("userId", account.getUserId());
                return "Logged In Success";
            } else {
                return "Account not yet unlocked";
            }
        } else {
            return "Invalid Credentials";
        }
    }

    public void logout() {
        this.session.invalidate();
    }

    public Boolean signup(SignUpForm signupForm) {
        UserAccount user = this.userRepo.findByMailId(signupForm.getMailId());
        if (user != null) {
            return false;
        } else {
            UserAccount userAcc = new UserAccount();
            BeanUtils.copyProperties(signupForm, userAcc);
            String tempPassword = DefaultPasswordGenerator.generatePassword();
            userAcc.setPassword(tempPassword);
            userAcc.setAccountStatus("LOCKED");
            this.userRepo.save(userAcc);
            String data = "<html><body><h1>Unlock your account with the below temporary password</h1><p>Temporary Password: <strong>" + tempPassword + "</strong></p><p><a href=\"http://localhost:8082/JRTP-MP02-FrontOfficeTeamPortal/unloackaccount?mail=" + signupForm.getMailId() + "\">Click Here To Unlock</a></p></body></html>";
            String subject = "Unlocke your account | Crazy Coding";
            this.mail.sendMail(signupForm.getMailId(), data, subject);
            return true;
        }
    }

    public Boolean unlockAccount(UnlockAccountForm unlockForm) {
        UserAccount account = this.userRepo.findByMailId(unlockForm.getMailId());
        if (account.getPassword().equals(unlockForm.getTemporaryPassword())) {
            account.setPassword(unlockForm.getNewPassword());
            account.setAccountStatus("UNLOCKED");
            this.userRepo.save(account);
            return true;
        } else {
            return false;
        }
    }

    public String forgotPassword(String email) {
        UserAccount account = this.userRepo.findByMailId(email);
        if (account != null) {
            String var10000;
            String data;
            String subject;
            boolean status;
            if (account.getAccountStatus().equals("UNLOCKED")) {
                data = "Recover Your Password Below | Crazy Coding";
                var10000 = account.getUserName();
                subject = "Hi " + var10000 + ",<br><br>   Your password is : <b>" + account.getPassword() + "<b><br><h3>Thanks & Regards<br>Crazy Coding</h3>";
                status = this.mail.sendMail(email, subject, data);
                return status ? "Password sent to your Mail" : "Internal Problem Try Again Later.";
            } else {
                var10000 = account.getPassword();
                data = "<html><body><h1>Unlock your account with the below temporary password</h1><p>Temporary Password: <strong>" + var10000 + "</strong></p><p><a href=\"http://localhost:8082/JRTP-MP02-FrontOfficeTeamPortal/unloackaccount?mail=" + email + "\">Click Here To Unlock</a></p></body></html>";
                subject = "Unlocke your account | Crazy Coding";
                status = this.mail.sendMail(email, data, subject);
                return status ? "Your Account is Locked , Mail sent to unlock" : "Your Account is Locked , Try Again Later to unlock";
            }
        } else {
            return "Invalid Mail, Enter Registered Mail";
        }
    }
}
