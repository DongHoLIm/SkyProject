package com.kh.finalProject.lectureEvaluation.model.service;

import java.util.ArrayList;

import com.kh.finalProject.board.model.vo.PageInfo;
import com.kh.finalProject.lectureEvaluation.model.exception.LectureEvaluationSelectListException;
import com.kh.finalProject.lectureEvaluation.model.vo.LectureEvaluation;

public interface LectureEvaluationService {
	
	int getListCount() throws LectureEvaluationSelectListException;

	ArrayList<LectureEvaluation> selectLectureEvalOpenList(PageInfo pi) throws LectureEvaluationSelectListException;

	int stGetListCount(String studentNo) throws LectureEvaluationSelectListException;

	ArrayList<LectureEvaluation> stSelectLectureEvalOpenList(String studentNo) throws LectureEvaluationSelectListException;

	ArrayList<LectureEvaluation> questionList();


}
