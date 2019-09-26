package com.kh.finalProject.studentInfo.model.dao;

import java.util.ArrayList;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.kh.finalProject.board.model.vo.Board;
import com.kh.finalProject.board.model.vo.PageInfo;
import com.kh.finalProject.board.model.vo.SearchCondition;
import com.kh.finalProject.member.model.vo.Member;
import com.kh.finalProject.studentInfo.model.exception.StudentInfoSelectListException;
import com.kh.finalProject.studentInfo.model.vo.ChangeMajor;
import com.kh.finalProject.studentInfo.model.vo.DropOut;
import com.kh.finalProject.studentInfo.model.vo.Explusion;
import com.kh.finalProject.studentInfo.model.vo.FilterCondition;
import com.kh.finalProject.studentInfo.model.vo.SecondMajor;
import com.kh.finalProject.studentInfo.model.vo.Graduation;
import com.kh.finalProject.studentInfo.model.vo.SchoolOff;
import com.kh.finalProject.studentInfo.model.vo.StudentInfo;

@Repository
public class StudentInfoDaoImpl implements StudentInfoDao{

	@Override
	public StudentInfo basicInfo(SqlSessionTemplate sqlSession, String studentNo) {
		
		return sqlSession.selectOne("StudentInfo.selectBasicInfo", studentNo);
	}

	@Override
	public StudentInfo stuInfo(SqlSessionTemplate sqlSession, String studentNo) {
		
		return sqlSession.selectOne("StudentInfo.selectStuInfo", studentNo);
	}

	@Override
	public int getListCount(SqlSessionTemplate sqlSession) throws StudentInfoSelectListException {
		
		int listCount = sqlSession.selectOne("StudentInfo.selectListCount");
		
		if(listCount <= 0) {
			sqlSession.close();
			throw new StudentInfoSelectListException("학생리스트 카운트 실패");
		}
		
		return listCount;
	}

	@Override
	public ArrayList<StudentInfo> selectStudentList(SqlSessionTemplate sqlSession, PageInfo pi) throws StudentInfoSelectListException {
		ArrayList<StudentInfo> list = null;
		
		int offset = (pi.getCurrentPage()-1)*pi.getLimit();
		
		RowBounds rowBounds = new RowBounds(offset,pi.getLimit());
		
		list = (ArrayList) sqlSession.selectList("StudentInfo.selectStudentList", null, rowBounds);
		
		if(list==null) {
			sqlSession.close();
			throw new StudentInfoSelectListException("학생정보 조회 실패");
		}
		
		return list;
	}

	@Override
	public int getFilterListCount(SqlSessionTemplate sqlSession, FilterCondition fc) throws StudentInfoSelectListException {
		
		int listCount = sqlSession.selectOne("StudentInfo.selectFilterListCount", fc);
		
		if(listCount <= 0) {
			sqlSession.close();
			throw new StudentInfoSelectListException("필터 학생리스트 카운트 실패");
		}
		
		return listCount;
	}

	@Override
	public ArrayList<StudentInfo> selectFilterStudent(SqlSessionTemplate sqlSession, FilterCondition fc, PageInfo pi) throws StudentInfoSelectListException {
		
		ArrayList<StudentInfo> list = null;
		
		int offset = (pi.getCurrentPage()-1)*pi.getLimit();
		
		RowBounds rowBounds = new RowBounds(offset,pi.getLimit());
		 
		list = (ArrayList) sqlSession.selectList("StudentInfo.selectFilterStudent", fc, rowBounds);
		
		if(list==null) {
			sqlSession.close();
			throw new StudentInfoSelectListException("학생정보 조회 실패");
		}
		
		return list;
	}

	@Override
	public ArrayList selectCollegeFilter(SqlSessionTemplate sqlSession, String col) throws StudentInfoSelectListException {
		
		ArrayList list = null;
		
		if(col.equals("단과대학")) {
			list = (ArrayList)sqlSession.selectList("StudentInfo.selectCollegeAll",col);
		}else {
			list = (ArrayList)sqlSession.selectList("StudentInfo.selectCollege",col);
		}
		
		if(list==null) {
			sqlSession.close();
			throw new StudentInfoSelectListException("단과대필터링 조회 실패");
		}
		
		return list;
	}

	@Override
	public ArrayList selectCollege(SqlSessionTemplate sqlSession) throws StudentInfoSelectListException {
		
		ArrayList collegeList = null;
		
		collegeList = (ArrayList)sqlSession.selectList("StudentInfo.selectCollegeList");
		
		if(collegeList==null) {
			sqlSession.close();
			throw new StudentInfoSelectListException("단과대 리스트 조회 실패");
		}
		
		return collegeList;
	}

	@Override
	public ArrayList selectSdeptList(SqlSessionTemplate sqlSession) throws StudentInfoSelectListException {
		
		ArrayList sdeptList = null;
		
		sdeptList = (ArrayList)sqlSession.selectList("StudentInfo.selectSdeptList");
		
		if(sdeptList==null) {
			sqlSession.close();
			throw new StudentInfoSelectListException("학과리스트 조회 실패");
		}
		
		return sdeptList;
	}

	@Override
	public StudentInfo personInfoManage(SqlSessionTemplate sqlSession, String userId) {
		
		return sqlSession.selectOne("StudentInfo.personInfoManage",userId);
	}

	@Override
	public int changePeronalInfo(SqlSessionTemplate sqlSession, StudentInfo si) {
		
		return sqlSession.update("StudentInfo.changePeronalInfo", si);
	}

	@Override
	public int changeParentsInfo(SqlSessionTemplate sqlSession, StudentInfo si) {
		
		return sqlSession.update("StudentInfo.changeParentsInfo", si);
	}

	@Override
	public int changeStudentInfo(SqlSessionTemplate sqlSession, StudentInfo si) {
		
		return sqlSession.update("StudentInfo.changeStudentInfo",si);
	}

	@Override
	public int insertSecondMajor(SqlSessionTemplate sqlSession, SecondMajor sm) {
		return sqlSession.insert("SecondMajor.insertSecondMajor", sm);
	}

	@Override
	public ArrayList<SecondMajor> selectSecondMajor(SqlSessionTemplate sqlSession, SecondMajor sm) {
		return (ArrayList) sqlSession.selectList("SecondMajor.selectSecondMajor", sm);
	}

	@Override
	public ArrayList<SecondMajor> selectSecondMajor(SqlSessionTemplate sqlSession, String userId) {
		return (ArrayList) sqlSession.selectList("SecondMajor.selectSecondMajor2", userId);
  }
  
	@Override
	public ArrayList<Graduation> selectGraduationCondition(SqlSessionTemplate sqlSession, String userId) throws StudentInfoSelectListException {
		
		ArrayList<Graduation> list = null;
		
		list = (ArrayList)sqlSession.selectList("Graduation.selectGraduationCondition", userId);
		
		if(list==null) {
			sqlSession.close();
			throw new StudentInfoSelectListException("졸업인증 관리 조회 실패");
		}
		
		return list;

	}


	@Override
	public ArrayList<SecondMajor> selectSecondMajorList(SqlSessionTemplate sqlSession, PageInfo pi) {
		ArrayList<SecondMajor> list = null;
		
		int offset = (pi.getCurrentPage() - 1) * pi.getLimit();
		
		RowBounds rowBounds = new RowBounds(offset, pi.getLimit());
		
		list = (ArrayList) sqlSession.selectList("SecondMajor.selectSecondMajorList", null, rowBounds);
		
		if(list == null) {
			sqlSession.close();
		}
		return list;
	}
	
	@Override
	public int selectSecondMajorListCount(SqlSessionTemplate sqlSession) {
		return sqlSession.selectOne("SecondMajor.selectSecondMajorListCount");
	}

	@Override
	public int SuccessSecondMajor(SqlSessionTemplate sqlSession, SecondMajor sm) {
		return sqlSession.update("SecondMajor.SuccessSecondMajor", sm);
	}

	@Override
	public int ChangeStudentInfo(SqlSessionTemplate sqlSession, SecondMajor sm) {
		return sqlSession.update("SecondMajor.ChangeStudentInfo", sm);
	}

	@Override
	public int selectSecondMajorSuccessListCount(SqlSessionTemplate sqlSession) {
		return sqlSession.selectOne("SecondMajor.selectSecondMajorSuccessListCount");
	}

	@Override
	public ArrayList<SecondMajor> selectSecondMajorSuccessList(SqlSessionTemplate sqlSession, PageInfo pi) {
		ArrayList<SecondMajor> list = null;
		
		int offset = (pi.getCurrentPage() - 1) * pi.getLimit();
		
		RowBounds rowBounds = new RowBounds(offset, pi.getLimit());
		
		list = (ArrayList) sqlSession.selectList("SecondMajor.selectSecondMajorSuccessList", null, rowBounds);
		
		if(list == null) {
			sqlSession.close();
		}
		return list;
	}

	@Override
	public SecondMajor smInfo(SqlSessionTemplate sqlSession, String studentNo) {
		return sqlSession.selectOne("SecondMajor.smInfo", studentNo);
	}

	@Override
	public int searchSecondMajorApplyCount(SqlSessionTemplate sqlSession, SearchCondition sc) {
		return sqlSession.selectOne("SecondMajor.searchSecondMajorApplyCount", sc);
	}

	@Override
	public ArrayList<SecondMajor> searchSecondMajorApplyList(SqlSessionTemplate sqlSession, SearchCondition sc,	PageInfo pi) {
		ArrayList<SecondMajor> list = null;
		
		int offset = (pi.getCurrentPage() - 1) * pi.getLimit();
		
		RowBounds rowBounds = new RowBounds(offset, pi.getLimit());
		
		list = (ArrayList) sqlSession.selectList("SecondMajor.searchSecondMajorApplyList", sc, rowBounds);
		
		if(list == null) {
			sqlSession.close();
		}
		return list;
	}

   @Override
   public ArrayList<Graduation> selectGraduationSchool(SqlSessionTemplate sqlSession) {
	
	   return (ArrayList)sqlSession.selectList("Graduation.selectGraduationSchool");
   }

	@Override
	public int searchSecondMajorApplyCount2(SqlSessionTemplate sqlSession, SearchCondition sc) {
		return sqlSession.selectOne("SecondMajor.searchSecondMajorApplyCount2", sc);
	}
	
	@Override
	public ArrayList<SecondMajor> searchSecondMajorApplyList2(SqlSessionTemplate sqlSession, SearchCondition sc, PageInfo pi) {
		ArrayList<SecondMajor> list = null;
		
		int offset = (pi.getCurrentPage() - 1) * pi.getLimit();
		
		RowBounds rowBounds = new RowBounds(offset, pi.getLimit());
		
		list = (ArrayList) sqlSession.selectList("SecondMajor.searchSecondMajorApplyList2", sc, rowBounds);
		
		if(list == null) {
			sqlSession.close();
		}
		return list;	
	}

	@Override
	public ChangeMajor cmInfo(SqlSessionTemplate sqlSession, String studentNo) {
		return sqlSession.selectOne("ChangeMajor.selectcmInfo", studentNo);
	}

	@Override
	public int insertChangeMajor(SqlSessionTemplate sqlSession, ChangeMajor cm) {
		return sqlSession.insert("ChangeMajor.insertChangeMajor", cm);
	}

	@Override
	public ChangeMajor selectChangeMajor(SqlSessionTemplate sqlSession, ChangeMajor cm) {
		return sqlSession.selectOne("ChangeMajor.selectChangeMajor", cm);
	}

	@Override
	public Graduation selectGraduationScDetail(SqlSessionTemplate sqlSession, String code) {
		
		return sqlSession.selectOne("Graduation.selectGraduationScDetail", code);
	}
	
	@Override
	public int ChangeMajorListCount(SqlSessionTemplate sqlSession) {
		return sqlSession.selectOne("ChangeMajor.ChangeMajorListCount");
	}
	
	@Override
	public ArrayList<ChangeMajor> ChangeMajorList(SqlSessionTemplate sqlSession, PageInfo pi) {
		ArrayList<ChangeMajor> list = null;
		
		int offset = (pi.getCurrentPage() - 1) * pi.getLimit();
		
		RowBounds rowBounds = new RowBounds(offset, pi.getLimit());
		
		list = (ArrayList) sqlSession.selectList("ChangeMajor.ChangeMajorList", null, rowBounds);
		
		if(list == null) {
			sqlSession.close();
		}
		return list;
	}

	@Override
	public int ChangeMajorListCount2(SqlSessionTemplate sqlSession) {
		return sqlSession.selectOne("ChangeMajor.ChangeMajorListCount2");
	}

	@Override
	public ArrayList<ChangeMajor> ChangeMajorList2(SqlSessionTemplate sqlSession, PageInfo pi) {
		ArrayList<ChangeMajor> list = null;
		
		int offset = (pi.getCurrentPage() - 1) * pi.getLimit();
		
		RowBounds rowBounds = new RowBounds(offset, pi.getLimit());
		
		list = (ArrayList) sqlSession.selectList("ChangeMajor.ChangeMajorList2", null, rowBounds);
		
		if(list == null) {
			sqlSession.close();
		}
		return list;
	}

	@Override
	public int ChangeMajorEnroll(SqlSessionTemplate sqlSession, ChangeMajor cm) {
		return sqlSession.update("ChangeMajor.ChangeMajorEnroll", cm);
	}

	@Override
	public int ChangeMajorEnrollStudentInfo(SqlSessionTemplate sqlSession, ChangeMajor cm) {
		return sqlSession.update("ChangeMajor.ChangeMajorEnrollStudentInfo", cm);
	}

	@Override
	public int ChangeMajorReject(SqlSessionTemplate sqlSession, ChangeMajor cm) {
		return sqlSession.update("ChangeMajor.ChangeMajorReject", cm);
	}

	@Override
	public ArrayList<ChangeMajor> searchChangeMajor(SqlSessionTemplate sqlSession, SearchCondition sc) {
		return (ArrayList) sqlSession.selectList("ChangeMajor.searchChangeMajor", sc);
	}

	@Override
	public ArrayList<ChangeMajor> searchChangeMajor2(SqlSessionTemplate sqlSession, SearchCondition sc) {
		return (ArrayList) sqlSession.selectList("ChangeMajor.searchChangeMajor2", sc);
	}


	@Override
	public ArrayList<Graduation> selectGraduationMajor(SqlSessionTemplate sqlSession) {
		
		return (ArrayList)sqlSession.selectList("Graduation.selectGraduationMajor");
	}
	
	@Override
	public Graduation selectGraduationMaDetail(SqlSessionTemplate sqlSession, String code) {
		
		return sqlSession.selectOne("Graduation.selectGraduationMaDetail", code);
	}
	
	@Override
	public int ExplusionListCount(SqlSessionTemplate sqlSession) {
		return sqlSession.selectOne("Explusion.ExplusionListCount");
	}
	
	@Override
	public ArrayList<Explusion> ExplusionList(SqlSessionTemplate sqlSession, PageInfo pi) {
		ArrayList<Explusion> list = null;
		
		int offset = (pi.getCurrentPage() - 1) * pi.getLimit();
		
		RowBounds rowBounds = new RowBounds(offset, pi.getLimit());
		
		list = (ArrayList) sqlSession.selectList("Explusion.ExplusionList", null, rowBounds);
		
		if(list == null) {
			sqlSession.close();
		}
		return list;
	}

	@Override
	public int ExplusionListCount2(SqlSessionTemplate sqlSession) {
		return sqlSession.selectOne("Explusion.ExplusionListCount2");
	}

	@Override
	public ArrayList<Explusion> ExplusionList2(SqlSessionTemplate sqlSession, PageInfo pi) {
		ArrayList<Explusion> list = null;
		
		int offset = (pi.getCurrentPage() - 1) * pi.getLimit();
		
		RowBounds rowBounds = new RowBounds(offset, pi.getLimit());
		
		list = (ArrayList) sqlSession.selectList("Explusion.ExplusionList2", null, rowBounds);
		
		if(list == null) {
			sqlSession.close();
		}
		return list;
	}

	@Override
	public int ExplusionEnroll(SqlSessionTemplate sqlSession, Explusion exp) {
		return sqlSession.insert("Explusion.ExplusionEnroll", exp);
	}

	@Override
	public ArrayList<Explusion> searchExplusion(SqlSessionTemplate sqlSession, SearchCondition sc) {
		return (ArrayList) sqlSession.selectList("Explusion.searchExplusion", sc);
	}

	@Override
	public ArrayList<Explusion> searchExplusion2(SqlSessionTemplate sqlSession, SearchCondition sc) {
		return (ArrayList) sqlSession.selectList("Explusion.searchExplusion2", sc);
	}

	@Override
	public int ExplusionUpdateStudent(SqlSessionTemplate sqlSession, Explusion exp) {
		return sqlSession.update("Explusion.ExplusionUpdateStudent", exp);
	}

	@Override
	public Explusion expInfo(SqlSessionTemplate sqlSession, String studentNo) {
		return sqlSession.selectOne("Explusion.expInfo", studentNo);
	}
	
	@Override
	public int updateGraduationSc(SqlSessionTemplate sqlSession, Graduation gd) {
		
		return sqlSession.update("Graduation.updateGraduationSc", gd);
	}

	@Override
	public int updateGraduationMa(SqlSessionTemplate sqlSession, Graduation gd) {
		
		return sqlSession.update("Graduation.updateGraduationMa", gd);
	}

	@Override
	public DropOut doInfo(SqlSessionTemplate sqlSession, String studentNo) {
		return sqlSession.selectOne("DropOut.doInfo", studentNo);
	}

	@Override
	public int insertDropOut(SqlSessionTemplate sqlSession, DropOut dpo) {
		return sqlSession.insert("DropOut.insertDropOut", dpo);
	}

	@Override
	public ArrayList<DropOut> selectDropOut(SqlSessionTemplate sqlSession, DropOut dpo) {
		return (ArrayList)sqlSession.selectList("DropOut.selectDropOutList", dpo);
	}

	@Override
	public ArrayList<DropOut> selectDropOut(SqlSessionTemplate sqlSession, String studentNo) {
		return (ArrayList)sqlSession.selectList("DropOut.selectDropOutList2", studentNo);
	}

	@Override
	public int pro_dropOutListCount(SqlSessionTemplate sqlSession, String pdeptCode) {
		return sqlSession.selectOne("DropOut.pro_dropOutListCount", pdeptCode);
	}

	@Override
	public ArrayList<DropOut> pro_dropOutList(SqlSessionTemplate sqlSession, PageInfo pi, String pdeptCode) {
		ArrayList<DropOut> list = null;
		
		int offset = (pi.getCurrentPage() - 1) * pi.getLimit();
		
		RowBounds rowBounds = new RowBounds(offset, pi.getLimit());
		
		list = (ArrayList) sqlSession.selectList("DropOut.pro_dropOutList", pdeptCode, rowBounds);
		
		if(list == null) {
			sqlSession.close();
		}
		return list;
	}

	@Override
	public DropOut selectProInfo(SqlSessionTemplate sqlSession, String professorNo) {
		return sqlSession.selectOne("DropOut.selectProInfo", professorNo);
	}

	@Override
	public int pro_dropOutListCount2(SqlSessionTemplate sqlSession, String pdeptCode) {
		return sqlSession.selectOne("DropOut.pro_dropOutListCount2", pdeptCode);
	}

	@Override
	public ArrayList<DropOut> pro_dropOutList2(SqlSessionTemplate sqlSession, PageInfo pi, String pdeptCode) {
		ArrayList<DropOut> list = null;
		
		int offset = (pi.getCurrentPage() - 1) * pi.getLimit();
		
		RowBounds rowBounds = new RowBounds(offset, pi.getLimit());
		
		list = (ArrayList) sqlSession.selectList("DropOut.pro_dropOutList2", pdeptCode, rowBounds);
		
		if(list == null) {
			sqlSession.close();
		}
		return list;
	}

	@Override
	public int pro_DropOutEnroll(SqlSessionTemplate sqlSession, DropOut dpo) {
		return sqlSession.update("DropOut.pro_DropOutEnroll", dpo);
	}

	@Override
	public ArrayList<DropOut> searchDropOut(SqlSessionTemplate sqlSession, SearchCondition sc) {
		return (ArrayList) sqlSession.selectList("DropOut.searchDropOut", sc);
	}

	@Override
	public ArrayList<DropOut> searchDropOut2(SqlSessionTemplate sqlSession, SearchCondition sc) {
		return (ArrayList) sqlSession.selectList("DropOut.searchDropOut2", sc);
	}

	@Override
	public int em_dropOutListCount(SqlSessionTemplate sqlSession) {
		return sqlSession.selectOne("DropOut.em_dropOutListCount");
	}

	@Override
	public ArrayList<DropOut> em_dropOutList(SqlSessionTemplate sqlSession, PageInfo pi) {
		ArrayList<DropOut> list = null;
		
		int offset = (pi.getCurrentPage() - 1) * pi.getLimit();
		
		RowBounds rowBounds = new RowBounds(offset, pi.getLimit());
		
		list = (ArrayList) sqlSession.selectList("DropOut.em_dropOutList", null, rowBounds);
		
		if(list == null) {
			sqlSession.close();
		}
		return list;
	}

	@Override
	public int em_dropOutListCount2(SqlSessionTemplate sqlSession) {
		return sqlSession.selectOne("DropOut.em_dropOutListCount2");
	}

	@Override
	public ArrayList<DropOut> em_dropOutList2(SqlSessionTemplate sqlSession, PageInfo pi) {
		ArrayList<DropOut> list = null;
		
		int offset = (pi.getCurrentPage() - 1) * pi.getLimit();
		
		RowBounds rowBounds = new RowBounds(offset, pi.getLimit());
		
		list = (ArrayList) sqlSession.selectList("DropOut.em_dropOutList2", null, rowBounds);
		
		if(list == null) {
			sqlSession.close();
		}
		return list;
	}

	@Override
	public int em_DropOutEnroll(SqlSessionTemplate sqlSession, DropOut dpo) {
		return sqlSession.update("DropOut.em_DropOutEnroll", dpo);
	}

	@Override
	public int dropOutStudentInfoUpdate(SqlSessionTemplate sqlSession, DropOut dpo) {
		return sqlSession.update("DropOut.dropOutStudentInfoUpdate", dpo);
	}

	@Override
	public ArrayList<DropOut> searchDropOut3(SqlSessionTemplate sqlSession, SearchCondition sc) {
		return (ArrayList) sqlSession.selectList("DropOut.searchDropOut3", sc);
	}

	@Override
	public ArrayList<DropOut> searchDropOut4(SqlSessionTemplate sqlSession, SearchCondition sc) {
		return (ArrayList) sqlSession.selectList("DropOut.searchDropOut4", sc);
	}

	@Override
	public int em_DropOutReject(SqlSessionTemplate sqlSession, DropOut dpo) {
		return sqlSession.update("DropOut.em_DropOutReject", dpo);
	}

	@Override
	public DropOut dpoInfo(SqlSessionTemplate sqlSession, String studentNo) {
		return sqlSession.selectOne("DropOut.dpoInfo", studentNo);
	}

	@Override
	public ArrayList<SchoolOff> selectSchoolOff(SqlSessionTemplate sqlSession, String userId) {
		
		return (ArrayList)sqlSession.selectList("SchoolOff.selectSchoolOff", userId);
	}

	@Override
	public int schoolOffApply(SqlSessionTemplate sqlSession, SchoolOff so) {

		return sqlSession.insert("SchoolOff.schoolOffApply", so);
	}

	@Override
	public int getOffApplyListCount(SqlSessionTemplate sqlSession) {
		
		return sqlSession.selectOne("SchoolOff.getOffApplyListCount");
	}


}
