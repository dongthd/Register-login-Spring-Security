package vn.fs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

	@GetMapping("/login")
	public String login() {
		return "web/login";
	}
	
	@GetMapping("/home")
	public String home() {
		return "web/home";
	}
}
