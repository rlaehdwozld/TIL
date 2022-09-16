import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import kr.or.kosa.utils.Edu_Date;

/*

* Calendar 를 상속받아 완전히 구현한 클래스는 

* GregorianCalendar

buddhisCalendar 있는데 getInstance()는 [시스템의 국가와 지역설정]을 [확인]해서

태국인 경우 buddhisCalendar 의 인스턴스를 반환하고 그 외에는 GregorianCalendar

의 인스턴스를 반환한다

GregorianCalendar 는 Calendar를 상속받아 오늘날 전세계 공통으로 사용하고 있는 

그레고리력에 맞게 구현한 것으로 태국을 제외한 나머지 국가에서는 GregorianCalendar 사용

그래서 인스턴스를 직접 생성해서 사용하지 않고 메서드를 통해서 인스턴스를 반환받게하는

이유는 최소의 변경으로 프로그램 동작을 하도록 하기 위함

class MyApp{

static void main(){

Calendar cal = new GregorianCalendar();

다른 종류의 역법의 사용하는 국가에서 실행하면 변경...... } }

class MyApp{

static void main(){

Calendar cal = new getInstance();

다른 종류의 역법의 사용하는 국가에서 실행하면 변경...... } }

API : 생성자 Protected Calendar() 

*/
public class Ex09_Calender {
	public static void main(String[] args) {
		Date dt= new Date();//구버전 
		System.out.println(dt.toString());
		
		Calendar cal = Calendar.getInstance();//신버전

		//Calendar cal = new Calendar();
		// 이렇게 하지 않는 이유 

		//Calendar 추상 클래스
		System.out.println(cal.toString());
		//당신이 필요하 형식을 추출해서 조립하세요
		//java.util.GregorianCalendar[time=1663142259527,areFieldsSet=true,areAllFieldsSet=true,lenient=true,zone=sun.util.calendar.ZoneInfo[id="Asia/Seoul",offset=32400000,dstSavings=0,useDaylight=false,transitions=30,lastRule=null],firstDayOfWeek=1,minimalDaysInFirstWeek=1,ERA=1,YEAR=2022,MONTH=8,WEEK_OF_YEAR=38,WEEK_OF_MONTH=3,DAY_OF_MONTH=14,DAY_OF_YEAR=257,DAY_OF_WEEK=4,DAY_OF_WEEK_IN_MONTH=2,AM_PM=1,HOUR=4,HOUR_OF_DAY=16,MINUTE=57,SECOND=39,MILLISECOND=527,ZONE_OFFSET=32400000,DST_OFFSET=0]
		System.out.println("년도 :"+cal.get(Calendar.YEAR));
		System.out.println("월 :"+cal.get(Calendar.MONTH)+1);
		System.out.println("일 :"+cal.get(Calendar.DATE));
		
		System.out.println("이 달의 몇째 주 : "+cal.get(Calendar.WEEK_OF_MONTH));
		System.out.println("이 달의 몇째 주 : "+cal.get(Calendar.DAY_OF_MONTH));
		System.out.println("이 달의 몇째 주 : "+cal.get(Calendar.DAY_OF_WEEK));
		
		//시 분 초
		
		System.out.println("분"+cal.get(Calendar.MINUTE));
		System.out.println("시"+cal.get(Calendar.HOUR));
		System.out.println("초"+cal.get(Calendar.SECOND));
		System.out.println("오전오후"+cal.get(Calendar.AM_PM));
		
		//학사관리 시스템 
		//웹 : 페이지 본 수 : 200page
		//150page 날짜 정보 각 페이지 하단 출력(2022년 09월 14일)
		//A 친구 >>cal.get(Calendar.YEAR) +"월" ...
		//갑자기 해외 수출 ..... 야 우리 날짜를 한글 쓰지말고 2022-09-14 이렇게 바꾸자 
		//개발자 왈 150페이지에 이 코드 박혀있으니 그거 못한다고 말함 
		//어떻게 해야 핧까?
		//한번만 수정해서 150 페이지의  날짜 정보가 수정 될려면 
		//유틸 패키지에 모은다. 
		System.out.println(Edu_Date.DateString(Calendar.getInstance()));

System.out.println(Edu_Date.DateString(Calendar.getInstance(),"-"));
System.out.println(Edu_Date.DateString(Calendar.getInstance(),"/"));

System.out.println(Edu_Date.monthFormat_DateString(Calendar.getInstance()));


	}

}
