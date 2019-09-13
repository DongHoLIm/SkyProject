package com.kh.finalProject.studentInfo.model.dao;

import java.util.ArrayList;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.kh.finalProject.board.model.vo.PageInfo;
import com.kh.finalProject.studentInfo.model.exception.StudentInfoSelectListException;
import com.kh.finalProject.studentInfo.model.vo.FilterCondition;
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

	@Override
	public int getFilterListCount(SqlSessionTemplate sqlSession, FilterCondition fc) throws StudentInfoSelectListException {
		
		int listCount = sqlSession.selectOne("StudentInfo.selectFilterListCount", fc);
		
		if(listCount <= 0) {
			sqlSession.close();
			throw new StudentInfoSelectListException("필터 학생리스트 카운트 실패");
		}
		
		return listCount;
	}

	@Override
	public ArrayList<StudentInfo> selectFilterStudent(SqlSessionTemplate sqlSession, FilterCondition fc, PageInfo pi) throws StudentInfoSelectListException {
		
		ArrayList<StudentInfo> list = null;
		
		int offset = (pi.getCurrentPage()-1)*pi.getLimit();
		
		RowBounds rowBounds = new RowBounds(offset,pi.getLimit());
		 
		list = (ArrayList) sqlSession.selectList("StudentInfo.selectFilterStudent", fc, rowBounds);
		
		if(list==null) {
			sqlSession.close();
			throw new StudentInfoSelectListException("학생정보 조회 실패");
		}
		
		return list;
	}

	@Override
	public ArrayList selectCollegeFilter(SqlSessionTemplate sqlSession, String col) throws StudentInfoSelectListException {
		
		ArrayList list = null;
		
		if(col.equals("단과대학")) {
			list = (ArrayList)sqlSession.selectList("StudentInfo.selectCollegeAll",col);
		}else {
			list = (ArrayList)sqlSession.selectList("StudentInfo.selectCollege",col);
		}
		
		if(list==null) {
			sqlSession.close();
			throw new StudentInfoSelectListException("단과대필터링 조회 실패");
		}
		
		return list;
	}

	@Override
	public ArrayList selectCollege(SqlSessionTemplate sqlSession) throws StudentInfoSelectListException {
		
		ArrayList collegeList = null;
		
		collegeList = (ArrayList)sqlSession.selectList("StudentInfo.selectCollegeList");
		
		if(collegeList==null) {
			sqlSession.close();
			throw new StudentInfoSelectListException("단과대 리스트 조회 실패");
		}
		
		return collegeList;
	}

	@Override
	public ArrayList selectSdeptList(SqlSessionTemplate sqlSession) throws StudentInfoSelectListException {
		
		ArrayList sdeptList = null;
		
		sdeptList = (ArrayList)sqlSession.selectList("StudentInfo.selectSdeptList");
		
		if(sdeptList==null) {
			sqlSession.close();
			throw new StudentInfoSelectListException("학과리스트 조회 실패");
		}
		
		return sdeptList;
	}

	

	
	

}
