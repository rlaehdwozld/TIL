package Day4;



//다형성은 상속 관계에서 하나의 참조변수가 여러개의 타입을 가질 수 있는 것
//참조변수는 부모타입이고
//여러개의 타입은 부모를 상속 받는 자식이다.
class Tv{
	boolean power;
	int ch;
	
	void power() {
		this.power=!this.power;	
	}
	void chUp() {
		this.ch++;
	}
	void chDown() {
		this.ch--;
	}
}
	class CapTv extends Tv{
		String text;
		String captionText() {
			return this.text="현재 자막 처리중";
		}
	}

public class Poly {
public static void main(String[] args) {
	
	CapTv ct= new CapTv();
	ct.power();
	ct.chDown();
	ct.chUp();
	ct.captionText();
	System.out.println(ct.captionText());
	Tv tv=ct;
	//상속관계에서 부모타입은 자식의 타입의 주소를 가질 수 있다.
	// 단 부모는 자신의 자원만 접근 가능핟.
	//단 재정의는 제외하고
	
	System.out.println(ct.toString());
	System.out.println(tv.toString());
//	System.out.println(tv.captionText());
	//부모의 참조변수로 자식자원의 접근 불가(부모타입의 자원 접근)
	// 단 재정의는 뺴고
}
}
