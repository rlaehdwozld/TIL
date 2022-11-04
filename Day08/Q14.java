package Day4;

import java.util.Scanner;

public class Q14 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int input =sc.nextInt();
		if(input>0) {
			System.out.println(input+"는 양수입니다");
		}else {
			System.out.println(input+"는 음수입니다.");
		}
	}

}
