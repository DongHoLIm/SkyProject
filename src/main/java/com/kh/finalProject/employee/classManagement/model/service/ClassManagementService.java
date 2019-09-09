package com.kh.finalProject.employee.classManagement.model.service;

import java.util.ArrayList;

import com.kh.finalProject.board.model.vo.PageInfo;
import com.kh.finalProject.employee.classManagement.exception.ClassManagementSelectListException;
import com.kh.finalProject.employee.classManagement.model.vo.DepartmentProfessor;
import com.kh.finalProject.employee.classManagement.model.vo.LectureOpen;

public interface ClassManagementService {

	int getListCount();

	ArrayList<LectureOpen> selectnSubjectList(PageInfo pi) throws ClassManagementSelectListException;

	LectureOpen selectOneSubject(String subCode);

	ArrayList<DepartmentProfessor> selectProfessorList(String sdeptName);

}
