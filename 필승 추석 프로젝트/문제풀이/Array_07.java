package q6;

import java.util.Scanner;

public class Array_07 {
public static void main(String[] args) {
	Scanner n= new Scanner(System.in);
	
	System.out.println("배열의 요소는?");
	int cnt=n.nextInt();
	int a[]= new int[cnt];
	
	for(int i=0;i<a.length;i++) {
		a[i]=n.nextInt();
		System.out.println("a["+i+"] : "+a[i]);
	}
	System.out.println("찾을 값을 입력하시오");
	int find = n.nextInt();
	for(int i=0;i<a.length;i++) {
		if(find==a[i]) {
			System.out.println("그 값은 a["+i+"]에 있습니다.");
			break;
		}
	
}
}
}