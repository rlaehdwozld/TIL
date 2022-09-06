
/*
 user 사용자 <> provider 제공자
 
 class A{}
 class B{}
 관계 : A는 B를 사용합니다.
 
 1. 상속 : A extends B
 2. 포함 : A라는 클래스가 member field B를 사용  class A {B b; }
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
 >>>main 함수 
 A a = new A();// b도 함께 객체가 만들어진다.
 b에 접근하려면!!
 a.b.자원
 
 >>포함관계로 사용시
 >> B는 독자생성 불가능 >> A라는 객체가 만들어져야 B도 생성
 >> A a= new A() 해야만 B 객체 생성된다.
 >>A, B 객체는 같은 운명 공동체이다(전체집합)
 >>자동차와 엔진 , 노트북 cpu
 ________________________________________________
 public class B{}	
 public class A{
 	public int i;
 	public B b;//A는 B를 사용합니다
 	public A(){}
 
 //method
  void m(B b)	{
  this.b=b;
  }
 }
 >>main 함수영역
 >>A a=new A();
 >>B b=new B();
 >>a.m(b);
 >>같은 운명이 아니다.
 >> 학교(A) 학생(B)(부분집합)
 //이거 구글에서 따오기


 
 
 
*/

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

	}

}
