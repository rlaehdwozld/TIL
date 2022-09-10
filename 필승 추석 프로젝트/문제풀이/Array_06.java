package q6;

import java.util.Scanner;

public class Array_06 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("사람수 입력");
		int num = sc.nextInt();

		System.out.println("사람 수는 " + num);

		int a[] = new int[num];
		int sum = 0;
		for (int i = 0; i < num; i++) {// a[] 점수 삽입
			System.out.println((i + 1) + "번째 점수는?");
			a[i] = sc.nextInt();
			sum += a[i];

		}

	int max=a[0];
	int min=a[0];
	for(int i=1;i<num;i++) {
		if(a[i]>max) {
			max=a[i];
		}
		if(a[i]<max) {
			min=a[i];
		}
	}
	
	System.out.println(max+ "max");
	System.out.println(min+"min");
	

	}

}
