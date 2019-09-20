package com.kh.finalProject.member.model.service;

import java.util.ArrayList;
import java.util.List;

import javax.security.auth.login.LoginException;

import com.kh.finalProject.board.model.vo.PageInfo;
import com.kh.finalProject.member.model.exception.loginException;
import com.kh.finalProject.member.model.vo.Member;
import com.kh.finalProject.member.model.vo.MemberAccount;

public interface MemberService {

	Member loginCheck(Member m) throws loginException;

	void logOutLoginCheck(Member loginUser);

	int insertMember(Member insertMember);

	int insertStudentInfo(Member insertMember);

	int insertProfessorInfo(Member insertMember);

	int insertEmployeeInfo(Member insertMember);

	Member findIdResult(Member findId);

	Member findPwd(Member findPwd);

	int changeNewpassword(Member findMemberPwd);

	ArrayList<Member> memberAllList(String userId, PageInfo pi);

	int getMemberListCount(String memberId);

	Member memberDetail(Member findMemberDetail);

	int proUpdate(Member updateMember);

	int stuUpdate(Member updateMember);

	ArrayList<Member> employeeList(PageInfo pi);

	MemberAccount Account(String userId);

	Member employeeDetailList(Member employee);

	MemberAccount employeeMachart(MemberAccount ma);

	int updatingAccount(MemberAccount ma);

	int accountMember();

	int searchMemberCount(String searchValue);

	ArrayList<Member> searchMember(String searchValue, PageInfo pi);
}
