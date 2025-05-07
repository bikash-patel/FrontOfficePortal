//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.bikash.controller;

import com.bikash.dto.LoginForm;
import com.bikash.dto.SignUpForm;
import com.bikash.dto.UnlockAccountForm;
import com.bikash.service.IUserManagementService;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class UserManagementController {
    @Autowired
    private IUserManagementService userService;

    public UserManagementController() {
    }

    @GetMapping({"/login"})
    public String loginPage(@ModelAttribute("login") LoginForm loginForm) {
        return "login";
    }

    @PostMapping({"/login"})
    public String loginData(@ModelAttribute("login") LoginForm loginForm, RedirectAttributes red) {
        String result = this.userService.login(loginForm);
        if (result.equals("Logged In Success")) {
            return "redirect:/dashboard";
        } else if (result.equals("Invalid Credentials")) {
            red.addFlashAttribute("errorMsg", result);
            return "redirect:/login";
        } else {
            red.addFlashAttribute("errorMsg", result);
            return "redirect:/login";
        }
    }

    @GetMapping({"/register"})
    public String registerPage(@ModelAttribute("user") SignUpForm signup) {
        return "register";
    }

    @PostMapping({"/register"})
    public String registerData(@ModelAttribute("user") SignUpForm signup, RedirectAttributes red, Map<String, Object> map) {
        boolean status = this.userService.signup(signup);
        if (status) {
            red.addFlashAttribute("successMsg", "Account Created , Check Your Email");
            map.put("successMsg", "Account Created , Check Your Email");
            return "redirect:/register";
        } else {
            red.addFlashAttribute("errorMsg", "Duplicate mail id , login with new mail id");
            map.put("errorMsg", "Duplicate mail id , login with new mail id");
            return "register";
        }
    }

    @GetMapping({"/forgotpassword"})
    public String forgotPswdPage() {
        return "forgotpassword";
    }

    @PostMapping({"/forgotpassword"})
    public String forgotPswdData(@RequestParam String mailId, Map<String, Object> map, RedirectAttributes red) {
        if (mailId != null && !mailId.equals("")) {
            String result = this.userService.forgotPassword(mailId);
            if (result.equals("Password sent to your Mail")) {
                red.addFlashAttribute("successMsg", result);
                return "redirect:/login";
            }

            if (result.equals("Internal Problem Try Again Later.")) {
                red.addFlashAttribute("errorMsg", result);
                return "redirect:/forgotpassword";
            }

            if (result.equals("Invalid Mail, Enter Registered Mail")) {
                red.addFlashAttribute("errorMsg", result);
                return "redirect:/forgotpassword";
            }

            if (result.equals("Your Account is Locked , Mail sent to unlock") || result.equals("Your Account is Locked , Try Again Later to unlock")) {
                red.addFlashAttribute("errorMsg", result);
                return "redirect:/forgotpassword";
            }
        }

        red.addFlashAttribute("errorMsg", "Mail should not be empty");
        return "redirect:/forgotpassword";
    }

    @GetMapping({"/unloackaccount"})
    public String unloackAccountPage(@RequestParam String mail, Map<String, Object> map) {
        UnlockAccountForm unlockData = new UnlockAccountForm();
        unlockData.setMailId(mail);
        map.put("unlock", unlockData);
        return "unloackaccount";
    }

    @PostMapping({"/unloackaccount"})
    public String unloackAccountData(Map<String, Object> map, RedirectAttributes red, @ModelAttribute("unlock") UnlockAccountForm unlockData) {
        if (unlockData.getNewPassword().equals(unlockData.getConfirmPassword())) {
            boolean check = this.userService.unlockAccount(unlockData);
            if (check) {
                red.addFlashAttribute("successMsg", "Account Unlocked !");
                return "redirect:/login";
            } else {
                map.put("errorMsg", "Temporary Password Not Matching");
                return "unloackaccount";
            }
        } else {
            map.put("errorMsg", "New Password and Confirm Password should match ");
            return "unloackaccount";
        }
    }

    @GetMapping({"/logout"})
    public String homePage() {
        this.userService.logout();
        return "home";
    }
}
