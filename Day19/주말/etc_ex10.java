package 주말;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class etc_ex10 {
public static void main(String[] args) {
	Date currdate = new Date();
	Calendar cal=Calendar.getInstance();
	
	System.out.println(cal.getTime());
	
	SimpleDateFormat dateformat = new  SimpleDateFormat("yyyyMMddHHmm");
	
	String s =dateformat.format(currdate);
	String s1= dateformat.format(cal.getTime());
	System.out.println(s);
	System.out.println(s1);
}
}
