package com.kh.finalProject.professor.sendSMS.model.dao;

import java.util.ArrayList;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.kh.finalProject.board.model.vo.PageInfo;
import com.kh.finalProject.member.model.vo.Member;
import com.kh.finalProject.professor.sendSMS.model.vo.SendSMSList;
import com.kh.finalProject.professor.sendSMS.model.vo.StudentList;
import com.kh.finalProject.professor.sendSMS.model.vo.professorSubjectList;

@Repository
public class professorDaoImpl implements professorDao{

	@Override
	public int studentList(SqlSessionTemplate sqlSession) {
		int listCount =sqlSession.selectOne("professorSendSMS.studentListCount");
		return listCount;
	}

	@Override
	public ArrayList<StudentList> studentPageList(SqlSessionTemplate sqlSession, PageInfo pi) {
		ArrayList<StudentList> list = null;
		int offset = (pi.getCurrentPage() - 1) * pi.getLimit();
		
		RowBounds rowBounds = new RowBounds(offset, pi.getLimit());
		
		list = (ArrayList)sqlSession.selectList("professorSendSMS.studentList","",rowBounds);
		return list;
	}

	@Override
	public int insertSMS(SqlSessionTemplate sqlSession, StudentList sl) {
		// TODO Auto-generated method stub
		return sqlSession.insert("professorSendSMS.insertSMS",sl);
	}

	@Override
	public ArrayList<SendSMSList> sendSMSList(SqlSessionTemplate sqlSession, SendSMSList list,PageInfo pi) {
		int offset = (pi.getCurrentPage() - 1) * pi.getLimit();
		
		RowBounds rowBounds = new RowBounds(offset, pi.getLimit());
		
		ArrayList<SendSMSList> SMSList =(ArrayList) sqlSession.selectList("professorSendSMS.sendSMSList", list,rowBounds);		
		return SMSList;
	}

	@Override
	public ArrayList<StudentList> SendSMSDetail(SqlSessionTemplate sqlSession, SendSMSList sl) {
		ArrayList<StudentList> list = (ArrayList) sqlSession.selectList("professorSendSMS.sendSMSDetail", sl);
		
		return list;
	}

	@Override
	public int sendSMSListCount(SqlSessionTemplate sqlSession, SendSMSList list) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("professorSendSMS.sendSMSListCount",list);
	}

	@Override
	public ArrayList<professorSubjectList> professorSubList(SqlSessionTemplate sqlSession, Member loginUser) {
		 ArrayList<professorSubjectList> list =(ArrayList) sqlSession.selectList("professorSendSMS.professorSubList",loginUser);
		return list;
	}

	@Override
	public int searchStuListSMSCount(SqlSessionTemplate sqlSession, professorSubjectList psl) {
		int listCount = sqlSession.selectOne("professorSendSMS.searchStuListSMSCount", psl);
		return listCount;
	}

	@Override
	public ArrayList<StudentList> searchStuListSMS(SqlSessionTemplate sqlSession, PageInfo pi,
			professorSubjectList psl) {
		int offset = (pi.getCurrentPage() - 1) * pi.getLimit();
		
		RowBounds rowBounds = new RowBounds(offset, pi.getLimit());
		ArrayList<StudentList> list = (ArrayList)sqlSession.selectList("professorSendSMS.searchStuListSMS", psl,rowBounds);
		return list;
	}

	
}
