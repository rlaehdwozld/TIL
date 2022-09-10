package q7;

import java.util.Scanner;

public class Method_02 {
	static int min(int a,int b, int c){
		int min=a;
		if(b<min)
			min=b;
		if(c<min)
			min=c;
		return min;
	}
	
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		System.out.println("a값은?");
		int a= sc.nextInt()	;
		System.out.println("b값은?");
		int b= sc.nextInt()	;
		System.out.println("c값은?");
		int c= sc.nextInt()	;
		System.out.println(min(a,b,c));
	}

}
