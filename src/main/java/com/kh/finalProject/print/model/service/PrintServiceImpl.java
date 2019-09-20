package com.kh.finalProject.print.model.service;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.finalProject.print.model.dao.PrintDao;
import com.kh.finalProject.print.model.exception.PrintException;
import com.kh.finalProject.print.model.vo.Print;

@Service
public class PrintServiceImpl implements PrintService{
	@Autowired
	private SqlSessionTemplate sqlSession;
	@Autowired
	private PrintDao printDao;
	
	@Override
	public ArrayList printCheck(String studentNo) throws PrintException {
		return printDao.printCheck(sqlSession, studentNo);
	}
	
	 
	
	
}
