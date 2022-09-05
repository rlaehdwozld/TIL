package q4;

import java.util.Scanner;

public class Q4_4 {
	public static void main(String[] args) {
		
	
		Scanner sc= new Scanner(System.in);
		System.out.println("정수값을 입력해라");
		int a= sc.nextInt();
		int b= sc.nextInt();
		
		if(a>b) {
			int t;
			t=a;
			a=b;
			b=a;
			
		}
		do {
			System.out.println(a+"");
			a+=1;
		}while(a<=b);
		System.out.println();
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		/*
		 * Scanner sc= new Scanner(System.in);{ System.out.println("a, b를 입력하세요"); int
		 * x=sc.nextInt(); int y=sc.nextInt();
		 * 
		 * if(x>y) { int t=x; x=y; y=t; } do { System.out.println(x); x+=1;
		 * }while(x<=y);
		 * 
		 * System.out.println(); }
		 */
}
}