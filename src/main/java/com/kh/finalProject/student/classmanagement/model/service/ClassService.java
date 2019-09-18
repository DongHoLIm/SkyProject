package com.kh.finalProject.student.classmanagement.model.service;

import java.util.ArrayList;

import com.kh.finalProject.employee.classManagement.model.vo.OpenSubject;
import com.kh.finalProject.student.classmanagement.model.vo.Sdepartment;
import com.kh.finalProject.student.classmanagement.model.vo.SubjectApply;

public interface ClassService {

	ArrayList<Sdepartment> selectSdept();

	ArrayList<OpenSubject> selectOpenSubject();

	ArrayList<OpenSubject> selectSubject(OpenSubject os);

	ArrayList<OpenSubject> selectOpenSubject(OpenSubject os);

	ArrayList<OpenSubject> selectSearchgwamok(String gwamok);

	ArrayList<OpenSubject> selectProfessor(String professor);

	ArrayList<OpenSubject> selectProGwamok(OpenSubject os);

	void insertCourseApply(String[] subCode, SubjectApply sa);

	ArrayList<SubjectApply> selectMySugang(SubjectApply sa);

}
