package com.kh.finalProject.employee.classManagement.model.dao;

import java.util.ArrayList;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.kh.finalProject.board.model.vo.PageInfo;
import com.kh.finalProject.employee.classManagement.exception.ClassManagementSelectListException;
import com.kh.finalProject.employee.classManagement.model.vo.ClassRoomInformation;
import com.kh.finalProject.employee.classManagement.model.vo.DepartmentProfessor;
import com.kh.finalProject.employee.classManagement.model.vo.LectureOpen;
import com.kh.finalProject.employee.classManagement.model.vo.LectureRegistration;
import com.kh.finalProject.employee.classManagement.model.vo.OpenSubject;

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
	public LectureOpen seletOneSubject(SqlSessionTemplate sqlSession,String subCode) {
		System.out.println("Dao in!!!!");
		return sqlSession.selectOne("LectureOpen.selectOneSubject", subCode);
	}

	@Override
	public ArrayList<DepartmentProfessor> selectProfessorList(SqlSessionTemplate sqlSession, String sdeptName) throws ClassManagementSelectListException {
		
		ArrayList<DepartmentProfessor> list = null;
		System.out.println("proDao !!!!");
		
		System.out.println(sdeptName);
		list = (ArrayList) sqlSession.selectList("lectureprofessor.selectProfessorList", sdeptName);
		
		if(list == null) {
			sqlSession.close();
			throw new ClassManagementSelectListException("실패!");
		}
		
		System.out.println(list);
		
		return list;
	}

	@Override
	public ArrayList<ClassRoomInformation> selectClassRoomList(SqlSessionTemplate sqlSession) {
		ArrayList<ClassRoomInformation> list = null;
		
		
		list = (ArrayList) sqlSession.selectList("classroominformation.selectroomList");
		
		System.out.println("list::!!!" + list);
		return list;
	}

	

	@Override
	public int insertCourseOffered(SqlSessionTemplate sqlSession, LectureRegistration lr) {
	
		return sqlSession.insert("LectureRegistration.insertCouserOffered", lr);
	}

	@Override
	public int updateSubject(SqlSessionTemplate sqlSession, String subCode) {
		
		
		System.out.println("subCode");
		return sqlSession.update("LectureOpen.updateSubject", subCode);
	}

	@Override
	public ArrayList<OpenSubject> selectOpenSubjectList(SqlSessionTemplate sqlSession) {
		ArrayList<OpenSubject> list = null;
		
		list = (ArrayList) sqlSession.selectList("courseRegistration.selectOpenSubjectList");
		return list;
	}

	

}
