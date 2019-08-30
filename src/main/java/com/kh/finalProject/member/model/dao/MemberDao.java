package com.kh.finalProject.member.model.dao;

import org.mybatis.spring.SqlSessionTemplate;

import com.kh.finalProject.member.model.exception.loginException;
import com.kh.finalProject.member.model.vo.Member;

public interface MemberDao {

	Member loginCheck(SqlSessionTemplate sqlSession, Member m) throws loginException;

}
