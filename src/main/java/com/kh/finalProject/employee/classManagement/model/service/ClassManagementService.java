package com.kh.finalProject.employee.classManagement.model.service;

import java.util.ArrayList;

import com.kh.finalProject.board.model.vo.PageInfo;
import com.kh.finalProject.employee.classManagement.exception.ClassManagementSelectListException;
import com.kh.finalProject.employee.classManagement.model.vo.ClassRoomInformation;
import com.kh.finalProject.employee.classManagement.model.vo.DepartmentProfessor;
import com.kh.finalProject.employee.classManagement.model.vo.LectureOpen;
import com.kh.finalProject.employee.classManagement.model.vo.LectureRegistration;
import com.kh.finalProject.employee.classManagement.model.vo.OpenSubject;
import com.kh.finalProject.employee.classManagement.model.vo.SubjectDelete;
import com.kh.finalProject.student.classmanagement.model.vo.SubjectApply;

public interface ClassManagementService {

	int getListCount();

	ArrayList<LectureOpen> selectnSubjectList(PageInfo pi) throws ClassManagementSelectListException;

	LectureOpen selectOneSubject(String subCode);

	ArrayList<DepartmentProfessor> selectProfessorList(String sdeptName) throws ClassManagementSelectListException;

	ArrayList<ClassRoomInformation> selectClassRoomList();

	int insertCourseOffered(LectureRegistration lr);

	int updateSubject(String openSubCode);

	ArrayList<OpenSubject> selectOpenSubjectList();

	void updateOpenSubject(String[] subCode);

	ArrayList<OpenSubject> selectPreliminaryOpenSubjectList();

	void updateFinishOpenSubject(String[] subCode);

	ArrayList<OpenSubject> selectFinishOpenSubjectList();

	void closeFinishOpenSubject(String[] subCode);

	void updateSubjectApply();

	ArrayList<SubjectApply> selectUpdateList();

	void insertSubApplyDone(String[] code);

	void deleteCloseSubjectApply();

	ArrayList<LectureOpen> selectsubjectAbolitionList(PageInfo pi) throws ClassManagementSelectListException;

	OpenSubject selectOneOpenSubject(String subCode);

	void insertSubjectDelete(SubjectDelete sd, OpenSubject os);

}
