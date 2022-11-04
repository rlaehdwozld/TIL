/*
 생성자 함수(constructor)
 1. 함수(특수한 목적)
 2. 목적(member field 초기화)	>> static{},{ 초기자 블럭}
 3. 일반함수와 차이점
 3-1 함수의 이름이 고정(class 이름과 동일)
 3-2 return type 없어요(객체 생성과 동시에 호출)(return 을 받을 대상이 없다)
 3-3 실행시점 >> new객체 생성 >> heap공간 생성 >>member field가 자리를 잡는다>> 자동으로 생성자 함수 호출
 3-4 return type(x)>> void>> public void(생략) 클래스 이름을 쓴다.>> public 클래스 이름 () {}
 
 4 why : 생성되는 객체마다 (강제적으로) member field 값을 초기화 할 수 있다. 
 
 class Car{String color;}
 
 >>설계도를 만들었어... 자동차의 색상은 만들떄 알아서해
 
 a) 저 무조건 파랑색 차를 생성... 처음 파랑색으로 설계해 주세요
 class Car{String color = "blue"}
 
 b) 저는 차 색상은 제가 알아서 할게요
 class Car{String color;}
 Car car= new Car(	);
 car.color = "gold";
 
  문제) 
  자동차의 색상을 설정하지 않고 출고하면
  null 이란 색상(없는 색상)
  
  >> 차량을 만들 떄 무조건 색상을 입력하게 할 수 있는 방법...
  >>함수나 초기자 블럭이 있지만 강제성이 약하고, 입력값을 넣을 수가 없다. 
  
   5. 생성자 함수(......overloading 기법 적용 가능)
   
   6. 생성자 오버로딩을 통해서 다양한 강제사항을 구현한다....
   
   ★★★★★★★★★★★★생성자를 쓰는 가장 중요한 목적은 "강제적' 초기화(member field)★★★★★★★★★★★★★
  */
class Car {
	String carname = "포니";
	// 당신이 만약 Car설게도를 만들때...
	// 컴파일러가 알아서 함수를 생성...
	// 생성자 함수
	// public Car() {}자동 생산...

	// 개발자가 직접 구현
	public Car() {// 자동호출
		System.out.println("기본 생성자 호출");
		carname = "내마음";
	}
}

class Car4 {
	String carname;
	// 생략되어있다.
	// public Car4(){} 생성자가 생략되어있다.
}

class Car2 {
	String carname;

	public Car2() {
		carname = "포니";

	}
}

class Car3 { //기본 자동차이름 생산해도 되고 다종차 이름을 넣어서 생산해도돼!
	String carname;

	public Car3() {
		carname = "기본이름";
	}
//오버로딩을 통해서
	public Car3(String name) { //오전 point
		carname = name;

	}
}

class Car5 { //기본 자동차이름 생산해도 되고 다종차 이름을 넣어서 생산해도돼!
	String carname;
	
//오버로딩을 통해서
	public Car5(String name) { //오전 point
		carname = name;
//위 코드는 public  Car5()	{} 구현하지 않아도 컴파일러가 자동생산한다면서요...
		// 예외적으로 개발자가 오버로딩 된 생성자를 하나라도 만든다면 컴파일러는 자동으로 default생성자를 만들지 않는다. 
	}
}
//자동차의 이름은 무조건 자동차가 만들어 질때 사용하게 해 ... 설계도를 만들어라
public class Ex16_Constructor {
	public static void main(String[] args) {
		Car car = new Car();// new Car() 괄호가 함수의 괄호//default constructor
		System.out.println();
		
		Car3 car3=new Car3();
		System.out.println(car3.carname);
		
		Car3 car4 = new Car3("mycar");
		System.out.println(car4.carname);
		
	}

}
