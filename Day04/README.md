# 2022.08.24 수요일 못먹어도 고!

### 입력받기

import는 \*로 모두 불러 오는 것보다 코드의 직관성을 위해서 해당 유틸만 불러오는 게 좋다.  
Scanner sc = new Scanner(System.in);
String value = sc.nextLine();
입력하고 엔터를 칠때까지 대기한다.

```java
/*
		 * 제어문 조건문 : if(3가지) , switch(조건) {case값... break} 반복문: for(반복횟수가 명확) ,
		 * while(진위) {}, do{}~while() 분기문 : break(블럭탈출) , continue(아래 구문 skip)
		 *
		 */
		int count = 0;
		if (count < 1)
			System.out.println("true");

		if (count < 1) {
			System.out.println("true");

		}
		char data = 'A';
		switch (data) {
		case 'A':
			System.out.println("문자비교 같아요");
			break;
		case 'B':
			break;
		default:
			System.out.println("나머지 처리");
		}
		int result = 0;
		// for문
		// 1~100 누적합을 구해라
		for (int i = 1; i <= 100; i++) {
			result += i;

		}
		System.out.println(result);

		// 1~5까지의 합
		// for문과 while 쓰지말고
		// 개수 *(시작+끝)/2
		result = 5 * (1 + 5) / 2;

		// for 문을 사용해서 1~10까지 홀수의 합을 구하세요
		// for 문 안에 if 사용 x

		int sum2=0;
		for (int i = 1; i <= 10; i+=2) {
			sum2+=i;

		}System.out.println(sum2);

		//for안에 if문을 사용해서 1~1000까지 합을 구하세요(짝수)
		int sum3=0;
		for(int i =1;i<=1000;i++) {
			if(i%2==0) {
				sum3+=i;
				System.out.println(i);
			}
		}System.out.println(sum3);

```

### print f

```java
	System.out.println();//출력하고 줄바꿈(엔터)
		System.out.print("A");
		System.out.print("B");
		System.out.print("C");
		System.out.print("D");

		int num =100;
		System.out.println(num);
		System.out.println("num 값은"+num+"입니다.");
		//형식 format
		System.out.printf("num값은 %d입니다", num);
		System.out.println();
		System.out.printf("num 값은 [%d]입니다 또[%d]도 있어요", num, 12345);


		//format 형식문자
		/*
		 %d(10진수 형식의 정수)
		 %f(실수)
		 %s(문자열)
		 %c(문자)
		 \t tab \n 줄바꿈
		 */

		float f= 3.14f;
		System.out.println(f);
		System.out.printf("f변수값 %f입니다.\n",f);

		//입력받기 (cmd) 사용자가 입력한 값을...
		Scanner sc = new Scanner(System.in);
		String value = sc.nextLine();//입력하고 엔터를 칠떄까지 대기한다.
		//입력한 값을 문자열 전달해주세요
		System.out.println(value);

		//Today Point
		//[문자를] ==>숫자를 (정수,실수)
		//Integer.parseInt("1111")--->정수--->1111
		//Float.parseFloat("3.14")--->실수-->3.14
		System.out.print("숫자를 입력하세요");
		int number = Integer.parseInt(sc.nextLine());
		System.out.println(number);

	}
```

### simple calculator

```java
	System.out.println();//출력하고 줄바꿈(엔터)
		System.out.print("A");
		System.out.print("B");
		System.out.print("C");
		System.out.print("D");

		int num =100;
		System.out.println(num);
		System.out.println("num 값은"+num+"입니다.");
		//형식 format
		System.out.printf("num값은 %d입니다", num);
		System.out.println();
		System.out.printf("num 값은 [%d]입니다 또[%d]도 있어요", num, 12345);


		//format 형식문자
		/*
		 %d(10진수 형식의 정수)
		 %f(실수)
		 %s(문자열)
		 %c(문자)
		 \t tab \n 줄바꿈
		 */

		float f= 3.14f;
		System.out.println(f);
		System.out.printf("f변수값 %f입니다.\n",f);

		//입력받기 (cmd) 사용자가 입력한 값을...
		Scanner sc = new Scanner(System.in);
		String value = sc.nextLine();//입력하고 엔터를 칠떄까지 대기한다.
		//입력한 값을 문자열 전달해주세요
		System.out.println(value);

		//Today Point
		//[문자를] ==>숫자를 (정수,실수)
		//Integer.parseInt("1111")--->정수--->1111
		//Float.parseFloat("3.14")--->실수-->3.14
		System.out.print("숫자를 입력하세요");
		int number = Integer.parseInt(sc.nextLine());
		System.out.println(number);

	}
```

### 반복문

```java
//반복문(while, do~ while)
//		int i =10;
//		while(i>=10) {
//			//반드시 개발자가 인위적으로 증가감을 명시!!해야한다.
//			i--;//증가감의 위치도 고민하자
//			i--;
//			System.out.println('i'+i);
//		}
//		//while 1~100까지의 합
//		int sum =0;
//		int j =1;
//		while(j<=100) {
//			sum+=j;
//			j++;
//		}
//	System.out.println("sum : "+sum);

		//while 구구단

		//for(int i =2; i<=9;i++)
		//for(int j =1; j<=9;j++)
	//
		int k=2;
		int p=1;
		while(k<=9) {
		p=1;
		System.out.println(k+"단 시작 : ");

			while(p<=9) {
			System.out.println(k+"*"+p+"="+(k*p)+"\t");
			p++;
		}
			System.out.println("["+k+"]");
			k++;
		}
		//
		//for(;;) {} 무한루프
		//while(true){if(조건) break;}
		//do ~ while : 일단 1번은 강제적으로 수행하고 그리고 조건을 봐라
		//do { 실행문... 값을 받아요} while(조건판단)
		/*메뉴구성
		 점심메뉴를 선택하세요
		 1. ㅉ장
		 2. 짬뽕
		 계속 3입력메뉴가 다시 나오게 다시 입력 받으세요

		  프로그램 동작
		  당신이 원하는 메뉴 번호를 선택하세요 do..선택값 받아서
		  while(input >2) 다시 입력하세요 >> while false 구문을 종효



		*/
	Scanner sc= new Scanner(System.in);

//	int inputdata=0;
//	do {
//		System.out.println("숫자를 입력해(0~9)");
//		inputdata = Integer.parseInt(sc.nextLine());
//
//	}while(inputdata>=10);// true가 되면 계속do문 실행
//
//	System.out.println("당신이 입력한 숫자는 : "+inputdata);

	int inputdata = 0;
	do {
		System.out.println("숫자를 입력해아(0~9)");
		inputdata= Integer.parseInt(sc.nextLine());
	}while(inputdata>=10);
	System.out.println("당신이 입력한 숫자는"+inputdata);
```

### flow chart

```java
//문제1
String status = "hunger";
		String food = "nothing";


		if (status == "hunger") {
			if (food != "nothing") {
				System.out.println("밥을 먹는다");

			} else {
				System.out.println("밥을 먹지 않는다.");

			}
		} else {
			System.out.println("밥을 먹지 않는다");

		}

//문제2
		int unit=10000;
	int num = 0;
	boolean sw=false;

	Scanner sc= new Scanner(System.in);
	int money= sc.nextInt();



	while(unit>1) {
		num=money/unit;
		money=money-unit*num;
		System.out.println(unit+" "+num+"개");
		if(sw==false) {
			unit=unit/2;
					sw=true;
		}else
		{
			unit=unit/5;
			sw=false;
		}
	}
```

### OOP 기본

```java
/*
	 클래스 == 설계도== 타입
	 클래스 구성요소(설계도라고 판단할려면 최소한 무엇을 가지고 있어야한다)
	 필드 + 함수 + 생성자 함수

	 필드(member field) >> 데이터, 정보 담아야한다>>고유정보, 상태정보, 부품정보 >> field>>variable
	 함수(method) >> 기능 (행위)>>자동차>> 달린다, 멈춘다, 소리가 난다.
	 +추가적으로 생성자>> 특수한 목적의 함수>> 객체가 만들어질 때 member field초기화 목적으로

	 클래스, 필드, 생성자, 함수 :영역(범위) >> 접근자, 한정자, 수정자
	 >>public, private, default, protected

	 >>kr.or.kosa.common 안에 Car 클래스 >> public class Car{}>>나 다 오픈할꺼야
	 >>kr.or.kosa.common 안에 Airplane >> class Airplane{>>default class Airplane}
	 >>default 같은 폴더에서는 공유 : [같은 pakage안에서는 오픈][다른 package에선ㄴ 접근 불가]
	 >>default 접근자는 : 같은 폴더(package)내에서 만들어서 연습용

	 하나의 물리적인 java 파일은 여러개의 클래스를 가질 수 있다.
	 >>Ex01_Main.java  파일은 그 안에 Ex01_Main이라는 클래스를 하나 가지고 있다.
	 >>일반적으로 필요한 클래스를 별도의 파일로 생성해서 사용...
	 */


	문제푼다고 정신이 없다!!!
```
