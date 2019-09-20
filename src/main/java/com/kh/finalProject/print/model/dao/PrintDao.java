package com.kh.finalProject.print.model.dao;


import java.util.ArrayList;

import org.mybatis.spring.SqlSessionTemplate;

import com.kh.finalProject.print.model.exception.PrintException;
import com.kh.finalProject.print.model.vo.Print;

public interface PrintDao {

	ArrayList<Print> printCheck(SqlSessionTemplate sqlSession, String studentNo) throws PrintException;

}
