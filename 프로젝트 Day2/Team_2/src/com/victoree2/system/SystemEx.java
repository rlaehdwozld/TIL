package com.victoree2.system;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

import com.victoree2.common.AccountData;
import com.victoree2.common.ReturnMessage;
import com.victoree2.main.ReadingRoom;

public class SystemEx extends ReturnMessage{
	Scanner scan = new Scanner(System.in);


	ReadingRoomFactory factory = new ReadingRoomFactory();
	ReadingRoom room = new ReadingRoom();
	boolean change = true;
	
	public void run() {
		System.out.println(message(room.language, "0004"));
		
		int key=0;

		while((key = selectMenu()) != 0){
			AccountSystem user = factory.getUser();
			user.load(); //로그인 체크를 위해 로그인 정보가 저장된 파일을 불러올것이다
			//관리자가 회원의 정보를 모두 보기위해 map값을 전부 가져옴
			HashMap<String, AccountData> userMap = user.getAccount();
						
			switch (key) {
			case 1://로그인
				AccountData userStatus = user.login();
				if (userStatus != null) {
					if (userStatus.getStatus() == 1) {// 사용자일 경우
						UserSystem us = factory.getUserSystem(userStatus);
						us.run();
					} else if (userStatus.getStatus() == 9) {// 관리자일 경우.
						AdminSystem as = factory.getAdminSystem(userMap);
						as.run();
					} else if (userStatus.getStatus() == 0) {
						System.out.println(message(room.language, "0000"));
						// System.out.println("해당계정은 정지되었습니다.");
					}
				}
				break;
			case 2://회원가입
				user.signUP();
				break;
			case 3://좌석보기
				break;
			case 4://언어선택
				change=!change;
				room.language = (change) ?  "kor" : "en";
				break;
			case -1:
				System.out.println(message(room.language, "0018"));
				System.exit(0);
				break;
			default:
				System.out.println(message(room.language, "0020"));
				break;
			}
		}
	}
	
	int selectMenu() {
		System.out.println(message(room.language, "0001"));
		
		return Integer.parseInt(scan.nextLine());
	}
}
