package com.kh.finalProject.employee.classManagement.model.service;

import java.util.ArrayList;

import com.kh.finalProject.board.model.vo.PageInfo;
import com.kh.finalProject.employee.classManagement.exception.ClassManagementSelectListException;
import com.kh.finalProject.employee.classManagement.model.vo.LectureOpen;
import com.kh.finalProject.professor.model.vo.Professor;

public interface ClassManagementService {

	int getListCount();

	ArrayList<LectureOpen> selectnSubjectList(PageInfo pi) throws ClassManagementSelectListException;

	LectureOpen selectOneSubject(String subCode);

	ArrayList<Professor> selectProfessorList(String sdeptName);

}
