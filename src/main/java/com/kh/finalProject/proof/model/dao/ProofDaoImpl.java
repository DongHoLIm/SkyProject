package com.kh.finalProject.proof.model.dao;

import java.util.ArrayList;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.kh.finalProject.proof.model.vo.Proof;

@Repository
public class ProofDaoImpl implements ProofDao{

	@Override
	public ArrayList<Proof> selectProofList(SqlSessionTemplate sqlSession) {
		return (ArrayList) sqlSession.selectList("Proof.selectProofList");
	}

	@Override
	public int insertProofPint(SqlSessionTemplate sqlSession, Proof pf) {
		return sqlSession.insert("Proof.insertProofPrint");
	}
	
}
