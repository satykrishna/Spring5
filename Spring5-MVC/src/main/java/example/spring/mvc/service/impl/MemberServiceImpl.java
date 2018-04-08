package example.spring.mvc.service.impl;

import static java.util.Collections.emptyList;

import java.util.ArrayList;

import static java.util.Arrays.*;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

import example.spring.mvc.models.Member;
import example.spring.mvc.service.MemberService;

@Service
public class MemberServiceImpl implements MemberService {

	private List<Member> memberList = new ArrayList<Member>();
	
	@Override
	public List<Member> list() {
		return memberList;
	}
	
	@PostConstruct
	public void init() {
		memberList.addAll(asList(new Member("Satya", "Krishna", "A1001")));
	}
	

	@Override
	public void add(Member member) {
		memberList.add(member);
	}

	@Override
	public void remove(String memberName) {
		
	}

}
