class Pbase{
	int p=100;
}
class Cbase extends Pbase{
	int c=200;
}

class Dbase extends Pbase{
	
}
public class Ex11_Inherit_Poly {

	public static void main(String[] args) {
		
Cbase cbase = new Cbase();
System.out.println(cbase.toString());

Pbase p=cbase;//상속 관계에서 부모타입의 변수는 자식타입의 주소를 가질 수 있다.


Dbase dbase= new Dbase();


p=dbase;//다형성 
//부모타입의 참조변수가 어떨 때는 dbase 어떨때는 cbase-->다형
System.out.println(p.toString());

Cbase c=(Cbase)p;//down(부모 > 자식으로)
	}

}
