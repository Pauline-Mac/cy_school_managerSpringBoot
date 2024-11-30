package app.controllers;

import app.models.User;
import app.services.authentication.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class AuthController {
	@Autowired
	AuthService authService;

	@GetMapping("/login")
	public String login() {
		return "login";
	}

	@GetMapping("/authenticate")
	@RequestMapping(value = "authenticate", method = RequestMethod.POST)
	public String authenticate(@RequestParam("email") String email, @RequestParam("password") String password, RedirectAttributes redirectAttributes) {
		User user = authService.authenticate(email, password);
		if (user != null){
			redirectAttributes.addFlashAttribute("email", email);
			return "redirect:/" + user.getRole().toLowerCase() + "/index";
		} else {
			return "redirect:/login";
		}

	}


}