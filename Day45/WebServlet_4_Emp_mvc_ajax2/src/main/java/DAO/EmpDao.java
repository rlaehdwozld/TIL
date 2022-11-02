package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import DTO.Emp;
import UTILS.SingletonHelper;

public class EmpDao {

	private Connection conn;
	
	public EmpDao() {
		conn = SingletonHelper.getConnection("oracle");
	}
	
	//전체 조회
	public List<Emp> getEmpListAll() {
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Emp> emplist = new ArrayList<Emp>();
		
		try {
			
			String sql = "select * from emp";
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				do {
					Emp emp = new Emp();
					emp.setEmpno(rs.getInt("empno"));
					emp.setEname(rs.getString("ename"));
					emp.setJob(rs.getString("job"));
					emp.setMgr(rs.getInt("mgr"));
					emp.setHiredate(rs.getDate("hiredate"));
					emp.setSal(rs.getInt("sal"));
					emp.setComm(rs.getInt("comm"));
					emp.setDeptno(rs.getInt("deptno"));

					emplist.add(emp);
				}while(rs.next());
			}else {
				System.out.println("조회 데이터 없음");
			}
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			SingletonHelper.close(rs);
			SingletonHelper.close(pstmt);
		}
		
		return emplist;
	}
	
	//조건 조회
	public Emp getEmpListByEmpno(int empno) {
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Emp emp = new Emp();
		
		try {
			String sql = "select * from emp where empno=?";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, empno);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				emp.setEmpno(rs.getInt("empno"));
				emp.setEname(rs.getString("ename"));
				emp.setJob(rs.getString("job"));
				emp.setMgr(rs.getInt("mgr"));
				emp.setHiredate(rs.getDate("hiredate"));
				emp.setSal(rs.getInt("sal"));
				emp.setComm(rs.getInt("comm"));
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
	
	//삽입
	public int insertEmp(Emp emp) {
		PreparedStatement pstmt = null;
		int row = 0;
		
		try {
			String sql = "insert into emp(empno, ename, job, mgr, hiredate, sal, comm, deptno) values(?,?,?,?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, emp.getEmpno());
			pstmt.setString(2, emp.getEname());
			pstmt.setString(3, emp.getJob());
			pstmt.setInt(4, emp.getMgr());
			
			SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
			String date = dateformat.format(emp.getHiredate());
			pstmt.setDate(5, java.sql.Date.valueOf(date));
			
			pstmt.setInt(6, emp.getSal());
			pstmt.setInt(7, emp.getComm());
			pstmt.setInt(8, emp.getDeptno());
			
			row = pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			SingletonHelper.close(pstmt);
		}
		
		return row;
	}
	
	//수정
	public int updateEmp(Emp emp) {
		PreparedStatement pstmt = null;
		int row = 0;
		
		try {
			String sql = "update emp set ename=?, job=?, sal=?, hiredate=? where empno=?";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, emp.getEname());
			pstmt.setString(2, emp.getJob());
			pstmt.setInt(3, emp.getSal());
			
			pstmt.setDate(4, new java.sql.Date(emp.getHiredate().getTime()));
			
			pstmt.setInt(5, emp.getEmpno());
			
			row = pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			SingletonHelper.close(pstmt);
		}
		
		return row;
	}	
	
	//삭제
	public int deleteEmp(int empno) {
		PreparedStatement pstmt = null;
		int row = 0;
		
		try {
			String sql = "delete from emp where empno = ?";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, empno);
			
			row = pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			SingletonHelper.close(pstmt);
		}
		
		return row;
	}	
	
	//Like 검색 
	public List<Emp> getEmpListByEname(String ename){
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Emp> emplist = new ArrayList<Emp>();
		
		try {
			
			String sql = "select * from emp where ename like ?";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, "%" + ename + "%"); //'%?%'
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				do {
					Emp emp = new Emp();
					emp.setEmpno(rs.getInt("empno"));
					emp.setEname(rs.getString("ename"));
					emp.setJob(rs.getString("job"));
					emp.setMgr(rs.getInt("mgr"));
					emp.setHiredate(rs.getDate("hiredate"));
					emp.setSal(rs.getInt("sal"));
					emp.setComm(rs.getInt("comm"));
					emp.setDeptno(rs.getInt("deptno"));

					emplist.add(emp);
				}while(rs.next());
			}else {
				System.out.println("조회 데이터 없음");
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
