import java.util.Random;
import java.util.Scanner;

public class Ex12_Statement_Quiz_Practice {

	public static void main(String[] args) {
		/*
		 * 가위 , 바위 ,보 게임 또 제어문을 통해서 작성하세요 (IF)
		 * 
		 * 예를 들명)
		 * 
		 * 컴퓨터가 자동으로 나온 가위 , 바위 , 보 에 대해서 사용자가 값을 입력 해서 처리 하세요
		 * 
		 * ( 예를 들면 : 가위=> 1 , 바위 => 2 , 보 => 3)
		 * 
		 * ​
		 */
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.println("1.가위   2.바위   3.보");
			System.out.println("선택하세요");

			int user = Integer.parseInt(sc.nextLine());
		
			int com = 0;
			int com2=0;
			Random r = new Random();
			com = (r.nextInt(3) + 1);
			
			com2=(r.nextInt(3));
			System.out.println("당신 :"+user+"|"+com+": 컴퓨터");
			System.out.println(com2+"com2");
			// 판단
			int diff= user-com;
			
			if(user>=4) {
				System.out.println("잘못된 수를 입력하셨습니다. 다시 실행하십시오");
				break;
			}else
			{
				if(diff==0) {
					System.out.println("무승부입니다.");
				}else if(diff==-2 ||diff==1){
					System.out.println("이겼습니다");
				}else {
					System.out.println("졌습니다.");
				}
			}
			
				
//			if (user == 1) {
//				if (com == 1) {
//					System.out.println("비겼습니다");
//				} else if (com == 2) {
//					System.out.println("졌습니다.");
//				} else if
//					System.out.println("이겼습니다.");
//			} else if (com == 2) {
//				if (com == 1) {
//					System.out.println("졌습니다.");
//				} else if (com == 2) {
//					System.out.println("이겼습니다.");
//				} else
//					System.out.println("비겼습니다.");
//			} else if (com == 1) {
//				System.out.println("이겼습니다.");
//			} else if (com == 2) {
//				System.out.println("비겼습니다.");
//			} else
//				System.out.println("졌습니다.");

		}
		
	}

}
