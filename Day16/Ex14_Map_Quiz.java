import java.util.HashMap;
import java.util.Scanner;

public class Ex14_Map_Quiz {

	public static void main(String[] args) {
		/*
		 Map 사용 구현하는 데이터 집합
		 지역번호 , 우편번호 , 회원가입(id,pwd) 정보 
		  
		 */
		HashMap loginmap = new HashMap();
		loginmap.put("kim", "kim1004");
		loginmap.put("scott", "tiger");
		loginmap.put("lee", "kim1004");
		
		/*
		 우리 시스템은 회원가입한 회원의 id,pwd정보를 가지고 있다
		 로그인시 아이디와 비번을 확인해서 회원이라면 사이트 접속 가능 
		 
		 id(0) , pwd(0) >> 회원님 방가방가        1
		 id(0) , pwd(x) >> 비밀번호 입력 추가....  2
		 
		 id(x) , pwd(0) >> 회원가입으로 유도       3
		 id(x) , pwd(x) >> 회원가입으로 유도
		  
		 */
		
			//id 와 pwd 받으세요
			//id는 공백 제거 >> 소문자 변환  (String 함수)
			//pwd 공백제거
			/*
			 id(0) , pwd(0) >> 회원님 방가방가  출력하세요 while 탈출
			 id(0) , pwd(x) >> 아이디 , 비밀번호 확인해 주세요 입력 받게 ...
			 
			 id(x) , pwd(0) >> id 재입력 하세요 출력   아이디 , 비밀번호 입력
			 id(x) , pwd(x) >> id 재입력 하세요 출력   아이디 , 비밀번호 입력
			 3가지 논리를 if문을 제어
			
			 */
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.println("id, pwd  입력해 주세요");
			
			System.out.println("ID");
			String id = sc.nextLine().trim().toLowerCase();
			
			System.out.println("PWD");
			String pwd = sc.nextLine().trim();
			
			if( !loginmap.containsKey(id)) {
				  //id(x)
				  System.out.println("id 맞지 않습니다 ... 재입력 하세요");
			}else {
				  //id(0)
				   if(loginmap.get(id).equals(pwd)) {
					      System.out.println("회원님 방가방가 ^^");
					      break;
				   }else {
					     System.out.println("비밀번호 확인하세요");
				   }
			}
		}
	}

}