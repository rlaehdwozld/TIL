package q4;
//2자리의 정숫값(10~99) 숫자 맞추기 게임을 만들자  난수 생성과 if문 그리고 do문을 사용할 것

import java.util.Scanner;

public class Q4_3 {

	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int input;
		int rd = (int)(Math.random()*100+1);
		System.out.println(rd);
		
		do {
			System.out.println("정수를 입력하세요");
		input = sc.nextInt();
		if(input>rd) {
			System.out.println("더 작은 수 입니다.");
		}else if(input<rd) {
			System.out.println("더 큰 수 입니다.");
		}
		
	}while(input!=rd);
		System.out.println("정답입니다!");
		sc.close();
		
	}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
	/*	Scanner sc= new Scanner(System.in);
		int rd= (int)(Math.random()*100+1);
		int input;
		System.out.println(rd);
		do {
			System.out.println();
			System.out.println("정수값을 입력하세요");
			input = sc.nextInt();
			
			if(input>rd) {
				System.out.println("더 작은 수입니다.");
			}else if(input<rd){
				System.out.println("더 큰 수 입니다.");
				
			}
		}while(input!=rd);
		
		System.out.println("정답입니다.");
		
	}
}
*/