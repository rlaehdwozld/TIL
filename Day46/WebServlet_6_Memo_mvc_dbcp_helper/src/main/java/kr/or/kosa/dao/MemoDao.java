
package kr.or.kosa.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kr.or.kosa.dto.Memo;
import kr.or.kosa.utils.ConnectionHelper;

/*	
DB연결
CRUD 함수 생성 > memo
1. 전체조회  : select id , email , content from memo
2. 조건조회  : select id , email , content from memo where id=? //제약 id >pk
3. 삽입     : insert into memo(id,email,content) values(?,?,?)
4. 수정     : update memo set email=? , content=? where id=?
5. 삭제     : delete from memo where id=?
알파... LIKE 검색  where email like '%naver%'


자바로 함수를 생성 .... 처리 ... 거의 똑같아요
ArrayList
HashMap
제너릭 ...

*/
public class MemoDao {
	/*
	싱글톤 방식 연습 (DB연결) 
	Connection conn = null;
	
	public MemoDao() {
		conn = SingletonHelper.getConnection("oracle"); //singleton
	}
	*/
	
	//POOL
	/*
	DataSource ds = null;
	
	public MemoDao() {
		try {
			//JNDI
			Context context = new InitialContext();
			//현재 [프로젝트]에서 특정 이름을 가진 객체를 검색 (사용 : 이름기반 검색)
			ds = (DataSource)context.lookup("java:comp/env/jdbc/oracle"); //  정해진 약속 : java:comp/env/ + jdbc/oracle
		    //lookup 된 객체의 타입이 DataSource
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	*/
	//전체조회
	public List<Memo> getMemoList() throws SQLException{
		
		PreparedStatement pstmt = null;
		String sql="select id, email , content from memo";
		
		///POOL///////////////////////
		Connection conn = ConnectionHelper.getConnection("oracle");
		//////////////////////////////
		
		pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		
		List<Memo> memolist = new ArrayList<Memo>(); //POINT
		//[new memo()][new memo()][new memo()][new memo()]
		while(rs.next()) {
			Memo m = new Memo();
			m.setId(rs.getString("id"));
			m.setEmail(rs.getString("email"));
			m.setContent(rs.getString("content"));
			
			memolist.add(m);
		}
		
		ConnectionHelper.close(rs);
		ConnectionHelper.close(pstmt);
		
		//POOL 에게 연결객체 반환////////////
		ConnectionHelper.close(conn);
		////////////////////////////////
		
		return memolist;
	}
	
	
	//조건조회 (where id=? : 데이터 1건 보장 : id컬럼 > unique , primary key)
	public Memo getMemoListById(String id) {
		
		//select id, email , content from memo where id=?
		//memo m = new memo();
		//return m
		
		return null;
		
	}
	
	
	//삽입
	//public int insertMemo(String id, String email , String content) parameter 객체 ...
	public int insertMemo(Memo m) {
		
		System.out.println(m.toString());
		int resultrow=0;
		
		PreparedStatement pstmt = null;
		String sql="insert into memo(id,email,content) values(?,?,?)";
		
		//POOL
		Connection conn = null;
		
		try {
				//POOL
				conn = ConnectionHelper.getConnection("oracle");
				
				pstmt = conn.prepareStatement(sql);
				
				pstmt.setString(1,m.getId());
				pstmt.setString(2,m.getEmail());
				pstmt.setString(3,m.getContent());
				
				resultrow = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			ConnectionHelper.close(pstmt);
			try {
				ConnectionHelper.close(conn); //반환하기 
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
				
		return resultrow;
	}
	
	//수정
	public int updateMemo(Memo m) {
		return 0;
	}
	//삭제
	public int deleteMemo(String id) {
		return 0;
	}
	//검색
	public Memo idSearchByEmail(String email) {
		return null;
	}
	//ID 유무 함수
	public String isCheckById(String id) {
	
		String ismemoid=null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql="select id from memo where id=?";

		Connection conn = null;
		try {
			  conn = ConnectionHelper.getConnection("oracle");
			  pstmt = conn.prepareStatement(sql);
			  pstmt.setString(1, id);
			  		
			  rs = pstmt.executeQuery();
			  if(rs.next()) {
				  //같은 ID 존재
				  ismemoid = "false";
			  }else {
				  //사용가능한 ID
				  ismemoid = "true";
			  }
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}finally {
			ConnectionHelper.close(rs);
			ConnectionHelper.close(pstmt);
			try {
				ConnectionHelper.close(conn); //반환하기
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		
		return ismemoid;
		
	}
}