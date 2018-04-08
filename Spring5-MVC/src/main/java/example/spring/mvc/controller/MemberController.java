package example.spring.mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import example.spring.mvc.models.Member;
import example.spring.mvc.service.MemberService;

@Controller
public class MemberController {

	@Autowired
	private MemberService memberService;
	
	@RequestMapping("/member/add")
	private String addMember(Model model) {
		model.addAttribute("member", new Member());
		model.addAttribute("guests", memberService.list());
		return "membersList";
	}
	
	@RequestMapping(value = {"/member/remove", "/member/delete"}, method=RequestMethod.GET)
	public String removeMember(@RequestParam("memberName") String memberName) {
		memberService.remove(memberName);
		return "redirect:";
	}
}
