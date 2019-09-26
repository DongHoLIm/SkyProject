package com.kh.finalProject.professor.stuInfo.model.service;

import java.util.ArrayList;

import com.kh.finalProject.board.model.vo.PageInfo;
import com.kh.finalProject.professor.stuInfo.model.vo.stuInfoVo;

public interface stuInfoService {

	int stuInfoListCount(String professorId);

	ArrayList<stuInfoVo> stuInfoList(String professorId, PageInfo pi);

}
