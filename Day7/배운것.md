# 2022.08.29 월요일 못먹어도 고!

### static method 복습

### 오버로딩(Overloading)

OOP객체 지향 프로그래밍(여러개의 조각들을(설계도) 만들어서 조합하는 행위
여러개의 설계또를 재사용하는 방법

1. 상속 (재사용성)
2. 캡슐화 (은닉화) : private....setter, getter(직접 할당을 막고 간접 할당을 통해서 데이터를 보호하겠다)
3. 다형성 : 하나의 타입으로 여러개 객체의 주소를 가질 수 있는 것

method overloading(오버로딩)  
하나의 이름으로 여러가지 기능을 하는 함수  
System.out.println() >> println()함수 이름은 한개... 사용 방법은 여러개

1. 오버로딩은 성능향상과는 상관없다.(개발자 편하라고 있는 것, 만약 오버로딩이 없다면 함수 이름 다 외워야한다!!
2. 오버로딩을 사용하지 않아도 문제되지 않는다.

```java
public class Ex13_Method_Overloading {
	public static void main(String[] args) {
		System.out.println();
		System.out.println("A");//자동으로  parameter가 String녀석을 호출한다
		System.out.println('a');//자동으로 parameter가 char녀석 호출한다.

		System.out.println();
		/*
		 System.out.println();
		 System.out.printlnString();
		 System.out.printlnChar();
		 */

        OverTest ot = new OverTest();
		int result=ot.add(100	);
		System.out.println(result);
		int result1=ot.add(200,300);
		System.out.println(result1);
```

오버로딩은 다음과 같은 조건을 만족해야한다.

1. 매서드 이름이 같아야한다.
2. 매개변수의 개수 또는 타입이 달라야한다
3. 반환타입은 관계없다.
4. 매개변수의 순서가 다름을 인정한다.

```java
class Human{
	String name;
	int age;
}


class OverTest{
	int add(int i) {
		return 100+i;
	}

	//int add(int s) {//이름 충돌

	//}

	int add(int i, int j) {//파라매터 int i는 같지만 int j가 있기때문에 오버로딩의 조건을 만족한다
		return i+j;
	}
    String add(String s) {
		System.out.println("오버로딩  : "+s);
		return "hello"+s;
	}

	String add(String s, int i) {
		return "오버로딩";
	}
	String add(int i, String s) {//순서가 다름을 인정한다.
		return "";
	}
    	void add(Human human) {//얘도 오버로딩이다  //Human 타입의 객체 주소가 들어와야한다
		human.name="홍길동";
		human.age = 100;
		System.out.println(human.name+" "+human.age);

	}
}


```

### 생성자 함수

생성자 함수(constructor)

1. 함수(특수한 목적)
2. 목적(member field 초기화) >> static{},{ 초기자 블럭}
3. 일반함수와 차이점  
   3.1 함수의 이름이 고정(class 이름과 동일  
   3.2 return type 없어요(객체 생성과 동시에 호출)(return 을 받을 대상이 없다)  
   3.3 실행시점 >> new객체 생성 >> heap공간 생성 >>member field가 자리를 잡는다>> 자동으로 생성자 함수 호출  
   3-4 return type(x)>> void>> public void(생략) 클래스 이름을 쓴다.>> public 클래스 이름 () {}

4 why : 생성되는 객체마다 (강제적으로) member field 값을 초기화 할 수 있다.

```java
class Car{String color;}

>>설계도를 만들었어... 자동차의 색상은 만들떄 알아서해

a) 저 무조건 파랑색 차를 생성... 처음 파랑색으로 설계해 주세요
class Car{String color = "blue"}

b) 저는 차 색상은 제가 알아서 할게요
class Car{String color;}
Car car= new Car(	);
car.color = "gold";
```

문제)
자동차의 색상을 설정하지 않고 출고하면
null 이란 색상(없는 색상)

차량을 만들 떄 무조건 색상을 입력하게 할 수 있는 방법...
함수나 초기자 블럭이 있지만 강제성이 약하고, 입력값을 넣을 수가 없다.

5. 생성자 함수(......overloading 기법 적용 가능)

6. 생성자 오버로딩을 통해서 다양한 강제사항을 구현한다....

★★생성자를 쓰는 가장 중요한 목적은 "강제적' 초기화(member field)★★

---

### 문제

자동차 영업소 입니다.

영업사원은 고객에게 자동차를 팔려고 합니다.

고객은 자동차의 기본 사양을 살 수 도 있고 .... 여러가지 선택 옵션을 선택 할 수 있습니다.

자동차의 기본은

문의 개수 4개 , 자동차의 색상 기본은 red 4개가 기본 입니다

그런데 고객은

문의 개수만 변경 가능하고 자동차의 색상 기본은 red 으로 할 수 있고

문의 개수는 기본으로 하고 자동차의 색상 변경 가능하고

문의 개수와 자동차의 색상 모든 변경 하여 차를 구매할 수 있습니다

​

자동차 구매

1. 기본 사양

2. 옵션 : 문 변경 , 자동차의 색상 기본

3. 옵션 : 자동차의 색상 변경 , 문 기본

4. 옵션 : 자동차의 색상 변경 , 휠 변경

​

```java
package Day4;

class Car1{
	String color;
	int doornum;


	Car1(String c,int d){
		color ="red";
		doornum=4;
		}
	public void carInfoPrint() {
		System.out.printf("color [%s]차량, door [%d] , ",color,doornum);
	}
}
public class Car {
	public static void main(String[] args) {
		Car1 c1=new Car1("red",5);
		c1.carInfoPrint();
		System.out.println("c1의 color는 "+c1.color+" 문 갯수는 "+c1.doornum);

		Car1 c2=new Car1("blue",4);
		System.out.println("c2의 color는 "+c2.color+" 문 갯수는 "+c2.doornum);

		Car1 c3=new Car1("red",5);
		System.out.println("c3의 color는 "+c3.color+" 문 갯수는 "+c3.doornum);


		}
	}
```

### 문제

책은 책이름과 가격 정보를 가지고 있다.  
책이 출판되면 반드시 책 이름과 책의 가격 정보를 가지고 있어야한다.  
책의 이름과 가격 정보는 특정 기능을 통해서만 볼 수 있고, 출판된 이후에는 수정할 수 없다.(책의 가격 이름)  
책이름과 가격 정보는 각각 확인 할 수 있다.

```java
public class Book {
	private int price;
	private String name;

	Book(int price1, String name1) {// overloading constructor
		name = name1;
		price = price1;
	}

	public void bookInfo() {
		System.out.println("책 가격"+price+"책정보 : "+name);
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public static void main(String[] args) {

		Book b1 = new Book(500,"가");
		b1.bookInfo();

		Book b2=new Book(1000,"나");
		b2.bookInfo();
	}
}

```

### 예외처리

오류

1. 에러(error) : 네트워크 장애, 메모리 용량부족, 하드웨어>> 개발자가 코드적으로 해결 불가
2. 예외(exception) : 개발자가 코드의 실수에 의해 방샐 >> 문제 코드를 찾아서 >> 코드를 수정>> 배포
   프로그램 컴파일시가 아니라... 실행시에 발생되서 알 수 없다. 문제가 발생하면 ( exception) 프로그램 강제 종료 (웹이라면 500번 오류)
3. 예외처리>> 예외 발생애 대한 코드 수정하는 것이 아니고>> 일단 임시방편으로>> 문제가 생기더라도>>프로그램이 안정적으로 종료...처리>> 결국 예외처리를 통해서 문제가 생긴 부분을 찾고
   다시 코드 수정 >> 배포

try{  
문제가 의심되는 코드 실행  
문제가 발생(exception)  
}catch(Exception e){  
문제가 발생한 예외 부분을 파악...  
처리 (코드를 수정하는 것이 아니고 보고하는 것)

1. 관리자 email
2. 로그 파일에 기록(장외 발생 기록)\
3. 강제 프로그램 종료 막는다(일단은)
   결국 개발자 연락을 받고 수정하는 것이 답...  
   }finally{  
   문제가 발생하던, 발생하지 않던 강제적으로 실행해야될 코드  
   DB작업 문제(특정 자원에 종료) 강제

```java
public class Ex01_Exception {
	public static void main(String[] args) {
		/*
		System.out.println("main start");

		System.out.println(0 / 0);

		System.out.println("main end");
		*/
		System.out.println("main start");

		try {
			System.out.println(0/0);
			//연산 예외가 발생 .... try {}catch() 처리 프로그램이 강제 종료 되진 않아요

			//Exception 클래스 사용(에외 클래스최상위 부모)
			//e라고 변수는 무엇을 받는 것일까요?
			//Exception e >> Exception 객체 주소값....

			//ArithmeticException 문제가 발생
			//컴파일러에 의해서 ArithmeticException객체가 생성되고
			//그 객체에게 문제가 되는 메시지 , 코드 전달하면...
		}catch(Exception e){//부모타입의 변수는 자식타입의 주소값을 받을 수 있따.(다형성)
		//어떤 문제인지를 파악하고 그 정보를 전달
		//관리자, email,log write
			System.out.println(e.getMessage());


		}
		System.out.println("main end");


		System.out.println("main end");
	}
}
```

```java
public class Ex02_Exception {
	public static void main(String[] args) {
		int num = 100;
		int result = 0;
		try {
			for (int i = 0; i < 10; i++) {
				result = num / (int) (Math.random() * 10);
				System.out.println("result :" + result + "i:" + i);
			}
		} catch (ArithmeticException e) {// 문제가 발생되면 발생객체의 주소를 받아서 원인 분석...
			System.out.println("문제가 발생 관리자에게 문제에대한 원인을 메일로 전송");
			System.out.println("원인 : " + e.getMessage());
		}//catch (Eception e) 보다는 구체적인 객체 명시하는 가독성을 좋게한다.
		System.out.println("main end");
	}

}

```

### this

1. 객체 자신을 가르키는 this (앞으로 생성될 객체의 주소를 담을 곳이라고 가정)  
   인스턴스 자신을 가리키는 참조변수. 인스턴스의 주소가 저장되어있음  
   ((모든 인스턴스 메서드에 지역변수로 숨겨진 채로 존재))

2. this 객체 자신의 주소(생성자 호출) >>원칙적으로 생성자 객체 생성시 한개만 호출
   그런데 this학습 하면 예외적으로 this()통해서 여러개의 생성자를 호출 할 수 있다.

```java
class Test{
	int i;
	int j;
	Test(){ //생성자

	}
	Test(int i, int j){
	this.i=i;
	this.j=j;
	}
}

class Book2{
	String bookname;
	Book2(String bookname){
		this.bookname=bookname;//매개변수가 멤버필드를 초기화 할 떄 멤버 필드의 변수명과 똑같이 써야한다.
		//그리고 this로 구별을 해준다.
	}
}

//Today Point
class Socar{
	String color;
	String geartype;
	int door;

	Socar(){
		this.color=  "red";//member field(instance variable)사용시 반드시 this사용!
		this.geartype="auto";
		this.door=2;
	}

	Socar(String color, String geartype, int door	){
		this.color=color;
		this.door=door;
		this.geartype=geartype;
	}
	void print() {

		System.out.println(this.color+" "+this.door+" "+this.geartype);
	}
}

public class Ex19_this {

	public static void main(String[] args) {
		Test t= new Test(100,200);
		System.out.println(t.i);

		Socar socar =new Socar();
		socar.print();

		Socar socar2 = new Socar("gold","auto",6);
		socar2.print();

	}

}


}
```
