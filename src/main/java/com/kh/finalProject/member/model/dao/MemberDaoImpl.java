package com.kh.finalProject.member.model.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.kh.finalProject.member.model.exception.loginException;
import com.kh.finalProject.member.model.vo.Member;

@Repository
public class MemberDaoImpl implements MemberDao {
	//login check 메소드 
	@Override
	public Member loginCheck(SqlSessionTemplate sqlSession, Member m) throws loginException {		
		Member loginUser =  sqlSession.selectOne("Member.loginCheck",m);
//		
//		if(loginUser==null) {
//			throw new loginException("해당아이디가 없습니다.");
//		}
			
		return loginUser;
	}
	//loginCheck 값 변경
	@Override
	public void updateLoginCheck(SqlSessionTemplate sqlSession, Member loginUser) {
		sqlSession.update("Member.upDateLoginCheck",loginUser);
		
	}
	//메인에서의 loginCheck값 변경 
	@Override
	public void logOutLoginCheck(SqlSessionTemplate sqlSession, Member loginUser) {
		sqlSession.update("Member.upDateLooutCheck",loginUser);
		
	}
	//정보 추가
	@Override
	public int insertMember(SqlSessionTemplate sqlSession, Member insertMember) {
		
		return sqlSession.insert("Member.insertMember",insertMember);
	}
	//학적 정보 추가
	@Override
	public int insertStudentInfo(SqlSessionTemplate sqlSession, Member insertMember) {
		
		return sqlSession.insert("Member.insertStudentInfo",insertMember);
	}
	//교수정보 추가
	@Override
	public int insertProfessorInfo(SqlSessionTemplate sqlSession, Member insertMember) {
		
		return sqlSession.insert("Member.insertProfessorInfo",insertMember);
	}
	//교직원 정보 추가
	@Override
	public int insertEmployeeInfo(SqlSessionTemplate sqlSession, Member insertMember) {
	
		return sqlSession.insert("Member.insertEmployeeInfo",insertMember);
	}
	@Override
	public Member findIdResult(SqlSessionTemplate sqlSession, Member findId) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("Member.memberFindId", findId);
	}
	
}
