package example.spring.mvc.controller;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import  static org.springframework.web.bind.annotation.RequestMethod.*;

@Controller
@RequestMapping("/welcome")
public class WelcomeController {
	
	@RequestMapping(method=GET)
	public String welcome(Model model) {
		Date today  = new Date();
		model.addAttribute("today", today);
		return "welcome";
	}
}
