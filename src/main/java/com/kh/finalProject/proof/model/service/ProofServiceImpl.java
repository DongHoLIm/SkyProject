package com.kh.finalProject.proof.model.service;

import java.util.ArrayList;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.finalProject.proof.model.dao.ProofDao;
import com.kh.finalProject.proof.model.vo.Proof;


@Service
public class ProofServiceImpl implements ProofService{
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Autowired
	private ProofDao pd;

	@Override
	public ArrayList<Proof> selectProofList() {
		return pd.selectProofList(sqlSession);
	}

	@Override
	public int insertProofPrint(Proof pf) {
		return pd.insertProofPint(sqlSession, pf);
	}
}
