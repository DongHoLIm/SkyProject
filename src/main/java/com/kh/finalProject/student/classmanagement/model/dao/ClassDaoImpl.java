package com.kh.finalProject.student.classmanagement.model.dao;

import java.util.ArrayList;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.kh.finalProject.employee.classManagement.model.vo.LectureRegistration;
import com.kh.finalProject.employee.classManagement.model.vo.OpenSubject;
import com.kh.finalProject.student.classmanagement.model.vo.Sdepartment;
import com.kh.finalProject.student.classmanagement.model.vo.SubjectApply;

@Repository
public class ClassDaoImpl implements ClassDao{


	@Override
	public ArrayList<Sdepartment> selectSdept(SqlSessionTemplate sqlSession) {
		ArrayList<Sdepartment> sdList = null;

		sdList = (ArrayList) sqlSession.selectList("Sdepartment.selectSdept");

		return sdList;
	}

	@Override
	public ArrayList<OpenSubject> selectOpenSubject(SqlSessionTemplate sqlSession) {
		ArrayList<OpenSubject> osList = null;

		osList = (ArrayList) sqlSession.selectList("courseRegistration.selectOpenSubject");

		return osList;
	}

	@Override
	public ArrayList<OpenSubject> selectSubject(SqlSessionTemplate sqlSession, OpenSubject os) {
		ArrayList<OpenSubject> osList = null;

		if(os.getCompleteType().equals("ALL")) {
			osList = (ArrayList) sqlSession.selectList("courseRegistration.selectSubject1", os);
		}else {

			osList= (ArrayList) sqlSession.selectList("courseRegistration.selectSubject2", os);		
		}
		return osList;
	}

	@Override
	public ArrayList<OpenSubject> selectOpenSubject(SqlSessionTemplate sqlSession, OpenSubject os) {
		ArrayList<OpenSubject> list = null;


		list = (ArrayList) sqlSession.selectList("courseRegistration.studentSelectOpenSubject", os);

		return list;
	}

	@Override
	public ArrayList<OpenSubject> selectSearchgwamok(SqlSessionTemplate sqlSession, String gwamok) {
		ArrayList<OpenSubject> list = null;

		list = (ArrayList) sqlSession.selectList("courseRegistration.selectSearchGwamok", gwamok);

		System.out.println(list);
		return list;
	}

	@Override
	public ArrayList<OpenSubject> selectProfessor(SqlSessionTemplate sqlSession, String professor) {
		ArrayList<OpenSubject> list2 = null;

		list2 = (ArrayList) sqlSession.selectList("courseRegistration.selectSearchProfessor", professor);

		return list2;
	}

	@Override
	public ArrayList<OpenSubject> seletProGwamok(SqlSessionTemplate sqlSession, OpenSubject os) {
		ArrayList<OpenSubject> list = null;

		list = (ArrayList) sqlSession.selectList("courseRegistration.selectProGwamok", os);

		return list;
	}

	@Override
	public ArrayList<SubjectApply> selectMySugang(SqlSessionTemplate sqlSession, SubjectApply sa) {
		ArrayList<SubjectApply> list = null;

		list = (ArrayList) sqlSession.selectList("subjectApply.selectMySugang", sa);

		return list;
	}

	@Override
	public void insertCourseApply(SqlSessionTemplate sqlSession, String[] subCode, SubjectApply sa) {		
		for(int i=0; i<subCode.length;i++) {
			sa.setOpenSubCode(subCode[i]);
			sqlSession.insert("subjectApply.insertCourseApply", sa);
		}
	}

	@Override
	public ArrayList<OpenSubject> selectPreliminaryCourseApplyList(SqlSessionTemplate sqlSession, SubjectApply sa) {
		ArrayList<OpenSubject> list2 = null;
		OpenSubject os = new OpenSubject();
		os.setStudentNo(sa.getStudentNo());

		list2 = (ArrayList) sqlSession.selectList("courseRegistration.selectPreliminaryCourseApplyList", os);

		return list2;
	}

	@Override
	public ArrayList<OpenSubject> prliminaryGwamokSelect(SqlSessionTemplate sqlSession, OpenSubject os) {
		ArrayList<OpenSubject> list = null;

		list = (ArrayList) sqlSession.selectList("courseRegistration.prliminaryGwamokSelect", os);

		return list;
	}

	@Override
	public ArrayList<OpenSubject> prliminaryProfessorSelect(SqlSessionTemplate sqlSession, OpenSubject os) {
		ArrayList<OpenSubject> list = null;

		list = (ArrayList) sqlSession.selectList("courseRegistration.prliminaryProfessorSelect", os);

		return list;
	}
	@Override
	public ArrayList<OpenSubject> prliminaryCompleteSelect(SqlSessionTemplate sqlSession, OpenSubject os) {
		ArrayList<OpenSubject> list = null;

		list = (ArrayList) sqlSession.selectList("courseRegistration.prliminarySdeptSelect", os);

		return list;
	} 

	@Override
	public void deleteCourseApply(SqlSessionTemplate sqlSession, SubjectApply sa, String[] subCode) {
		
		for(int i=0; i<subCode.length;i++) {
			sa.setOpenSubCode(subCode[i]);
			sqlSession.delete("subjectApply.deleteCourseApply", sa);
		}
	}

	@Override
	public void insertFinishSubjectApply(SqlSessionTemplate sqlSession, String subCode, SubjectApply sa) {
		LectureRegistration lr = new LectureRegistration();
			sa.setOpenSubCode(subCode);
			lr.setOpenSubCode(subCode);
			sqlSession.insert("subjectApply.insertFinishSubjectApply", sa);
			sqlSession.update("LectureRegistration.updateStudentCount", lr);
		
	}

	@Override
	public ArrayList<OpenSubject> selectFinishSubjectApplyList(SqlSessionTemplate sqlSession, SubjectApply sa) {
		ArrayList<OpenSubject> list2 = null;
		OpenSubject os = new OpenSubject();
		os.setStudentNo(sa.getStudentNo());

		list2 = (ArrayList) sqlSession.selectList("courseRegistration.selectFinishSubjectApplyList", os);

		return list2;
	}

	@Override
	public int selectStudentCount(SqlSessionTemplate sqlSession, String subCode) {
		int result = 0;

		System.out.println("!!!!!");
		
		result = sqlSession.selectOne("courseRegistration.selectStudentCount", subCode);
		
		return result;
	}

	@Override
	public void updateFinishSubjectApply(SqlSessionTemplate sqlSession, SubjectApply sa) {
		LectureRegistration lr = new LectureRegistration();
		lr.setOpenSubCode(sa.getOpenSubCode());
		sqlSession.update("subjectApply.updateFinishSubjectApply", sa);
		sqlSession.update("LectureRegistration.updateStudentCount", lr);		
	}

	@Override
	public int selectSubGrade(SqlSessionTemplate sqlSession, SubjectApply sa) {
		OpenSubject os = new OpenSubject();
		os.setStudentNo(sa.getStudentNo());
		int result2 = 0;
		System.out.println("nn:::" + os.getStudentNo());
		result2 = sqlSession.selectOne("courseRegistration.selectSubGrade", os);
		System.out.println("result2" + result2);
		return result2;
	}

	@Override
	public ArrayList<OpenSubject> selectEnrolType(SqlSessionTemplate sqlSession) {
		ArrayList<OpenSubject> list2 = null;
		
		list2 = (ArrayList) sqlSession.selectList("courseRegistration.selectEnrolType");
		
		
		return list2;
	}
}
