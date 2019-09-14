package com.kh.finalProject.student.classmanagement.model.dao;

import java.util.ArrayList;

import org.mybatis.spring.SqlSessionTemplate;

import com.kh.finalProject.student.classmanagement.model.vo.Sdepartment;

public interface ClassDao {


	ArrayList<Sdepartment> selectSdept(SqlSessionTemplate sqlSession);

}
