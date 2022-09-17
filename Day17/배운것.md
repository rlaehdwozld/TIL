# 2022.09.14 수요일 못먹어도 고!

### Wrapper 클래스

자바 8가지 기본 타입(값타입) : Java API제공

8가지 기본 타입에 대해서 객체 형태로 사용 가능하도록 만든 클래스(wrapper class)

사용 용도

1. 매개변수가 객체가 요구 될때
2. 기본형 값이 아닌 객체 형태로 저장이 필요할 때
3. 객체간 값을 비교할 때
4. 타입 변환시 처리

generic 설계 (객체 형태)>>int > Integer

```java
public class Ex08_Wrapper_Class {

	public static void main(String[] args) {
		int i = 100;
		/*
		 * Integer n = new Integer(500) ; System.out.println("n :"+n);//toString 재정의 되어
		 * 있다. System.out.println(Integer.MAX_VALUE);
		 * System.out.println(Integer.MIN_VALUE);
		 */

		//Point
		//parameter 활용
		//제네릭(generic) : 객체 생성시 타입 강제 방식 >> wrapper class
		List<Integer> li = new ArrayList<Integer>();
		li.add(100);
		//li.add("A");
		for( int value : li) {
			System.out.println(value);
		}

		Integer i2 = new Integer(100);
		Integer i3= new Integer(100);
		System.out.println(i2==i3);//false//주소값을 비교
		System.out.println(i2.equals(i3));//equals 메서드를 재정의 했다. (주소를 찾아가서 '값'을 비교한다.)

		//String >> 문자열 값을 비교 >>> equals(재정의)

		int i4= 100;
		int i5=100;
		System.out.println(i4==i5);




	}

}

```

### Calendar 클래스

Calendar 를 상속받아 완전히 구현한 클래스는 GregorianCalendar

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

```java
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

```

### Format data

```java
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

```

### Format Data ETC

```java
import java.text.DecimalFormat;
import java.text.MessageFormat;

public class Ex11_Format_ETC {
	public static void main(String[] args) {
		double money = 123456.5678;
		DecimalFormat df = new DecimalFormat("0.0");// 123456.6반올림
		System.out.println(df.format(money));

		DecimalFormat df2 =new DecimalFormat("0");// 123457 반올림
		System.out.println(df2.format(money));

		DecimalFormat df3 =new DecimalFormat("0.000");
		System.out.println(df3.format(money));

		DecimalFormat df4 =new DecimalFormat("#.######");
		System.out.println(df4.format(money));

		String userId="kglim";
		String userName="홍길동";
		String userTel = "010-111-1111";

		String message = "회원 Id :{0} \n회원 이름 : {1} \n회원 전화번호 : {2}";

		String result = MessageFormat.format(message, userId, userName, userTel);

		//printf()
		System.out.println(result);

	}
}

```

### Map Genenric

HashMap<k,v>

HashMap<String , String>  
HashMap<Integer , Integer>  
HashMap<String ,Student > Point!!!!

Student st = new Student();  
put("kglim", st);  
or
put("kglim",new Student());  
class Student{ // 클래스 == 데이터 타입

```java
class Student{
	int kor;
	int math;
	int eng;
	String name;

	public Student(int kor, int math, int eng, String name) {
		super();
		this.kor = kor;
		this.math = math;
		this.eng = eng;
		this.name = name;
	}


}

class ArrayTest{
	//알아두자!!
	//genenric으로 배열도 가능 하다!!
	ArrayList<String[]>al=new ArrayList<String[]>();
}
public class Ex15_Map_Generic {
	public static void main(String[] args) {
		HashMap<String, String >sts = new HashMap<String, String>();
		sts.put("A", "AAA");
		System.out.println(sts.get("A"));


		//실무 에서의 Map
		//학생의 성적 데이터
		//kim , 국어, 영어, 수학>>Array, Collection(ArrayList(0))
		//Value 값은 객체 타입 (Emp, Student)

		//Map<String, Student>smap = new HashMap<String, Student>(); 더 좋은 코드

		//TodayPoint
		HashMap<String, Student>smap = new HashMap<String, Student>();

		smap.put("hong", new Student(100, 80, 50, "홍길동"));
		smap.put("kim",new Student(50, 30, 60, "김유신"));

		Student sd=smap.get("hong");
		System.out.println(sd.kor);
		System.out.println(sd.math);


		ArrayTest at= new ArrayTest();
	String []starr = {"A","B","c"};
		at.al.add(starr);

		//Tip
		Set set=smap.entrySet();//entrySet은 Map key, value 가공 >> key +"="+value
		Iterator it= set.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
//		hong=Student@3e57cd70
//		kim=Student@9a7504c

		//Tip key, value 분리되서 결과를 보고 싶어요
		//class Entry{Object key, object value}
		//Map { Entry[] elements}>>Map.Entry
		for(Map.Entry m : smap.entrySet()) {
			System.out.println(m.getKey()+"/"+((Student)m.getValue()).name);
		}

	}

}

```

### Map Genenric

```java
lass QuizInfo{
	String question;
	String answer;
	String result;

	public QuizInfo(String question, String answer, String result) {
		super();
		this.question = question;
		this.answer = answer;
		this.result = result;
	}

	@Override
	public String toString() {
		return "QuizInfo [문제=" + question + ", 답안=" + answer + ", 결과=" + result + "]";
	}

}


public class Ex16_Map_Generic {

	public static void main(String[] args) {

		HashMap<String, String> quiz = new HashMap<String, String>();
		quiz.put("1+1", "2"	);
		quiz.put("1+2","3");
		quiz.put("1+3", "4");

		for(int i=0;i<quiz.size();i++ ) {
			Set set = quiz.keySet();
			Object[] obj= set.toArray();//key 집합을 배열로 바꾸어서 처리
			//System.out.println(obj.length);
			System.out.println("문제 : "+obj[i]);
			//System.out.println(quiz.keySet().toArray()[i]);
			//문제 : 1+1
			//문제 : 1+2
			//문제 : 1+3



		}

	}

}
```

### Properties 클래스

Map 인터페이스 구현한 클래스  
특수한 목적 : <\String><\String> key 와 value타입이 고정되어 있는 클래스가 바로 properties다.  
//제네릭 타입을 적지 않아도 String String이다.  
사용 목적  
1.App 전체에 사용되는 자원 관리  
2. 환경변수  
3. 프로그램 버전  
4. 파일 경로  
5. 공통 변수

```java
public class Ex17_Properties {
public static void main(String[] args) {
	Properties prop = new Properties();
	prop.setProperty("admin", "kosa@or.kr");
	prop.setProperty("version", "1.x.x.x");
	prop.setProperty("downpath", "C:\\Temp|images");
	//각각의 개발 페이지에서
	System.out.println(prop.getProperty("admin"));
	System.out.println(prop.getProperty("version"));
	System.out.println(prop.getProperty("downpath"));

}
}

```

### BookMAnager 조별 과제

```java
package kr.or.kosa;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

class Book {
	private String bISBN;
	private String bname;
	private int bprice;

	public Book() {
	}

	public Book(String bISBN, String bname, int bprice) {
		this.bISBN = bISBN;
		this.bname = bname;
		this.bprice = bprice;
	}

	public String getBISBN() {
		return bISBN;
	}

	public String getBname() {
		return bname;
	}

	public int getBprice() {
		return bprice;
	}

	@Override
	public String toString() {
		return "Book [ISBN=" + bISBN + ", 책이름=" + bname + ", 책가격=" + bprice + "]";
	}

}

public class BookManagement {
	String ISBN = "";
	String bname = "";
	int bprice = 0;

	String inputISBN = "";
	String inputName = "";
	int inputPrice;

	String compareISBN = "";
	String compareName = "";
	int comparePrice = 0;

	int searchItem;

	int menuNum;

	HashMap<String, Book> hs;
	Scanner sc = new Scanner(System.in);

	public void menu() {

		while (true) {
			System.out.println("도서관리 프로그램");
			System.out.println("1. 책 추가");
			System.out.println("2. 책 삭제");
			System.out.println("3. 책 검색");
			System.out.println("4. 책 목록");
			System.out.println("5. 일련번호 목록");
			System.out.println("0. 종료");
			menuNum = sc.nextInt();

			switch (menuNum) {
			case 1:
				addBook();
				break;
			case 2:
				removeBook();
				break;
			case 3:
				searchBook();
				break;
			case 4:
				printBookList();
				break;
			case 5:
				printISBNList();
				break;
			case 0:
				return;
			default:
				System.out.println("정해진 번호만 누르세요");
				break;
			}
		}
	}

	public BookManagement() {
		hs = new HashMap<String, Book>();
		ISBN = "";
		bname = "";
		bprice = 0;

		inputISBN = "";
		inputName = "";
		inputPrice = 0;

		compareISBN = "";
		compareName = "";
		comparePrice = 0;

		hs.put("1235", new Book("1235", "수학책", 6000));

	}

	@Override
	public String toString() {
		return "BookManagement [ISBN=" + ISBN + ", bname=" + bname + ", bprice=" + bprice + "]";
	}

	public void addBook() {
		inputISBN = "";
		inputName = "";
		inputPrice = 0;

		System.out.println("고교 교과서 번호 1xxx");
		System.out.println("위인전 번호 : 2xxx");
		System.out.println("it 교재 : 3xxx");
		System.out.println("책 번호 입력");
		inputISBN = sc.next();
		System.out.println("책 이름 입력");
		inputName = sc.next();
		System.out.println("책 가격 입력");
		inputPrice = sc.nextInt();
		System.out.println("숫자를 입력하세요");
		sc.nextLine();
		hs.put(inputISBN, new Book(inputISBN, inputName, inputPrice));
		System.out.printf("ISBN : %s 이름 : %s 가격 : %d", inputISBN, inputName, inputPrice);
		System.out.println();
	}

	public void searchBook() {
		System.out.println("검색할 책 번호를 입력하세요");
		String inputCompareISBN = sc.next();
		Book compareBook = hs.get(inputCompareISBN);
		if (compareBook == null) {
			System.out.println("그런 책 없습니다.");
		} else {
			System.out.println("찾으신 책은");
			System.out.println("책번호" + compareBook.getBISBN());
			System.out.println("책이름" + compareBook.getBname());
			System.out.println("책가격" + compareBook.getBprice());
		}
	}

	public void removeBook() {
		System.out.println("삭제할 책 번호를 입력하세요");
		String inputCompareISBN = sc.next();
		Book compareBook = hs.get(inputCompareISBN);
		if (compareBook == null) {
			System.out.println("그런 책 없습니다.");
		} else {
			if (compareBook.equals(inputCompareISBN)) {
				hs.remove(compareBook);
			}
		}
		System.out.println("삭제할 도서 :" + inputCompareISBN);
		System.out.println("책이 삭제되었습니다");
	}

	public void printBookList() {
		for (int i = 0; i < hs.size(); i++) {
			Set set = hs.keySet();
			Object[] obj = set.toArray();

			System.out.println("ISBN" + obj[i]);
			System.out.println(hs.get(obj[i]));
		}
		System.out.println();

	}

	public void printISBNList() {
		for (int i = 0; i < hs.size(); i++) {
			Set set = hs.keySet();
			Object[] obj = set.toArray();

			System.out.println("Key : " + obj[i]);
		}
	}

	public static void main(String[] args) {
		BookManagement book = new BookManagement();
		book.menu();

	}

}
```

```java

```
