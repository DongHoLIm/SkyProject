package com.kh.finalProject.professor.result.model.dao;

import java.util.ArrayList;

import org.mybatis.spring.SqlSessionTemplate;

import com.kh.finalProject.member.model.vo.Member;
import com.kh.finalProject.professor.result.model.vo.ProfessorResult;

public interface ProfessorResultDao {

	ArrayList<ProfessorResult> subList(SqlSessionTemplate sqlSession, Member loginInfo);

}
