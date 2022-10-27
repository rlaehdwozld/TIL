package kr.or.kosa;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import UTILS.SingletonHelper;

/*
EMP 테이블대해서
전체조회  
조건조회  where empno=7788
삽입   insert into emp( ....) values(...)
삭제   delete from emp where empno=7788
수정   update emp set ename=? , job=? , sal=? , hiredate=?  where empno=?
Like 검색 이름 검색
 */
public class EmpDao {
	Connection conn = null;

	public EmpDao() {
		conn = SingletonHelper.getConnection("oracle");
	}
	// 1. 전체조회

	public List<Emp> getEmpAllList() {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Emp> emplist = new ArrayList<Emp>();

		try {
			String sql = "select * from emp";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				Emp emp = new Emp();
				emp.setEmpno(rs.getInt("empno"));
				emp.setEname(rs.getString("ename"));
				emp.setJob(rs.getString("job"));
				emp.setMgr(rs.getString("mgr"));
				emp.setHiredate(rs.getDate("hiredate"));
				emp.setSal(rs.getInt("sal"));
				emp.setComm(rs.getString("comm"));
				emp.setDeptno(rs.getInt("deptno"));
				emplist.add(emp);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			SingletonHelper.close(rs);
			SingletonHelper.close(pstmt);
		}
		return emplist;
	}

	// 2. 조건조회
	public Emp getEmpListByEmpNo(int empno) {

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Emp emp = null;

		try {
			String sql = "select empno, ename, job, mgr, hiredate, sal, comm, deptno from emp where empno = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, empno);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				emp = new Emp();
				emp.setEmpno(rs.getInt("empno"));
				emp.setEname(rs.getString("ename"));
				emp.setJob(rs.getString("job"));
				emp.setMgr(rs.getString("mgr"));
				emp.setHiredate(rs.getDate("hiredate"));
				emp.setSal(rs.getInt("sal"));
				emp.setComm(rs.getString("comm"));
				emp.setDeptno(rs.getInt("deptno"));
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			SingletonHelper.close(rs);
			SingletonHelper.close(pstmt);
		}
		return emp;
	}

	// 3. 데이터 삽입 insert into emp( ....) values(...)
	public int insertEmp(Emp emp) {
		PreparedStatement pstmt = null;
		int rowcount = 0;
		try {
			String sql = "insert into emp(empno, ename, job, mgr, hiredate, sal, comm, deptno) values(?,?,?,?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, emp.getEmpno());
			pstmt.setString(2, emp.getEname());
			pstmt.setString(3, emp.getJob());
			pstmt.setString(4, emp.getMgr());
			pstmt.setDate(5, new java.sql.Date(emp.getHiredate().getTime()));
			pstmt.setInt(6, emp.getSal());
			pstmt.setString(7, emp.getComm());
			pstmt.setInt(8, emp.getDeptno());
			rowcount = pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		} finally {
			SingletonHelper.close(pstmt);
		}
		return rowcount;
	}

	// 4. 데이터 수정 update emp set ename=? , job=? , sal=? , hiredate=? where empno=?
	public int updateEmp(Emp emp) {
		PreparedStatement pstmt = null;
		int rowcount = 0;
		try {
			String sql = "update emp set ename=?, job=?, mgr=?, hiredate=?, sal=?, comm=?, deptno=? where empno=?";
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, emp.getEname());
			pstmt.setString(2, emp.getJob());
			pstmt.setString(3, emp.getMgr());
			pstmt.setDate(4, new java.sql.Date(emp.getHiredate().getTime()));
			pstmt.setInt(5, emp.getSal());
			pstmt.setString(6, emp.getComm());
			pstmt.setInt(7, emp.getDeptno());
			pstmt.setInt(8, emp.getEmpno());
			rowcount = pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		} finally {
			SingletonHelper.close(pstmt);
		}
		return rowcount;
	}

	// 5. 데이터 삭제 delete from emp where empno=7788
	public int deleteEmp(int empno) {
		PreparedStatement pstmt = null;
		int rowcount = 0;
		try {
			String sql = "delete from emp where empno=?";
			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, empno);
			rowcount = pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		} finally {
			SingletonHelper.close(pstmt);
		}
		return rowcount;
	}

//	6. Like 검색 이름 검색
	public List<Emp> getEmpAllListByEname(String ename) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		List<Emp> emplist = new ArrayList<Emp>();

		try {
			String sql = "select empno, ename, job, mgr, hiredate, sal, comm, deptno from emp where like ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%" + ename + "%");
			rs = pstmt.executeQuery();

			while (rs.next()) {
				Emp emp = new Emp();
				emp.setEmpno(rs.getInt("empno"));
				emp.setEname(rs.getString("ename"));
				emp.setJob(rs.getString("job"));
				emp.setMgr(rs.getString("mgr"));
				emp.setHiredate(rs.getDate("hiredate"));
				emp.setSal(rs.getInt("sal"));
				emp.setComm(rs.getString("comm"));
				emp.setDeptno(rs.getInt("deptno"));
				emplist.add(emp);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			SingletonHelper.close(rs);
			SingletonHelper.close(pstmt);
		}
		return emplist;
	}

}
