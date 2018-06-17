package example.app.rest.service;

import java.util.List;

import example.app.rest.model.Member;

public interface MemberService {

	public abstract List<Member> findAll();

}
