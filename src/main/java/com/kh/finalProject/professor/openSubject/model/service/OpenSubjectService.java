package com.kh.finalProject.professor.openSubject.model.service;

import java.util.List;

import com.kh.finalProject.employee.classManagement.model.vo.LessonPlan;
import com.kh.finalProject.professor.openSubject.model.vo.OpenSubject;

public interface OpenSubjectService {

	List<OpenSubject> selectOpenSubjectList();

	OpenSubject selectOneSubject(String subCode);

}
