package com.kh.finalProject.proof.model.service;

import java.util.ArrayList;

import com.kh.finalProject.member.model.vo.Member;
import com.kh.finalProject.proof.model.vo.Proof;

public interface ProofService {

	ArrayList<Proof> selectProofList();

	int insertProofPrint(Proof pf);

	ArrayList<Proof> selectProofPrintList(Member loginUser);

	Proof selectProofInfo(Proof pf);

	int updatePrintStatus(Proof pf);

}
