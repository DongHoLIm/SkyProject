package com.kh.finalProject.studentInfo.model.dao;

import java.util.ArrayList;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.kh.finalProject.board.model.vo.PageInfo;
import com.kh.finalProject.studentInfo.model.exception.StudentInfoSelectListException;
import com.kh.finalProject.studentInfo.model.vo.StudentInfo;

@Repository
public class StudentInfoDaoImpl implements StudentInfoDao{

	@Override
	public StudentInfo basicInfo(SqlSessionTemplate sqlSession, String userId) {
		
		return sqlSession.selectOne("StudentInfo.selectBasicInfo", userId);
	}

	@Override
	public StudentInfo stuInfo(SqlSessionTemplate sqlSession, String userId) {
		
		return sqlSession.selectOne("StudentInfo.selectStuInfo", userId);
	}

	@Override
	public int getListCount(SqlSessionTemplate sqlSession) throws StudentInfoSelectListException {
		
		int listCount = sqlSession.selectOne("StudentInfo.selectListCount");
		
		if(listCount <= 0) {
			sqlSession.close();
			throw new StudentInfoSelectListException("학생리스트 카운트 실패");
		}
		
		return listCount;
	}

	@Override
	public ArrayList<StudentInfo> selectStudentList(SqlSessionTemplate sqlSession, PageInfo pi) throws StudentInfoSelectListException {
		ArrayList<StudentInfo> list = null;
		
		int offset = (pi.getCurrentPage()-1)*pi.getLimit();
		
		RowBounds rowBounds = new RowBounds(offset,pi.getLimit());
		
		list = (ArrayList) sqlSession.selectList("StudentInfo.selectStudentList", null, rowBounds);
		
		if(list==null) {
			sqlSession.close();
			throw new StudentInfoSelectListException("학생정보 조회 실패");
		}
		
		return list;
	}

	

}
