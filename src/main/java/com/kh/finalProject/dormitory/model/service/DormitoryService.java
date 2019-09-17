package com.kh.finalProject.dormitory.model.service;

import java.util.ArrayList;

import com.kh.finalProject.dormitory.model.exception.DormitoryException;
import com.kh.finalProject.dormitory.model.vo.Dormitory;

public interface DormitoryService {

	ArrayList<Dormitory> userDormitory(String studentNo) throws DormitoryException;
	
	public void insertDormitory(Dormitory dormitory);
}
