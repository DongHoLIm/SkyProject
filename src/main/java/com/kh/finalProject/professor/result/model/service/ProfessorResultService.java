package com.kh.finalProject.professor.result.model.service;

import java.util.ArrayList;

import com.kh.finalProject.member.model.vo.Member;
import com.kh.finalProject.professor.result.model.vo.ProfessorResult;
import com.kh.finalProject.professor.result.model.vo.StudentResult;
import com.kh.finalProject.professor.result.model.vo.SubjectScheduler;

public interface ProfessorResultService {

	ArrayList<ProfessorResult> subList(Member loginInfo);

	ArrayList<StudentResult> studentList(String opensubCode);

	SubjectScheduler subSch(String opensubCode);

	int resultInsertStu(StudentResult sr);

}
