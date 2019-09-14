package com.kh.finalProject.student.classmanagement.model.dao;

import java.util.ArrayList;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.kh.finalProject.student.classmanagement.model.vo.Sdepartment;

@Repository
public class ClassDaoImpl implements ClassDao{

	
	@Override
	public ArrayList<Sdepartment> selectSdept(SqlSessionTemplate sqlSession) {
		ArrayList<Sdepartment> sdList = null;
		
		sdList = (ArrayList) sqlSession.selectList("Sdepartment.selectSdept");
		
		return sdList;
	}

}
