package example.app.rest.controller;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import example.app.rest.model.Members;
import example.app.rest.service.MemberService;

@RestController
public class RestMemberController {

	@Autowired
	private MemberService memberService;
	
	@GetMapping("/members")
	public Members getRestMembers() {
		Members members = new Members();
		members.addMembers(memberService.findAll());
		return members;
	}
	
/*	@GetMapping("/members")
	public String getRestMembers(Model model) {
		Members members = new Members();
		members.addMembers(memberService.findAll());
		model.addAttribute("members", members);
		return "memberTemplate";
	}*/
	
	@PostConstruct
	public void init() {
		System.out.println("Controller is initialized");
	}
	
}
