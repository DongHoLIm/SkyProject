package com.kh.finalProject.student.classmanagement.model.service;

import java.util.ArrayList;

import com.kh.finalProject.employee.classManagement.model.vo.OpenSubject;
import com.kh.finalProject.student.classmanagement.model.vo.Sdepartment;

public interface ClassService {

	ArrayList<Sdepartment> selectSdept();

	ArrayList<OpenSubject> selectOpenSubject();

	ArrayList<OpenSubject> selectSubject(OpenSubject os);

	ArrayList<OpenSubject> selectOpenSubject(OpenSubject os);

	ArrayList<OpenSubject> selectSearchgwamok(String gwamok);

	ArrayList<OpenSubject> selectProfessor(String professor);

	ArrayList<OpenSubject> selectProGwamok(OpenSubject os);

}
