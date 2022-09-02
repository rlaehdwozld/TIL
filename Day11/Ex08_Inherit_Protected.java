import kr.or.kosa.Pclass;

/*
상속 관계에서 접근자 : Protected

public 
private
default(같은 폴더)

protected : 양면성 (박쥐) >> default, public
>>상속이 없는 클래스 안에서 protected >> default와 동일
>>결국 상속 관계에서만 의미를 가진다.>> public
상속이 없다면 Protected를 사용할 이유가 없다.

*/
class Dclass{
	public int i;
	private int p;
	int s;//default
	protected int k;//default 왜 쓰냐???안써도 되는데 굳이 쓸 이유가 없다 하지만 오류는 아님
	
}
class Child2 extends Pclass{
	void method() {
		this.k=100;//상속관계>> 자식은 부모의 protected자원을 public 처럼 사용
		//public 쓰면 되는데 왜 굳이 protected쓰냐?
		//this.k//
	}
	//상속 관계
}

public class Ex08_Inherit_Protected {

	public static void main(String[] args) {
		Pclass p = new Pclass();
		//p.i;
		//p.k>> 객체 생성 사용 (default)
	
	
	}

}
