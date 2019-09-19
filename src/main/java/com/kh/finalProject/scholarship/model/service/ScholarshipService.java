package com.kh.finalProject.scholarship.model.service;

import java.util.ArrayList;
import java.util.List;

import com.kh.finalProject.scholarship.model.exception.ScholarshipException;
import com.kh.finalProject.scholarship.model.vo.Scholarship;
import com.kh.finalProject.scholarship.model.vo.ScholarshipApply;

public interface ScholarshipService {

	List<Scholarship> beforeScholarshipData(Scholarship scholarship) throws ScholarshipException;
	
	ArrayList<Scholarship> userScholarship(String studentNo) throws ScholarshipException;

	ArrayList<Scholarship> userScholarshipApply(String studentNo) throws ScholarshipException;

	public void insertScholarship(Scholarship scholarship);

	List<Scholarship> beforeScholarData(String studentNo) throws ScholarshipException;
	

}
