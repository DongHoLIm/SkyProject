package com.kh.finalProject.enrollment.model.service;

import com.kh.finalProject.enrollment.model.exception.EnrollmentException;
import com.kh.finalProject.enrollment.model.vo.Enrollment;

public interface EnrollmentService {

	Enrollment userEnrollment(String studentNo) throws EnrollmentException;

}
