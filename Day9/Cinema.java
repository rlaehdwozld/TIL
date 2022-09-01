
  package kr.or.bit;
/*
 * import java.util.Scanner;
 * 
 * public class Cinema { Scanner sc = new Scanner(System.in); static String[][]
 * seatArr = new String[4][5];
 * 
 * // 좌석초기화 public void Cinema() { for (int i = 0; i < seatArr.length; i++) {
 * for (int j = 0; j < seatArr[i].length; j++) { seatArr[i][j] = i + 1 + "-" +
 * ((int) j + 1); } } }
 * 
 * public void showSeat() { for (int i = 0; i < seatArr.length; i++) { for (int
 * j = 0; j < seatArr[i].length; j++) { System.out.print("[ " + seatArr[i][j] +
 * " ]"); } System.out.println(); } }
 * 
 * public void booking() { while (true) {
 * System.out.print("예매하고자 하는 좌석 번호(행, 열)을 입력하세요...>>"); int x = sc.nextInt() -
 * 1; int y = sc.nextInt() - 1; if (seatArr[x][y] == "예매") {
 * System.out.println("이미 예매된 자리입니다."); return; } else {
 * System.out.print("예매하시겠습니까? (1)예 (2)다른좌석예매하기 (3)초기화면으로 돌아가기>>"); int answer =
 * sc.nextInt();
 * 
 * switch (answer) { case 1: seatArr[x][y] = "예매";
 * System.out.printf("예매가 완료되었습니다... [%d-%d]\n", x + 1, y + 1); showSeat();
 * return;
 * 
 * case 2: continue; case 3: return; } } } } }
 */

import java.util.Scanner;
public class Cinema {
static Scanner scanner = new Scanner(System.in); 
static String[][] seatArr = new String[4][5];
private int Row, Column;


/*====================좌석 초기화(생성자)====================*/
public void init() {
	for(int i=0;i<seatArr.length;i++) {
		for(int j=0;j<seatArr[i].length;j++) {
			seatArr[i][j] = i+1 + "-" + ((int)j+1);
		}
	}
}


/*====================시작====================*/
	void start() {
		while(true)
		
			switch (displayMenu ()) {
			case 1: reservation ();
			break;
			case 2: checkReservation ();
			break;
			case 3: cancelReservation ();
			break;
			case 4:
				System.exit(0);
			break;
		}
		}
	

	/*====================기능 정의====================*/
	void reservation () {
		System.out.println("예약하기");
		booking();

	}
	
	void checkReservation () {
		System.out.println("예매조회");
		showSeat();
	}
	
	void cancelReservation () {
		System.out.println("예매취소");
		delete();
	}
	
	int displayMenu (){

		int input = 0; 
			
					try {
						System.out.println("*****************************");
						System.out.println("******* 영화 예매 시스템 *******");
						System.out.println("*****************************");
						System.out.println("******* 메뉴를 선택하세요 *******");
						System.out.println("*****************************");
						System.out.println("1. 예약하기");
						System.out.println();
						System.out.println("2. 예매조회");
						System.out.println();
						System.out.println("3. 예매취소");
						System.out.println();
						System.out.println("4. 프로그램종료");
						System.out.println();
						
						input = Integer.parseInt(scanner.next()); // 원하는 메뉴번호 입력
						if (input >=1 && input <=4) //입력한 값 input 이 1과 6사이의 값이면
						{
							return input; //do~while문 탈출
						}
						else { //input이 1과 6사이의 값이 아니면
							//throw new Exception("메뉴 선택 번호가 잘못되었습니다"); // 예외 처리 클래스 Exception
						}// else 문 끝
					} // try 문 끝
					catch (Exception e) { // try 안에서 에러가 나면(에러가 나는 상황: input 이 1~6 사이의 int이 아닌 경우) 문제발생 파일의 주소를 parameter 'e'가 가진다
//						System.out.println("에러 발생 원인: " + e.getMessage()); // e.getMessage() : 
//						System.out.println("1~3까지의 메뉴 번호 중 하나를 입력해 주세요");
	
					}
			
	// 1~3중 하나를 선택했다면
	 return input; 
	 
	}

	
	
	/*====================예매====================*/
	
	public void booking() {
		while (true) {
			System.out.print("예매하고자 하는 좌석 번호(행, 열)을 입력하세요...>>");
			int x = scanner.nextInt() - 1;
			int y = scanner.nextInt() - 1;
			
			if (seatArr[x][y] == "예매") {
				System.out.println("이미 예매된 자리입니다.");
				return;
			} else {
				System.out.print("예매하시겠습니까? (1)예 (2)다른좌석예매하기 (3)초기화면으로 돌아가기>>");
				int answer = scanner.nextInt();

				switch (answer) {
				case 1:
					seatArr[x][y] = "예매";
					System.out.printf("예매가 완료되었습니다... [%d-%d]\n", x + 1, y + 1);
					//showSeat();
					return;

				case 2:
					continue;
				case 3:
					return;
				}
			}
		}
	}
	
	
	
	/*====================예매취소====================*/
	public void delete() {
		showSeat();
		checknumber();
		checkSeat();
		}
	
	public void checknumber() {
		System.out.println("취소할 좌석을 알려주세요 (숫자 중간 띄어쓰기)");
			int Row = (scanner.nextInt()-1);
			int Column = (scanner.nextInt()-1);
			if(seatArr.length > Row && seatArr[0].length > Column) {
				this.Row = Row;
				this.Column = Column;
			}
			else {
				System.out.println("없는자리입니다. 다시 해주세요.");
				checknumber();
				return;
			}
	}
		
	public void checkSeat() {
		
			boolean i = seatArr[this.Row][this.Column].equals("예매");
			if(i != true) {
				System.out.println("빈 좌석입니다.");
			} else {
				System.out.println("예매취소 완료 되었습니다.");
				seatArr[this.Row][this.Column] = Row + 1 + "-" + ((int)Column+ 1);
			}
	}
	
	
	public void Init() {
		for(int i=0;i<seatArr.length;i++) {
			for(int j=0;j<seatArr[i].length;j++) {
				seatArr[i][j] = i+1 + "-" + ((int)j+1);
			}
		}
	}
	
	public void showSeat() {
		System.out.println("현 좌석 상태입니다.");
		for(int i=0;i<seatArr.length;i++) {
			for(int j=0;j<seatArr[i].length;j++) {
				System.out.print("["+seatArr[i][j]+ "]");
			}
			System.out.println();
		}
	}
	
	
	


	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Cinema seatReservation = new Cinema();
		seatReservation.init();
		seatReservation.start();
	}

}