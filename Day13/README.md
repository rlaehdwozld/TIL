# 2022.09.06 화요일 못먹어도 고!

### 추상클래스

추상 메소드(abstract method)란 자식 클래스에서 반드시 오버라이딩해야만 사용할 수 있는 메소드를 의미합니다.

자바에서 추상 메소드를 선언하여 사용하는 목적은 추상 메소드가 포함된 클래스를 상속받는 자식 클래스가 반드시 추상 메소드를 구현하도록 하기 위함입니다.

1. 완성된 코드 + 미완성 코드
2. 완성(함수) 실행블럭이 있는 함수 + 미완성(함수) 실행 블럭이 없는 함수 >> public void run();  
   원래 함수) public void run() { 실행블럭 };
3. 완성된 클래스(new 가능) - 미완성 클래스( 스스로 객체 생성 불가)

설계자 입장에서  
의도 >> 반드시 재정의 해라 >> 강제적 구현을 목적으로(믿지 못하니깐)

```java
class Car {
	void run() {
	} // {구문이 없어도 : 실행블럭만 있으면 완성된코드}
}

class Hcar extends Car {
	@Override
	void run() {
		System.out.println("재정의");
	}
}

abstract class Abclass {// 클래스 안에 최소 1개의 추상 함수(method)를 가지고 있는 클래스
	// 완성된 코드도 있어도 된다!
	int pos;

	void run() {
		pos++;
	}

	// 미완성 코드 추가(미완성 함수 : 추상함수)
	abstract void stop();// 실행블럭{ }이 있으면 안된다.----> Override를 강제하는 것이다.
}

class Child extends Abclass {

	@Override
	void stop() {// 실행 블럭을 만들면 구현(강제적)
		this.pos = 0;
		System.out.println("stop:" + this.pos);

	}

}

class Child2 extends Abclass {

	@Override
	void stop() {// 실행 블럭을 만들면 구현(강제적)
		this.pos = 0;
		System.out.println("stop:" + this.pos);

	}

}


public class Ex01_abstract_class {
	public static void main(String[] args) {
		Child ch = new Child();
		ch.run();
		ch.run();
		ch.stop();

		Child2 ch2 = new Child2();
		ch2.stop();
		Abclass ab= ch;//다형성
		//상속과게에서 부모 타입의 참조변수가 자식타입객체들의 주소를 받을 수 있다(다형성)
		//단 부모는 자신의 것만 볼 수 있다.
		//단 재정의.. 자식의 자원을 본다.
		ab.run();
		ab.stop();//자식 함수를 호출(구현)Z

	}

}
```

Car 만든 사람이 run() 재정의 해서 내용을 좀 바꿔라  
그러나 강제가 없으므르 Hcar를 만드는 사람이 run()를 채울 "필요"는 없다.  
추상클래스 없이도 재정의는 가능하다!!! 헷갈리면 안된다.  
위의 코드는 강제성이 없지만 추상클래스는 강제성이 있다.

### 추상클래스 스타크래프트 예제

게임 : 유닛(unit)

unit : 공통기능 (이동좌표, 이동, 멈춘다) : 추상화, 일반화  
unit : 이동 방법은 다르다(이동방법은 unit 마다 별도의 구현 강제)

abstract class Unit {abstract void move(); }

```java
abstract class Unit{
	int x,y;
	void stop() {
		System.out.println("Unit 멈춤");
	}
	//이동( 서로 다르게) 강제 구현... 다름을 구현
	abstract void move(int x, int y) ;//{} 실행 블럭을 만들면 안된다 >>추상함수

}
class Tank extends Unit{

	@Override
	void move(int x, int y) {
		this.x=x;
		this.y=y;
		System.out.println("Tank 소리내며 이동 :"+this.x+" "+this.y);

		//필요하다면 Tank만의 구체화 특수화 내용을 구현
	}
	void changeMode() {
		System.out.println("모드변환");
	}
}
class Marine extends Unit{

	public Object move;
	@Override
	void move(int x, int y) {
		this.x=x;
		this.y=y;
		System.out.println("총쏘면서 이동 :"+this.x+" "+this.y);

	}
	//특수화, 구체화
	void steamPack() {
		System.out.println("스팀팩기능");
	}
}
class DropShip extends Unit{

	@Override
	void move(int x, int y) {
		this.x=x;
		this.y=y;
		System.out.println("하늘로 이동 :"+this.x+" "+this.y);

	}
	//특수화, 구체화
	void load() {
		System.out.println("Unit load");
	}
	void unload() {
		System.out.println("Unit unload");
	}





}
public class Ex02_abstract_class {
public static void main(String[] args) {
/*	Tank tank = new Tank();
	tank.move(10, 11);
	tank.stop();
	tank.changeMode();*/

	Marine marine= new Marine();
	marine.move(10, 111);
	marine.stop();
	marine.steamPack();


	//1. 탱크 3대를 만들고 같은 좌표로 (600,800)로 이동 시키세요
	Tank[] tanklist = {new Tank(), new Tank(), new Tank()} ;

	for(Tank t: tanklist) {
		t.move(600,800);
	}
//	for(int i=0;i<tanklist.length;i++) {
//		tanklist[i].x=600;
//		tanklist[i].y=800;
//	}
	//2. 여러개의 (Tank1대, Marine, DropShip 1대)를 생성하고 같은 좌표로 이동시키세요(666,888)
	Unit[] unitlist = {new Tank(), new Marine(), new DropShip()};
	//상속관계에서 부모타입의 참조변수는 자식타입의 객체를 받을 수있다.
	//단!! 시저모드, 스팀팩, 로드에는 접근하지 못한다.
	for(Unit u : unitlist) {
		u.move(666, 888);
	}
}

}
```

### 인터페이스

추상 클래스와 인터페이스  
추상클래스와 인터페이스 공통점  
1.스스로 객체 생성 불가능( new 연산자 사용 불가)  
1.1 두놈의 차이점 : 추상클래스(완성된 것 + 미완성), 인터페이스( 모든것이 미완성)

2. 사용  
   추상클래스 extends  
   인터페이스 implements

class Car extends Abclass{}  
class Car implements Ia{}  
둘다 추상 자원을 가지고 있다. >>extend, implements >> 강제적 구현 목적(재정의)

추상클래스와 인터페이스의 차이점  
3. 추상클래스(완성된 코드를 함께 가질 수 있다) 그러나 인터페이스는 전체가 미완성
3.1 원칙적으로 클래스 다중상속(계층적 상속) 그러나 inteface는 유일하게 [다중 구현]이 가능하다.
작은 단위로 여러개를 만들어서 >> 모아모아서 큰 약속>너무 큰 약속을 사용성이 떨어짐 그리고 재사용성이 떨어짐  
Ia, Ib, Ic  
class Test extends Object implements Ia.Ib.Ic  
Tip)인터페이스와 인터페이스끼리는 상속이 가능하다(extends)>> 약속을 크게 만들 수 있다.

4.인터페이스 (상수를 제외한 나머지는 미완성 추상(함수))>> JDK8버전부터 default 값, static값(잘 안쓴다)

초급 개발자의 시선에서

1.  인터페이스를 [[[다형성]]] 입장으로 접근 {인터페이스는 부모타입} \***\*\*\*\***
2.  서로 연관성이 없는 클래스를 하나로 묶어주는 기능을 한다.( 같은 부모를 가지게 함으로써)
3.  Java API 수많은 (미리 만들어진) 인터페이스를 제공(설계하지 않아도) 사용 가능
4.  인터페이스(~able) : 날 수 있는 , 수리할 수 있는
5.  객체간 연결고리(객체간 소통) >>> 다형성

인터페이스 : 약속, 표준을 만드는 것(규칙, 규약)  
소프트웨어 설계 최상위 단계..  
초급 걔발자가 인터페이스를 설계할 일은 많지 않다  
초급 개발자는 만들어진 인터페이스를 사용하는 방법 처리...  
범용적으로 구현부를 가지지는 않는다. 약속에 대한 정의만 있다.

interface  
1.실제 구현부를 가지고 있지 않다 : 실행 블럭이 없다 : 규칙(약속)  
시스템에서 이동하는 것을 move라는 이름을 사용하고 이동시에는 좌표값을 받아야한다.  
합의 >> void move(int x, int y); >> {구현은 알아서 } 클래스 알아서....>> 재정의 >> 구현  
Collection(동적배열)>> Vector, [ArrayList], HashSet, [HashMap]  
Collection 클래스는 수 많은 interface를 구현하고 있는 클래스

자바에서 프로젝트 할 때 제일 중요한 것 top3  
배열, HashMap, ArrayList

2. 생성방법  
   2.1 상수(final) : [public static fina]l int VERSION=1 > int VERSION =1;
   생략하면 컴파일러가 알아서 [public static final] 사용합니다.  
   2.2 추상함수(method) : [public abstract] void run();> void run();
   생략하면 컴파일러가 알아서 [public abstract] 사용
   interface Aa{  
    int VERSION =1;  
    void run() ;  
    String move(int x, int y);  
   }

인터페이스의 종류  
interface Aabel{} // 아무 자원을 가지지 않아도 되요  
interface Aable{int num=10;}  
interface Aable{void run();}

class Test extends Object implements Ia, Ib, Ic{}  
class Test implements Ia,Ib,Ic

```java
interface Ia{
	int AGE=100; //상수 // [public static final] int AGE //앞에꺼 생략가능
	String GENDENR="남"; //[public static final] String GENDER
	String print();//[public abstract] String print();
	void message(String str);//[public abstract] void message(String str);
}

class Test2 extends Object implements Ia{

	@Override
	public String print() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void message(String str) {
		// TODO Auto-generated method stub

	}//

}
interface Ib{
	int AGE=10;
	void info();
	String val(String s);
}


class Test3 extends Object implements Ia,Ib{

	@Override
	public void info() {
		// TODO Auto-generated method stub

	}

	@Override
	public String val(String s) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String print() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void message(String str) {
		// TODO Auto-generated method stub

	}//다중 구현

}



public class Ex03_Interface {
	public static void main(String[] args) {
		Test2 t2= new Test2();
		/////////////////////////////////////////////////////
		Ia ia=t2;//다형성 부모는 자식 객체의 주소를 가질 수 있다( 다형성)
		/////////////////////////////////////////////////////
		ia.message("재정의"); //재정의된 자원(자식 함수) 호출
		System.out.println(ia.GENDENR);

		///////////////////////////////////////////////////
		Test3 t3= new Test3();
		Ia ia2= t3;//Test3의 부모는 Ia, Ib 부모는 자식객체의 주소값을 가질 수 있다.
		Ib ib2=t3;
		System.out.println(ia2.GENDENR);
		System.out.println(ib2.AGE);

	}

}

```

### 인터페이스 심화 예제

Scv 구체화, 특수화된 고유한 기능  
수리하다(repair)  
Tank2, Scv

전자제품 매장 예시에서 물건이 1000개 있으면 과연 buy()라는 함수를 1000개 만들거냐(X)  
다형성을 사용해서 부모타입의 변수로 buy(Product p)

문제점 ) 부모는 찾았어요 부모는 GroundUnit(Tank2, Marine2, Scv)  
Marine2는 repair에 대상이 되지 않는다.  
void reapair (Unit2 Unit)>>Tank2, Marine2(x), Scv  
void reapair (GroundUnit Unit)>>Tank2, Marine2(x), Scv

개발자는 고민에 빠진다....

\*\*\*CommandCenter repair대상이야....(더 깊은 고민)  
Tank2, Marine2, Scv, CommandCenter 공통된 특징이 없다(연관성)

interface Irepairable{}

void repair(Tank2 tank) { if(tank.hitpoint !=tank.MAX_HP) { tank.hitpoint+=5;

} } void repair(Scv scv) { if(scv.hitpoint !=scv.MAX_HP) { scv.hitpoint+=5; }

} }

단 부모자원만 접근 가능  
단 재정의된 자원 접근

void repair(Irepariable repairunit) >> Tank2, CommandCenter, Scv가 올 수 있다.  
Irepairable 의 자식 타입....  
repair Tank2,Scv >>> scv.hitpoint+=5;  
repair CommandCenter는 다른 방법으로

repairunit 통해서 Unit2접근

답이되려면 Tanke2, Scv만 와야되는데 커맨드센터가 있어서 안됨>Unit2  
Unit2 unit2 = (Unit2)repairunit;//Down캐스팅  
unit2.hitpoint+=5;

CommndCenter>Unit2 연관성이 없다.  
Unit2 unit = (Unit2)repairunit;(예외)

repair(Irepairable repairunit)사용  
비교 (타입)>> instance of >> 타입 질문

```java


//인터페이스 설계
//~~을 할 수 있는 (수리 할 수 있는)
interface Irepariable{}

class Unit2 {
	int hitpoint;// 기본에너지
	final int MAX_HP;// 최대 에너지
	// Unit2(){}

	Unit2(int hp) {
		this.MAX_HP = hp;
	}
}

//지상유닛, 공중유닛, 건물

//지상유닛
class GroundUnit extends Unit2 {
	public GroundUnit(int hp) {
		super(hp);
	}
}

//공중유닛
class AirUnit extends Unit2 {
	public AirUnit(int hp) {
		super(hp);

	}

}

//건물
class CommandCenter implements Irepariable{
}

class Tank2 extends GroundUnit implements Irepariable{
	public Tank2() {
		super(50);
		this.hitpoint = this.MAX_HP;
	}

	@Override
	public String toString() {
		return "Tank2";
	}
}

class Marine2 extends GroundUnit {

	public Marine2() {
		super(50);
		this.hitpoint = this.MAX_HP;
	}

	@Override
	public String toString() {
		return "Marine2";
	}
}

class Scv extends GroundUnit implements Irepariable{

	public Scv() {
		super(50);
		this.hitpoint = this.MAX_HP;
	}

	@Override
	public String toString() {
		return "Scv";
	}
```

### 인터페이스 심화 예제

user 사용자 <> provider 제공자

class A{}  
class B{}  
관계 : A는 B를 사용합니다.

1. 상속 : A extends B
2. 포함 : A라는 클래스가 member field B를 사용 class A {B b; }  
   2.1 부분  
   2.2 전체

public class B{}  
public class A{  
public int i;(instance variable)  
public B b;//A는 B를 사용합니다(포함)  
Public A(){  
b=new B{};//생성자를 통해서 초기화(주소값)  
}  
}
main 함수  
A a = new A();// b도 함께 객체가 만들어진다.  
b에 접근하려면!!  
a.b.자원

포함관계로 사용시  
B는 독자생성 불가능 >> A라는 객체가 만들어져야 B도 생성  
A a= new A() 해야만 B 객체 생성된다.  
A, B 객체는 같은 운명 공동체이다(전체집합)  
자동차와 엔진 , 노트북 cpu

---

public class B{}
public class A{  
public int i;  
public B b;//A는 B를 사용합니다  
public A(){}

method  
void m(B b) {  
this.b=b;  
}  
}  
main 함수영역  
A a=new A();  
B b=new B();  
a.m(b);  
같은 운명이 아니다.  
학교(A) 학생(B)(부분집합)

```java
interface Icall {
	void m();
}

class D implements Icall {
	@Override
	public void m() {
		System.out.println("D Icall인터페이스의 m()재정의");
	}
}

class F implements Icall {

	@Override
	public void m() {
		System.out.println("F Icall인터페이스의 m()재정의");

	}

}
//현대적인 프로그래밍 방식 (interface 대세)>> 유연성>> 대충 만들어도 대충...
//느슨하게....>>interface를 부모로 두고 걔를 구현하는 것처럼 짜면된다.

class C {
	void method(Icall ic) {//Icall을 구현하는 모든 객체의 주소를 올 수 있다.
		ic.m();

	}
	/*
	 확장성 변환무시하는 코드다...
	 void method(D d){}
	 void m(F f){}
	*/
}

public class Ex05_User_Provider {

	public static void main(String[] args) {
		C c = new C();
		D d = new D();
		F f = new F();
		c.method(d);//implements Icall
		c.method(f);
		//c주소로 가서 method의 parameter ic에 D타입의 d를 넣는다. >> ic주소가서 m()에 d를 넣는데 구현부 없으니까 D클래스로 가서 D의 메소드의 구현부를 실행



	}

}
```
