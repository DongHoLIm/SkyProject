package com.kh.finalProject.member.model.dao;

import org.mybatis.spring.SqlSessionTemplate;

import com.kh.finalProject.member.model.exception.loginException;
import com.kh.finalProject.member.model.vo.Member;

public interface MemberDao {

	Member loginCheck(SqlSessionTemplate sqlSession, Member m) throws loginException;

	void updateLoginCheck(SqlSessionTemplate sqlSession, Member loginUser);

	void logOutLoginCheck(SqlSessionTemplate sqlSession, Member loginUser);

	int insertMember(SqlSessionTemplate sqlSession, Member insertMember);

	int insertStudentInfo(SqlSessionTemplate sqlSession, Member insertMember);

	int insertProfessorInfo(SqlSessionTemplate sqlSession, Member insertMember);

	int insertEmployeeInfo(SqlSessionTemplate sqlSession, Member insertMember);

	Member findIdResult(SqlSessionTemplate sqlSession, Member findId);

}
