package com.kh.finalProject.dormitory.model.service;

import java.util.ArrayList;
import java.util.List;

import com.kh.finalProject.dormitory.model.exception.DormitoryException;
import com.kh.finalProject.dormitory.model.vo.Dormitory;

public interface DormitoryService {

	ArrayList<Dormitory> userDormitory(String studentNo) throws DormitoryException;
	
	public void insertDormitory(Dormitory dormitory);

	List<Dormitory> beforeDormitoryData() throws DormitoryException;

	List<Dormitory> beforeDormData(Dormitory dor) throws DormitoryException;

	ArrayList<Dormitory> empDormitory() throws DormitoryException;
}
