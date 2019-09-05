package com.kh.finalProject.member.model.service;

import java.util.List;

import javax.security.auth.login.LoginException;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Service;

import com.kh.finalProject.member.model.dao.MemberDao;
import com.kh.finalProject.member.model.exception.loginException;
import com.kh.finalProject.member.model.vo.Member;

@Service
public class MemberServiceImpl implements MemberService{
	@Autowired
	private SqlSessionTemplate sqlSession;
	@Autowired
	private MemberDao md;
	
	@Autowired
	private DataSourceTransactionManager transactionManager;
	
	@Override
	public Member loginCheck(Member m) throws loginException {
		Member loginUser = null;
		
		loginUser = md.loginCheck(sqlSession,m);
		
		if(loginUser.getLoginCheck().equals("1")) {
			
			throw new loginException("해당 아이디는 이미 로그인 되었습니다.");
		}else {
			md.updateLoginCheck(sqlSession,loginUser);
		}
		return loginUser;
	}
	//로그아웃 에 대한 로그인 상태 변경 
	@Override
	public void logOutLoginCheck(Member loginUser) {
		md.logOutLoginCheck(sqlSession,loginUser);
		
	}
	//insert Member 
	@Override
	public int insertMember(Member insertMember) {
		return md.insertMember(sqlSession,insertMember);
	}

	
}
