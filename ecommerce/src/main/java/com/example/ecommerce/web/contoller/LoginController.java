package com.example.ecommerce.web.contoller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.ecommerce.model.LoginForm;

@Controller
@CrossOrigin(origins = "*")
public class LoginController {

	@RequestMapping(value="/adminlogin", method=RequestMethod.GET)
	
	public String getloginform() {
		
		return "adminLogin";
	}
	
	
	@RequestMapping(value="/adminlogin", method=RequestMethod.POST)
	public String login(@ModelAttribute("loginForm") LoginForm loginForm, Model model) {
		
		String email = loginForm.getEmail();
		String password = loginForm.getPassword();
		
		if("admin@gmail.com".equals(email) && "admin".equals(password)) {
			return "adminHome";
		}
		
		model.addAttribute("Invalid Credentials",true);
		
		return "adminLogin";
	}
	
}
