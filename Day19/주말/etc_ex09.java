package 주말;

import java.util.Calendar;

public class etc_ex09 {
	public static String DateString(Calendar date, String opr) {
		return date.get(Calendar.YEAR)+"년"+opr+
				(date.get(Calendar.MONTH)+1)+"월"+opr+
						date.get(Calendar.DATE)+"일";
		
	}
	public static void main(String[] args) {
		Calendar cal = Calendar.getInstance();
		
		System.out.println(etc_ex09.DateString(cal, "/"));
		
	}
}
