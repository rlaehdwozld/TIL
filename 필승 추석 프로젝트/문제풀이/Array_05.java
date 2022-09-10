package q6;

import java.util.Scanner;

public class Array_05 {
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
				System.out.println("요소값을 입력하세요");
		int i=sc.nextInt();
		
		int a[]=new int[i];
		
		for(int j=0;j<a.length;j++) {
			System.out.println("배열의 각 값을 입력하시오");
			Scanner k= new Scanner(System.in);
			a[j]=k.nextInt();
			
			
		}
		
		for(int p=0;p<a.length;p++) {
			System.out.print(a[p]+"  ");
		}
	}

}
