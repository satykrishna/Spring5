package example.spring.mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import example.spring.mvc.models.Member;
import example.spring.mvc.service.MemberService;

@Controller
@RequestMapping("/member/*")
public class MemberController {

	@Autowired
	private MemberService memberService;
	
	@RequestMapping("add")
	private String addMember(Model model) {
		model.addAttribute("member", new Member());
		model.addAttribute("guests", memberService.list());
		return "membersList";
	}
	
	@RequestMapping(value = {"remove", "delete"}, method=RequestMethod.GET)
	public String removeMember(@RequestParam("memberName") String memberName) {
		memberService.remove(memberName);
		return "redirect:";
	}

	@RequestMapping("display/{member}")
	public String displayMember(@PathVariable("member") String member, Model model) {
		return member;
	}
	
	@RequestMapping
	public void memberList(){
		
	}
	
	public void memberLogic(String memberName) {
		
	}
	
	@PostMapping("processUser")
	public String submitForm(@ModelAttribute("member") Member member, BindingResult bindingResult, Model model ) {
		return "memberList";
	}
}
