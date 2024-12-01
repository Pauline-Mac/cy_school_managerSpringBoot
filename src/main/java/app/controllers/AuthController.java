package app.controllers;

import app.models.User;
import app.repositories.UserRepository;
import app.services.authentication.AuthService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Enumeration;

@Controller
public class AuthController {
	@Autowired
	AuthService authService;
	@Autowired
	private UserRepository userRepository;

	@GetMapping("/login")
	public String Login() {
		return "login";
	}

	@GetMapping("/authenticate")
	@RequestMapping(value = "authenticate", method = RequestMethod.POST)
	public String Authenticate(@RequestParam("email") String email, @RequestParam("password") String password, HttpServletRequest request) {
		User user = authService.authenticate(email, password);
		if (user != null){
			request.getSession().setAttribute("user", userRepository.findByEmail(email));
			return "redirect:/" + user.getRole().toLowerCase() + "/index";
		} else {
			return "redirect:/login";
		}

	}

	@GetMapping(path="/logout")
	public String Logout(HttpServletRequest request) {
		Enumeration<String> attribute = request.getSession().getAttributeNames();
		while(attribute.hasMoreElements()){
			request.getSession().removeAttribute(attribute.nextElement());
		}
		request.getSession().invalidate();
		return "/login";
	}
}