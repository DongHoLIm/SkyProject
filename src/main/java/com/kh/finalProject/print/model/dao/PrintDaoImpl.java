package com.kh.finalProject.print.model.dao;

import java.util.ArrayList;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.kh.finalProject.print.model.exception.PrintException;
import com.kh.finalProject.print.model.vo.Print;

@Repository
public class PrintDaoImpl implements PrintDao{

	@Override
	public ArrayList<Print> printCheck(SqlSessionTemplate sqlSession, String studentNo) throws PrintException {
		System.out.println("프린트 dao 들어옴");
		ArrayList<Print> printCheck = null;
		
		printCheck = (ArrayList) sqlSession.selectList("Print.printCheckInfo", studentNo);
		
		if(printCheck == null) {
			throw new PrintException("정보가 존재하지 않습니다.");
		}
		return printCheck;
	}
 

}
