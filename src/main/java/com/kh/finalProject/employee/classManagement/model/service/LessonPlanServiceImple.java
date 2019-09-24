package com.kh.finalProject.employee.classManagement.model.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.finalProject.employee.classManagement.model.dao.LessonPlanDao;
import com.kh.finalProject.employee.classManagement.model.vo.LessonPlan;
@Service
public class LessonPlanServiceImple  implements LessonPlanService{

	@Autowired
	LessonPlanDao lpd;
	
	@Autowired
	private SqlSessionTemplate sqlSession;

	@Override
	public void insertLessonPlan(LessonPlan lp) {
		lpd.insertLessonPlan(sqlSession, lp);	
	}

	@Override
	public List<LessonPlan> selectLessonPlanServiceList() {
		return lpd.selectLessonPlanServiceList(sqlSession);	
	}
	

}
