
public class Ex08_Card {
public static void main(String[] args) {
	
	Card c1= new Card();
	c1.kind="Heart";
	c1.number=7;
	
	Card c2= new Card();
	c2.kind="Spade";
	c2.number=8;
	
	Card c3= new Card();
	c3.kind="Heart";
	c3.number=7;
	
	System.out.println(c1.kind +"  "+c1.number +"  "+ c1.width+"  "+c1.height);
	
	c1.width=30;
	c1.height=60;
	System.out.println(c2.kind +"  "+c2.number +"  "+ c2.width+"  "+c2.height);
	
	
	System.out.println(c3.kind +"  "+c3.number +"  "+ c3.width+"  "+c3.height);
}
}
class Card{
	String kind;
	int number;
	
	static int width=20;
	static int height = 50;
	
	
}