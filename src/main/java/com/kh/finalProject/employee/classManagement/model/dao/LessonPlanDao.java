package com.kh.finalProject.employee.classManagement.model.dao;

import org.mybatis.spring.SqlSessionTemplate;

import com.kh.finalProject.employee.classManagement.model.vo.LessonPlan;

public interface LessonPlanDao {
		
 void insertLessonPlan(SqlSessionTemplate sqlSession, LessonPlan lp);
}
