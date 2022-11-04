package kr.or.bit;

import java.util.Scanner;

public class Cinema_Book {
	// 예매조회
	Scanner sc= new Scanner(System.in);
	static String[][] seatArr = new String[4][5];
	
	//좌석초기화
	public void Cinema() {
	      for(int i=0;i<seatArr.length;i++) {
	         for(int j=0;j<seatArr[i].length;j++) {
	            seatArr[i][j] = i+1 + "-" + ((int)j+1);
	         }
	      }
	   }

	

	  public void showSeat() {
	      for(int i=0;i<seatArr.length;i++) {
	         for(int j=0;j<seatArr[i].length;j++) {
	            System.out.print("[ "+seatArr[i][j]+ " ]");
	         }
	         System.out.println();
	      }
	  }


			/*
			 * for (int i = 0; i < seatArr.length; i++) { for (int j = 0; j <
			 * seatArr[i].length; j++) { System.out.printf("[%s]", seatArr[i][j].equals("["
			 * + (i + 1) + "-" + (j + 1) + "]") ? (i + 1) + "-" + (j + 1) : "예매"); }
			 * System.out.println(); }
			 */
	
	
	
	
		      
			public void booking() {
			      while(true) {
			         System.out.print("예매하고자 하는 좌석 번호(행, 열)을 입력하세요...>>");
			         int x = sc.nextInt() - 1;
			         int y = sc.nextInt() - 1;
			         if(seatArr[x][y] == "예매") {
			            System.out.println("이미 예매된 자리입니다.");
			            return;
			         }else {
			            System.out.print("예매하시겠습니까? (1)예 (2)다른좌석예매하기 (3)초기화면으로 돌아가기>>");
			            int answer = sc.nextInt();
			            
			 
			            switch(answer) {
			               case 1: seatArr[x][y] = "예매";
			                  System.out.printf("예매가 완료되었습니다... [%d-%d]\n", x+1, y+1);
			                   showSeat();
			                  return;
			                 
			               case 2:continue;
			               case 3:return;
			            }
			            }
			      }
			}
			      
			      
			   
			
		
		/*
		 * while(true) { System.out.println("좌석을 선택해주세요."); booknum = sc.nextLine();
		 * 
		 * if (seatArr[row][col].equals(booknum)) { System.out.println("예매 가능한 좌석입니다.");
		 * System.out.println("예매 하시겠습니까? ");
		 * System.out.println("네(1), 아니오(2), 초기화면(0)"); a=sc.nextInt(); if(a==1) { for
		 * (int i = 0; i < seatArr.length; i++) { for (int j = 0; j < seatArr[i].length;
		 * j++) { System.out.printf("[%s]", seatArr[i][j].equals("[" + (i + 1) + "-" +
		 * (j + 1) + "]") ? (i + 1) + "-" + (j + 1) : "예매"); }
		 * 
		 * } } } else { System.out.println("이미 예매된 좌석입니다."); break; }
		 */
		//}
		
		


	public static void main(String[] args) {
		String[][] seatArr = new String[4][5];
		Cinema_Book book1 = new Cinema_Book();
		book1.Cinema();
		book1.showSeat();
		book1.booking();
	
	}

}
