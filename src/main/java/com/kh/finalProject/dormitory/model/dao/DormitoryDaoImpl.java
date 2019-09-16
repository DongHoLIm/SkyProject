package com.kh.finalProject.dormitory.model.dao;

import java.util.ArrayList;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.kh.finalProject.dormitory.model.exception.DormitoryException;
import com.kh.finalProject.dormitory.model.vo.Dormitory;

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
	public void insertDormitory(SqlSessionTemplate sqlSession, Dormitory d) {
		sqlSession.insert("dormitoryApply.add", d);
	}

}
