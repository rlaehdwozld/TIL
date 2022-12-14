# 2022.08.23 화요일 못먹어도 고!

**클래스는 설계도이다 , 클래스는 데이터 타입이다**  
 클래스 == 설계도 == 타입

클래스는 구체화를 통해서 사용된다.(집을 짓는 행위)
프로그램에서는 [ new연산자 ] 를 통해서 memory라는 공간에다가 집을 짓는다. >> 만들어진 것 >> 객체(인스턴스)

**설계도의 종류 2가지**

1.  독자적으로 실행 가능한 설계도 >>public static void main(String [] args){} 가지고 있는 클래스
2.  독자적으로 실행 불가능 >> main함수가 없는 나머지 클래스 >> 남을 도와주는 클래스 >> 라이브러리(LIB) 우리가 대부분 사용하는 클래스는 2번의 경우

```java
        class Apt2{
    int door = 10;
    int window=20;
    }

    class Car{


    }
    public class Ex05_Ref_Type {

        public static void main(String[] args) {
            //Apt2 설계도를 가지고
            //구체화된 산물 생산 (객체)

            int num;
            num = 100; //정수 값을 넣어두면 된다.
            Apt2 apt2;
            apt2 = new Apt2();//Apt2 설계도를 기반으로 지어진 아파트를 짓는다. (JVM >> memory >>heap)
            System.out.println("apt2 : "+ apt2); // 주소값 Apt2@75a1cd57

            Apt2 ssapt = apt2; //주소값을 할당... ssapt변수는 apt2가 가지고 있는 주소값으로 초기화가 된다. if apt2가 객체가 생성 되어있었다면 주소값이 변했으니
            //가비지 컬렉터로 가게된다.
            ssapt.door = 100;// .주소를 찾아가는 연산자

            System.out.println("apt2가 바라보는 door : "+ apt2.door);
```

## 연산자

(+) 더하기  
(-) 뺴기  
(/) 나누기  
(%) 나머지  
(++) 1씩 증가  
(--) 1씩 감소

```java
        int i =10;
		++i; //전치 증가
		System.out.println("전치 : "+i);
		i++;
		System.out.println("후치 : "+i);

		//Today Point( 증가감 연산자 다른 연산자와 결합되면 전치, 후치)
		int i2 =5;
		int j2 = 4;
		int result2 = i2 + ++j2;//전치증가는 선행연산보다 우선된다.
		System.out.println("result2 : " + result2 + " j2 : " +j2);
		//result2 : 10 j2 : 5
		result2 = i2 + j2++;
		System.out.println("result2 : " + result2 + " j2 : " +j2);
        //result2 : 10 j2 : 6
        byte b = 100;
		byte c = 1;
		//byte d= b+c;// byte -128~127
		//Type mismatch: cannot convert from int to byte
		//자바는 연산을 하기 위해서 정수방을 사용한다.

		int d = b + c; // 결과의 타입을 조정해서(손실 발생하지 않는다.
		System.out.println("d값 출력 : "+d);
```

### Today 포인트

정수의 모든 연산은 [int] 타입 변환 후 처리  
 byte + short => 컴파일러가 내부적으로 int + int  
 char + char => 컴파일러가 내부적으로 int + int  
 정수의 연산에서 int 보다 작은 타입은 int 변환 연산 (long제외)  
 byte, char, short 연산시에는 int 방에 넣어서 계산  
 char + int >> int + int  
 int + long>> long + long 예외적으로  
 정수 + 실수 >> 타입의 크기와 상관 없이 .. 실수 승자

```java
        long ln = 1000000000L;
		float fl = 12.4f;
		// long lnresult = ln + fl;
		// long lnresult = (long)(ln+fl);//손실발생
		float lnresult = ln + fl;
		System.out.println(lnresult);
		System.out.println(lnresult);

		float num2 = 10.45f;
		int num3 = 20;
		// num2 + num3
		// float + int >> float + float
		float result5 = num2 + num3;
		System.out.println(result5);

		char c2 = '!';//33
		char c3 = '!';
		int result6 = c2 + c3;
		System.out.println(result6);
```

---

## 제어문

중소기업 시험 문제에 구구단 출력 혹은 별찍기 문제가 자주 출제된다.

![삼항연산자](https://cafeptthumb-phinf.pstatic.net/MjAyMDA4MDZfMjU1/MDAxNTk2Njg5MDEzODMx.frIKdyKnLNbwQdQ8I-9mWDrGKSPC3kld-HYr5HlfUBwg.D3Y_MVgJXA-ICIo_0R-Cq6fwaJnx1INxjnoQkdMLbmMg.PNG/%EB%8B%A4%EC%9A%B4%EB%A1%9C%EB%93%9C.png?type=w1600)

#### Today Point

연산자 중에서 제어문 역할을 하는 것  
삼항연산자

```java
        int p = 10;
		int k = -10;
		int result8 = (p==k) ? p:k;

		//위 코드를 if문으로 바꿔보자
		int result9 =0;
		if(p==k) {
			result9 = p;
		}else {
			result9 = k;
		}
```

![삼항연산자](https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Ft1.daumcdn.net%2Fcfile%2Ftistory%2F99375E495C020AB503)

※ 주의사항

1. 삼항 연산자를 사용하여 코드의 라인이 줄어들었다고 컴파일 속도가 빨라지는 것은 아니다.

2. 삼항 연산자를 중복해서 처리할 경우. 가독성이 떨어질 수 있으므로 중복처리는 피하는 것이 좋다.

## 연산자 (비트)

| or 연산
& and 연산

|| 논리연산(OR)
&& 논리연산(AND)

### Today Point ( && (and), || (or))

    	//if(10>0 && -1>1&&100>2&&1>-1){ A } else { B }
    	//거짓이 나오는 순간 처리 됩니다.
    	//if(10>0 or -1>1or100>2or1>-1){ A } else { B }

### swtich문

```java
int data = 50;
		switch (data) {
		case 100:
			System.out.println("100입니다.");
			break;
		case 90:
			System.out.println("90입니다");
			break;
		case 80:
			System.out.println("80입니다");
			break;
		case 70:
			System.out.println("70입니다");
			break;
		case 60:
			System.out.println("60입니다");
			break;
		default:
			System.out.println("일치하는 값이 없어요");
		}
		int data1 = 100;
		switch (data) {
		case 100:
			System.out.println("100입니다.");
		case 90:
			System.out.println("90입니다");
		case 80:
			System.out.println("80입니다");
		case 70:
			System.out.println("70입니다");
		case 60:
			System.out.println("60입니다");
		default:
			System.out.println("일치하는 값이 없어요");
		}


	int month = ; //월은 데이터를 제공하면 해당 월이 가지고 있는 일 수를 알려준다.

	String res="";// 빈문자열 초기화

	switch(month){
	case 1:
	case 3:
	case 5:
	case 7:
	case 8:
	case 10:
	case 12:
		res = "31";
		break;
	case 4:
	case 6:
	case 9:
	case 11:
		res = "30";
		break;
	case 2:
		res = "29";
		break;
	default :
		res ="월이 아닙니다.";

	}	System.out.println(month+"월은 "+res+"일까지 입니다.");

}
```

### 난수 ( 랜덤값 : 임의의 추출값)

    java ( 사용하고자하는 다양한 자원을 미리 생성해 두웠다>> 찾아서 >>사용 JAVA API)
    도움말 ( 찾아서...)
    java.lang.Math 클래스 찾았어요
    public static double random()
     equal to 0.0 and less than 1.0 범위의 난수를 얻을 수 있따.
    결과 : double 실수 return 0.0<=random <1.0

    원칙적인 방법
    쓰고자 하는 자원이 있는 폴더를 open
    mport java.lang.* >> java폴더 안에 lang 폴덩안에 있는 모든 자원은 사용가능

### 문제를 풀어보자!!

우리는 백화점 경품 시스템을 만들려고 한다.  
 경품 시스템은 나오는 점수에 따라 경품을 지급하는 시스템이다  
 경품 추첨시 1000 점수가 나오면  
 경품으로 TV , NoteBook , 냉장고 , 한우세트 , 휴지  
 경품 추첨시 900 점수가 나오면  
 경품으로 NoteBook , 냉장고 , 한우세트 , 휴지  
 경품 추첨시 800 점수가 나오면  
 경품으로 냉장고 , 한우세트 , 휴지  
 경품 추첨시 700 점수가 나오면  
 경품으로 한우세트 , 휴지  
 경품 추첨시 600 점수가 나오면  
 경품으로 휴지  
 그외 점수는 100 ~ 500 까지는 칫솔  
 경품시스템의 점수 범위는 100 ~ 1000 점까지 한정되어 있다  
 사용자가 경품 시스템을 사용시 랜덤하게 100 ~ 1000까지의 값이 나오게 되어 있습니다.\*/

```java
	// 내가 쓴 답

	int num;
	String gift="";
	num=((int)(Math.random()*10)+1)*100;


	System.out.println("num :"+num);
	switch(num){
		case 1000 : gift ="TV , NoteBook , 냉장고 , 한우세트 , 휴지";
		System.out.println(gift);
		break;
		case 900 : gift = "NoteBook , 냉장고 , 한우세트 , 휴지";
		System.out.println(gift);
		break;
		case 800 : gift = "냉장고 , 한우세트 , 휴지";
		System.out.println(gift);
		break;
		case 700 : gift = "한우세트 , 휴지";
		System.out.println(gift);
		break;
		case 600 : gift = "휴지";
		System.out.println(gift);
		break;
		case 500 : gift = "칫솔";
		System.out.println(gift);
		break;
		case 400 : gift = "칫솔";
		System.out.println(gift);
		break;
		case 300 : gift = "칫솔";
		System.out.println(gift);
		break;
		case 200 : gift = "칫솔";
		System.out.println(gift);
		break;
		case 100 : gift = "칫솔";
		System.out.println(gift);
		break;
	}
```

```java
	// 선생님이 알려주신 답

	System.out.println(num);
	switch (num) {
	case 1000:gift+="Tv";
	case 900:gift+="노트북";
	case 800:gift+="냉장고";
	case 700:gift+="한우";
	case 600:gift+="휴지";
	break;
	default:gift +="칫솔";
	} System.out.println(gift);


	//switch(조건) 정수만 .. dkslwy
	// 조건식은 "문자열"도 가능, "문자"도 가능

	String m = "F";
	String f="";
	switch(m)	{



		case "A":
		case "B":
		case "C":
		case "D":
		case "E":
		case "F":
		case "G": f= "ok";
		case "H":
		case "k": f= "no";
		default : f= "no data";
	}
	System.out.println("f : "+f);
```

### if 조건문 문제

간단한 학점 계산기  
학점 A+ , A- , B+ , B- ,....F  
점수 : 94점
판단 기준 90점이 이상인지 >>A 부여  
판단 95점 이상 >>A+  
아니라면 >>A-  
84 일단 80점이 이상 >B  
판단 85 이상>>B+  
아니라면 >> B-  
if문을 사용해서 학점을 계산

```java
// 내가쓴답
		int score = 98;
		String grade = "";
		System.out.println("당신의 점수는 :" + score);
		// if문 동작
		if (score >= 95) {
			grade = "A+";
			}	else if(score<90) {
			grade ="A-";
			} else if (score <= 85) {
			grade ="B+";
			}else if (score<85)
			grade = "B-";
		else {

		System.out.println("당신의 점수는 :"+grade);

    //조건문 연습 많이 했는데 헷갈렸다...
    //조건 범위 설정이 문제인 듯

    //정답
		int score = 97;
		String grade = "";// A+ , A- 를 담는 변수
		System.out.println("당신의 점수는 : " + score);

		// if문 동작
		if (score >= 90) {
			grade = "A";
			grade = (score >= 95) ? (grade += "+") : (grade += "-");//삼항연산자 사용해서 90에 +,-붙이는 용도로 사용
		} else if (score >= 80) {
			grade = "B";
			if (score >= 85) {
				grade += "+";
			} else {
				grade += "-";
			}
		} else if (score >= 70) {
			grade = "C";
			if (score >= 75) {
				grade += "+";
			} else {
				grade += "-";
			}
		} else {
			grade = "F";
		}

		//
		System.out.println("당신의 학점은 : " + grade);
```

### 초보자용 문제1

[1번 문제]  
알파벳(A~Z) 까지 출력하는 프로그램을 작성하세요  
(for 문을 사용하세요)

```java
	int a ;
		for(int i =65;i<=91;i++) {
			System.out.println((char)i);}
```

### 초보자용 문제2

[1번 문제]  
1~100까지 10행 10열로 출력하는 프로그램을 작성하세요  
(for문을 사용하세요)

ex)

1 2 3 4 5 6 7 8 9 10

11 12 13 .....

91 92 93 94 ... 100

```java
int plus = 0;
		for (int i = 1; i <= 10; i++) {//렬
			for (int j = 1; j <= 10; j++) {//행
				System.out.print(plus++);//
			}
			System.out.println();
		}
```

[3번 문제]
두개의 주사위를 던졌을 때 눈의 합이 6이 되는 모든 경우의 수를 출력하는 프로그램을 작성하세요

```java
int num1=0;
		for(int i =1;i<=6;i++) {
			for(int j=1;j<=6;j++) {

				if(i+j==6) {
					System.out.println(i+" "+j);
				}
			}

		}
```
