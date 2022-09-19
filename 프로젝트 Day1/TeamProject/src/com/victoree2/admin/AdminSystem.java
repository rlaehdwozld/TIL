package com.victoree2.admin;




import java.util.Scanner;

import com.victoree2.common.ReadingroomFactory;
import com.victoree2.common.accountSystem;
import com.victoree2.common.returnmessage;
import com.victoree2.user.SignupSystem;


public class AdminSystem extends returnmessage implements accountSystem{
	Scanner scan = new Scanner(System.in);
	private String language="kor";
	ReadingroomFactory factory;
	
	
	public AdminSystem(String language) {
		this.language = language;
		this.factory = new ReadingroomFactory();
	}
	@Override
	public void run() {
		System.out.println("관리자 페이지에 접속하였습니다.");
		
		int key=0;
		while ((key = selectMenu()) != 0) {
			SignupSystem user = factory.getUser();
			user.load(); // 로그인 체크를 위해 로그인 정보가 저장된 파일을 불러올것이다
			switch (key) {
			case 1:
				
				break;
			case 2:
				user.signUP();
				break;
			case 0:
				System.out.println("종료");
				System.exit(0);
				break;
			default:
				System.out.println("잘못 선택하였습니다.");
				break;
			}
		}

	}
	public void selectAccount(SignupSystem id) {
		//특정회원 조회
	}
	
	@Override
	public void selectAccount() {
		//회원 전부 조회
		
	}

	@Override
	public void paymentCancel() {
		//관리자는 회원 결제내역을 삭제할 수 있다.
		
	}

	@Override
	public void checkSeat() {
		//전체좌석을 확인할 수 있다.
		
	}
	@Override
	public int selectMenu() {
		System.out.println("1:회원정보 조회 2:결제취소 3:자리조회 0:종료");
		return Integer.parseInt(scan.nextLine());
	}
	
	
}
