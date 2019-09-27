package com.kh.finalProject.professor.message.model.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.kh.finalProject.board.model.vo.PageInfo;
import com.kh.finalProject.employee.classManagement.exception.ClassManagementSelectListException;
import com.kh.finalProject.member.model.vo.Member;
import com.kh.finalProject.professor.message.model.vo.MessageVO;

@Repository
public class MessageDaoImpl implements MessageDao{


	@Override
	public List<MessageVO> selectmessageList(SqlSessionTemplate sqlSession, String memberId, PageInfo pi) throws ClassManagementSelectListException {
		
		ArrayList<MessageVO> list = null;

		int offset = (pi.getCurrentPage() - 1) * pi.getLimit();

		RowBounds rowBounds = new RowBounds(offset, pi.getLimit());

		list = (ArrayList) sqlSession.selectList("Message.selectMessageList", memberId, rowBounds);

		if(list == null) {
			sqlSession.close();
			throw new ClassManagementSelectListException("실패!");
		}
		return list;
	}

	@Override
	public List<MessageVO> selectsendMessageList(SqlSessionTemplate sqlSession, String memberId) {
		return sqlSession.selectList("Message.selectsendMessageList", memberId);
	}

	@Override
	public List<Member> selectMemberList(SqlSessionTemplate sqlSession) {
		return sqlSession.selectList("Message.selectMemberList");
	}

	@Override
	public int getListCount(SqlSessionTemplate sqlSession, String memberId) {
		
		return sqlSession.selectOne("Message.selectListCount", memberId);
	}

	@Override
	public void sendMessage(SqlSessionTemplate sqlSession, MessageVO messageVO) {
		sqlSession.selectOne("Message.sendMessage", messageVO);
		
	}
	

}