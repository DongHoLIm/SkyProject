package com.kh.finalProject.professor.stuInfo.model.dao;

import java.util.ArrayList;

import org.mybatis.spring.SqlSessionTemplate;

import com.kh.finalProject.board.model.vo.PageInfo;
import com.kh.finalProject.professor.stuInfo.model.vo.stuInfoVo;

public interface stuInfoDao {

	int stuInfoListCount(SqlSessionTemplate sqlSession, String professorId);

	ArrayList<stuInfoVo> stuInfoList(SqlSessionTemplate sqlSession, String professorId, PageInfo pi);

}
