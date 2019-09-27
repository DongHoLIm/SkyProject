package com.kh.finalProject.professor.stuInfo.model.dao;

import java.util.ArrayList;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.kh.finalProject.board.model.vo.PageInfo;
import com.kh.finalProject.professor.stuInfo.model.vo.stuInfoVo;

@Repository
public class stuInfoDaoImpl implements stuInfoDao{

	@Override
	public int stuInfoListCount(SqlSessionTemplate sqlSession, String professorId) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("stuInfoPro.stuInfoListCount",professorId);
	}

	@Override
	public ArrayList<stuInfoVo> stuInfoList(SqlSessionTemplate sqlSession, String professorId, PageInfo pi) {
		int offset = (pi.getCurrentPage() - 1) * pi.getLimit();
		
		RowBounds rowBounds = new RowBounds(offset, pi.getLimit());
		
		ArrayList<stuInfoVo> list = (ArrayList) sqlSession.selectList("stuInfoPro.stuInfoList", professorId, rowBounds);
		
		return list;
	}

	@Override
	public int ajaxSearchStuList(SqlSessionTemplate sqlSession, stuInfoVo sv) {
		
		return sqlSession.selectOne("stuInfoPro.searchStuListCount",sv);
	}

	@Override
	public ArrayList<stuInfoVo> searchStu(SqlSessionTemplate sqlSession, stuInfoVo sv, PageInfo pi) {
		int offset = (pi.getCurrentPage() - 1) * pi.getLimit();
		
		RowBounds rowBounds = new RowBounds(offset, pi.getLimit());
		ArrayList<stuInfoVo> list = (ArrayList) sqlSession.selectList("stuInfoPro.searchStuList", sv, rowBounds);
		return list;
	}

}
