package com.kh.finalProject.employee.classManagement.model.dao;

import java.util.ArrayList;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.kh.finalProject.board.model.vo.Board;
import com.kh.finalProject.board.model.vo.PageInfo;
import com.kh.finalProject.employee.classManagement.exception.ClassManagementSelectListException;
import com.kh.finalProject.employee.classManagement.model.vo.LectureOpen;

@Repository
public class ClassManagementDaoImpl implements ClassManagementDao{

	@Override
	public int getListCount(SqlSessionTemplate sqlSession) {

		return sqlSession.selectOne("LectureOpen.selectListCount");
	}

	@Override
	public ArrayList<LectureOpen> selctSubjectList(SqlSessionTemplate sqlSession, PageInfo pi) throws ClassManagementSelectListException {

		ArrayList<LectureOpen> list = null;

		int offset = (pi.getCurrentPage() - 1) * pi.getLimit();

		RowBounds rowBounds = new RowBounds(offset, pi.getLimit());

		list = (ArrayList) sqlSession.selectList("LectureOpen.selectSubjectList", null, rowBounds);
		
		if(list == null) {
			sqlSession.close();
			throw new ClassManagementSelectListException("실패!");
		}
		
		return list;
	}

	@Override
	public LectureOpen selectOneSubject(SqlSessionTemplate sqlSession, String subCode) {
		
		return sqlSession.selectOne("LectureOpen.selectOneSubject", subCode);
	}

	

}
