package com.victoree2.common;
import java.util.HashMap;

import com.victoree2.main.ReadingRoom;

public class ReturnMessage {
	ReadingRoom room = new ReadingRoom();

	
	HashMap<String, String> kor_message = new HashMap<String, String>();
	HashMap<String, String> en_message = new HashMap<String, String>();
	

	
	void init() {
		kor_message.put("0000", "해당계정은 정지되었습니다.");
		kor_message.put("0001","1:로그인 2:회원가입 3:좌석보기 4:영어(toggle) -1:종료");
		kor_message.put("0002","1:마이페이지 2:정기권 예약 3:시간권 예약 4:스터디룸 예약 5:좌석보기 0:로그아웃 -1:종료"); 
		/*dayeong*/
		kor_message.put("0003","1:좌석현황 2:전체회원 목록 3:회원검색 4:매출현황 5:쿠폰관리 0:로그아웃 -1:종료"); 
		/*dayeong*/
		kor_message.put("0004","스터디 카페 방문을 환영합니다.^^;;");
		kor_message.put("0005","계정이 없습니다.");
		kor_message.put("0006","계정을 만들어 사용하시오.");
		kor_message.put("0007","관리자");
		kor_message.put("0008","아이디");
		kor_message.put("0009","입력");
		kor_message.put("0010","패스워드");
		kor_message.put("0011","계정을 생성하였습니다.");
		kor_message.put("0012","아이디와 패스워드를 입력하시오.");
		kor_message.put("0013","아이디/패스워드가 틀렸습니다.");
		kor_message.put("0014","파일이 존재하지 않습니다.");
		kor_message.put("0015","끝");
		kor_message.put("0016","파일을 읽을 수 없습니다.");
		kor_message.put("0017","나머지 예외 : ");
		kor_message.put("0018","종료");
		kor_message.put("0019","님께서 로그인 하였습니다.");
		kor_message.put("0020","잘못 선택하였습니다.");
		kor_message.put("0021","관리자 페이지에 접속하였습니다.");
		kor_message.put("0022","<<회원가입>>");		
		kor_message.put("0023","이름");
		kor_message.put("0024","생일(주민등록번호 앞의 6자리)");
		kor_message.put("0025","전화번호");
		kor_message.put("0026","1:비밀번호 변경 2:환불 0:뒤로가기 -1:종료");

		
//		kor_message.put("0023","생일");
//		kor_message.put("0023","생일");
//		kor_message.put("0023","생일");
//		kor_message.put("0023","생일");
		
		
		/*dhj*/ /*dayeong*/
		//1:좌석현황 2:전체 회원 목록 3:회원검색 4:매출현황 5:쿠폰관리 0:로그아웃
		kor_message.put("0051", "현재 스터디카페 좌석 현황입니다.");  //1.좌석현황
		kor_message.put("0052", "전체 회원 목록을 조회합니다."); //2.전체 회원 목록 //3.회원검색
		kor_message.put("0053", "회원검색합니다. \n검색할 회원의 이름을 입력하세요."); //3.회원검색
		kor_message.put("0054", "쿠폰을 관리합니다. \n 1:현재 발행된 쿠폰 확인  2:쿠폰 추가  3:쿠폰 삭제  0:뒤로가기 -1:종료"); //5.쿠폰관리
		kor_message.put("0055", "현재 사용가능한 쿠폰 목록입니다.");//5.쿠폰발행 -> 1.현재 발행된 쿠폰 확인
		kor_message.put("0056", "추가할 쿠폰의 번호와 할인율을 입력하세요. 추가를 원치 않으면 0을 입력하세요.");//5. 쿠폰발행 -> 2.쿠폰추가
		kor_message.put("0057", "삭제할 쿠폰의 번호를 입력하세요. 삭제를 원치 않으면 0을 입력하세요.");//5.쿠폰발행 -> 3.쿠폰삭제
		kor_message.put("0058","검색결과"); //3.회원 검색 - 회원검색결과
		kor_message.put("0059","1:회원입퇴실내역조회 2:비밀번호 초기화 3.경고 4.정지 0:뒤로가기 -1:종료");//3.회원검색결과의 하위 옵션
		kor_message.put("0060","이 회원에게 경고를 줍니까? 1:예 2:뒤로가기"); //3.회원 검색 -> 3.경고
		kor_message.put("0061","경고를 주었습니다."); //3.회원검색 ->3.경고
		kor_message.put("0062","해당 회원의 입퇴실내역입니다."); //3.회원 검색 -> 1.회원입퇴실내역조회
		kor_message.put("0063","이 회원의 비밀번호를 초기화하겠습니까? 0000으로 초기화됩니다. 1:예 2:뒤로가기");//3.회원검색 -> 2.비밀번호 초기화
		kor_message.put("0064","비밀번호가 초기화되었습니다.");//회원검색결과3번옵션-2
		/*ndy*/
		kor_message.put("0065", "매출 현황 입니다"); //4. 매출 현황
		kor_message.put("0066","이 회원을 정지시킵니까? 1:예 2:뒤로가기"); //3.회원 검색 -> 4.정지 확인
		kor_message.put("0067","이 회원의 권한을 정지하였습니다"); //3.회원 검색 -> 정지
		kor_message.put("0068", "이 회원의 입퇴실 내역 입니다"); //3.회원검색 -> 1.회원의 입퇴실 내역

		/*dhj*/ /*dayeong*/
		
		
		
		
		
		
		
		
		
		/*GBJ*/
		//정기권 예약
		kor_message.put("0100","몇주를 예약하시겠습니까? \n 1: 2주권(%s원) \n 2: 4주권(%s원) \n 3: 8주권(%s원) \n 0: 뒤로가기 \n");//정기권예약
		
		kor_message.put("0102","%s원 결제하시겠습니까? \n 1:예  2:쿠폰이 있어요! 0:뒤로가기 \n"); // 1,2,3 선택시
		
		 //1번 "예" 눌렀을 경우
		kor_message.put("0104","%s 회원님의 권한이 부여되었습니다! 좌석을 선택해주세요 %s \n"); //앞에 이름 붙혀주기
		 //2번 "쿠폰이 있어요!" 눌렀을 경우
		kor_message.put("0105","쿠폰번호를 입력해주세요.");
		kor_message.put("0106","(쿠폰)몇주를 예약하시겠습니까?");
		kor_message.put("0107"," 1: 2주권(%s원)\n 2: 4주권(%s원)\n 3: 8주권(%s원)\n 0: 뒤로가기 \n");//이후 104번 출력
		kor_message.put("0108"," 1: 2시간(%s원)\n 2: 4시간(%s원)\n 3: 7시간(%s원)\n 4: 9시간(%s원)\n 5: 12시간(%s원)\n 0: 뒤로가기 \n");//이후 104번 출력
		kor_message.put("0109"," 시즌권은 자리를 지금 선택하셔야 합니다.");
		kor_message.put("0110","좌석을 선택해주세요.\n");
		/*GBJ*/
		
		/*kdj*/
		kor_message.put("0200", "안녕하세요");
		kor_message.put("0201", "님!\n 회원님의 회원권은 ");
		kor_message.put("0202", "남았습니다. ");
		kor_message.put("0203"," 1:비밀번호 변경 \n 2:환불 \n 0:뒤로가기");
		kor_message.put("0204","현재 비밀번호를 입력하세요.");
		kor_message.put("0205","비밀번호를 다시 확인하세요 ");
		kor_message.put("0206","새 비밀번호를 입력하세요");
		kor_message.put("0207","비밀번호 변경이 완료되었습니다. ");
		kor_message.put("0208","환불 규정\n정기권 환불의 경우 1일 기준 환불이 가능합니다.\n시간권 환불의 경우 1시 기준 환불이 가능합니다.");
		kor_message.put("0209","회원님의 환불 가능 금액 : ");
		kor_message.put("0210","환불하시겠습니까? \n 1. 예 \n 2. 뒤로가기");
		kor_message.put("0211","환불되었습니다. \n다음에 또 이용해주세요. \n감사합니다. ");
		kor_message.put("","");
		kor_message.put("","");
		kor_message.put("","");
		kor_message.put("","");
		kor_message.put("","");
		kor_message.put("","");

		/*kdj*/
		
		
		
		
	

		
		
		
		
		
		
		
		
		
		
		
		//////////영문////////////
		
		//1:좌석현황 2:전체 회원 목록 3:회원검색 4:회원정지 5:매출현황 6:쿠폰관리 0:로그아웃
		en_message.put("0000", "This account has been suspended.");
		en_message.put("0001", "1:Login 2:Membership 3:Seat View 4:Toggle -1:End");
		en_message.put("0002","1:My Page 2:Regular Ticket Reservation 3:Time Ticket Reservation 4:Study Room Reservation 5:Seat View 0:Logout -1:End");
		en_message.put("0003","1: Seat status 2:All member list 3:Member search 4:Sales status 5:Coupon management 0: Logout -1: End");
		en_message.put("0004","1: Welcome to the study cafe.^^;;");
		en_message.put("0005","There is no account.");
		en_message.put("0006","Please create an account.");
		en_message.put("0007","Amin");
		en_message.put("0008","ID");
		en_message.put("0009","PASSWORD");
		en_message.put("0010","INPUT");
		en_message.put("0011","You have successfully created an account.");
		en_message.put("0012","Enter your ID and password.");
		en_message.put("0013","Invalid ID/password.");
		en_message.put("0014","The file does not exist.");
		en_message.put("0015","END");
		en_message.put("0016","Unable to read file.");
		en_message.put("0017","Remaining exceptions:");
		en_message.put("0018","exit");
		en_message.put("0019","has logged in.");
		en_message.put("0020","You have selected the wrong one.");
		en_message.put("0021","You have accessed the Administrator page.");
		en_message.put("0022","<<SignUp>>");
		en_message.put("0023","Name");
		en_message.put("0024","Birthday (6 digits before resident registration number)");
		en_message.put("0025","PhoneNumber");
		en_message.put("0026","1:Change password 2:Refund 0:Back -1:End");
		
		
		
		
		
		
		/*ndy*/
		en_message.put("0051", "Current study seats status");  //1.좌석현황
		en_message.put("0052", "The list of the entire members"); //2.전체 회원 목록 //3.회원검색
		en_message.put("0053", "Searching a specific member \n Enter the name of the member"); //3.회원검색
		en_message.put("0054", "Manage coupons. \\n1:Check Current Issued Coupon 2:Add Coupon 3:Delete Coupon 0:Back -1:End"); //5.쿠폰관리
		en_message.put("0055", "List of the valid coupon");//5.쿠폰발행 -> 1.현재 발행된 쿠폰 확인
		en_message.put("0056", "Enter the coupon code and discount rate. If you don't want it, enter the number 0");//5. 쿠폰발행 -> 2.쿠폰추가
		en_message.put("0057", "Enter the coupon code you want to delete. If you don't want it, enter the number 0");//5.쿠폰발행 -> 3.쿠폰삭제
		en_message.put("0058","Search results"); //3.회원 검색 - 회원검색결과
		en_message.put("0059","1: Member entry and exit details inquiry 2: Password initialization 3. Warning 4. Stop 0: Back -1: End");//3.회원검색결과의 하위 옵션
		en_message.put("0060","Are you sure to give a caution to this member? 1:Yes 2:Back"); //3.회원 검색 -> 3.경고 확인
		en_message.put("0061","Caution has been given"); //3.회원검색 ->3.경고 결과
		en_message.put("0062","List of entry/exist of this member"); //3.회원 검색 -> 1.회원입퇴실내역조회
		en_message.put("0063","Are you sure to initialize the password of this member? It became 0000.  1:Yes 2:Back");//3.회원검색 -> 2.비밀번호 초기화
		en_message.put("0064","The password has been initialized");//회원검색결과3번옵션-2
		en_message.put("0065", "Viewing sale status"); //4. 매출 현황
		en_message.put("0066","Are you sure to suspend this member?  1:Yes 2:back"); //3.회원 검색 -> 4.정지 확인
		en_message.put("0067","This account has been suspended"); //3.회원 검색 -> 정지 결과
		en_message.put("0068", "List of entry/exit of this member"); //3.회원검색 -> 1.회원의 입퇴실 내역
		/*ndy*/
		
		
		
		en_message.put("0200", "Hi");
		en_message.put("0201", "!\n Your membership remain ");
		en_message.put("0202", ". ");
		en_message.put("0203"," 1:Change password\n 2:refund \n 0:back to prevoous menu");
		en_message.put("0204","Input your current password.");
		en_message.put("0205","Check out your password ");
		en_message.put("0206","Input new password");
		en_message.put("0207","Password change successfully ");
		en_message.put("0208","Refund regulation \nIn case of season ticket, refund will be on an hour basis .\nIn case of time ticket, refund will be on an hour basis ");
		en_message.put("0209","your total refundable money : ");
		en_message.put("0210","Do you want to refund? \n 1. 예 \n 2. 뒤로가기");
		en_message.put("0211","refund has been proceed successfully . \n look forward to seeing you again \nThank you. ");
		en_message.put("","");
		en_message.put("","");
		en_message.put("","");
		en_message.put("","");
		en_message.put("","");
		en_message.put("","");

		
	}
	
	
	public String message(String language, String key) {
		init();
		String message="";
		if(room.language=="kor")
		{
			message = kor_message.get(key);
		}
		else {
			message = en_message.get(key);
		}
		return message;
	}
	
}
	