package com.kh.finalProject.professor.result.model.service;

import java.util.ArrayList;

import com.kh.finalProject.member.model.vo.Member;
import com.kh.finalProject.professor.result.model.vo.ProfessorResult;

public interface ProfessorResultService {

	ArrayList<ProfessorResult> subList(Member loginInfo);

}
