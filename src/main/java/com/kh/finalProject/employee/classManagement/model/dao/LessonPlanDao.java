package com.kh.finalProject.employee.classManagement.model.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;

import com.kh.finalProject.employee.classManagement.model.vo.LessonPlan;

public interface LessonPlanDao {
		
 void insertLessonPlan(SqlSessionTemplate sqlSession, LessonPlan lp);

List<LessonPlan> selectLessonPlanServiceList(SqlSessionTemplate sqlSession);
}
