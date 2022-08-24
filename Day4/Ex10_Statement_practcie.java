import java.util.Scanner;

public class Ex10_Statement_practcie {

	public static void main(String[] args) {
		 
		        Scanner scan = new Scanner(System.in);
		        System.out.print("값을 입력하라 : ");
		        int a = scan.nextInt();
		        
		        while(a < 1) {
		            System.out.print("0이나 그 이하의 값은 불가능, 값 재입력 : ");
		            a = scan.nextInt();
		        }
		        for(int i = 1; i <= a; i++) {
		            for(int j = 1; j <= i; j++) {
		                if(j<i) {
		                    System.out.print("@");
		                }else {
		                    System.out.print("*");
		                }
		            }
		            System.out.println();
		        }
		        
		        
		        //-------------------------------------------------------------------
		        
		        int b;
		        int n;
		         
		         do {
		            System.out.print("출력 줄수 : ");
		            b = scan.nextInt();
		        }while(b <= 1);
		        System.out.println();
		        n = b*2-1;
		        
		        for(int i = 1; i <= b; i++) {
		            for(int j = 1; j <= n; j++) {
		                if(j<i) {
		                    System.out.print(" ");
		                }else {
		                    System.out.print("*");
		                }
		            }
		            n--;
		            System.out.println();
		            scan.close();
		        }
		//------------------------------------------------------------------------        
		        
		       
		         int c;
		        int m;
		        int s;
		         
		         do {
		            System.out.print("출력 줄수 : ");
		            c = scan.nextInt();
		        }while(c <= 1);
		         s = m = c;
		         System.out.println();
		         
		         for(int i = 1; i <= c; i++) {
		             for(int j = 1; j <= m; j++) {
		                 if(j<s) {
		                     System.out.print(" ");
		                 }else {
		                     System.out.print("*");
		                 }
		             }
		             s--;
		             m++;
		             System.out.println();
		             scan.close();
		        }
	//------------------------------------------------------------------------	        
		       
		         int d;
		         
		         do {
		            System.out.print("출력 줄수 : ");
		            d = scan.nextInt();
		        }while(d <= 1);
		     
		         System.out.println();
		         
		         for(int i = 1; i <= d; i++) {
		             for(int j = 1; j <= i+d-1; j++) {
		                 if(j<d+1-i) {
		                     System.out.print(" ");
		                 }else {
		                     System.out.print("*");
		                 }
		             }
		             System.out.println();
		             scan.close();
		        }
		         //------------------------------------------------------------
		         
		         int coffee= 10;
		         int money = 300;
		         while(money>0) {
		        	System.out.println("돈이 남았으니 커피를 줍니다.");
		        	 coffee--;
		        	 System.out.println("남아있는 커피 양은 "+coffee+"입니다.");
		        	 if(coffee==0) {
		        		 System.out.println("커피가 다 떨어졌습니다");
		        		 break;
		        		 
		        	 }
		        	 
		         }
	}

}
