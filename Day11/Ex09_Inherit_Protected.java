
import kr.or.kosa.Bird;

//설계자 

class Bi extends Bird {
	
	@Override
	public void moveFast() {
		//마음대로 ...
		super.moveFast(); // 
	}
}

class Ostrich extends Bird {
	//구체화 , 특수화
	void run() {
		System.out.println("run ...");
	}
	
	@Override
	public void moveFast() {
		run();
	}
}

public class Ex09_Inherit_Protected {

	public static void main(String[] args) {
		Bi b = new Bi();
		b.fly();
		b.moveFast();
		//moveFast() 상속관계에서 재정의 하지 않으면  당신은 사용 안되 (강제)

		Ostrich o = new Ostrich();
		o.run();
		o.moveFast();
	}

}