package com.kh.finalProject.dormitory.model.dao;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.kh.finalProject.dormitory.model.exception.DormitoryException;
import com.kh.finalProject.dormitory.model.vo.Dormitory;
import com.kh.finalProject.enrollment.model.vo.Enrollment;

@Repository
public class DormitoryDaoImpl implements DormitoryDao{

	@Override
	public ArrayList<Dormitory> userDormitory(SqlSessionTemplate sqlSession, String studentNo) throws DormitoryException {
		ArrayList<Dormitory> memberDormitory = null;
		
		memberDormitory = (ArrayList) sqlSession.selectList("Dormitory.DormitoryCheck", studentNo);
		
		if(memberDormitory == null) {
			throw new DormitoryException("정보가 존재하지 않습니다.");
		}
		
		return memberDormitory;
	}

	@Override
	public void insertDormitory(SqlSessionTemplate sqlSession, Dormitory dormitory) {
		System.out.println("dormitory ::: " + dormitory);
		sqlSession.insert("Dormitory.add", dormitory);
		
	}

	@Override
	public List<Dormitory> beforeDormitoryData(SqlSessionTemplate sqlSession) throws DormitoryException {
		System.out.println("검색 dao 들어옴");
		List<Dormitory> beforeDormitory = null;
		beforeDormitory = (List) sqlSession.selectList("Dormitory.beforeDormitory");
		
		if(beforeDormitory == null) {
			throw new DormitoryException("정보가 존재하지 않습니다.");
		}
		
		return beforeDormitory;
	}

	@Override
	public List<Dormitory> beforeDormData(SqlSessionTemplate sqlSession, Dormitory dor) throws DormitoryException {
		System.out.println("null이 아닐때 dao들어옴");
		List<Dormitory> beforeDormitory = null;
		
		beforeDormitory = (List) sqlSession.selectList("Dormitory.searchDorm", dor);
		
		if(beforeDormitory == null) {
			throw new DormitoryException("정보가 존재하지 않습니다.");
		}
		
		return beforeDormitory;
	}

}
