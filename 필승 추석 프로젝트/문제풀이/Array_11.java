package q6;

import java.util.Scanner;

public class Array_11 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		final int number =6;
		
		int[][]point = new int [number][2];
		int []sumStudent	= new int[number];
		int[]sumSubject	= new int[2];
		
		System.out.printf("%d명의 국어, 수학 점수를 입력하세요\n",number);
		for(int i=0;i<number;i++) {
			System.out.print("국어"+i+1);
			point[i][0]=sc.nextInt();
			System.out.print("수학"+i);
			point[i][1]=sc.nextInt();
			
			sumStudent[i]=point[i][0]+point[i][1];
			sumSubject[0]+=point[i][0];
			sumSubject[1]+=point[i][1];
			
		}
		
		
	}

}
