package kr.or.bit;

import java.util.Scanner;

public class Lotto1 {
	public static void main(String[] args) {
		int[] lotto1=new int[6];
		
		Scanner sc = new Scanner(System.in);
		int cnt=(int)(Math.random()*45+1);
		int i=0;
		
		
		while(i<lotto1.length) {
		if(cnt %2!=0) {
			lotto1[i]=cnt;
				i++;
				 cnt=(int)(Math.random()*45+1);
			}
		else 
			{
				 cnt=(int)(Math.random()*45+1);
			
			}
		}
		for(int arr :lotto1) {
			System.out.print(arr+" ");
		}
	}
}
