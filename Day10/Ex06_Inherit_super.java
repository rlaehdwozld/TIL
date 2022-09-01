
/*
this : 객체 자신을 가르키는 this(this.empno, this. ename)
this : 생성자를 호출하는  this(this(100,"red"))

상속관계 
부모, 자식
super(현재 자식이 부모의 접근 주소값) : 상속관계에서의 부모에 접근(super 부모객체의 조소값)

1. super>>상속관계에서 부모 자원에 접근
2. super>> 상속관계에서 부모의 생성자를 호출(명시적으로)

Tip)
c# : base()
java : super()

*/
class Base{
	String basename;
	Base(){
		System.out.println("Base 기본 생성자 함수");
	}
	Base(String basename){
		this.basename=basename;
		System.out.println("basename :"+this.basename);
	}
		void method() {
			System.out.println("부모 메소드");
		}
	
}

class Derived extends Base{
	String dname;
	Derived(){
		super();// 맞는 문법
		System.out.println("Derived 기본 생성자 함수");
	}
	
	Derived(String dname){
		
		//이때 부모의 생성자를 호출 할 수 있는 super
		super(dname);//부모 생성자 호출
		
		this.dname=dname;
		System.out.println("dname :"+this.dname);
	}
	@Override
	void method() {
		System.out.println("부모자원 재정의");
	}
	//어느날 부모님 그리울 떄가 있다.(부모 자원이 그립다)
	//유일한 방법....super
	void pmethod() {
		super.method();//부모함수
		//재정의 상태에서 부모자원을 부를 수 있는 유일한 방법 : super
	}
	
}
public class Ex06_Inherit_super {
public static void main(String[] args) {
//	Derived d = new Derived();
	Derived d = new Derived("홍길동");//과연 누가 호출 될 것이냐 39줄, 23줄
	d.method();//자식이 재정의를 하지 않으면 부모자원 호출
	d.pmethod();
	//자식은 오버로딩 생성자가 호출이 되지만 부모는 기본 생성자가 호출된다.
	
	
}
}
