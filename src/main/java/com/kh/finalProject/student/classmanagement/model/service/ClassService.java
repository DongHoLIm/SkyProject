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

	ArrayList<OpenSubject> selectPreliminaryCourseApplyList(SubjectApply sa);

	ArrayList<OpenSubject> prliminaryGwamokSelect(OpenSubject os);

	ArrayList<OpenSubject> prliminaryProfessorSelect(OpenSubject os);

	ArrayList<OpenSubject> prliminaryCompleteSelect(OpenSubject os);

	void deleteCourseApply(String[] subCode, SubjectApply sa);

	void insertFinishSubjectApply(String subCode, SubjectApply sa);

	ArrayList<OpenSubject> selectFinishSubjectApplyList(SubjectApply sa);

	int selectStudentCount(String subCode);

	void updateFinishSubjectApply(SubjectApply sa);

	int selectSubGrade(SubjectApply sa);

	ArrayList<OpenSubject> selectEnrolType();

}
