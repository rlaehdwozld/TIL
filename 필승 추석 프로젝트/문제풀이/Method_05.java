package q7;

import java.util.Scanner;

public class Method_05 {
	
	static void printSeason(int m) {
		
		switch(m) {
		case 1 : case 12: case 2: System.out.println("겨울");break;
		case 3: case 4: case 5:System.out.println("봄");break;
		case 9: case 10: case 11:System.out.println("가을");break;
		case 6: case 7: case 8:System.out.println("여름");break;
	
		}

		
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int m=sc.nextInt();
		printSeason(m);
	}

}
