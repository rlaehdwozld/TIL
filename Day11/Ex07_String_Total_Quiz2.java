import java.util.Scanner;

//주민번호 : 뒷번호 첫자리 : 1,3 남자 , 2,4 여자 라고 출력 ... 하는 문제
	//main 함수 Scanner  사용 주민번호 입력받고
	//앞:6자리     뒷:7자리
	//입력값 : 123456-1234567 

	//static
	//1. 자리수 체크 (기능)함수 (14 ok)  return true , false 
	//2. 뒷번호 첫번째 자리값 1~4까지의 값만 허용 기능함수  return true, false
	//3. 뒷번호 첫번째 자리값을 가지고 1,3 남자 , 2,4 여자 출력 기능함수  void  출력
	/*
	이 문제 설계에서 필요한 과정
	1. Scanner로 입력값을 받아야겠다.
	2. 
	카페에 있다 
	*/
class Number{
	
}
static void Print() {
	
}

public class Ex07_String_Total_Quiz2 {
	public static void main(String[] args) {
		String ssn="";
		String regNum[]=new String[14];
		do {
			Scanner sc= new Scanner(System.in);
			System.out.println("주민번호 입력 :");
			ssn= sc.next();
			if(ssn.length()==14) {
				//문자열의 길이가 14일때는 배열안에 값을 받아서 "-"를 ""로 replace 한다음에 
			}else {
				continue;
			}
		}while(true);
	}

}
