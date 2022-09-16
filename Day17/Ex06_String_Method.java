import java.awt.Point;
import java.util.Arrays;
import java.util.StringTokenizer;

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
	
	
	
	
	
//	
//	int sum7=0;
//	
//	String[]  sum6	=jumin.replace("-", "").split("");
//	
//	for(String r : sum6) {
//		sum7=Integer.parseInt(r)++;
//		System.out.println(Integer.parseInt(r));
//		
//	}
//	
////	System.out.println(Integer.parseInt());
//	
////	String sum5 = jumin.replace("-","");
////	System.out.println(sum5);
//	
//	
//	
//	
//	
//	
//	
	
	
//	
//	String[]results = sum5.split("[]");
//	String[] digits = new String [sum5.length()];//"12334561234567"
//	for(String o : digits) {
//		sum5+=Integer.parseInt(o);
//	}
//	System.out.println(sum5);
//	
	
	
	
	}
}
