package Day4;

import java.util.Scanner;

public class Q10 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("정수를 입력하세요");
		int input = sc.nextInt();
		if(input==0) {
			System.out.println("돌");
		
		}else if(input ==1) {
			System.out.println("가위");
		}else if(input ==2) {
			System.out.println("보");
		}else {
			System.out.println("오류");
		}
	}

}
