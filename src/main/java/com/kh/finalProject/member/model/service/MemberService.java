package com.kh.finalProject.member.model.service;

import java.util.List;

import javax.security.auth.login.LoginException;

import com.kh.finalProject.member.model.exception.loginException;
import com.kh.finalProject.member.model.vo.Member;

public interface MemberService {

	Member loginCheck(Member m) throws loginException;

	void logOutLoginCheck(Member loginUser);

	void insertMember(List<String> values);
}
