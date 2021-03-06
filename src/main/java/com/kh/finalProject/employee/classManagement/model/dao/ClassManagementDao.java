package com.kh.finalProject.employee.classManagement.model.dao;

import java.util.ArrayList;

import org.mybatis.spring.SqlSessionTemplate;

import com.kh.finalProject.board.model.vo.PageInfo;
import com.kh.finalProject.employee.classManagement.exception.ClassManagementSelectListException;
import com.kh.finalProject.employee.classManagement.model.vo.ClassManagement;
import com.kh.finalProject.employee.classManagement.model.vo.ClassRoomInformation;
import com.kh.finalProject.employee.classManagement.model.vo.DepartmentProfessor;
import com.kh.finalProject.employee.classManagement.model.vo.LectureOpen;
import com.kh.finalProject.employee.classManagement.model.vo.LectureRegistration;
import com.kh.finalProject.employee.classManagement.model.vo.OpenSubject;
import com.kh.finalProject.employee.classManagement.model.vo.SubApplyDone;
import com.kh.finalProject.employee.classManagement.model.vo.SubjectDelete;
import com.kh.finalProject.student.classmanagement.model.vo.SubjectApply;

public interface ClassManagementDao {

	int getListCount(SqlSessionTemplate sqlSession);

	ArrayList<LectureOpen> selctSubjectList(SqlSessionTemplate sqlSession, PageInfo pi) throws ClassManagementSelectListException;

	LectureOpen seletOneSubject(SqlSessionTemplate sqlSession, String subCode);

	ArrayList<DepartmentProfessor> selectProfessorList(SqlSessionTemplate sqlSession, String sdeptName) throws ClassManagementSelectListException;

	ArrayList<ClassRoomInformation> selectClassRoomList(SqlSessionTemplate sqlSession);

	int insertCourseOffered(SqlSessionTemplate sqlSession, LectureRegistration lr);

	int updateSubject(SqlSessionTemplate sqlSession, String subCode);

	ArrayList<OpenSubject> selectOpenSubjectList(SqlSessionTemplate sqlSession);

	void updateOpenSubject(SqlSessionTemplate sqlSession, String[] subCode);

	ArrayList<OpenSubject> selectPreliminaryOpenSubjectList(SqlSessionTemplate sqlSession);

	void updateFinishOpenSubject(SqlSessionTemplate sqlSession, String[] subCode);

	ArrayList<OpenSubject> selectFinishOpenSubjectList(SqlSessionTemplate sqlSession);

	void updateCloseFinishOpenSubject(SqlSessionTemplate sqlSession, String[] subCode);

	void updateSubjectApply(SqlSessionTemplate sqlSession);

	ArrayList<SubjectApply> selectUpdateList(SqlSessionTemplate sqlSession);

	void insertSubApplyDone(SqlSessionTemplate sqlSession, String[] code);

	void deleteCloseSubjectApply(SqlSessionTemplate sqlSession);

	ArrayList<LectureOpen> selectsubjectAbolitionList(SqlSessionTemplate sqlSession, PageInfo pi) throws ClassManagementSelectListException;

	OpenSubject selectOneOpenSubject(SqlSessionTemplate sqlSession, String subCode);

	void insertSubjectDelete(SqlSessionTemplate sqlSession, SubjectDelete sd, OpenSubject os);

	ArrayList<OpenSubject> selectOpenSubjectList2(SqlSessionTemplate sqlSession, PageInfo pi) throws ClassManagementSelectListException;

	int getListCount2(SqlSessionTemplate sqlSession);

	int getListCount3(SqlSessionTemplate sqlSession);

	int getListCount4(SqlSessionTemplate sqlSession);

	ArrayList<LectureOpen> selectAbolitiontList(SqlSessionTemplate sqlSession, PageInfo pi) throws ClassManagementSelectListException;

	int insertLectureEvaluation(SqlSessionTemplate sqlSession, LectureRegistration lr);

	void insertClassManagement(SqlSessionTemplate sqlSession, String[] acCode, String[] studentNo);

	ArrayList<SubApplyDone> selectSubApplyDone(SqlSessionTemplate sqlSession);

	ArrayList<ClassManagement> selectClassManagementList(SqlSessionTemplate sqlSession);

	void insertGrade(SqlSessionTemplate sqlSession, String[] classCode, String[] studentNo);

}
