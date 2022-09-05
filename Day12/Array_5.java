package 명품자바;

import java.util.Scanner;

public class Array_5 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("정수를 입력하세요");
		int[]arr=new int[10];
		for(int i=0;i<arr.length;i++) {
			arr[i]=sc.nextInt();
		}
		for(int j=0;j<arr.length;j++) {
			if(arr[j]%3==0) {
				System.out.println(arr[j]);
			}
		}
	}

}
