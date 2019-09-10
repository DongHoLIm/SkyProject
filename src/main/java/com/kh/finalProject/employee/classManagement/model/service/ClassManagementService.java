package com.kh.finalProject.employee.classManagement.model.service;

import java.util.ArrayList;

import com.kh.finalProject.board.model.vo.PageInfo;
import com.kh.finalProject.employee.classManagement.exception.ClassManagementSelectListException;
import com.kh.finalProject.employee.classManagement.model.vo.ClassRoomInformation;
import com.kh.finalProject.employee.classManagement.model.vo.DepartmentProfessor;
import com.kh.finalProject.employee.classManagement.model.vo.LectureOpen;
import com.kh.finalProject.employee.classManagement.model.vo.LectureRegistration;

public interface ClassManagementService {

	int getListCount();

	ArrayList<LectureOpen> selectnSubjectList(PageInfo pi) throws ClassManagementSelectListException;

	LectureOpen selectOneSubject(String subCode);

	ArrayList<DepartmentProfessor> selectProfessorList(String sdeptName);

	ArrayList<ClassRoomInformation> selectClassRoomList();

	int insertCourseOffered(LectureRegistration lr);

}
