package q6;

import java.util.Scanner;

public class Array_09 {
	public static void main(String[] args) {
		
			
			Scanner sc= new Scanner(System.in);
			System.out.println("요소의 수는");
			int n=sc.nextInt();
			int[] a=new int[n];
			a[0]=(int) (Math.random()*10+1);
			for( int i=1;i<a.length;i++) {
				
				do {
			
					
					a[i]=(int) (Math.random()*10+1);
				
				}while(a[i]==a[i-1]);
				
			}
			for(int i=0;i<a.length;i++)	{
				System.out.println(a[i]);
			}
			
	}

}
