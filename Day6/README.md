# 2022.08.26 금요일 못먹어도 고!

### java를 종료한다는 것

```java
System.exit(0)을 사용하여 Java 메소드 종료

 public static void exampleMethod() {
        for (int i = 0; i < 10; i++) {
            if (i > 3) {
                System.exit(0);
            }
            System.out.println("i: " + i);
        }
    }
```

return을 사용하여 Java 메소드 종료  
메소드를 종료하는 또 다른 방법은return키워드를 사용하는 것입니다.  
이 키워드는 사용할 때 메서드 실행을 완료하며 함수에서 값을 반환하는 데 사용할 수도 있습니다.

아래 예에는num1및num2의 두 매개 변수를 사용하는exampleMethod메소드가 있습니다.  
메소드에서 빼기를 수행하지만num2가num1보다 큰지 확인하고이 조건이 true가되면return이 메소드를 종료하고 실행이 완료됩니다.  
void를 반환 유형으로 사용하므로이 메서드는 값을 반환하지 않습니다.

```java
public class ExitMethod {
    public static void main(String[] args) {

        exampleMethod(2, 5);
        exampleMethod(3, 2);
        exampleMethod(100, 20);
        exampleMethod(102, 110);
    }

    public static void exampleMethod(int num1, int num2) {

        if (num2 > num1)
            return;

        int subtractedValue = num1 - num2;
        System.out.println(subtractedValue);


    }
```

### Getter Setter

원칙적으로 실무에서 사용하는 것과 동일한 방식으로...

1. 캡슐화 : 정보를 저장하는 (memeber field)에 대해서
2. 캡슐화 : 간접적으로 처리할 수 있는 코드가 필요---> setter, getter함수
3. 이런 데이터를 담을 수 있는 클래스 (DTO, VO, DOMAIN) 보통은 DTO를 많이 쓴다.

필요에 따라서 getter만 만드는 경우가 있고-->write만 하겠따  
필요에 따라서 setter만 만드는 경우가 있고-->read만 하겠다  
둘다 만드는 경우가 있다.--> 둘다 하겠다.

**_쉽게 만드는 방법_**

1. IDE를 사용해서 source--> generate getter setter
2. spring 때 배울것이지만 lombook라이브러리를 이용  
   Lombok 이란 Java 라이브러리로 반복되는 getter, setter, toString .
   등의 반복 메서드 작성 코드를 줄여주는 코드 다이어트 라이브러리 이다.  
   @Getter  
   @Stter  
   컴파일러에게 자동으로 setter, getter함수를 만들어 달라는 요청이다.  
   필요하다면 별도의 함수를 생성
   speed를 10씩 올리거나 감소하는 기능을 만들어라
   일반적으로 아래처러므 별도의 함수를 만들기 보다는 read와 write를 한다면
   setter와 getter를 통해서 제어하는 것이 일반적이다.

```java
public class Car {
	private int window;//굳이 초기화가 필요없다 default값을 가지기 때문에
	private  int  speed;
    public void speedUp() {
		speed+=10;
	}
	public void speedDown() {

		if(speed>0) {
			speed-=10;
		}else {
			speed=0;
		}
	}
	public int getWindow() {
		return window;

	}
	public void setWindow(int data) { //this를 안배워서 이렇게 쓰는데 원해는 setWindow (int window){this...}
		window = data;//setter 함수


	}

	public int getSpeed() {
		return speed;
	}
	public void setSpeed(int speed) {
		this.speed = speed;
	}
}
```

```java
import kr.or.kosa.Car;

public class Ex05_Modifier {
public static void main(String[] args) {
	Car car = new Car();
	int speed = car.getSpeed();
	System.out.println("speed : "+speed);

		car.speedUp();
		car.speedUp();
		speed = car.getSpeed();
		System.out.println("speed :"+speed);

		car.speedDown();
		car.speedDown();
		car.speedDown();
		speed = car.getSpeed();
		System.out.println("sped : "+speed);

}
}

```

### static

1. member field, instance varivable
2. iv 언제 사용 가능 할깐요(메모리에 언제 올라갈까요)  
   2-1 Variable v= new Variable() ;>>heap객체 생성>> 객체 안에 iv생성
   Variable v= new Variable() ;
3. 목적 : 데이터(정보), 자료를 담을 목적  
   3.1 정보 : 고유, 상태, 부툼(class)  
   -생성되는 객체마다 다른 값을 가질 수 있다.  
   -그래서 초기화 해서 값을 강제하지 않는다.  
   -대신에 default값은 가지고 있다. (int>0, double>0.0, char >빈문자'\u0000',
   boolean>false, String>null, Car>null)  
   iv 변수의 생성 시점 : new라는 연산자를 통해서heap Variable이름의 객체가 만들어지고 나서 바로 생성(그 안에)

instance variable >> class Car{private Stirng color;}  
생성되는 객체마다 다른 색상을 가질 수 있다.

local variable>> class Car{public void move(){ int speed=0;}}  
습관적으로 지역안에 있는 변수는 초기화를 하자

block variable >> class Car{public void move(){for(int t;i<10.....)}제어생성... 소멸  
static variable >> 공유자원 (객체간), 객체 생성 이전에 memory 올라가는 자원 ( 영역 : class area, method area)

객체를 만드는 유일한 방법은 new를 통해서 memory에 올리는 것이라고 하셨지만  
static은 new없이도 memory에 올라간다.  
Ex06_Variable_Scope 클래스 >> 구체화(메모리) >>Ex06_Variable_Scope>> 이 클래스는 new를 한 적이 없었다 한번도

1. class variable(클래스 변수) ,일반적으로 static variable(객체간 공유자원)
2. 목적 : 정보를 담는것 (생성되는 모든 객체가 공유하는 자원)  
   생성되는 모든 객체라는 것은 (heap영역에 생성된 객체들이 공유하는 자원)
3. 접근방법  
   1.class 이름.static변수명>> Variable.cv>>why(객체가 생성되기 전에...접근
4. Variable v =new Variable();>>c.cv  
   Variable v2 =new Variable();>>v2.cv  
   v.cv의 주소값과 v2.cv(같은 주소를 바라본다 : static 변수 주소)
5. 생성시점  
   Hello.java>javac Hello.java>Hello.class  
   java.exe Hello 엔터 실행  
   JVM>OS>Memory빌려 > 정리(영역을 나누어요)>class Loader system 분석  
   클래스 정보(metadata : 설명) >> clss area(method area)메모리에 올림( 언제. 어떤 자원, 버전..)  
   그 클래스 안에 static variable 또는 static method있다면 두녀석을 class area(method area) 영역에 할당합니다.  
   그런데 그 함수의 이름이 만약에 main() 이라면 정해진 규칙에 따라서 실행합니다(Stack영역) 자원 할당...

```java
class Variable{
	int iv;//instance Variable
    static int cv;//
    void method() {
		int lv=0;//local variable
		/*
		local Variable(함수안에 : 지역변수 : 사용전에 반드시 초기화)
		생명주기) 함수가 호출되면 (stack생성되었다고 함수가 끝나면, 강제 return되면 같이 소멸)
		 */

		for(int i =0; i<10;i++) {
			//int i>> block변수>>for문이 생성되면 생성되었다가 for문이 끝나면 소멸
		}
		for(int i =0; i<10;i++) {

		}


	}

}

public class Ex06_Variable_Scope {

	public static void main(String[] args) {
		//어떤 객체도 생성하지 않아요
		Variable.cv =100;
		Ex06_Variable_Scope ex06= new Ex06_Variable_Scope();


	}
	public void method() {
		System.out.println("나 일반 함수");

	}



}


```

### Airplane 예제

    우리 회사는 비행기를 주문 제작 판매 하는 회사입니다
    우리 회사는 비행기를 생산하는 설계도를 만들려고 합니다

    요구사항
    1. 비행기를 생산하고 비행기의 이름과 번호를 부여해야 한다
    2. 비행기가 생산되면 비행기의 이름과 번호가 맞게 부여되었는지 확인 하는 작업이 필요하다(출력)
    3. 공장장은 현재까지 만들어진 비행기의 총 누적대수를 확인 할 수 있다

    AirPlane air101 = new AirPlane();
    air101 이름 >> 대한항공
    air101 번호 >> 707
    출력 확인..
    ....5대
    관리자 비행기 누적 대수 확인 ..... 5대가 제작되었습니다

    조건 ) 생성자를 사용하지 마세요 (아직 ....)
    hint) static 객체간 공유 자원이다 ....

```java
public class AirPlane {
	private int airnum;
	private String airname;
	private static int airtotalcount; //모든 객체가 공유하는 자원

	public void makeAirPlane(int airnum , String airname) {
		this.airnum = airnum;
		this.airname = airname;
		//airtotalcount 누적대수
		airtotalcount++;

		AirDisplay();
	}

	private void AirDisplay() {
		System.out.printf("번호[%d] , 이름[%s] \n",this.airnum	,this.airname);
	}

	public void airPlaneTotalCount() {
		System.out.printf("총 비행기 제작 대수 : [%d] \n",airtotalcount );
	}

}

import kr.or.kosa.AirPlane;

public class Ex07_Static_AirPlane {

	public static void main(String[] args) {
		//비행기 3대 만드시고 확인하세요
		AirPlane air1 = new AirPlane();
		air1.makeAirPlane(101, "대한항공");
		air1.airPlaneTotalCount();

		AirPlane air2 = new AirPlane();
		air2.makeAirPlane(707, "대한항공");
		air2.airPlaneTotalCount();

		AirPlane air3 = new AirPlane();
		air3.makeAirPlane(808, "아시아나");
		air3.airPlaneTotalCount();
	}

}
```

### card예제

```java

public class Ex08_Card {
public static void main(String[] args) {

	Card c1= new Card();
	c1.kind="Heart";
	c1.number=7;

	Card c2= new Card();
	c2.kind="Spade";
	c2.number=8;

	Card c3= new Card();
	c3.kind="Heart";
	c3.number=7;

	System.out.println(c1.kind +"  "+c1.number +"  "+ c1.width+"  "+c1.height);

	c1.width=30;
	c1.height=60;
	System.out.println(c2.kind +"  "+c2.number +"  "+ c2.width+"  "+c2.height);


	System.out.println(c3.kind +"  "+c3.number +"  "+ c3.width+"  "+c3.height);
}
}
class Card{
	String kind;
	int number;

	static int width=20;
	static int height = 50;


```

```java
// static 변수는 객체마다 같은 값을 가지게 할꺼야
// instance변수는 객체마다 다른 값을 가지게 할꺼야 목적으로 설계

//두 변수에 대해서 초기화를 하는 방법이 두가지가 있따.
class InitTest{
	static int cv=10;
	static int cv2;
	int iv= 11;
	//3놈은 사실 default값은 초기화 하지 않아도 된다.
	static{
		//static 자원에 초기화 블럭
		//초기화 블럭은 언제 실행이 될까?
		//static int cv=10, static int cv2이 메모리에 올라간 직후
		cv=1111;
		cv2=cv+2222;//조작된 값의 표현이 가능하다.

	}

	{

	//초기자 블럭 (member field초기화)
	//객체가 생성되고 나서 int iv 메모리에 올라가고 나서 바로 호출 {블럭}
		//인위적인 코드 //if(iv>10) iv =100
		System.out.println("초기자블럭");
		//iv=2222;;
		if(iv>10) iv=1000;

			cv=100;//객체가 new되지 않으면 초기화 안되요(static)


	}
}
public class Ex09_Static_init {
	public static void main(String[] args) {
//		InitTest t = new InitTest();
//		System.out.println(t.iv);
		System.out.println(InitTest.cv);
		System.out.println(InitTest.cv2);
	}
}
```

### Method

static member field : 객체간 공유자원...
static method :왜 만들까??-->

1. 객체 생성 없이...어떤 느낌이냐?
2. 많이 사용해요
3. 설계도를 만들 때 고려해야한다.(당신이 그 자원을 (기능)을 많이 사용한다면)
4. 자원 많이 쓰네.... 편하게 쓰게해줄께..new객체 하는거 불편하지 그럼 편하게 해줄께
5. 많이 쓰는 함수는 static하는게 편하게 쓰게 해줄께 .>>static설계

```java
class StaticClass{
	int iv;
	static int cv;

	void m() {
		//1. 일반함수에서 iv제어 가능
		cv=100;
		//why : 생성시점 {static 자원은 객체 생성 이전에 memory로드)
	}
	static void print() {
		//static 함수
		//1. cv 제어 가능?? 가능
		//2. 일반 변수 iv 제어 가능??
		//iv=100;(x)
		//static자원은 일반 자원보다 우선되기떄문에 일반 자원은 사용하지 못한다.
		//결과 : static 자원만 가지고 논다.
	}
}
public class Ex10_Method {
public static void main(String[] args) {
	System.out.println(StaticClass.cv);//new 없이 함수 사용
	System.out.println();
	System.out.println();

	//일반자원 (객체생성)
	StaticClass sc= new StaticClass();
	sc.m();
	sc.print();
}
}

```
