package org.angular.spring.service;

import java.util.List;

import org.angular.spring.example.model.Member;


public interface MemberService {
	
    public List<Member> getAllMembers();

    public Member getMemberById(Long id);

    public void addMember(Member Member);

    public void deleteMemberById(Long id);

    public void deleteAll();

    public void updateMember(Member Member);
}
