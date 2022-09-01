
public class Ex02_Inherit_Composition_self {
class Animals{
	
	void move() {
		System.out.println("움직인다.");
	}
	void eat() {
		System.out.println("먹이를 먹는다.");
	}
}

class Food{
	String salad;
	String meat;
	
	
}

class Land extends Animals{
	
	public Land() {
		
	}
}
}
