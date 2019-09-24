package com.kh.finalProject.employee.classManagement.model.service;


import java.util.List;

import com.kh.finalProject.employee.classManagement.model.vo.LessonPlan;

public interface LessonPlanService {


	void insertLessonPlan(LessonPlan lp);

	List<LessonPlan> selectLessonPlanServiceList();
	
}
