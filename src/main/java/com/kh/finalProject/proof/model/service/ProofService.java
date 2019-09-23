package com.kh.finalProject.proof.model.service;

import java.util.ArrayList;

import com.kh.finalProject.proof.model.vo.Proof;

public interface ProofService {

	ArrayList<Proof> selectProofList();

	int insertProofPrint(Proof pf);

}
