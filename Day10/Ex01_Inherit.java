/*
OOP 특징 여러개의 조각들을 조리해서 하나의 큰 제품을 만드는 행위 )
1. 상속 
2. 캡슐화{은닉화}
3. 다형성 ( 상속 관계에서 부모 타입이 자식 타입을 주소를 가질 수 있다)


상속 
java : child extends Base

특징 
1. 다중 상속은 불가( 단일 상속(계층적 상속 가능)
2. 단일 상속(계층적상속) 가능 (여러개의 클래스를 상속)
3. 다중 상속을 지원 (interface)

상속 
1. 진정한 의미 : 재사용성
2. 단점 : 초기 설계비용
3. 재사용성 >> 설계>> 시간(여러개의 설계도로 분할한다 부모와 자식 관계를 만들기 위해)

상속 관계에서는
부모부터 메모리에 올라간다... 자식 순으로
GrandFather>>Father>> Child

사용자가(개발자)가 만드는 모든 클래스는 default>Object클래스를 상속
class Car extends Object
Object 모든 클래스의 root(최상위) : 모든 클래스의 부모

*/
class Car//extends Object(굳이 쓸필요 없지만 상관은 없음)
{
	
}

class GrandFather //extends Object
{
	public int gmoney = 10000;
	public GrandFather() {
		System.out.println("GranFather");
		
	}
}
class Father extends GrandFather{
	public int fmoney = 5000;
	private int pmoney = 10000;//상속 관계여도 접근을 할 수가 없다. : 간접적으로 (public 함수)
	public Father() {
		System.out.println("Father");
	}
	
}
class Child extends Father{
	public int cmoney = 3000;
	public Child() {
		System.out.println("child");
	}
}
public class Ex01_Inherit {
	public static void main(String[] args) {
		Child child= new Child();
		
		System.out.println(child.gmoney);
		System.out.println(child.fmoney);
		System.out.println(child.cmoney);
		
		
		Car car = new Car();
		
	}

}
