package com.kh.finalProject.employee.classManagement.model.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.kh.finalProject.employee.classManagement.model.vo.LessonPlan;
@Repository
public class LessonPlanDaoImpl implements LessonPlanDao{


	@Override
	public void insertLessonPlan(SqlSessionTemplate sqlSession, LessonPlan lp) {
		
		 sqlSession.insert("LessonPlan.insertLessonPlan", lp);
	}

	@Override
	public List<LessonPlan> selectLessonPlanServiceList(SqlSessionTemplate sqlSession) {
		// TODO Auto-generated method stub
		return  sqlSession.selectList("LessonPlan.selectLessonPlanServiceList");
	}

}
