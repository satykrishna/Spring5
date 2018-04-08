package example.spring.mvc.service.impl;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

import example.spring.mvc.models.Member;
import example.spring.mvc.service.MemberService;

@Service
public class MemberServiceImpl implements MemberService {

	private List<Member> memberList;
	
	@Override
	public List<Member> list() {
		return memberList;
	}
	
	@PostConstruct
	public void init() {
		memberList = Collections.emptyList();
		memberList.addAll(Arrays.asList(new Member("SATYA", "KRISHNA", "A1001")));
	}

	@Override
	public void add(Member member) {
		memberList.add(member);
	}

	@Override
	public void remove(String memberName) {
		
	}

}
