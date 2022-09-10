package q6;

import java.util.Scanner;

public class Array_10 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int month= (int) ((Math.random()*12+1));
		System.out.println(month);
		
		String a[]= {"jan","feb","mar","apr","may","jun","jul","aug","sep","oct","nov","dec"};
		
	int input=0;
		do {
			
			System.out.println("해당 월의 영어단어를 입력하세요");
			System.out.print(month+":");
			String spell=sc.nextLine();
			if(a[month-1].equals(spell)){
				System.out.println("정답입니다. ");
			}else {
				System.out.println("틀렸습니다.");
			}
				System.out.println("다시 원하시면 0 종료 원하시면 1");						
				input=sc.nextInt();
				
				if(input==0||input==1) { 
					System.out.println(input+"을 선택하셨습니다.");
				}else {
					System.out.println("올바른 수를 입력하세요");
				}
				
		}while(input==0);
	}

}
