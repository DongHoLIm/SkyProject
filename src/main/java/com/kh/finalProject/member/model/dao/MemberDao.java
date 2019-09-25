package com.kh.finalProject.member.model.dao;

import java.util.ArrayList;

import org.mybatis.spring.SqlSessionTemplate;

import com.kh.finalProject.board.model.vo.PageInfo;
import com.kh.finalProject.member.model.exception.loginException;
import com.kh.finalProject.member.model.vo.Member;
import com.kh.finalProject.member.model.vo.MemberAccount;

public interface MemberDao {

	Member loginCheck(SqlSessionTemplate sqlSession, Member m) throws loginException;

	void updateLoginCheck(SqlSessionTemplate sqlSession, Member loginUser);

	void logOutLoginCheck(SqlSessionTemplate sqlSession, Member loginUser);

	int insertMember(SqlSessionTemplate sqlSession, Member insertMember);

	int insertStudentInfo(SqlSessionTemplate sqlSession, Member insertMember);

	int insertProfessorInfo(SqlSessionTemplate sqlSession, Member insertMember);

	int insertEmployeeInfo(SqlSessionTemplate sqlSession, Member insertMember);

	Member findIdResult(SqlSessionTemplate sqlSession, Member findId);

	Member findPwdResult(SqlSessionTemplate sqlSession, Member findPwd);

	int changeNewPassword(SqlSessionTemplate sqlSession, Member findMemberPwd);
	
	ArrayList<Member> memberAllList(SqlSessionTemplate sqlSession, String userId, PageInfo pi);

	int getMemberListCount(SqlSessionTemplate sqlSession, String memberId);

	Member memberDetail(SqlSessionTemplate sqlSession, Member findMemberDetail);

	int memberUpdate(SqlSessionTemplate sqlSession, Member updateMember);

	ArrayList<Member> employeelist(SqlSessionTemplate sqlSession, PageInfo pi);

	int employeeUpdate(SqlSessionTemplate sqlSession, Member updateMember);

	MemberAccount Account(SqlSessionTemplate sqlSession, String userId);

	Member employeeDetailList(SqlSessionTemplate sqlSession, Member employee);

	MemberAccount employeeMachart(SqlSessionTemplate sqlSession, MemberAccount ma);

	int updatingAccount(SqlSessionTemplate sqlSession, MemberAccount ma);

	Member selectEncPwd(SqlSessionTemplate sqlSession, Member m);

	int accountMember(SqlSessionTemplate sqlSession);

	int searchMemberCount(SqlSessionTemplate sqlSession, String searchValue);

	ArrayList<Member> searchMember(SqlSessionTemplate sqlSession, String searchValue, PageInfo pi);

	Member memberInfo(SqlSessionTemplate sqlSession, Member loginUser);

	int updateMemberInfo(SqlSessionTemplate sqlSession, Member m);

}
