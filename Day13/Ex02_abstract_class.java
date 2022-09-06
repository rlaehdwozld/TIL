
/*
게임 : 유닛(unit)

unit : 공통기능 (이동좌표, 이동, 멈춘다) : 추상화, 일반화
unit  : 이동 방법은 다르다(이동방법은 unit 마다 별도의 구현 강제)

abstract class Unit {abstract void move(); }

*/
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
