package 주말;

import java.util.Scanner;

public class etc_ex07_2 {
	static boolean juminCheck(String str) {
		return str.length() == 14 ? true : false;

	}

	static boolean juminGenderCheck(String str) {
		boolean numcheck = false;
		int num = Integer.parseInt(str.substring(7, 8));
		if (num < 0 || num > 4) {
			return numcheck = false;
		} else {
			return numcheck = true;
		}

	}

	static void juminDisplay(String ssn) {
		char cgen = ssn.replace("-", "").charAt(6);
		// 123456-1234567 -> 1234561234567 > 123456[1]234567 추출> '1'
		switch (cgen) {
		case '1': // break 생략
		case '3':
			System.out.println("남자^^");
			break;
		case '2': // break 생략
		case '4':
			System.out.println("여자^^");
			break;
		default:
			System.out.println("중성");
		}
	}

	public static void main(String[] args) {
		String ssn = "";
		do {
			Scanner sc = new Scanner(System.in);
			System.out.print("주민번호 입력:");
			ssn = sc.nextLine();
		} while (!juminCheck(ssn) || !juminGenderCheck(ssn));
		// 둘다 true 인경우 > false || false 탈출
		// !true || !true => false || false 탈출
		juminDisplay(ssn);
	}

	/*
	핵심 
	1. 기초 설계  : 메서드와 파라매터 값을 어떻게 받을 것인지 설계를 해야한다. 
	2. main문에 do while에서 boolean 값으로 루프를 돌릴지 말지 결정짓는 코드에 대한 이해
	3. 주민번호와 성별 유효성 검사에 대한 매개변수값의 구분 아이디어
	4. "-"이 포함된 String 값을 char at()메서드로 char값으로 받고 swift문 돌려줌
	*/
}
