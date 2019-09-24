package com.kh.finalProject.enrollment.model.service;

import java.util.ArrayList;
import java.util.List;

import com.kh.finalProject.enrollment.model.exception.EnrollmentException;
import com.kh.finalProject.enrollment.model.vo.Enrollment;

public interface EnrollmentService {

	ArrayList<Enrollment> userEnrollment(String studentNo) throws EnrollmentException;

	List<Enrollment> beforeEnrollData(String studentNo) throws EnrollmentException;

	List<Enrollment> beforeEnrollmentData(Enrollment enrollment) throws EnrollmentException;
	
	//public List<Enrollment> getList();
}
