
/*
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
3.1 원칙적으로 클래스 다중상속(계층적 상속) 그러나 inteface는 유일하게 [다중 구현]이 가능하다  작은 단위로 
 >>여러개를 만들어서 >> 모아모아서 큰 약속>너무 큰 약속을 만들면 사용성이 떨어짐 그리고 재사용성이 떨어짐
 Ia, Ib, Ic
 class Test extends Object implements Ia.Ib.Ic
 Tip)인터페이스와 인터페이스끼리는 상속이 가능하다(extends)>> 약속을 크게 만들 수 있다.
 
 4.인터페이스 (상수를 제외한 나머지는 미완성 추상(함수))>> JDK8버전부터 default 값, static값(잘 안쓴다)
 
 초급 개발자의 시선에서 
 1. 인터페이스를 [[[다형성]]] 입장으로 접근 {인터페이스는 부모타입} *********
 2. 서로 연관성이 없는 클래스를 하나로 묶어주는 기능을 한다.( 같은 부모를 가지게 함으로써)
 3. Java API 수많은 (미리 만들어진) 인터페이스를 제공(설계하지 않아도) 사용 가능
 4. 인터페이스(~able) : 날 수 있는 , 수리할 수 있는
 5. 객체간 연결고리(객체간 소통) >>> 다형성

인터페이스 : 약속, 표준을 만드는 것(규칙, 규약)
소프트웨어 설계 최상위 단계...
초급 걔발자가 인터페이스를 설계할 일은 많지 않다
초급 개발자는 만들어진 인터페이스를 사용하는 방법 처리...
범용적으로 구현부를 가지지는 않는다. 약속에 대한 정의만 있다.

interface
1.실제 구현부를 가지고 있지 않다 : 실행 블럭이 없다 : 규칙(약속)
시스템에서 이동하는 것을 move라는 이름을 사용하고 이동시에는 좌표값을 받아야한다.
>> 합의 >> void move(int x, int y); >> {구현은 알아서 } 클래스 알아서....>> 재정의 >> 구현
>> Collection(동적배열)>> Vector, [ArrayList], HashSet, [HashMap]
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
	void run()	;
	String move(int x, int y);
}

인터페이스의 종류 
interface Aabel{} // 아무 자원을 가지지 않아도 되요
interface Aable{int num=10;}
interface Aable{void run();}

class Test extends Object implements Ia, Ib, Ic{}
class Test implements Ia,Ib,Ic


	

*/

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
