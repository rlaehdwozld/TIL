# 2022.09.02 금요일 못먹어도 고!

### String 클래스

![String Class](https://blog.kakaocdn.net/dn/bKdSeg/btqwA2soavo/KdKbWI5Js1LhERvFRAgRuk/img.png)

C언어에서는 문자열을 char형 배열로 표현하지만, 자바에서는 문자열을 위한 String이라는 클래스를 별도로 제공합니다.

String 클래스에는 문자열과 관련된 작업을 할 때 유용하게 사용할 수 있는 다양한 메소드가 포함되어 있습니다.

이러한 String 클래스는 java.lang 패키지에 포함되어 제공됩니다.

String 인스턴스는 한 번 생성되면 그 값을 읽기만 할 수 있고, 변경할 수는 없습니다.

이러한 객체를 자바에서는 불변 객체(immutable object)라고 합니다.

즉, 자바에서 덧셈(+) 연산자를 이용하여 문자열 결합을 수행하면, 기존 문자열의 내용이 변경되는 것이 아니라 내용이 합쳐진 새로운 String 인스턴스가 생성되는 것입니다.

```java
public class Ex05_String_Class {
    public static void main(String[] args) {

        String str="";
		String[]strarr= {"aaa","bbb","ccc"};
		for(String s : strarr) {
            System.out.println(s);
		}
		//사용방법 : int , double 값타입 처럼 사용하면 된다.

		String st= "홍길동";

		System.out.println(st.length());
		//사실은 내부적으로 배열로 관리한다.
		//문자열에 length를 사용하면 문자열의 길이를 알 수 있다.
		System.out.println(st);//toString()이 사실 생략되어 있는 것이다.
		System.out.println(st.toString());//주소로 가서 데이터를 리턴 설계(재정의 )
		//String 클래스는 Object부모 클래스 toString()상속 관계 재정의...

		//정석적인 방법
		String sdata = new String("김유신");
		System.out.println(sdata);
		System.out.println(sdata.toString());

		String name="가나다라마";
		//String 내부적으로 char[] member field가 있고 [가][나][다][라][마] 배열의 주소값이 있는거다
		//class String extends{private char[] str...@Overide toString()}

		String str1 ="AAA";
		String str2 ="AAA";

		// 문자열의 비교
		System.out.println(str1);
		System.out.println(str2.toString());//toString() 재정의 주소값이 아니고 값이 나온다.
		System.out.println(str1==str2);
		// ==연산자는 값을 비교 str1(주소값), str2(주소값)을 가지고 있는거다
		// 근데 왜 true가 나오지???? 서로 다른 주소값인데???
		//같은 주소 판명
		//** 메모리에 실제로 같은 문자열이 있으면 [재사용]되도록 설계되었다.
		//Point
		System.out.println(str1.equals(str2));//주소를 찾아가서 그 안에 있는 값을 비교
		//==과 equals()의 차이!
		//왜 eqauls()를 써야하는 것인가
		String str3= new String("CCC");
		String str4=new String("CCC");

		System.out.println(str3==str4);//
		//왜 false가 나오냐?? new를 쓰면 heap메모리에 다른 객체를 만든다 값이 같아도 다른 메모리에 있는 것이기 때문에 false나오는 것//
		//문자열은 값이 중요하다
		System.out.println(str3.equals(str4));//주소를 찾아가서 그 안에 있는 값을 비교하는 것 값은 같기 때문에 true
		//문자열의 비교는 그.래.서. equals()를 쓰자!

		String s= "A";
		s+="B";
		s+="C";
		System.out.println(s);

		s= "A";
		//문자열의 누적을 하는 것은 바보다!!
		//
	}

}

```

    ### 정규 표현식

![정규표현식](https://mblogthumb-phinf.pstatic.net/20160531_141/mals93_1464702694728xJ5Ur_PNG/%C7%A5%C7%F6%BD%C4.png?type=w800)

```java

public class Ex06_String_Method {
    public static void main(String[] args) {

        String str = "hello";
		String concatstr = str.concat("world");
		str.concat(concatstr);

		boolean bo = str.contains("e");
		System.out.println(bo);

		boolean bo1 = str.contains("ell");
		System.out.println(bo1);

		boolean bo2 = str.contains("elo2");
		System.out.println(bo2);

		String str2 = "a b c d";
		System.out.println(str2.length());

		String filename = "hello java world";
		System.out.println(filename.indexOf("a"));
		System.out.println(filename.indexOf("java"));
		System.out.println(filename.indexOf("개폭망"));// 배열은 이런 값은 -1을 리턴한다 (내가 원하는 단어가 없다)
		// 0번째 문자열의 첫번째 값
		// 신문 사설에서 원하는 검색할 때 indexOf()쓰면 좋다.
		// 내가원하는 문자열이 그 사설 내부에 포함되어 있는지 확인할 때!
		if (filename.indexOf("wo") != -1) {
			System.out.println("wo단어가 하나라도 있다.");
		}
		System.out.println(filename.lastIndexOf("a"));// a를 끝에서부터 찾아라가 아님 dlrow 'a'찾으면 안된다. 맨 뒤에 있는 "a"를 앞에서 부터 찾는것이다

		// length(), indexOf(), substring(), replce(), spilt()

		String result = "superman";
		System.out.println(result.substring(0));// 시작 index를 제공하면 superman
		System.out.println(result.substring(1));// 시작 index를 제공하면 uperman
		System.out.println(result.substring(1, 2));// "u"
		// beginIndex - the beginning index, inclusive.
		// endIndex - the ending index, exclusive. //endindex-1
		System.out.println(result.substring(0, 0));// (0,-1)
		System.out.println(result.substring(0, 1));// s

		// Quiz
		String filename2 = "home.jpeg";// or h.png or aaaa.hwp
		// 여기서 파일명과 확장자를 분리해서 출력하세요
		// 파일멸 : home
		// 확장자 : jpeg
		// 단위에서 배운 함수만 사용해서 출력하세요

		System.out.println(filename2.substring(0, 4));
		System.out.println(filename2.lastIndexOf(0));
		System.out.println(filename2.indexOf("."));

		int position = filename2.indexOf(".");

		String file = filename2.substring(0, position);

		String extension2 = filename2.substring(position + 1, filename2.length());
		String extension = filename2.substring(++position);
		String extension3 = filename2.substring(6);

		System.out.println(position);
		System.out.println(file);
		System.out.println(extension);
		System.out.println(extension2);
		System.out.println(extension3);

		// 게시판에 파일이름 중복 났을 때 사용 이거보다 쉬운게 있다!

		// replace
		String str3 = "ABCDADDDDDA";
		String result3 = str3.replace("DDDDD", "오늘은 금요일");
		System.out.println(result3);

		result3 = str3.replace("A", "a");
		System.out.println(result3);

		// ETC
		System.out.println(str3.charAt(0));
		System.out.println(str3.charAt(3));
		System.out.println(str3.endsWith("DDDA"));
		System.out.println(str3.endsWith("DDDB"));
		System.out.println(str3.equalsIgnoreCase("abCDAdDDDDA"));// 대소문자 구별없이 비교해라

		// Today Point
		String str4 = "슈퍼맨,팬티,노랑색,우하하,우하하";
		String[] namearray = str4.split(",");

		for (String s : namearray) {
			System.out.println(s);
		}

		String str5 = "슈퍼맨.팬티.노랑색.우하하.우하하";
		String[] namearray2 = str5.split("\\.");// "\."은 정규표현식이라서 .만 단독으로 나오면 정규표현식인줄 알기때문에 "\"붙여준다!
		for (String s : namearray) {
			System.out.println(s);// 질문
		}
		// 정규표현식 ( 문자들을 조합해서 규칙을 만들고 : 그 규칙하고 데이트를 비교해서판단)
		// 우편번호 : {\d3}-{\d3}>>12-123(false), 123*123(false) , 111-111(ture)//정해진 패턴이
		// 맞아야 true다!!

		// 정규 표현식(java, javascript, Oracle, C#) 표준 모두 다 동일하다!!!
		// 핸드폰 번호 , 차량 번호, 도메인 주소, 이메일 정규표현으로 구현>> 입력한 데이터랑 유효성 검증하는 것이다.

		// 정규표현식 이메일 주소, 핸드폰번호, 비밀번호 유효선 검사
		// 다음주 과제로 제출

		String filename3 = "kosa.hwp";
		// 파일명과 확장자를 분리
		String[] filearray = filename3.split("\\.");
		for (String w : filearray) {
			System.out.println(w);
		}

		String str6 = "a\b,c-d.f";
		StringTokenizer sto = new StringTokenizer("/,-.");
		while (sto.hasMoreElements()) {
			System.out.println(sto.nextToken());
		}
		// 넌센스
		String str7 = "홍      길         동";
		// 저장 >> 공백제거>>"홍길동";으로 만들어준다.
		String result10 = str7.replace(" ", "");
		System.out.println(str7);
		System.out.println(result10);

		String str8 = "                 홍길동                 ";
		System.out.println(">" + str8 + "<");
		System.out.println(">" + str8.trim() + "<");

		String str9 = "           홍           길         동             ";
		// "홍길동"
		System.out.println(str9.trim());
		String result5 = str9.trim();
		String result6 = str9.replace(" ", "");
		System.out.println(result6);
		// 무식한 인간 소리 듣는다 자원 많이 쓴다고


		//************* 여러개의 함수를 사용 (method chain 기법)사용
		str9.trim().replace(" ",	""	).substring(2);
		//여러개의 함수를 사용 할 때는 체인 기법으로 묶자


	int sum=0;
	String[]	numarr= {"1","2","3","4"};
	for(String s : numarr) {
		sum+=Integer.parseInt(s);
		}
	System.out.println();



	//QUiz
	String jumin = "123456-1234567";
	//위 주민번호의 합을 구하라

	//강사님 답

//	int sum2=0;
//	for(int i=0;jumin.length();i++) {
//
//	}

//	int sum7=0;
//
//	String[]  sum6	=jumin.replace("-", "").split("");
//
//	for(String r : sum6) {
//		sum7=Integer.parseInt(r)++;
//		System.out.println(Integer.parseInt(r));

//	}

//	System.out.println(Integer.parseInt());
//
//	String sum5 = jumin.replace("-","");
//	System.out.println(sum5);

//	String[]results = sum5.split("[]");
//	String[] digits = new String [sum5.length()];//"12334561234567"
//	for(String o : digits) {
//		sum5+=Integer.parseInt(o);
//	}
//	System.out.println(sum5);

	}
}

```

### 주민등록번호 문제

주민번호 : 뒷번호 첫자리 : 1,3 남자 , 2,4 여자 라고 출력 ... 하는 문제  
main 함수 Scanner 사용 주민번호 입력받고  
앞:6자리 뒷:7자리  
입력값 : 123456-1234567

1. 자리수 체크 (기능)함수 (14 ok) return true , false
2. 뒷번호 첫번째 자리값 1~4까지의 값만 허용 기능함수 return true, false
3. 뒷번호 첫번째 자리값을 가지고 1,3 남자 , 2,4 여자 출력 기능함수 void 출력

```java
public class Ex07_String_Total_Quiz {
public static void main(String[] args) {

		Scanner sc= new Scanner(System.in);

		System.out.println("당신의 주민번호를 입력하세요(######-####### : ");
		String regNo = sc.nextLine();//주민번호 입력창

		char gender=regNo.charAt(7);//regNo에서 8번째 문자 보고 gender을 판단한다.
	//배열은 0부터 시작하는 거라서 8번째는 (7)이다.

		String gender1;//마지막에 남자, 여자를 변수로 출력하기 위하여 따로 설정해줌.
		char year=regNo.charAt(0);//주민번호 첫째 자리 숫자를 보고 출생연도가 2000년대 이후인지 이전인지
		String year1;//2000년 이저, 이후를 변수로 출력하기 위하여 따로 설정해줌.

		if(gender=='1') {
			gender1="남자";
		}else if(gender =='2') {
			gender1= "여자";

		}else {
			gender1= "성별이 없습니다.";
		}//성별 판단



		if(year>=3) {
			year1= "2000년 이전";

		}else {
			year1= "2000년이후";
		}//년도 판단

		System.out.println("당신은 "+year1+"에 출생한"+gender1+"입니다.");

		switch(gender) {
		case '1' :
			gender1= "남자";
			break;
		case'2'	:
			gender1=" 여자";
		}//성별판단

		  switch (year) {
	        case '0':
	        case '1':
	        case '2': //year은 char형이므로 ''안에 넣어줘야한다.
	            year1 = "2000년 이후";
	            break;

	        default:
	            year1 = "2000년 이전";
	            break;
	        } // 2000년대 이후 판단. 2020년이니까 year1 이 2까지는 2000년대 이후 출생.

	        System.out.println("당신의 주민번호를 입력하세요.: " + regNo);
	        System.out.println("당신은 " + year1 + "에 출생한 " + gender1 + "입니다.");
	        sc.close();





		}




}
```

### 주민등록번호 문제

주민번호 : 뒷번호 첫자리 : 1,3 남자 , 2,4 여자 라고 출력 ..하는 문제  
main 함수 Scanner 사용 주민번호 입력받고  
앞:6자리 뒷:7자리

입력값 : 123456-1234567

static

1. 자리수 체크 (기능)함수 (14 ok) return true , false
2. 뒷번호 첫번째 자리값 1~4까지의 값만 허용 기능함수 return true, false
3. 뒷번호 첫번째 자리값을 가지고 1,3 남자 , 2,4 여자 출력 기능함수 void 출력

```java


public class Ex07_String_Total_Quiz2 {

	static boolean juminCheck(String str) {
		return str.length() == 14 ? true : false;
	}

	static boolean JunminFirstNumber(String str) {
		boolean numcheck = false;
		int num = Integer.parseInt(str.substring(7, 8));
		if (num > 0 && num < 5) {
			numcheck = true;
		}
		return numcheck;
	}
	static void JuminDisplay(String ssn) {
		// CASE1 >
		// String gender= ssn.replace("-","").substring(6,7);
		// int numgender = Integer.parseInt(gender);
		// if(numgender%2 == 0)System.out.println("여자");
		// if(numgender%2 == 1)System.out.println("남자");

		// CASE2 >
		char cgen = ssn.replace("-", "").charAt(6);
		// 123456-1234567 -> 1234561234567 > 123456[1]234567 추출> '1'
		switch (cgen) {
			case '1': // break 생략
			case '3':
				System.out.println("남자^^");
				break;
			case '2': // break 생략
			case '4':
				System.out.println("여자^^");
				break;
			default:
				System.out.println("중성");
		}
	}
	public static void main(String[] args) {
		String ssn = "";
		do {
			Scanner sc = new Scanner(System.in);
			System.out.print("주민번호 입력:");
			ssn = sc.nextLine();
		} while (!juminCheck(ssn) || !JunminFirstNumber(ssn));
		// 둘다 true 인경우  > false || false 탈출
		// !true || !true => false || false 탈출
		JuminDisplay(ssn);

```
