
package kr.or.kosa.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import kr.or.kosa.dto.RegisterDto;
import kr.or.kosa.utils.ConnectionHelper;

/*
1. DB연결 POOL
2. insert 작업 
insert into mvcregister(id,pwd,email) values(?,?,?)

*/
public class RegisterDao {
  
	//writeOk ...
	//insert into mvcregister(id,pwd,email) values(?,?,?)
	public int writeOk(RegisterDto dto) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int resultrow=0;
		try {
				conn = ConnectionHelper.getConnection("oracle");
				String sql="insert into mvcregister(id,pwd,email) values(?,?,?)";
				pstmt = conn.prepareStatement(sql);
				
				pstmt.setInt(1,dto.getId());
				pstmt.setString(2,dto.getPwd());
				pstmt.setString(3,dto.getEmail());
				
				resultrow = pstmt.executeUpdate();
		} catch (SQLException e) {
		
			e.printStackTrace();
		}finally {
			ConnectionHelper.close(pstmt);
			ConnectionHelper.close(conn);
		}
		return resultrow;
	}
}