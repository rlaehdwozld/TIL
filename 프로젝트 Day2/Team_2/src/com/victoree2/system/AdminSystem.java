package com.victoree2.system;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import com.victoree2.common.AccountData;
import com.victoree2.common.ActionInterface;
import com.victoree2.common.ReturnMessage;
import com.victoree2.main.ReadingRoom;


public class AdminSystem extends ReturnMessage implements ActionInterface{
	Scanner scan = new Scanner(System.in);
	ReadingRoom room = new ReadingRoom();
	ReadingRoomFactory factory;
	HashMap<String, AccountData> userMap;
	
	Scanner adminScan = new Scanner(System.in);
	

	public AdminSystem(HashMap<String, AccountData> userMap2) {
		this.userMap = userMap2;
		this.factory = new ReadingRoomFactory();
	}
	@Override
	public void run() {
		System.out.println(message(room.language, "0021"));//"관리자 페이지에 접속하였습니다."
		
		//1:좌석현황 2:전체 회원 목록 3:회원검색 4:회원정지 5:매출현황 6:쿠폰관리 0:로그아웃
		int key=0;
		while ((key = selectMenu("0")) != -1) {
			switch (key) {
			case 1:
				selectAccount();
				break;
			case 2:
				selectAccount();
				break;
			case 3:
				specificUser();
				break;
			case 4:
				coupon();
				break;
			case 0:
				System.out.println(message(room.language, "0018"));
				System.exit(0);
				break;
			default:
				System.out.println(message(room.language, "0020"));
				break;
			}
		}

	}

	public void specificUser() {
//		int key = selectMenu("03");  //이걸 살려두면 selectAccount에서 스캐너에 String이 들어가 selectMenu에서 에러가 뜸...어카징?
		System.out.println(message(room.language, "0053"));
		String id = scan.nextLine();
		Boolean searchResultCheck = selectAccount(id).size()!=0 ? true : false;
			int key;// = selectMenu("03");
			
			if(searchResultCheck) {
				while((key = selectMenu("03"))!=-1){
					switch(key){
						case 1:
							//회원 경고
							System.out.println("WARNNG");
							break;
						case 2:
							//입퇴실내역조회
							System.out.println("입퇴실내역조회");
							break;
						case 3:
							//비밀번호 초기화
							System.out.println("Reset pw");
							break;
						case 0:
							return;
							//돌아가기
						default:
							System.out.println(message(room.language, "0020"));
							break;
					}
				}
				return;
			}else {
				//검색결과가 없으니 함수 종료
				return;
			}
		
//		}
		
	}
	public List selectAccount(String name) {
		List<AccountData> searchUsers = new ArrayList<>();
		for(AccountData ac : userMap.values()) {
			if(ac.getName().equals(name)) {
				searchUsers.add(ac);
			}
		}
		if(searchUsers.size() == 0) { //검색결과가 0일 때
			System.out.println("검색결과가 존재하지 않습니다."); //이거 나중에 returnMessage에 넣기
			return null;
		}else {
			int index = 1;
			 for(int i = 0; i < searchUsers.size(); i++) {
		            System.out.println(index + " : " + searchUsers.get(i));
		            index++;
		      }
			 return searchUsers;
		}
		
		 //
	}
	
//아이디로 검색하는 함수
//	public void selectAccount(String id) {
//		//특정회원 조회
//		
//		AccountData user = null;
//		
//
////		for(String key : userMap.keySet()) {
////			if(key.equals(id)) {
////				System.out.println(userMap.get(key));
////			}
////		}
//		System.out.println(userMap.get(id));
//		//이러면 여기서 또 switch문으로 입력받은거에 따라 경고하거나 조회하거나 뒤로가기 할텐데
//		//이건 아예 위에 큰 메소드를 만드는게 나을듯 ㅇㅈ?
//	}
	
	public void userManager() {//회원관리(경고)
		
	}
	public void inoutSeat() { // 회원 입퇴실 내역조회
		
	}
	@Override
	public void pwdReset() { //패스워드 초기화
		//회원 검색 후
		//비밀번호 초기화
	}
	public void coupon() {//쿠폰
		
	}
	@Override
	public void selectAccount() {
		//회원 전부 조회
		for(Object value : userMap.values()) {
			System.out.println(value); //이렇게 하면 id만 나옴
		}
	}
	
	@Override
	public void paymentCancel() {
		//관리자는 회원 환불.
		
	}

	@Override
	public void checkSeat() {
		//전체좌석을 확인할 수 있다.
		
	}
	@Override
	public int selectMenu(String index) { //선택메뉴만 여기서 출력하고 메소드 안에서 필요한 프린트는 메소드내에서 바로 syso해도됨
		if(index == "0")
			System.out.println(message(room.language, "0003"));
		else if(index == "01")
			System.out.println("양식");
//		else if(index == "03")
//			System.out.println(message(room.language, "0053"));//"0053", "회원검색합니다. \n검색할 회원의 이름을 입력하세요."
		else if(index == "03") //검색결과가 존재할 경우
			System.out.println(message(room.language, "0059"));//"0059","1:회원 관리 2:회원입퇴실내역조회 3:분실계정 비밀번호 초기화 0:뒤로가기"
		else if(index == "031")
			System.out.println(message(room.language, "0060"));//	kor_message.put("0060","이 회원에게 경고를 줍니까? 1:예 2:뒤로가기");//1눌렀을 때
		else if(index == "0311")
			System.out.println(message(room.language, "0061"));//	kor_message.put("0061","경고를 주었습니다.");
		else if(index == "032")
			System.out.println(message(room.language, "0062"));//	kor_message.put("0062","해당 회원의 입퇴실내역입니다.");//회원검색결과 2번옵션
		else if(index == "033")
			System.out.println(message(room.language, "0063"));//	kor_message.put("0063","정말 비밀번호를 초기화하겠습니까? 0000으로 초기화됩니다. 1:예 2:뒤로가기");//회원검색결과3번옵션
		else if(index == "0331")
			System.out.println(message(room.language, "0064"));//	kor_message.put("0064","비밀번호가 초기화되었습니다.");//회원검색결과3번옵션-2
		return Integer.parseInt(scan.nextLine());
	}





	
	
}