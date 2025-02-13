package com.bikash.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bikash.appconst.AppConst;
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
	
	@Override
	public String login(LoginForm loginForm) {
		UserAccount account=userRepo.findByMailIdAndPassword(loginForm.getUserName(),loginForm.getPassword());
		if(account!=null)
		{
			if(account.getAccountStatus().equals(AppConst.STR_UNLOCK))
			{
				session.setAttribute(AppConst.STR_USERID,account.getUserId());
				return AppConst.STR_LOGIN_SUCCESS;
			}
				return AppConst.STR_ACC_NOT_YET_UNLOCK;
		}
		return AppConst.STR_INVALID_CREDENTIAL;
	}

	@Override
	public void logout() {
		session.invalidate();  //Stop the session
	}
	
	@Override
	public Boolean signup(SignUpForm signupForm) {
	
		UserAccount user=userRepo.findByMailId(signupForm.getMailId());
		if(user!=null)
		{
			return false;
		}
		
		UserAccount  userAcc=new UserAccount();
		BeanUtils.copyProperties(signupForm, userAcc);
		
		String tempPassword=DefaultPasswordGenerator.generatePassword();
		userAcc.setPassword(tempPassword); 
		
		userAcc.setAccountStatus(AppConst.STR_LOCK);
		
		userRepo.save(userAcc);
		
		String data = "<html>"
	            + "<body>"
	            + "<h1>Unlock your account with the below temporary password</h1>"
	            + "<p>Temporary Password: <strong>" + tempPassword + "</strong></p>"
	            + "<p><a href=\"http://localhost:8082/JRTP-MP02-FrontOfficeTeamPortal/unloackaccount?mail="+signupForm.getMailId()+"\">Click Here To Unlock</a></p>"
	            + "</body>"
	            + "</html>";
	
		String subject=AppConst.STR_MAIL_UNLOCK_SUBJECT;
		mail.sendMail(signupForm.getMailId(),data, subject);
		
		return true;
	}

	@Override
	public Boolean unlockAccount(UnlockAccountForm unlockForm) {
		UserAccount account=userRepo.findByMailId(unlockForm.getMailId());
		if(account.getPassword().equals(unlockForm.getTemporaryPassword()))
		{
			account.setPassword(unlockForm.getNewPassword());
			account.setAccountStatus(AppConst.STR_UNLOCK);
			userRepo.save(account);
			return true;
		}
		return false;
	}

	@Override
	public String forgotPassword(String email) {
		UserAccount account=userRepo.findByMailId(email);
		if(account!=null)
		{
			//If account unlocked then send password with Recover Password Option
			if(account.getAccountStatus().equals(AppConst.STR_UNLOCK))
			{
				String subject=AppConst.STR_MAIL_PWD_RECOVER_SUBJECT;
				String data="Hi "+account.getUserName()+","
				+"<br><br>   Your password is : <b>"+account.getPassword()+"<b>"
				+"<br><h3>Thanks & Regards<br>Crazy Coding</h3>";
				boolean status=mail.sendMail(email,data,subject);
				if(status)
				{
					return AppConst.STR_MAIL_PWD_SENT;
				}
				return AppConst.STR_MAIL_INTERNAL_PROB;
			}
			//If account locked then send temp password with unlock account url
			else
			{
				String data = "<html>"
			            + "<body>"
			            + "<h1>Unlock your account with the below temporary password</h1>"
			            + "<p>Temporary Password: <strong>" + account.getPassword() + "</strong></p>"
			            + "<p><a href=\"http://localhost:8082/JRTP-MP02-FrontOfficeTeamPortal/unloackaccount?mail="+email+"\">Click Here To Unlock</a></p>"
			            + "</body>"
			            + "</html>";
			
				String subject=AppConst.STR_MAIL_UNLOCK_SUBJECT;
				boolean status=mail.sendMail(email,data, subject);
				if(status)
				{
					return AppConst.STR_MAIL_UNLOCK_STS_SUCCESS;
				}
					return AppConst.STR_MAIL_UNLOCK_STS_FAIL;
			}
		}
		return AppConst.STR_MAIL_INVALID_MAIL;
	}

}
