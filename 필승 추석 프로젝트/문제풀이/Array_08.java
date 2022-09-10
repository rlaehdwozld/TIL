package q6;

import java.util.Scanner;

public class Array_08 {
	public static void main(String[] args) {
		
	Scanner sc= new Scanner(System.in);
	int n=sc.nextInt();
	int[] a=new int[n];
	
	for( int i=0;i<a.length;i++) {
		a[i]=(int) (Math.random()*10+1);
		System.out.println(a[i]);
	}
	
	}
	


}
