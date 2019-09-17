package com.kh.finalProject.student.classmanagement.model.dao;

import java.util.ArrayList;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.kh.finalProject.employee.classManagement.model.vo.OpenSubject;
import com.kh.finalProject.student.classmanagement.model.vo.Sdepartment;

@Repository
public class ClassDaoImpl implements ClassDao{

	
	@Override
	public ArrayList<Sdepartment> selectSdept(SqlSessionTemplate sqlSession) {
		ArrayList<Sdepartment> sdList = null;
		
		sdList = (ArrayList) sqlSession.selectList("Sdepartment.selectSdept");
		
		return sdList;
	}

	@Override
	public ArrayList<OpenSubject> selectOpenSubject(SqlSessionTemplate sqlSession) {
		ArrayList<OpenSubject> osList = null;
		
		osList = (ArrayList) sqlSession.selectList("courseRegistration.selectOpenSubject");
		
		return osList;
	}

	@Override
	public ArrayList<OpenSubject> selectSubject(SqlSessionTemplate sqlSession, OpenSubject os) {
		ArrayList<OpenSubject> osList = null;
		
		if(os.getCompleteType().equals("ALL")) {
			osList = (ArrayList) sqlSession.selectList("courseRegistration.selectSubject1", os);
		}else {
		
			osList= (ArrayList) sqlSession.selectList("courseRegistration.selectSubject2", os);		
		}
		return osList;
	}

	@Override
	public ArrayList<OpenSubject> selectOpenSubject(SqlSessionTemplate sqlSession, OpenSubject os) {
		ArrayList<OpenSubject> list = null;
		
		
		list = (ArrayList) sqlSession.selectList("courseRegistration.studentSelectOpenSubject", os);

		return list;
	}

	@Override
	public ArrayList<OpenSubject> selectSearchgwamok(SqlSessionTemplate sqlSession, String gwamok) {
		ArrayList<OpenSubject> list = null;
		
		list = (ArrayList) sqlSession.selectList("courseRegistration.selectSearchGwamok", gwamok);
		
		System.out.println(list);
		return list;
	}

	@Override
	public ArrayList<OpenSubject> selectProfessor(SqlSessionTemplate sqlSession, String professor) {
		ArrayList<OpenSubject> list2 = null;
		
		list2 = (ArrayList) sqlSession.selectList("courseRegistration.selectSearchProfessor", professor);
		
		return list2;
	}

	@Override
	public ArrayList<OpenSubject> seletProGwamok(SqlSessionTemplate sqlSession, OpenSubject os) {
		ArrayList<OpenSubject> list = null;
		
		list = (ArrayList) sqlSession.selectList("courseRegistration.selectProGwamok", os);
		
		return list;
	}

}
