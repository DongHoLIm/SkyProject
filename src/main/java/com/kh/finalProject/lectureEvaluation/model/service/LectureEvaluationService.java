package com.kh.finalProject.lectureEvaluation.model.service;

import java.util.ArrayList;

import com.kh.finalProject.board.model.vo.PageInfo;
import com.kh.finalProject.lectureEvaluation.model.exception.LectureEvaluationSelectListException;
import com.kh.finalProject.lectureEvaluation.model.vo.LectureEvaluation;

public interface LectureEvaluationService {

	int em_LectureEvalOpenListCount();

	ArrayList<LectureEvaluation> em_LectureEvalOpenList(PageInfo pi);

	int em_LectureEvaluationInsert(LectureEvaluation lev);

	int em_LectureEvalOpenListCount2();

	ArrayList<LectureEvaluation> em_LectureEvalOpenList2(PageInfo pi);

	


}
