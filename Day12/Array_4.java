package 명품자바;

import java.util.Scanner;

public class Array_4 {
	

		   public static void main(String[] args) {
		      // TODO Auto-generated method stub
		      Scanner sc = new Scanner(System.in);
		      String s;
		      char c;
		      
		       s=sc.next();
		      c=s.charAt(0);
		      for(int i=0;i<c-'a';i++	) {
		    	  for(char j='a';j<=c-i;j++) {
		    		  System.out.print(j);
		    	  }
		    	  System.out.println();
		      }
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
				/*
				 * System.out.print("소문자 알파벳 하나를 입력하시오 >> "); s = sc.next(); //s 에 문자열 읽기 c =
				 * s.charAt(0); //s의 첫번쨰 문자를 c에 입력 System.out.println(c); for(int i = 0;
				 * i<=c-'a'; i++) { for(char j = 'a'; j<= c-i; j++) { System.out.print(j); }
				 * System.out.println(); }
				 * 
				 * sc.close();
				 */

		
	}

}
