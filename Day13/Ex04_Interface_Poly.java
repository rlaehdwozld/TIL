

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
	
	//Scv 구체화, 특수화된 고유한 기능 
	//수리하다(repair)
	//Tank2, Scv
	
	
	//전자제품 매장 예시에서 물건이 1000개 있으면 과연 buy()라는 함수를 1000개 만들거냐(X)
	//다형성을 사용해서 부모타입의 변수로 buy(Product p)
	
	//문제점 ) 부모는 찾았어요 부모는 GroundUnit(Tank2, Marine2, Scv)
	//Marine2는 repair에 대상이 되지 않는다. 
	//void reapair (Unit2 Unit)>>Tank2, Marine2(x), Scv
	//void reapair (GroundUnit Unit)>>Tank2, Marine2(x), Scv
	
	//개발자는 고민에 빠진다....
	
	// ***CommandCenter repair대상이야....(더 깊은 고민)
	//Tank2, Marine2, Scv, CommandCenter 공통된 특징이 없다(연관성)
	
	//interface Irepairable{}
	
	/*
	 * void repair(Tank2 tank) { if(tank.hitpoint !=tank.MAX_HP) { tank.hitpoint+=5;
	 * 
	 * } } void repair(Scv scv) { if(scv.hitpoint !=scv.MAX_HP) { scv.hitpoint+=5; }
	 * 
	 * } }
	 */
	
	//단 부모자원만 접근 가능
	// 단 재정의된 자원 접근
	
	//1. void repair(Irepariable repairunit) >> Tank2, CommandCenter, Scv가 올 수 있다. 
	//Irepairable 의 자식 타입....
	//repair Tank2,Scv >>> scv.hitpoint+=5;
	//repair CommandCenter는 다른 방법으로
	
void repair(Irepariable repairunit) {
	//repairunit 통해서 Unit2접근
	
	//답이되려면 Tanke2, Scv만 와야되는데 커맨드센터가 있어서 안됨>Unit2
//	Unit2  unit2 = (Unit2)repairunit;//Down캐스팅
//	unit2.hitpoint+=5;
	
	//CommndCenter>Unit2 연관성이 없다. 
	//Unit2 unit = (Unit2)repairunit;(예외)
	
//	repair(Irepairable repairunit)사용
	//비교 (타입)>> instance of >> 타입 질문
	
	if(repairunit instanceof Unit2) {
		//Tank2,Scv
		Unit2  unit = (Unit2)repairunit;
		if(unit.hitpoint !=unit.MAX_HP) {
			unit.hitpoint=unit.MAX_HP;
		}
	}else {
		//다른 객체
		System.out.println("다른 충전방식을 통해서 repair를 제공");
		
	}
	
}
}
public class Ex04_Interface_Poly {
	public static void main(String[] args) {
		Tank2 tank= new Tank2();
		Marine2 marine = new Marine2();
		Scv scv = new Scv();
		
		tank.hitpoint-=20;
		System.out.println("탱크  :"+tank.hitpoint);
		System.out.println("Scv수리 요청");
		
		scv.repair(tank);
		
		System.out.println("탱크 수리 완료 : "+tank.hitpoint);
		
		scv.hitpoint-=30;
		System.out.println("Scv : "+scv.hitpoint);
		System.out.println("Scv수리요청");
		scv.repair(scv);
		
		System.out.println("Scv 수리 완료 "+scv.hitpoint);
		
		CommandCenter center = new CommandCenter();
		scv.repair(center);

	}
}
