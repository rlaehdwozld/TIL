package kr.or.kosa.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import kr.or.kosa.dto.KoreaMember;
import kr.or.kosa.utils.ConnectionHelper;

public class KoreaMemberDao {

   // 단건 조회
   public KoreaMember findOne(String id) {
      KoreaMember koreaMember = null;
      Connection conn = null;
      PreparedStatement pstmt = null;
      ResultSet rs = null;
      try {
         conn = ConnectionHelper.getConnection("oracle");
         String sql = "select id, pwd, name, age, gender, email from koreamember where id=?";
         pstmt = conn.prepareStatement(sql);
         pstmt.setString(1, id);
         rs = pstmt.executeQuery();
         while (rs.next()) {
            koreaMember = new KoreaMember();
            koreaMember.setId(rs.getString("id"));
            koreaMember.setPwd(rs.getString("pwd"));
            koreaMember.setName(rs.getString("name"));
            koreaMember.setAge(rs.getInt("age"));
            koreaMember.setGender(rs.getString("gender"));
            koreaMember.setEmail(rs.getString("email"));
         }
      } catch (Exception e) {
         e.printStackTrace();
      } finally {
         ConnectionHelper.close(conn);
         ConnectionHelper.close(pstmt);
         ConnectionHelper.close(rs);
      }
      return koreaMember;
   }
   
   // KoreaMember insert
   public int saveOne(KoreaMember koreaMember) {
      Connection conn = null;
      PreparedStatement pstmt = null;
      int rowcount = 0;
      try {
         conn = ConnectionHelper.getConnection("oracle");
         String sql = "insert into koreamember(id, pwd, name, age, gender, email, ip) values(?,?,?,?,?,?,?)";
         pstmt = conn.prepareStatement(sql);
         pstmt.setString(1, koreaMember.getId());
         pstmt.setString(2, koreaMember.getPwd());
         pstmt.setString(3, koreaMember.getName());
         pstmt.setInt(4, koreaMember.getAge());
         pstmt.setString(5, koreaMember.getGender());
         pstmt.setString(6, koreaMember.getEmail());
         pstmt.setString(7, koreaMember.getIp());
         rowcount = pstmt.executeUpdate();
      } catch (Exception e) {
         System.out.println(e.getStackTrace());
         e.printStackTrace();
      } finally {
         ConnectionHelper.close(conn);
         ConnectionHelper.close(pstmt);
      }
      return rowcount;
   }
   
   public List<KoreaMember> findAll() {
      List<KoreaMember> result = new ArrayList<>();
      Connection conn = null;
      PreparedStatement pstmt = null;
      ResultSet rs = null;
      try {
         conn = ConnectionHelper.getConnection("oracle");
         String sql="select id, pwd, name, age, gender, email, ip from koreamember";
         pstmt = conn.prepareStatement(sql);
         rs = pstmt.executeQuery(); 
         while(rs.next()) {
            KoreaMember km = new KoreaMember(
                  rs.getString("id"), 
                  rs.getString("pwd"), 
                  rs.getString("name"), 
                  rs.getInt("age"), 
                  rs.getString("gender"), 
                  rs.getString("email"), 
                  rs.getString("ip")
            );
            result.add(km);
         }
      } catch (Exception e) {
         e.printStackTrace();
      } finally {
         ConnectionHelper.close(rs);
         ConnectionHelper.close(pstmt);
         ConnectionHelper.close(conn);
      }
      return result;
   }
   
   public int deleteOne(String id) {
      Connection conn = null;
      PreparedStatement pstmt = null;
      int rowcount = 0;
      try {
         conn = ConnectionHelper.getConnection("oracle");
         String sql = "delete from koreamember where id=?";
         pstmt = conn.prepareStatement(sql);
         pstmt.setString(1, id);
         rowcount = pstmt.executeUpdate();
      } catch (Exception e) {
         e.printStackTrace();
      } finally {
         ConnectionHelper.close(pstmt);
         ConnectionHelper.close(conn);
      }
      return rowcount;
   }
   
   public int updateOne(KoreaMember koreaMember) {
      Connection conn = null;
      PreparedStatement pstmt = null;
      int rowcount = 0;
      try{
         conn = ConnectionHelper.getConnection("oracle");
         String sql = "update koreamember set name=? , age=? , email=? , gender=? where id=?";
         pstmt = conn.prepareStatement(sql);
         pstmt.setString(1, koreaMember.getName());
         pstmt.setInt(2, koreaMember.getAge());
         pstmt.setString(3, koreaMember.getEmail());
         pstmt.setString(4, koreaMember.getGender());
         pstmt.setString(5, koreaMember.getId());
         int result = pstmt.executeUpdate();
         
      } catch(Exception e) {
         e.printStackTrace();
      } finally{
         ConnectionHelper.close(pstmt);
         ConnectionHelper.close(conn);
      }
      return rowcount;
   }
   
   public List<KoreaMember> findAllByKeyword(String name) {
      Connection conn = null;
      PreparedStatement pstmt = null;
      ResultSet rs = null;
      List<KoreaMember> result = new ArrayList<>();
      try {
         conn = ConnectionHelper.getConnection("oracle");
         String sql = "select id, name, email from koreamember where name like ?";
         pstmt = conn.prepareStatement(sql);
         pstmt.setString(1, '%'+name+'%');
         rs = pstmt.executeQuery();
         while(rs.next()) {
            KoreaMember km = new KoreaMember();
            km.setId(rs.getString("id"));
            km.setName(rs.getString("name"));
            km.setEmail(rs.getString("email"));
            result.add(km);
         }
      } catch (Exception e) {
         e.printStackTrace();
      } finally {
         ConnectionHelper.close(rs);
         ConnectionHelper.close(pstmt);
         ConnectionHelper.close(conn);
      }
      
      return result;
   }
   
}