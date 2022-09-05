package q4;

import java.util.Scanner;

public class Q4_5 {
public static void main(String[] args) {
	Scanner sc= new Scanner(System.in);
	int a;
	do {
		System.out.println("값을 입력하라");
		a=sc.nextInt();
		if(a<0) {
			System.out.println("양수 값을 입력하라");
		}
		
	}while(a<=0);
	
	while(a>=0){
		
		System.out.println(a--);
	}
	System.out.println(a+"입니다");
}


}
