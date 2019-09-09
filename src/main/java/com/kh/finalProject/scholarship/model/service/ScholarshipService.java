package com.kh.finalProject.scholarship.model.service;

import java.util.ArrayList;

import com.kh.finalProject.scholarship.model.exception.ScholarshipException;
import com.kh.finalProject.scholarship.model.vo.Scholarship;

public interface ScholarshipService {

	ArrayList<Scholarship> userScholarship(String studentNo) throws ScholarshipException;

}
