import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Ex10_Foramat_Date {
public static void main(String[] args) {
	Date currdate = new Date();
	Calendar cal=Calendar.getInstance();
	
	System.out.println("date "+currdate);
	//date Thu Sep 15 09:19:31 KST 2022 날짜 형식

	System.out.println("cal"+cal);
	//caljava.util.GregorianCalendar[time=1663201182659,areFieldsSet=true,areAllFieldsSet=true,lenient=true,zone=sun.util.calendar.ZoneInfo[id="Asia/Seoul",offset=32400000,dstSavings=0,useDaylight=false,transitions=30,lastRule=null],firstDayOfWeek=1,minimalDaysInFirstWeek=1,ERA=1,YEAR=2022,MONTH=8,WEEK_OF_YEAR=38,WEEK_OF_MONTH=3,DAY_OF_MONTH=15,DAY_OF_YEAR=258,DAY_OF_WEEK=5,DAY_OF_WEEK_IN_MONTH=3,AM_PM=0,HOUR=9,HOUR_OF_DAY=9,MINUTE=19,SECOND=42,MILLISECOND=659,ZONE_OFFSET=32400000,DST_OFFSET=0]
	//문자열의 조합
	
	System.out.println("cal getTime()함수"+cal.getTime());
	//Thu Sep 15 09:21:11 KST 2022
	
	
	SimpleDateFormat dateformat = new SimpleDateFormat("yyyyMMddHHmm");
	
	String s = dateformat.format(currdate);
	String s1= dateformat.format(cal.getTime());
	System.out.println(s);
	System.out.println(s1);
	//사이트 어떤 정보를 입력
	//문자열 >> 날짜 형식으로
	//"202209150925"
	String StringDate = "202209150925";
	Date stringdate=null;
	try {
		stringdate = dateformat.parse(StringDate);
		//parse 만든 설계자 (문제발생 고민) throws.... 사용자는 예외처리...
		
		long datelong = stringdate.getTime();
		System.out.println(datelong);
	} catch (ParseException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally {
	System.out.println(stringdate);
	}
	System.out.println();
}
}
