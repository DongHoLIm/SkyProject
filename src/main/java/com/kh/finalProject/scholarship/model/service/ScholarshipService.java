package com.kh.finalProject.scholarship.model.service;

import java.util.ArrayList;

import com.kh.finalProject.scholarship.model.exception.ScholarshipException;
import com.kh.finalProject.scholarship.model.vo.Scholarship;
import com.kh.finalProject.scholarship.model.vo.ScholarshipApply;

public interface ScholarshipService {

	ArrayList<Scholarship> beforeScholarshipData(String studentNo) throws ScholarshipException;
	
	ArrayList<Scholarship> userScholarship(String studentNo) throws ScholarshipException;

	ArrayList<Scholarship> userScholarshipApply(String studentNo) throws ScholarshipException;

	public void insertScholarship(Scholarship scholarship);
	

}
