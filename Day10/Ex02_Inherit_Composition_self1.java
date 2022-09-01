
class Money {
	String value = "가치가 있다";
	String commodity = "실물화폐";

	void want() {
		System.out.println("갖고싶다!");
	}
}

class Unit {
	int mil;
	int tho;
	int hun;
	int ten;
	int one;

	public Unit(int mil, int tho, int hun, int ten, int one) {
		this.mil = mil;
		this.tho = tho;
		this.hun = hun;
		this.ten = ten;
		this.one = one;
	}
}

class Color {

	String color;

	public Color(String color) {
		this.color = color;
	}
}

class Materials {

	String materials;

	public Materials(String materials) {
		this.materials=materials;
	}
}

class Coin extends Money {
	Materials materials;
	

}

class Bill extends Money {

}

class Check extends Money {

}

public class Ex02_Inherit_Composition_self1 {

	public static void main(String[] args) {

	}
}
