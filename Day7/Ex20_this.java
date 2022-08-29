
/*
 원칙 : 객체를 만들 떄 생성자는 1개만 호출 가능(new Car() or new Car(20)....)
 
 this(객체) : 여러개의 생성자를 호출 가능
 
 코드량도 감소
 */

class Zcar{
	String color;
	String geartype;
	int door;
	
	Zcar(){//default 생성자
		this("red","auto",2);
//		this.color="red";
//		this.geartype="auto";
//		this.door=2;
		System.out.println("default.....");
	}
	Zcar(String color, String geartype, int door){
		this.color=color;
		this.door=door;
		this.geartype=geartype;
		System.out.println("overloading...");
	}
	
	void print() {
		System.out.println(this.color+" ,"+this.door+", "+this.geartype);
	}
}
public class Ex20_this {

	public static void main(String[] args) {
		Zcar zcar= new Zcar();
		zcar.print();
		Zcar zcar2 = new Zcar("blue", "auto", 2);
		
	}
}
