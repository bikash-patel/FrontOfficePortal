package com.bikash.controller;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.bikash.appconst.AppConst;
import com.bikash.dto.LoginForm;
import com.bikash.dto.SignUpForm;
import com.bikash.dto.UnlockAccountForm;
import com.bikash.service.IUserManagementService;

@Controller
public class UserManagementController {
	
	@Autowired
	private IUserManagementService userService;
	
	@GetMapping("/login")
	public String loginPage(@ModelAttribute("login") LoginForm loginForm)
	{
		return "login";
	}
	
	@PostMapping("/login")
	public String loginData(@ModelAttribute("login") LoginForm loginForm,RedirectAttributes red)
	{
		String result=userService.login(loginForm);
		if(result.equals(AppConst.STR_LOGIN_SUCCESS))
		{
			return "redirect:/dashboard";
		}
		
		if(result.equals(AppConst.STR_INVALID_CREDENTIAL))
		{
			red.addFlashAttribute(AppConst.STR_ERR_KEY,result);
			return AppConst.STR_RED_LOGIN_PAGE;
		}
		red.addFlashAttribute(AppConst.STR_ERR_KEY,result);
		return AppConst.STR_RED_LOGIN_PAGE;
	}
	
	@GetMapping("/register")
	public String registerPage(@ModelAttribute("user") SignUpForm signup)
	{
		return "register";
	}
	
	@PostMapping("/register")
	public String registerData(@ModelAttribute("user") SignUpForm signup,RedirectAttributes red,Map<String,Object> map)
	{
		boolean status=userService.signup(signup);
		if(status)
		{
			red.addFlashAttribute(AppConst.STR_SUCC_KEY,AppConst.STR_ACC_CREATED_CHK_MAIL);
			map.put(AppConst.STR_SUCC_KEY,AppConst.STR_ACC_CREATED_CHK_MAIL);
			return "redirect:/register";
		}
			red.addFlashAttribute(AppConst.STR_ERR_KEY,AppConst.STR_DUP_MAIL_LOG_WITH_NEW_MAIL);
			map.put(AppConst.STR_ERR_KEY,AppConst.STR_DUP_MAIL_LOG_WITH_NEW_MAIL);
			return "register";
	}
	
	@GetMapping("/forgotpassword")
	public String forgotPswdPage()
	{
		return "forgotpassword";
	}
	
	@PostMapping("/forgotpassword")
	public String forgotPswdData(@RequestParam String mailId,Map<String,Object> map,RedirectAttributes red)
	{
		if(mailId!=null && !mailId.equals(""))
		{
			String result=userService.forgotPassword(mailId);
			if(result.equals(AppConst.STR_MAIL_PWD_SENT))
			{
				red.addFlashAttribute(AppConst.STR_SUCC_KEY,result);
				return AppConst.STR_RED_LOGIN_PAGE;
			}
			if(result.equals(AppConst.STR_MAIL_INTERNAL_PROB))
			{
				red.addFlashAttribute(AppConst.STR_ERR_KEY,result);
				return AppConst.STR_RED_FORGOT_PASSWORD_PAGE;
			}
			if(result.equals(AppConst.STR_MAIL_INVALID_MAIL))
			{
				red.addFlashAttribute(AppConst.STR_ERR_KEY,result);
				return AppConst.STR_RED_FORGOT_PASSWORD_PAGE;
			}
			if(result.equals(AppConst.STR_MAIL_UNLOCK_STS_SUCCESS) || result.equals(AppConst.STR_MAIL_UNLOCK_STS_FAIL))
			{
				red.addFlashAttribute(AppConst.STR_ERR_KEY,result);
				return AppConst.STR_RED_FORGOT_PASSWORD_PAGE;
			}
			
			
		}
		red.addFlashAttribute(AppConst.STR_ERR_KEY,AppConst.STR_MAIL_SHOULD_NOT_EMPTY);
		return AppConst.STR_RED_FORGOT_PASSWORD_PAGE;
	}
	
	@GetMapping("/unloackaccount")
	public String unloackAccountPage(@RequestParam String mail,Map<String,Object> map)
	{
		UnlockAccountForm unlockData=new UnlockAccountForm(); 
		unlockData.setMailId(mail);
		map.put("unlock",unlockData);
		return AppConst.STR_UNLOACK_ACC_PAGE;
	}
	
	@PostMapping("/unloackaccount")
	public String unloackAccountData(Map<String,Object> map,RedirectAttributes red,@ModelAttribute("unlock") UnlockAccountForm unlockData)
	{
		if(unlockData.getNewPassword().equals(unlockData.getConfirmPassword()))
		{
			boolean check=userService.unlockAccount(unlockData);
			if(check)
			{
				red.addFlashAttribute(AppConst.STR_SUCC_KEY,AppConst.STR_ACC_UNLOCK);
				return AppConst.STR_RED_LOGIN_PAGE;
			}
			map.put(AppConst.STR_ERR_KEY,AppConst.STR_TEMP_PWD_NOT_MATCH);
			return AppConst.STR_UNLOACK_ACC_PAGE;
		}
		map.put(AppConst.STR_ERR_KEY,AppConst.STR_NEW_AND_CONF_PWD_SHUD_MATCH);
		return AppConst.STR_UNLOACK_ACC_PAGE;
	}
	
	@GetMapping("/logout")
	public String homePage()
	{
		userService.logout(); 
		return "home";
	}
}
