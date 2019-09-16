package com.kh.finalProject.professor.sendSMS.model.dao;

import java.util.ArrayList;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.kh.finalProject.board.model.vo.PageInfo;

import com.kh.finalProject.professor.sendSMS.model.vo.StudentList;

@Repository
public class professorDaoImpl implements professorDao{

	@Override
	public int studentList(SqlSessionTemplate sqlSession) {
		int listCount =sqlSession.selectOne("professorSendSMS.studentListCount");
		return listCount;
	}

	@Override
	public ArrayList<StudentList> studentPageList(SqlSessionTemplate sqlSession, PageInfo pi) {
		ArrayList<StudentList> list = null;
		int offset = (pi.getCurrentPage() - 1) * pi.getLimit();
		
		RowBounds rowBounds = new RowBounds(offset, pi.getLimit());
		
		list = (ArrayList)sqlSession.selectList("professorSendSMS.studentList","",rowBounds);
		return list;
	}

	
}
