package prac_1;

import java.util.Scanner;

public class etc_ex07 {
	public static void main(String[] args) {
		// 주민번호 : 뒷번호 첫자리 : 1,3 남자 , 2,4 여자 라고 출력 ... 하는 문제
		// main 함수 Scanner 사용 주민번호 입력받고
		// 앞:6자리 뒷:7자리
		// 입력값 : 123456-1234567
		// 1. 자리수 체크 (기능)함수 (14 ok) return true , false
		// 2. 뒷번호 첫번째 자리값 1~4까지의 값만 허용 기능함수 return true, false
		// 3. 뒷번호 첫번째 자리값을 가지고 1,3 남자 , 2,4 여자 출력 기능함수 void 출력

		Scanner sc = new Scanner(System.in);

		System.out.println("당신의 주민번호를 입력하세요 (######-####### : ");
		String regNo = sc.nextLine();
		char gender = regNo.charAt(7);

		String gender1 = null;
		
		char year = regNo.charAt(0);
		String year1;

		switch (gender) {
		case '1':
			gender1 = "남자";
			break;
		case '2':
			gender1 = "여자";
			break;
		case '3':
			gender1 = "남자";
			break;
		case '4':
			gender1 = "여자";
			break;
		default:
			break;
			// 성별 판단
		}
			switch (year) {
			case '0':
			case '1':
			case '2':
				year1 = "2000년대 이후";
				break;
			default:
				year1 = "2000년대 이전";
				break;

			}
			
			System.out.println("당신의 주민번호를 입력하세요"+regNo);
			System.out.println("당신은 "+year1+"에 태어난"+gender1+"입니다");
		}
	
	}


	/*
	  이 문제의 핵심
	  1.주민등록번호에 대한 이해 
	  2. charAt으로 요구사항을 뽑을 수 있는가
	  3. switch문 2번 
	 */