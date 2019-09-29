package com.kh.finalProject.employee.classManagement.model.dao;

import java.util.ArrayList;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.kh.finalProject.board.model.vo.PageInfo;
import com.kh.finalProject.employee.classManagement.exception.ClassManagementSelectListException;
import com.kh.finalProject.employee.classManagement.model.vo.ClassManagement;
import com.kh.finalProject.employee.classManagement.model.vo.ClassRoomInformation;
import com.kh.finalProject.employee.classManagement.model.vo.DepartmentProfessor;
import com.kh.finalProject.employee.classManagement.model.vo.Grade;
import com.kh.finalProject.employee.classManagement.model.vo.LectureOpen;
import com.kh.finalProject.employee.classManagement.model.vo.LectureRegistration;
import com.kh.finalProject.employee.classManagement.model.vo.OpenSubject;
import com.kh.finalProject.employee.classManagement.model.vo.SubApplyDone;
import com.kh.finalProject.employee.classManagement.model.vo.SubjectDelete;
import com.kh.finalProject.student.classmanagement.model.vo.SubjectApply;

@Repository
public class ClassManagementDaoImpl implements ClassManagementDao{

	@Override
	public int getListCount(SqlSessionTemplate sqlSession) {

		return sqlSession.selectOne("LectureOpen.selectListCount");
	}

	@Override
	public ArrayList<LectureOpen> selctSubjectList(SqlSessionTemplate sqlSession, PageInfo pi) throws ClassManagementSelectListException {

		ArrayList<LectureOpen> list = null;

		int offset = (pi.getCurrentPage() - 1) * pi.getLimit();

		RowBounds rowBounds = new RowBounds(offset, pi.getLimit());

		list = (ArrayList) sqlSession.selectList("LectureOpen.selectSubjectList", null, rowBounds);

		if(list == null) {
			sqlSession.close();
			throw new ClassManagementSelectListException("실패!");
		}

		return list;
	}


	@Override
	public LectureOpen seletOneSubject(SqlSessionTemplate sqlSession,String subCode) {
		System.out.println("Dao in!!!!");
		return sqlSession.selectOne("LectureOpen.selectOneSubject", subCode);
	}

	@Override
	public ArrayList<DepartmentProfessor> selectProfessorList(SqlSessionTemplate sqlSession, String sdeptName) throws ClassManagementSelectListException {

		ArrayList<DepartmentProfessor> list = null;
		System.out.println("proDao !!!!");

		System.out.println(sdeptName);
		list = (ArrayList) sqlSession.selectList("lectureprofessor.selectProfessorList", sdeptName);

		if(list == null) {
			sqlSession.close();
			throw new ClassManagementSelectListException("실패!");
		}

		System.out.println(list);

		return list;
	}

	@Override
	public ArrayList<ClassRoomInformation> selectClassRoomList(SqlSessionTemplate sqlSession) {
		ArrayList<ClassRoomInformation> list = null;


		list = (ArrayList) sqlSession.selectList("classroominformation.selectroomList");

		System.out.println("list::!!!" + list);
		return list;
	}



	@Override
	public int insertCourseOffered(SqlSessionTemplate sqlSession, LectureRegistration lr) {

		return sqlSession.insert("LectureRegistration.insertCouserOffered", lr);
	}

	@Override
	public int updateSubject(SqlSessionTemplate sqlSession, String subCode) {


		System.out.println("subCode");
		return sqlSession.update("LectureOpen.updateSubject", subCode);
	}

	@Override
	public ArrayList<OpenSubject> selectOpenSubjectList(SqlSessionTemplate sqlSession) {
		ArrayList<OpenSubject> list = null;

		list = (ArrayList) sqlSession.selectList("courseRegistration.selectOpenSubjectList");
		return list;
	}

	@Override
	public void updateOpenSubject(SqlSessionTemplate sqlSession, String[] subCode) {

		for(int i=0; i<subCode.length;i++) {
			OpenSubject os = new OpenSubject();
			os.setOpenSubCode(subCode[i]);
			sqlSession.update("courseRegistration.updateOpenSubject", os);

		}
	}

	@Override
	public ArrayList<OpenSubject> selectPreliminaryOpenSubjectList(SqlSessionTemplate sqlSession) {
		ArrayList<OpenSubject> list = null;

		list = (ArrayList) sqlSession.selectList("courseRegistration.selectPreliminaryOpenSubjectList");
		return list;
	}

	@Override
	public void updateFinishOpenSubject(SqlSessionTemplate sqlSession, String[] subCode) {
		for(int i=0; i<subCode.length;i++) {
			OpenSubject os = new OpenSubject();
			os.setOpenSubCode(subCode[i]);
			sqlSession.update("courseRegistration.updateFinishOpenSubject", os);

		}
	}

	@Override
	public ArrayList<OpenSubject> selectFinishOpenSubjectList(SqlSessionTemplate sqlSession) {
		ArrayList<OpenSubject> list = null;

		list = (ArrayList) sqlSession.selectList("courseRegistration.selectFinishOpenSubjectList");

		return list;
	}

	@Override
	public void updateCloseFinishOpenSubject(SqlSessionTemplate sqlSession, String[] subCode) {
		for(int i=0;i<subCode.length;i++) {
			OpenSubject os = new OpenSubject();
			os.setOpenSubCode(subCode[i]);
			sqlSession.update("courseRegistration.updateCloseFinishOpenSubject", os);
		}

	}

	@Override
	public void updateSubjectApply(SqlSessionTemplate sqlSession) {

		sqlSession.update("subjectApply.updateDoneType");

	}

	@Override
	public ArrayList<SubjectApply> selectUpdateList(SqlSessionTemplate sqlSession) {
		ArrayList<SubjectApply> list = null;

		list = (ArrayList) sqlSession.selectList("subjectApply.selectUpdateList");
		return list;
	}

	@Override
	public void insertSubApplyDone(SqlSessionTemplate sqlSession, String[] code) {
		for(int i=0;i<code.length;i++) {
			SubjectApply sa = new SubjectApply();
			sa.setSubApplyCode(code[i]);

			sqlSession.insert("SubApplyDone.insertSubApplyDone", sa);
		}

	}

	@Override
	public void deleteCloseSubjectApply(SqlSessionTemplate sqlSession) {

		sqlSession.delete("subjectApply.deleteCloseSubjectApply");
	}

	@Override
	public ArrayList<LectureOpen> selectsubjectAbolitionList(SqlSessionTemplate sqlSession, PageInfo pi) throws ClassManagementSelectListException {
		ArrayList<LectureOpen> list = null;

		int offset = (pi.getCurrentPage() - 1) * pi.getLimit();

		RowBounds rowBounds = new RowBounds(offset, pi.getLimit());

		list = (ArrayList) sqlSession.selectList("LectureOpen.selectsubjectAbolitionList", null, rowBounds);

		if(list == null) {
			sqlSession.close();
			throw new ClassManagementSelectListException("실패!");
		}

		return list;
	}

	@Override
	public OpenSubject selectOneOpenSubject(SqlSessionTemplate sqlSession, String subCode) {


		return sqlSession.selectOne("courseRegistration.selectOneOpenSubject", subCode);
	}

	@Override
	public void insertSubjectDelete(SqlSessionTemplate sqlSession, SubjectDelete sd, OpenSubject os) {
		LectureOpen lo = new LectureOpen();
		SubjectApply sa = new SubjectApply();
		ArrayList<SubjectApply> list = null;

		if(os != null) {
			sqlSession.insert("SubjectDelete.insertSubjectDelete", sd);
			System.out.println("!!!!!!!");
			lo.setSubCode(sd.getSubCode());
			sqlSession.update("LectureOpen.updateSubjectDelete", lo);
			System.out.println("??????");
			os.setCloseReason(sd.getReason());
			System.out.println("os:::" + os);
			sqlSession.update("courseRegistration.updateSubjectDelete", os);
			System.out.println("AAAAAAAA");
			sa.setOpenSubCode(os.getOpenSubCode());
			list = (ArrayList) sqlSession.selectList("subjectApply.selectList", sa);
			System.out.println("list:::" + list);
			if(list.size() >= 1) {
				System.out.println("in!!!>>>>");
				sqlSession.delete("subjectApply.updateSubjectDelete", sa);				
			}
		}else {
			lo.setSubCode(sd.getSubCode());
			sqlSession.insert("SubjectDelete.insertSubjectDelete", sd);
			sqlSession.update("LectureOpen.updateSubjectDelete", lo);			
		}
	}

	@Override
	public ArrayList<OpenSubject> selectOpenSubjectList2(SqlSessionTemplate sqlSession, PageInfo pi) throws ClassManagementSelectListException {
		ArrayList<OpenSubject> list = null;
		int offset = (pi.getCurrentPage() - 1) * pi.getLimit();
		RowBounds rowBounds = new RowBounds(offset, pi.getLimit());

		list = (ArrayList) sqlSession.selectList("courseRegistration.selectOpenSubjectList2", null, rowBounds);
		
		if(list == null) {
			sqlSession.close();
			throw new ClassManagementSelectListException("실패!");
		}

		return list;
	}
	

	@Override
	public int getListCount2(SqlSessionTemplate sqlSession) {
		
		return sqlSession.selectOne("LectureOpen.selectListCount2");
	}

	@Override
	public int getListCount3(SqlSessionTemplate sqlSession) {
		
		return sqlSession.selectOne("LectureOpen.selectListCount3");
	}

	@Override
	public int getListCount4(SqlSessionTemplate sqlSession) {
		
		return sqlSession.selectOne("LectureOpen.selectListCount4");
	}

	@Override
	public ArrayList<LectureOpen> selectAbolitiontList(SqlSessionTemplate sqlSession, PageInfo pi) throws ClassManagementSelectListException {
		ArrayList<LectureOpen> list = null;
		int offset = (pi.getCurrentPage() - 1) * pi.getLimit();
		RowBounds rowBounds = new RowBounds(offset, pi.getLimit());

		list = (ArrayList) sqlSession.selectList("LectureOpen.selectAbolitiontList", null, rowBounds);
		
		if(list == null) {
			sqlSession.close();
			throw new ClassManagementSelectListException("실패!");
		}

		return list;
	}

	@Override
	public int insertLectureEvaluation(SqlSessionTemplate sqlSession, LectureRegistration lr) {
		return sqlSession.insert("LectureOpen.insertLectureEvaluation", lr);
	}

	@Override
	public void insertClassManagement(SqlSessionTemplate sqlSession, String[] acCode, String[] studentNo) {
		for(int i=0;i<acCode.length;i++) {
			ClassManagement cm = new ClassManagement();
			cm.setDoneCode(acCode[i]);
			cm.setStudentNo(studentNo[i]);
			sqlSession.insert("ClassManagement.insertClassManagement", cm);
		
		}
	}

	@Override
	public ArrayList<SubApplyDone> selectSubApplyDone(SqlSessionTemplate sqlSession) {
		ArrayList<SubApplyDone> list2 = null;
		
		list2 = (ArrayList) sqlSession.selectList("SubApplyDone.selectList");
		
		return list2;
	}

	@Override
	public ArrayList<ClassManagement> selectClassManagementList(SqlSessionTemplate sqlSession) {
		ArrayList<ClassManagement> list3 = null;
		
		list3 = (ArrayList) sqlSession.selectList("ClassManagement.selectClassManagement");
		
		return list3;
	}

	@Override
	public void insertGrade(SqlSessionTemplate sqlSession, String[] classCode, String[] studentNo) {
		for(int i=0;i<classCode.length;i++) {
			Grade g = new Grade();
			g.setClassCode(classCode[i]);
			System.out.println("classCode::::" + classCode[i]);
			g.setStudentNo(studentNo[i]);
			
			sqlSession.insert("Grade.insertGrade", g);
		}
		
	}



}
