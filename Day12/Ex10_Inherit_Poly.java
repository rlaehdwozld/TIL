

/*
다형성( 상속관계에서 존재)
다형성 : 여러가지 성질(형태) 가질 수 있는 능력

c#  :다형성 (Overloading, override)

JAVA : [상속 관계]에서 [하나의 참조변수]가 [여러개의 타입]을 가질 수 있는 것
[하나의 참조변수] : 부모 타입 
[여러개의 타입] : 부모를 상속 받은 자식

다형성 : 현실 >> 부모는 자식에게 모든 것을 준다.
		 프로그램 >> 자식이 부모에게 조건없이 드린다.
*/
class Tv2{
	boolean power;
	int ch;
	
	void power() {
		this.power= !this.power;
	}
	void chUp() {
		this.ch++;
	}
	
	void chDown() {
		this.ch--;
	}
}
	class CapTv extends Tv2{//CapTv특수화, 구체화, 고유한 
		String text;
		String captionText() {
			return this.text="현재 자막 처리중";
		}
		
	}

public class Ex10_Inherit_Poly {
	public static void main(String[] args) {
		
	
		CapTv ct=new CapTv();
		ct.power();
		ct.chUp();
		ct.captionText();
		System.out.println(ct.captionText());
		
///////////////////////////////////////////////////////////
		Tv2 tv2 = ct;
		//상속 관계에서 [부모타입]은 [자식타입]의 주소를 가질 수 있다. 
		//단 부모는 자신의 자원만 접근 가능하다. 
		// 단 재정의는 제외하고....
		
		System.out.println(ct.toString());//
		System.out.println(tv2.toString());//
		
		//tv2.captionText()  //자식자원은 접근 불가(부모타입의 자원 접근)
									 //단 재정의는 제외하고
		
	}

}
