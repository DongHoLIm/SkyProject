package com.kh.finalProject.reply.model.dao;

import java.util.ArrayList;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.kh.finalProject.board.model.vo.PageInfo;
import com.kh.finalProject.reply.model.vo.Reply;

@Repository
public class ReplyDaoImpl implements ReplyDao {

	@Override
	public int insertFreeBoardRP(SqlSessionTemplate sqlSession, Reply rp) {
		return sqlSession.insert("Reply.insertFreeBoardRP", rp);
	}

	@Override
	public int selectFreeBoardRPListCount(SqlSessionTemplate sqlSession, int boardNo) {
		return sqlSession.selectOne("Reply.selectFreeBoardRPListCount", boardNo);
	}

	@Override
	public ArrayList<Reply> selectFreeBoardRPListCount(SqlSessionTemplate sqlSession, PageInfo pi, int boardNo) {
		ArrayList<Reply> list = null;
		
		int offset = (pi.getCurrentPage() - 1) * pi.getLimit();
		
		RowBounds rowBounds = new RowBounds(offset, pi.getLimit());
		
		list = (ArrayList) sqlSession.selectList("Reply.selectFreeBoardRPList", boardNo, rowBounds);
		
		
		return list;
	}

	@Override
	public int deleteFreeBoardRP(SqlSessionTemplate sqlSession, Reply rp) {
		return sqlSession.update("Reply.deleteFreeBoardRP", rp);
	}

	@Override
	public int updateFreeBoardRP(SqlSessionTemplate sqlSession, Reply rp) {
		return sqlSession.update("Reply.updateFreeBoardRP", rp);
	}
	

}
