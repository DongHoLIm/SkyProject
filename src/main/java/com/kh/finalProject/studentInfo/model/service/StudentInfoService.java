package com.kh.finalProject.studentInfo.model.service;

import java.util.HashMap;

import com.kh.finalProject.studentInfo.model.vo.StudentInfo;

public interface StudentInfoService {

	StudentInfo basicInfo(String userId);

	StudentInfo stuInfo(String userId);

	

}
