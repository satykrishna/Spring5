package example.spring.mvc.service;

import java.util.List;

import example.spring.mvc.models.Member;

public interface MemberService {

	public abstract List<Member> list();
	
	public abstract void add(Member member);

	public abstract void remove(String memberName);
}
