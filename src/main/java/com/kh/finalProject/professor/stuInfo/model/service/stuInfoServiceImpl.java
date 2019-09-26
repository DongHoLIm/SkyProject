package com.kh.finalProject.professor.stuInfo.model.service;

import java.util.ArrayList;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.finalProject.board.model.vo.PageInfo;
import com.kh.finalProject.professor.stuInfo.model.dao.stuInfoDao;
import com.kh.finalProject.professor.stuInfo.model.vo.stuInfoVo;

@Service
public class stuInfoServiceImpl implements stuInfoService{
	@Autowired
	private stuInfoDao sd;
	@Autowired
	 private SqlSessionTemplate sqlSession;
	@Override
	public int stuInfoListCount(String professorId) {
		// TODO Auto-generated method stub
		return sd.stuInfoListCount(sqlSession,professorId);
	}
	@Override
	public ArrayList<stuInfoVo> stuInfoList(String professorId, PageInfo pi) {
		// TODO Auto-generated method stub
		return sd.stuInfoList(sqlSession, professorId,pi);
	}
	@Override
	public int ajaxSearchStuList(stuInfoVo sv) {
		// TODO Auto-generated method stub
		return sd.ajaxSearchStuList(sqlSession,sv);
	}
	@Override
	public ArrayList<stuInfoVo> searchStu(PageInfo pi, stuInfoVo sv) {
		// TODO Auto-generated method stub
		return sd.searchStu(sqlSession,sv,pi);
	}

}
