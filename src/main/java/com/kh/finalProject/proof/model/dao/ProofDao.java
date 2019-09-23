package com.kh.finalProject.proof.model.dao;

import java.util.ArrayList;

import org.mybatis.spring.SqlSessionTemplate;

import com.kh.finalProject.proof.model.vo.Proof;

public interface ProofDao {

	ArrayList<Proof> selectProofList(SqlSessionTemplate sqlSession);

	int insertProofPint(SqlSessionTemplate sqlSession, Proof pf);

}
