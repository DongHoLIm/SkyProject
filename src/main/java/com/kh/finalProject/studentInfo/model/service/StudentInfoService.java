package com.kh.finalProject.studentInfo.model.service;

import java.util.HashMap;

import com.kh.finalProject.studentInfo.model.vo.StudentInfo;

public interface StudentInfoService {

	HashMap<String, StudentInfo> studentInfo(String userId);

	

}
