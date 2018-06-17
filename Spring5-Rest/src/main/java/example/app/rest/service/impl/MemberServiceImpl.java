package example.app.rest.service.impl;

import static java.util.Arrays.asList;
import static java.util.Collections.emptyList;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

import example.app.rest.model.Member;
import example.app.rest.service.MemberService;


@Service("memberService")
public class MemberServiceImpl implements MemberService {

	private List<Member> members = new ArrayList<>();
	
	@Override
	public List<Member> findAll() {
		return members;
	}

	@PostConstruct
	public void init() {
		members = asList(new Member("Satya", "satykrishna@gmail.com", "2105185210"),
				new Member("sai", "saikiran@gmail.com", "2105185210"));
	}
}
