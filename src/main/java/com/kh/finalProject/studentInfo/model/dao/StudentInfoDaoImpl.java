package com.kh.finalProject.studentInfo.model.dao;

import java.util.ArrayList;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.kh.finalProject.board.model.vo.Board;
import com.kh.finalProject.board.model.vo.PageInfo;
import com.kh.finalProject.board.model.vo.SearchCondition;
import com.kh.finalProject.studentInfo.model.exception.StudentInfoSelectListException;
import com.kh.finalProject.studentInfo.model.vo.ChangeMajor;
import com.kh.finalProject.studentInfo.model.vo.FilterCondition;
import com.kh.finalProject.studentInfo.model.vo.SecondMajor;
import com.kh.finalProject.studentInfo.model.vo.Graduation;
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

}
