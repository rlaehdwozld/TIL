package Day4;

import java.util.Scanner;

//3.정 수 를 입력 하고 입력 한 수가 1000 보다 많 으 면'입력 한 수>=1000'을 출력 합 니 다.
//그렇지 않 으 면'입력 한 수<1000'을 출력 합 니 다.
public class Q12 {
	public static void main(String[] args) {
	

	Scanner sc= new Scanner(System.in);
	int a= sc.nextInt();
	if(a>1000) {
		System.out.println("입력한 수 >=1000");
	}else {
		System.out.println("입력한 수<1000");
	}
}
}
