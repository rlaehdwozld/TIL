import java.util.Scanner;

public class Ex07_String_Total_Quiz {
	//주민번호 : 뒷번호 첫자리 : 1,3 남자 , 2,4 여자 라고 출력 ... 하는 문제
	//main 함수 Scanner  사용 주민번호 입력받고
	//앞:6자리     뒷:7자리
	//입력값 : 123456-1234567 
	//1. 자리수 체크 (기능)함수 (14 ok)  return true , false 
	//2. 뒷번호 첫번째 자리값 1~4까지의 값만 허용 기능함수  return true, false
	//3. 뒷번호 첫번째 자리값을 가지고 1,3 남자 , 2,4 여자 출력 기능함수  void  출력
	/*
	이 문제 설계에서 필요한 과정
	1. Scanner로 입력값을 받아야겠다.
	2. 
	*/
	public static void main(String[] args) {
		
		Scanner sc= new Scanner(System.in);
		
		System.out.println("당신의 주민번호를 입력하세요(######-####### : ");
		String regNo = sc.nextLine();//주민번호 입력창
		
		char gender=regNo.charAt(7);//regNo에서 8번째 문자 보고 gender을 판단한다.
													//배열은 0부터 시작하는 거라서 8번째는 (7)이다.
		
		String gender1;//마지막에 남자, 여자를 변수로 출력하기 위하여 따로 설정해줌.
		char year=regNo.charAt(0);//주민번호 첫째 자리 숫자를 보고 출생연도가 2000년대 이후인지 이전인지
		String year1;//2000년 이저, 이후를 변수로 출력하기 위하여 따로 설정해줌.
		
		if(gender=='1') {
			gender1="남자";
		}else if(gender =='2') {
			gender1= "여자";
			
		}else {
			gender1= "성별이 없습니다.";
		}//성별 판단
		
		
		
		if(year>=3) {
			year1= "2000년 이전";
			
		}else {
			year1= "2000년이후";
		}//년도 판단
		
		System.out.println("당신은 "+year1+"에 출생한"+gender1+"입니다.");
		
		switch(gender) {
		case '1' :
			gender1= "남자";
			break;
		case'2'	: 
			gender1=" 여자";
		}//성별판단
		
		  switch (year) {
	        case '0':
	        case '1':
	        case '2': //year은 char형이므로 ''안에 넣어줘야한다.
	            year1 = "2000년 이후";
	            break;
	 
	        default:
	            year1 = "2000년 이전";
	            break;
	        } // 2000년대 이후 판단. 2020년이니까 year1 이 2까지는 2000년대 이후 출생. 
	 
	        System.out.println("당신의 주민번호를 입력하세요.: " + regNo);
	        System.out.println("당신은 " + year1 + "에 출생한 " + gender1 + "입니다.");
	        sc.close();
		
		
		
		

		}

	
	

}
