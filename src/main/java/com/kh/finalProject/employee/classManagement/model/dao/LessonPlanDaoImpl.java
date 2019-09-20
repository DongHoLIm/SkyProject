package com.kh.finalProject.employee.classManagement.model.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.kh.finalProject.employee.classManagement.model.vo.LessonPlan;
@Repository
public class LessonPlanDaoImpl implements LessonPlanDao{


	@Override
	public void insertLessonPlan(SqlSessionTemplate sqlSession, LessonPlan lp) {
		
		 sqlSession.insert("LessonPlan.insertLessonPlan", lp);
	}

}
