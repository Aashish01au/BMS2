package com.revesion.bms2.controller;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.revesion.bms2.model.UserModel;
import com.revesion.bms2.service.UserService;
import com.revesion.bms2.utils.VerifyRecaptcha;

import jakarta.servlet.http.HttpSession;

@Controller
public class UserController {
	
	private static final Logger log = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private UserService userService;
	
	@GetMapping({"/","login"})
	public String getLogin() {
		log.info("--------------------Indisde Login Page---------------------------");
		return"loginForm";
	}
	
	@PostMapping("/login")
	public String postLogin(@ModelAttribute UserModel user, Model model,HttpSession session,@RequestParam("g-recaptcha-response") String recode) throws IOException {
		
		if(VerifyRecaptcha.verify(recode)) {
			user.setPassword(DigestUtils.md5DigestAsHex(user.getPassword().getBytes()));
			UserModel usr = userService.userLogin(user.getEmail(), user.getPassword());
				if(usr !=null) {
					log.info("-------------------- Login Success!!!---------------------------");
					session.setAttribute("activeuser", usr);
					session.setMaxInactiveInterval(200);
//					model.addAttribute("firstName",usr.getFirstName());
					return"Home";
				}else {

					log.info("-------------------- Login Fialed!!! ---------------------------");
					model.addAttribute("message", "User Not Found!!!");
					return"LoginForm";
				}
		}

		log.info("-------------------- Login Fialed!!! ---------------------------");
		model.addAttribute("message", "You  are Not a Human!!!");
		return"LoginForm";
	}
	
	@GetMapping("/signUp")
	public String getSignUp() {
		log.info("--------------------Indisde SignUp Page---------------------------");
		return "SignUpForm";
	}
	
	@PostMapping("/signUp")
	public String postSignUp(@ModelAttribute UserModel user) {
		log.info("--------------------SignUp SuccessFull !!!---------------------------");
		user.setPassword(DigestUtils.md5DigestAsHex(user.getPassword().getBytes()));
		userService.Signup(user);
		return"LoginForm";
	}
	

	@GetMapping("/home")
	public String getHome() {
		log.info("--------------------Inside Home Page---------------------------");
		return "Home";
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		log.info("-------------------- Logout Success---------------------------");
		session.invalidate();// Seesion Kills
		return "loginForm";
	}
	
	@GetMapping("profile")
	public String profile() {
		log.info("--------------------Indisde Profile Page---------------------------");
		return"Profile";
	}
}
