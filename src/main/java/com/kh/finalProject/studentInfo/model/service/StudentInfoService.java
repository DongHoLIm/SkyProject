package com.kh.finalProject.studentInfo.model.service;

import java.util.ArrayList;
import java.util.HashMap;

import com.kh.finalProject.board.model.vo.PageInfo;
import com.kh.finalProject.studentInfo.model.exception.StudentInfoSelectListException;
import com.kh.finalProject.studentInfo.model.vo.FilterCondition;
import com.kh.finalProject.studentInfo.model.vo.StudentInfo;

public interface StudentInfoService {

	StudentInfo basicInfo(String userId);

	StudentInfo stuInfo(String userId);

	int getListCount() throws StudentInfoSelectListException;

	ArrayList<StudentInfo> selectStudentList(PageInfo pi) throws StudentInfoSelectListException;

	int getFilterListCount(FilterCondition fc) throws StudentInfoSelectListException;

	

}
