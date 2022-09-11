package q8;
class SutdaCard{
		int num;
	boolean isKwang;

	SutdaCard() {
		this(1,true);
	}

	SutdaCard(int num, boolean isKwang) {
		this.isKwang = isKwang;
		this.num = num;
	}

	String info() {
		return num+(isKwang?"k":"");
	}
}
public class Class_05 {


	public static void main(String[] args) {
		SutdaCard c = new SutdaCard(0, false);
		SutdaCard c1= new SutdaCard();
		System.out.println(c.info());
	}


}