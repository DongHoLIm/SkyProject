package com.kh.finalProject.member.model.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.kh.finalProject.board.model.vo.PageInfo;
import com.kh.finalProject.member.model.exception.loginException;
import com.kh.finalProject.member.model.vo.Member;
import com.kh.finalProject.member.model.vo.MemberAccount;

@Repository
public class MemberDaoImpl implements MemberDao {
	//login check 메소드 
	@Override
	public Member loginCheck(SqlSessionTemplate sqlSession, Member m) throws loginException {		
		Member loginUser =  sqlSession.selectOne("Member.loginCheck",m);
			
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
		sqlSession.insert("Member.insertEmployeeAccount",insertMember);
		return sqlSession.insert("Member.insertEmployeeInfo",insertMember);
	}
	@Override
	public Member findIdResult(SqlSessionTemplate sqlSession, Member findId) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("Member.memberFindId", findId);
	}
	@Override
	public Member findPwdResult(SqlSessionTemplate sqlSession, Member findPwd) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("Member.memberFidPwd",findPwd);
	}
	@Override
	public int changeNewPassword(SqlSessionTemplate sqlSession, Member findMemberPwd) {
		
		return sqlSession.update("Member.memberchangeNewPassword", findMemberPwd);
	}

	@Override
	public int getMemberListCount(SqlSessionTemplate sqlSession, String memberId) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("Member.MemberListCount",memberId);
	}
	@Override
	public ArrayList<Member> memberAllList(SqlSessionTemplate sqlSession, String userId, PageInfo pi) {
		ArrayList<Member> list =null;
		
		int offset = (pi.getCurrentPage() - 1) * pi.getLimit();
		
		RowBounds rowBounds = new RowBounds(offset, pi.getLimit());
		
		list = (ArrayList) sqlSession.selectList("Member.MemberAllList", userId, rowBounds);
		return list;
	}
	@Override
	public Member memberDetail(SqlSessionTemplate sqlSession, Member findMemberDetail) {
		Member memberDetailUser = sqlSession.selectOne("Member.memberOneSelect",findMemberDetail);
		
		if(memberDetailUser.getMemberStatus().equals("1")) {
			return sqlSession.selectOne("Member.memberDetailStu",findMemberDetail);
		}else if(memberDetailUser.getMemberStatus().equals("2")){
			return sqlSession.selectOne("Member.memberDetailPro",findMemberDetail);
		}else {
			return sqlSession.selectOne("Member.memberDetailEmp", findMemberDetail);
		}		
	}
	@Override
	public int memberUpdate(SqlSessionTemplate sqlSession, Member updateMember) {
		System.out.println("memberUpdate : "+updateMember);
		return sqlSession.update("Member.memberUpdate",updateMember);
	}
	@Override
	public ArrayList<Member> employeelist(SqlSessionTemplate sqlSession, PageInfo pi) {
		
		int offset = (pi.getCurrentPage() - 1) * pi.getLimit();
		
		RowBounds rowBounds = new RowBounds(offset, pi.getLimit());
		
		ArrayList<Member> list = (ArrayList) sqlSession.selectList("Member.employeelist"," ",rowBounds);		
		return list;
	}
	@Override
	public int employeeUpdate(SqlSessionTemplate sqlSession, Member updateMember) {
		return sqlSession.update("Member.employeeUpdate",updateMember);
	}
	@Override
	public MemberAccount Account(SqlSessionTemplate sqlSession, String userId) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("MemberAccount.Account", userId);
	}
	@Override
	public Member employeeDetailList(SqlSessionTemplate sqlSession, Member employee) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("Member.employeeDetailList",employee);
	}
	@Override
	public MemberAccount employeeMachart(SqlSessionTemplate sqlSession, MemberAccount ma) {
		
		return sqlSession.selectOne("MemberAccount.employeeMachart",ma);
		
	}
	@Override
	public int updatingAccount(SqlSessionTemplate sqlSession, MemberAccount ma) {
		// TODO Auto-generated method stub
		return sqlSession.update("MemberAccount.updatingAccount",ma);
	}
	@Override
	public Member selectEncPwd(SqlSessionTemplate sqlSession, Member m) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("Member.encPwdCheck", m);
	}
	@Override
	public int accountMember(SqlSessionTemplate sqlSession) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("Member.AccountCount");
	}
	@Override
	public int searchMemberCount(SqlSessionTemplate sqlSession, String searchValue) {
		int result =0;
		if(searchValue.equals("1")||searchValue.equals("2")||searchValue.equals("3")) {
			result = sqlSession.selectOne("Member.searchMemberCountStatus", searchValue);
		}else {
			result= sqlSession.selectOne("Member.searchMemberCount",searchValue);
		}
		return result;
	}
	@Override
	public ArrayList<Member> searchMember(SqlSessionTemplate sqlSession, String searchValue, PageInfo pi) {
		int offset = (pi.getCurrentPage() - 1) * pi.getLimit();
		
		RowBounds rowBounds = new RowBounds(offset, pi.getLimit());
		ArrayList<Member> list =null;
		if(searchValue.equals("1")||searchValue.equals("2")||searchValue.equals("3")) {
			list = (ArrayList)sqlSession.selectList("Member.searchMemberListCheck",searchValue,rowBounds);
		}else {
			list = (ArrayList)sqlSession.selectList("Member.searchMemberList", searchValue, rowBounds);
			
		}
		System.out.println(list);
		return list;
	}
	@Override
	public Member memberInfo(SqlSessionTemplate sqlSession, Member loginUser) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("Member.memberInfo",loginUser);
	}
	
}
