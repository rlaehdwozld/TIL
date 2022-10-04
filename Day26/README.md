# 2022.10.04 월요일 못먹어도 고!

## JDBC

### Connection

JDBC

1. java 언어 (APP) 를 통해서 Oracle (소프트 웨어) 연결해서 CRUD작업
   2.java App : oracle, my-sql, ms-sql 등등 모든 데이터베이스에 연결 할 수 있고 (CRUD)
   2.1 각각의 제품에 맞는 드라이버를 갖고 있어야 한다. 그 드라이버는 오라클, 마이에스큐엘을 만든 vendor가 제공한다.
   CASE1 : 삼성 노트북>> HP프린터 연결>> HP프린터 사이트에서 드라이버 다운 >> 삼성 설치
   CASE2 : HP 프린터 제조 회사는.... 삼성 , LG회사마다 적용할 수 있는 드라이버를 별도로 제작
   각언어에 맞는 드라이버를 다운로드 해서 제품에 맞게 설치 ... 접속...
   oracle (C:\oraclexe\app\oracle\product\11.2.0\server\jdbc\lib)
   mysql(https://dev.mysql.com/downloads/connector/j/)

강사 PC : C:\KOSA_IT\Database\JDBC\ConnectionUtils\Oracle>> ojdbc6.jar

3. 드라이버를 참조 ( 현재 프로젝트에서 사용 가능 하도록)
   jar파일 추가
   3.1 드라이버 사용 준비 완요>> 메모리에 load사용...
   3.2 Class.forName("oracle.jdbc.OracleDriver");

4. JAVA CODE(CRUD) >> JDBC API제공 받는다.
   4.1 import java.sql.\*>> interface, class 제공
   4.2 개발자는 interface를 통해서 표준화된 DB작업 수행 가능
   POINT) 왜 인터페이스를 줬을까???? 왜 클래스 안만들고 인터페이스 형태로 제공할까?
   어떨때는 오라클, mysql ,.... 여러종류를 작업하든 똑같은 코드를 적용하고 싶다.
   //OracleConnection conn>> connection 구현
   //MysqlConnection conn >> Connection 구현
   //다형성 Connection 부모 타입 : 유연한 프로그램을 작성할 수 있다.
   //메모리에 로딩된 드라이버를 통해서 연결을 시도하는 것이다. 연결이 성공되면 conn이라는 변수가
   다형성을 구현하기 위해서 ( 인터페이스 활용)
   import java.sql.Connection
   import.java.sql.ResutlSet
   import.java.sql.Statement 등등의 인터페이스를 활용해서 프로그램을 짤 예정이다.

5. 작업순서
   5.1 DB연결 -> 명령생성-> 명령실행-> 처리-> 자원해제
   5.2 명령 : DDL( create, alter, drop)
   CRUD(insert, select, update, delete)
   실행 : 쿼리문을 DB서버에게 전달
   처리 : 결과를 받아서 화면 출력, 또는 다른 프로그램에 전달 등등
   자원해제 : 연결 끊기 ( io처럼 직접적으로 해제 해줘야 한다)

```java
public class Ex01_Oracle_connection {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		//DB연결--> 명령 생성--> 실행 --> 처리
		Class.forName("oracle.jdbc.OracleDriver");
		System.out.println("오라클 드라이버 로딩......");
		//loading된 드라이버를 통해서 oracle연결
		Connection conn= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","KOSA","1004");
		//OracleConnection conn= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","KOSA","1004");
		//MysqlConnection conn= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","KOSA","1004");
		System.out.println(conn.isClosed()+"정상 false");

		Statement stmt=conn.createStatement();

		//CRUD
		String sql = "select empno, ename, sal from emp";

		ResultSet rs=stmt.executeQuery(sql);//명령 실행
		//rs : db 서버 메모리에 생성된 정보를 조회 할 수 있다.
		//처리( 화면조회)
		//만약에 중간에 DB연결이 close()... 연결 기반...중간에 네트워크 끊어지면 데이터 못읽음
		while(rs.next()) {
			System.out.println(rs.getInt("empno")+"/"+rs.getString("ename")+"/"+rs.getInt("sal"));
		}
		stmt.close();
		rs.close();
		conn.close();
		System.out.println("DB연결 : "+conn.isClosed());

	}

}

```

### DML_DELETE

DML (insert, update, delete)
JDBC API통해서 작업

1. 결과 집합이 없다 (resultSet 필요 없다)
2. 반영결과 (return 행의 수) >> update 5건 >> return 5

java코드
update emp set sal=0 > 실행 > update 14건 >> return 14
update emp set sal=100 where empno=4444> update 0건 >> return 0

결과를 가지고 java코드로 로직처리
KET POINT

1. Oracle DML(developer, Cmd(sqlplus), tool) 하면 commit or rollback강제
2. JDBC API 사용해서 java 코드를 통해서 DML >> default >> autocommit; >> 실반영
3. JDBC API 통해서 delete from emp >> 실행 >> 자동 commit> 실반영
4. 필요에 따라 commit(), rollback 처리 코드...

begin
A계좌 인출 (update ...
....
B계좌 입급 (update ....
end

> > 하나의 논리적인 단위 업무(transaction)
> > 전체 commit 이거나 전체 rollback
> > 둘다 성공 이거나 둘다 실패

> > 업무 처리 >> JDBC >> autocomit 옵션을 >> false전환
> > 반드시 java

--KOSA계정에서
create table dmlemp
as
select \* from emp;

--제약정보는 복사가 안돼요
select \* from dmlemp;

alter table dmlemp
add constraint pk_dmlemp_empno primary key (empno);

select \* from user_constraints where table_name='DMLEMP';

```java
public class Ex02_Oracle_DML_delete {
   public static void main(String[] args) {
      Connection conn = null;
      Statement stmt = null;

      try {
         //드라이버 로딩
         //ClassforName("oracle.jdbc.OracleDriver"); 생략가능

         //Connection 인터페이스를 구현하고 있는 객체의 주소가 리턴 ...
         //다형성을 통해서 COnnection 타입의 conn 변수가 주소값을 받는다
         conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","KOSA","1004");
         stmt = conn.createStatement(); //Statement 구현하고 있는 객체의 주소 리

         //INSERT
           Scanner scan = new Scanner(System.in);
           int deptno = 0;

           System.out.print("부서입력 : ");
           deptno = Integer.parseInt(scan.nextLine());

           //delete dmlemp where deptno=부서번호
           String sql="delete dmlemp where deptno="+deptno;
           System.out.println(sql);


         //현재
         //values(?,?,?)      >> ? parameter 별도 설정
         //executeUpdate()   >> insert, update, delete 모두 수행
         int resultrow = stmt.executeUpdate(sql);

         if(resultrow > 0) {
            System.out.println("반영된 행의 수: " + resultrow);
         }else {
            System.out.println("예외가 발생된 것이 아니고 : 반영된 행이 없다 ");
         }

      } catch (Exception e) {
         //중복데이터 insert 해서 문제가 생기면 executeUpdate() 예외 발생
         //코드 처리
         System.out.println("SQL 예외발생: " + e.getMessage());
      } finally {
         //강제 수행 블럭
         //자원해제
         try {
            stmt.close();
         } catch (SQLException e) {
            e.printStackTrace();
         }
         try {
            conn.close();
         } catch (SQLException e) {
            e.printStackTrace();
         }
      }
   }
}

```

### DML_INSERT

```java
public class Ex02_Oracle_DML_insert {

	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt = null;
		try {
			// 드라이버 로딩은 생략 가능하다.
			// Class.forName("oracle.jdbc.OracleDriver"); 생략 가능

			// Connection 인터피이스를 구현하고 있는 객체의 주소가 return된다.
			// 다형성을 총해서 connection 인터페이스 타입의 conn 변수가 주소값을 받는다.
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "KOSA", "1004");
			stmt = conn.createStatement();// Statement 인터페이스를 구혆하고 있는 객체의 주소가 return

			// Insert
			int empno = 0;
			String ename = "";
			int deptno = 0;

			Scanner sc = new Scanner(System.in);
			System.out.println("사번입력");
			empno = Integer.parseInt(sc.nextLine());

			System.out.println("이름입력");
			ename = sc.nextLine();

			System.out.println("부서입력");
			empno = Integer.parseInt(sc.nextLine());

			// insert into dmlemp(empno, ename, deptno) values(100,'홍길동',10) 고전적인 방법
			 String sql="insert into dmlemp(empno,ename,deptno) ";
			 sql+= "values(" + empno + ",'" + ename + "'," + deptno+ ")";
			System.out.println(sql);
			// 현재
			// values(?,?,?) >> ?를 parameter 별도 설정
			// excuteUpdate(sql)하나가 insert, update, delete모두 수행

			int resultrow = stmt.executeUpdate(sql);

			if (resultrow > 0) {
				System.out.println("반영된 행의 수 :" + resultrow);
			} else {
				System.out.println("예외가 발생된 것이 아니고 : 반영된 행이 없다. ");
			}

		} catch (Exception e) {
			// 중복데이터 insert 해서 문제가 생기면 executeUpdate() 예외 발생
			// 코드처리
			System.out.println("sql 예외 발생 : "+e.getMessage());
		}finally {
			//강제 수행 블럭
			//자원 해줘야함 정상적이든 비정상적이든

			try {
				stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

}

```

### DML_UPDATE

```java
public class Ex02_Oracle_DML_update {

	public static void main(String[] args) {

		Connection conn = null;
		Statement stmt = null;

		try {
			 //드라이버 로딩
			 //Class.forName("oracle.jdbc.OracleDriver"); 생략가능

			 //Connection 인터페이스를 구현하고 있는 객체의 주소가 리턴 ...
			 //다형성을 통해서 Connection 타입의 conn 변수가 주소값을 받는다
			 conn =  DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","KOSA","1004");
			 stmt = conn.createStatement(); //Statement 구현하고 있는 객체의 주소 리턴

			 //UPDATE

			 int deptno=0;

			 Scanner sc = new Scanner(System.in);
			 System.out.println("부서입력");
			 deptno = Integer.parseInt(sc.nextLine());


			 //update dmlemp set sal=0 where deptno=부서번호
			 String sql="update dmlemp set sal=0 where deptno="+deptno;

			 System.out.println(sql);
			 //현재
			 //values(?,?,?)  >> ? parameter 별도 설정
			 //executeUpdate() >> insert , update , delete  모두 수행
			 int resultrow = stmt.executeUpdate(sql);

			 if(resultrow > 0) {
				 System.out.println("반영된 행의 수 : " + resultrow);
			 }else {
				 System.out.println("예외가 발생된 것이 아니고 : 반영된 행이 없다 ");
			 }

		} catch (Exception e) {
			//중복데이터 insert 해서 문제가 생기면 executeUpdate()예외 발생
			//코드 처리
			System.out.println("SQL 예외발생 : " + e.getMessage());
		}finally {
			//강제 수행 블럭
			//자원해제
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}


	}

}

```

### DML

```java
public class Ex02_Oracle_DML {

	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt = null;
		try {
			// 드라이버 로딩은 생략 가능하다.
			// Class.forName("oracle.jdbc.OracleDriver"); 생략 가능

			// Connection 인터피이스를 구현하고 있는 객체의 주소가 return된다.
			// 다형성을 총해서 connection 인터페이스 타입의 conn 변수가 주소값을 받는다.
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "KOSA", "1004");
			stmt = conn.createStatement();// Statement 인터페이스를 구혆하고 있는 객체의 주소가 return

			// Insert
			int empno = 0;
			String ename = "";
			int deptno = 0;

			Scanner sc = new Scanner(System.in);
			System.out.println("사번입력");
			empno = Integer.parseInt(sc.nextLine());

			System.out.println("이름입력");
			ename = sc.nextLine();

			System.out.println("부서입력");
			empno = Integer.parseInt(sc.nextLine());

			// insert into dmlemp(empno, ename, deptno) values(100,'홍길동',10) 고전적인 방법
			 String sql="insert into dmlemp(empno,ename,deptno) ";
			 sql+= "values(" + empno + ",'" + ename + "'," + deptno+ ")";
			System.out.println(sql);
			// 현재
			// values(?,?,?) >> ?를 parameter 별도 설정
			// excuteUpdate(sql)하나가 insert, update, delete모두 수행

			int resultrow = stmt.executeUpdate(sql);

			if (resultrow > 0) {
				System.out.println("반영된 행의 수 :" + resultrow);
			} else {
				System.out.println("예외가 발생된 것이 아니고 : 반영된 행이 없다. ");
			}

		} catch (Exception e) {
			// 중복데이터 insert 해서 문제가 생기면 executeUpdate() 예외 발생
			// 코드처리
			System.out.println("sql 예외 발생 : "+e.getMessage());
		}finally {
			//강제 수행 블럭
			//자원 해줘야함 정상적이든 비정상적이든

			try {
				stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

}

```

### Connection 부분만 따로 분리

```java
import java.sql.Connection;
import java.sql.SQLException;

import kr.or.kosa.ConnectionHelper;

public class Ex03_ConnectionHelper {

	public static void main(String[] args) throws SQLException {
		Connection conn = null;
		conn = ConnectionHelper.getConnection("oracle");
		System.out.println(conn.toString());
		System.out.println(conn.getMetaData().getDatabaseProductName());
		System.out.println(conn.getMetaData().getDatabaseProductVersion());
		System.out.println(conn.isClosed());

	    Connection conn2 = null;
	    conn2 = ConnectionHelper.getConnection("oracle", "HR", "1004");
	    System.out.println(conn2.toString());

	}


}
```

```java
public class ConnectionHelper {

	public static Connection getConnection(String dsn) {
		Connection conn = null;
		try {
			if (dsn.equals("oracle")) {
				Class.forName("oracle.jdbc.OracleDriver");
				conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "KOSA", "1004");
				Statement stmt = conn.createStatement();
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return conn;
	}

	public static void close(Connection conn) {
		if (conn != null) {
			try {
				conn.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}

	public static void close(ResultSet rs) {
		if (rs != null) {
			try {
				rs.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}

	public static void close(Statement stmt) {
		if (stmt != null) {
			try {
				stmt.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}

	public static void close(PreparedStatement pstmt) {
		if (pstmt != null) {
			try {
				pstmt.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}

	// 오버로딩해서 파라매터의 값만 달리 하겠다.
	public static Connection getConnection(String dsn, String id, String pwd) {
		Connection conn = null;
		try {
			if (dsn.equals("oracle")) {
				Class.forName("oracle.jdbc.OracleDriver");
				conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", id, pwd);
				Statement stmt = conn.createStatement();
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return conn;
	}
}

```

### Connection 부분만 따로 분리(Singleton 사용)

```java
import java.sql.Connection;
import java.sql.SQLException;

import kr.or.kosa.SingletonHelper;

public class Ex04_SingletonHelper {

	public static void main(String[] args) throws Exception {
		//Singleton 사용시
		//하나의 객체를 사용하겠다 ....
		//하나의 객체를 공유해서 사용하겠다

		//single 객체는 공유자원이기에 APP 이 종료될때까지 Close() 하지 않는 것 원칙


		Connection conn = null;
		conn = SingletonHelper.getConnection("oracle");
		System.out.println(conn.toString());
		System.out.println(conn.getMetaData().getDatabaseProductName());
		System.out.println(conn.getMetaData().getDatabaseProductVersion());
		System.out.println(conn.isClosed());

		Connection conn2 = null;
		conn2 = SingletonHelper.getConnection("oracle");
		System.out.println(conn2.toString());
		System.out.println(conn2.getMetaData().getDatabaseProductName());
		System.out.println(conn2.getMetaData().getDatabaseProductVersion());
		System.out.println(conn2.isClosed());

	}
```

```java
package kr.or.kosa;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

//조별 문제
// ConnectionHelpert  코드는 singleton으롷 바꾸세요
public class SingletonHelper {
	private static Connection conn = null; //public > private
	private SingletonHelper() {}

	public static Connection getConnection(String dsn) {
		if(conn != null) {
			System.out.println("conn is not null");
			return conn;
		}
		try {
			  if(dsn.equals("oracle")) {
				  Class.forName("oracle.jdbc.OracleDriver");
				  conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","KOSA","1004");
			  }else if(dsn.equals("mysql")) {
				  Class.forName("com.mysql.cj.jdbc.Driver");
				  conn = DriverManager.getConnection("jdbc:mysql://192.168.0.3:3306/sampledb?characterEncoding=UTF-8&serverTimezone=UTC&useSSL=true","kosta","1004");
			  }

		}catch(Exception e) {
			System.out.println(e.getMessage());
		}

		return conn;
	}



	public static void dbClose() {
		if(conn != null) {
			try {
				 conn.close();//연결해제 (DB 연결 끊기)
				 conn = null; //참조를  null 만는다
			}catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}

     public static void close(Connection conn) {

		if(conn != null) {
			try {
				conn.close();
			}catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}


	public static void close(Statement stmt) {
		if(stmt != null) {
			try {
				stmt.close();
			}catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}

	public static void close(ResultSet rs) {
		if(rs != null) {
			try {
				rs.close();
			}catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}

	public static void close(PreparedStatement pstmt) {
		if(pstmt != null) {
			try {
				pstmt.close();
			}catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}

```

### PreparedStatement

PreparedStatement (준비된 Statement )

(1) 설명
미리 SQL문이 셋팅된 Statement 가 DB가 전송되어져서 컴파일되어지고, SQL문의 ?만 나중에 추가 셋팅해서 실행
이 되어지는 준비된 Statement

ex) select _ from emp where empno=7788->구문분석-> 실행계획-> 메모리....
select _ from emp where EMPNO=7788->구문분석-> 실행계획-> 메모리....(비효율 똑같은 건데 실행과정은 동일하기 때문)

(2) 장점
<1> Statement 에 비해서 반복적인 SQL문을 사용할 경우에 더 빠르다. ( 특히, 검색문 )
<2> DB컬럼타입과 상관없이 ?하나로 표시하면 되므로 개발자가 헷깔리지 않고 쉽다. ( 특히, INSERT문 )
(이유: ?를 제외한 SQL문이 DB에서 미리 컴파일되어져서 대기)

(3) 단점
SQL문마다 PreparedStatement 객체를 각각 생성해야 하므로 재사용불가
(but, Statement 객체는 SQL문이 달라지더라도 한 개만 생성해서 재사용이 가능하다. )

(4) 특징
<1> Statement stmt = con.createStatement(); //생성 stmt.execute(sql);//실행
<2> PreparedStatement pstmt = con.prepareStatement(sql); //생성 pstmt.execute(); //실행

(5) 주의
DB 객체들(table, ..)의 뼈대( 테이블명 or 컬럼명 or 시퀀스명 등의 객체나 속성명)은
?로 표시할 수 없다.
즉, data 자리에만 ?로 표시할 수 있다.
cf) 그래서, DDL문에서는 PreparedStatement를 사용하지 않는다.

장점 : 보안 ( 전체 문장을 DB에 보내지 않아요) 나누어서... SQL문 (파라매터가 빠져있는) 보내서 컴파일 그 다음에는 파라메터만 보낸다. 행안부 보안문서 권장사항이다(보안적 이슈\_
미리 쿼리문 컴파일( 쿼리문은 DB 서버에서 보관) >> 그 이후 전송 >> parameter값만 >> 네트워크 트래픽 감소(성능적 이슈)

단점 : 쿼리문이 바뀌면 다시 컴파일... 4. CallableStatement ( 호출할 수 있는 Statement )
(1) 설명
DataBase 에 미리 컴파일되어 있는 Stored Procedure 를
호출하기 위한 Statement

(2) 생성 / 호출
String sql = "{call incre(?,?)}";
CallableStatement cstmt = con.prepareCall(sql);
(ex: day3/JDBC12.java )

5. 동적 커서 이동
   (1) 설명
   JDBC 2.0 부터는 ResultSet 의 커서가 원하는 위치대로
   이동 가능 함
   -> 이용하려면 stmt 생성시 아래의 방법으로 옵션을 줌

(2) 방법
-> con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
ResultSet.CONCUR_UPDATABLE);
Statement createStatement(int resultSetType,
int resultSetConcurrency)
throws SQLException

1.resultSetType

(1) ResultSet.TYPE_FORWARD_ONLY,

(2) ResultSet.TYPE_SCROLL_INSENSITIVE,

(3) ResultSet.TYPE_SCROLL_SENSITIVE

2.resultSetConcurrency

(1) ResultSet.CONCUR_READ_ONLY

(2) ResultSet.CONCUR_UPDATABLE

(3) 주요 ResultSet 의 커서 이동 메소드

<1> rs.next(); //커서를 한칸씩 내림

<2> rs.previous(); //커서를 한칸씩 올림

<3> rs.beforeFirst(); //커서를 BOF에 위치

<4> rs.afterLast(); // 커서를 EOF에 위치

```java
public class Ex05_Oracle_PreparedStatement {
	public static void main(String[] args) {
		Connection conn= null;
		PreparedStatement pstmt=null;
		ResultSet rs= null;
		try {
			conn=SingletonHelper.getConnection("oracle");
			String sql="select empno, ename from emp where deptno=?";
			//만약에 where조건에 조건이 3개면??
			//where id=? and name=? and job=?
			pstmt = conn.prepareStatement(sql);//미리 컴파일( 쿼리를 DB서버가 가지고 있어요)

			//이후에는 파라매터 설정해서 DB서버에 보내면 된다.
			pstmt.setInt(1, 30);//where deptno =30

			//ResultSet rs= stmt.executeQuery(sql);
			rs=pstmt.executeQuery();
			//공식같은 로직
			//데이터 1건, or 1건 이상 or 없는 경우
			if( rs.next()) {
				do{//rs.next가 true란 얘기 최소 1건은 있는 것이다.
					System.out.println(rs.getInt(1+"/"+rs.getString(2)));
				}while(rs.next());
			}else {
				//데이터 없다.
				System.out.println("조회된 데이터가 없습니다. ");
			}

		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			SingletonHelper.close(rs);
			SingletonHelper.close(pstmt);

	}

	}
}
```

### Prepared DML

    	INSERT
    	insert into dmlemp(empno, ename, deptno) values (?,?,?)

    	UPDATE
    	update dmlemp set ename=?, sal=?, job=?, deptno=?
    	where empno=?

```java
Connection conn=null;
		PreparedStatement pstmt= null;

		try {
			conn= SingletonHelper.getConnection("oracle");
			String  sql= "update dmlemp set ename=?, sal=?, job=?, deptno=? where empno=?";
			pstmt=conn.prepareStatement(sql);//미리 컴파일 해놓는 거임 db서버에 쿼리문만 미리 보냄

			//parameter준비
			pstmt.setString(1, "아무개");//ename='아무개'
			pstmt.setInt(2,2222);//sal=2222
			pstmt.setString(3, "IT");
			pstmt.setInt(4, 20);
			pstmt.setInt(5, 100);//empno=2000

			//실행
			int row = pstmt.executeUpdate();//이 때 ? 값들만 DB로 보낸다.
			if( row>0) {
				System.out.println("update row count :"+row);

			}

		} catch (Exception e) {
System.out.println(e.getMessage());
		}finally {
			SingletonHelper.close(pstmt);
		}

	}

}

```

### 조별과제

sdept 테이블에 대해서
전체조회
조건조회
삽입
삭제
수정
을 작업 하시면 됩니다
PreparedStatement

```java


class Homework{
	Connection conn=null;
	PreparedStatement pstmt= null;
	ResultSet rs=null;
	void insert() {
		try {
		conn=SingletonHelper.getConnection("oracle");
		String  sql= "insert into sdept(DEPTNO,DNAME,LOC) values(?,?,?)";
			pstmt=conn.prepareStatement(sql);

			pstmt.setInt(1, 50);//ename='아무개'
			pstmt.setString(2,"teach");//sal=2222
			pstmt.setString(3, "SEOUL");

			//실행
			int row = pstmt.executeUpdate();//이 때 ? 값들만 DB로 보낸다.
			if( row>0) {
				System.out.println("update row count :"+row);

			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());

		}finally{
			SingletonHelper.close(pstmt);
		}
	}
	void delete() {
		try {
			conn=SingletonHelper.getConnection("oracle");
			String  sql= "delete from sdept where deptno=?";
				pstmt=conn.prepareStatement(sql);

				pstmt.setInt(1,50);

				//실행
				int row = pstmt.executeUpdate();//이 때 ? 값들만 DB로 보낸다.
				if( row>0) {
					System.out.println("delete row count :"+row);

				}

			} catch (SQLException e) {
				System.out.println(e.getMessage());

			}finally{
				SingletonHelper.close(pstmt);
			}

	}
	void update() {
		try {
			conn= SingletonHelper.getConnection("oracle");
			String  sql= "update sdept set deptno=?, dname=?, loc=?";
			pstmt=conn.prepareStatement(sql);//미리 컴파일 해놓는 거임 db서버에 쿼리문만 미리 보냄

			//parameter준비
			pstmt.setInt(1, 30);//ename='아무개'
			pstmt.setString(2,"update");//sal=2222
			pstmt.setString(3, "Busan");

			//실행
			int row = pstmt.executeUpdate();//이 때 ? 값들만 DB로 보낸다.
			if( row>0) {
				System.out.println("update row count :"+row);

			}

		} catch (Exception e) {
System.out.println(e.getMessage());
		}finally {
			SingletonHelper.close(pstmt);
		}

	}
	void findByDname() {
		try {
			conn= SingletonHelper.getConnection("oracle");
			String  sql= "select * from sdept where dname =?";
			pstmt=conn.prepareStatement(sql);//미리 컴파일 해놓는 거임 db서버에 쿼리문만 미리 보냄



			//실행

			pstmt.setString(1, "ACCOUNTING");

			//실행
			rs = pstmt.executeQuery();//이 때 ? 값들만 DB로 보낸다.


			if( rs.next()) {
				do{//rs.next가 true란 얘기 최소 1건은 있는 것이다.
					System.out.println(rs.getString(1)+ "/" + rs.getString(2)+"/"+rs.getString(3));
				}while(rs.next());
			}else {
				//데이터 없다.
				System.out.println("조회된 데이터가 없습니다. ");
			}


		} catch (Exception e) {
System.out.println(e.getMessage());
		}finally {
			SingletonHelper.close(pstmt);
		}

	}
	void findAll() {

			try {
				conn= SingletonHelper.getConnection("oracle");
				String  sql= "select * from sdept";
				pstmt=conn.prepareStatement(sql);//미리 컴파일 해놓는 거임 db서버에 쿼리문만 미리 보냄
				rs=pstmt.executeQuery(sql);//명령 실행


				//실행

				if( rs.next()) {
					do{//rs.next가 true란 얘기 최소 1건은 있는 것이다.
						System.out.println(rs.getInt(1)+"/"+rs.getString(2)+"/"+rs.getString(3));
					}while(rs.next());
				}else {
					//데이터 없다.
					System.out.println("조회된 데이터가 없습니다. ");
				}

			} catch (Exception e) {
	System.out.println(e.getMessage());
			}finally {
				SingletonHelper.close(pstmt);
			}



	}
}
public class sdept {


	public static void main(String[] args) {
		Homework hw = new Homework();
		//hw.insert();
		hw.delete();
	//hw.findAll();
	//hw.findByDname();


	}

}

```
