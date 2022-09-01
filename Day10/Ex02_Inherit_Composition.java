/*
실무(현업) 환경

한개의 클래스만 설계 사용 경우(x)
설계도 1장 모든 업무를 구현 현실적으로 불가능
설계도 여러개로 나눈다.... 문제 발생...(기준, 관계)

쇼핑몰 : 결제관리, 배송관리, 판매처, 회원관리, 관리자관리,상품관리>>각각의 업무에 대해서 별도의 설계도를 만든다.
! 기준이 필요하다.
여러개의 설계도를 관계 이어주는 기준 
1. 상속(is ~ a : 상속) 은(는) ~이다(부모를 뒤에)
2. 포함(has ~ a : 포함) 은(는) ~을 가지고 있다. 

예)
원은 도형이다 
원 extends 도형
삼각형은 도형이다.
삼각형 extends 도형

원 과 점 관계

원은 점이다. (X)
원은 점을 가지고 있다. (ㅇ)
has ~ a (부품정보)
>>class 원 (점이라는 부품이 member field)

경찰 권총

경찰은 권총이다(x)
경찰은 권총을 가지고 있다(ㅇ)
>>class 권총{}
>>class 경찰 {권총 member field}

원은도형이다
삼각형은 도형이다
사각형은 도형이다.

도형은 분모(공통적) 공통 자원 : 추상화 , 일반화(그리다, 색상)

원은 구체화, 특수화 (본인만이 가지는 특징)(반지름, 한점)

점 : 좌표값(x,y)
원은 점을 가지고 있다.
삼각형은 점을 가지고 있다
사각형은 점을 가지고 있다.

class Shape{그리다, 색상)}>상속관계 부모(원, 삼각형, 사각형)
class Point{좌표값}>> 포함관계(부품)

구체화, 특수화 : Circle, Triangle

//문제1
//원을 만드세요 (원의 정의 : 원은 한점과 반지름을 가지고 있다)
//1. 원은 도형이다 (is ~ a) : shape 
//2. 원은 점을 가지고 있다(has ~a) : point >> member field
//3. 원은 반지름을 가지고 있다(특수 ,구체) : r

//원의 반지름은 초기값 10을 가진다
//점의 좌표는 초기값 (10,15) 가진다
//초기값을 설정하지 않으면 반지름과 점을 값을 입력을 받을 수 있다 (원이 만들어 질때  new )
//생성자를 ...활용 (hint)

//문제2)
/*
삼각형 클래스를 만드세요
삼각형은 3개의 점과 색상과 그리고 그리다 기능을 가지고 있다
hint) Shape , Point 제공 받아서 설계도 작성 하세요
hint) (x,y) , (x,y) , (x,y)
default 삼각형을 만들 수 있고  3개의 좌표값을 받아서 그릴 수 있다 
*/

class Shape{
	String color="gold"; //공통속성
	void draw() {
		System.out.println("도형을 그리다");
	}
}

class Point {
	int x;
	int y;
	
	public Point() {
		//this.x = 1;
		//this.y = 1;
		this(1,1);  //생성자를 호출하는 this
	}
	
	public Point(int x , int y) {
		this.x = x;
		this.y = y;
	}
}


//70점 + 10점
class Triangle extends Shape {
	Point x;
	Point y;
	Point z;
	
	public Triangle() {
		//this.x = new Point(10,20);
		//this.y = new Point(30,40);
		//this.z = new Point(50,60);
		this(new Point(10,20),new Point(30,40),new Point(50,60));
	}
	
	public Triangle(Point x , Point y , Point z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
	//구체화 ,특수화
	//추가적인 기능
	void trianglePoint() {
		System.out.printf("x :(%d,%d)\t",x.x , x.y);
		System.out.printf("y :(%d,%d)\t",y.x , y.y);
		System.out.printf("z :(%d,%d)\t",z.x , z.y);
		System.out.println();
	}
	
}

//100점
class Triangle2 extends Shape {
	Point[] pointarray;
	
	
	public Triangle2() {
		//this.x = new Point(10,20);
		//this.y = new Point(30,40);
		//this.z = new Point(50,60);
		//this(new Point(10,20),new Point(30,40),new Point(50,60));
		this(new Point[] {new Point(10,20),new Point(30,40),new Point(50,60)});
	}
	
	public Triangle2(Point[] pointarray) {
		this.pointarray = pointarray;
	}
	//구체화 ,특수화
	//추가적인 기능
	void trianglePoint() {
		for(Point point : this.pointarray) {
			System.out.printf("x :(%d,%d)\t",point.x , point.y);
		}
		/*
		System.out.printf("x :(%d,%d)\t",x.x , x.y);
		System.out.printf("y :(%d,%d)\t",y.x , y.y);
		System.out.printf("z :(%d,%d)\t",z.x , z.y);
		System.out.println();
		*/
	}
	
}


class Circle extends Shape{ //상속
	Point point; //포함(부품)
	int r; //특수성
	
	public Circle() {
		//this.r = 10;
		//this.point = new Point(10,15);
		this(10,new Point(10,15));
	}
	public Circle(int r, Point point) {
		this.r = r;
		this.point = point;
	}
}

public class Ex02_Inherit_Composition {

	public static void main(String[] args) {
		Circle c = new Circle();
		System.out.println(c.r);
		System.out.println(c.color); //상속
		System.out.println(c.point.x);  //이해 ...
		System.out.println(c.point.y);  //이해 ...
		c.draw(); //상속
		
		//반지름 , 점값을 내가 입력
		//Point point = new Point(100, 200);
		//Circle c2 = new Circle(50, point);
		Circle c2 = new Circle(50, new Point(100,200));
		
		Triangle tri = new Triangle();
		tri.trianglePoint();
		
		Triangle tri2 = new Triangle(new Point(1,2), new Point(3,4),new Point(5,6));
		tri2.trianglePoint();
		
		Point[] parray = new Point[] {new Point(11,22),new Point(33,44),new Point(55,66)};
		Triangle2 tri3 = new Triangle2(parray);
		tri3.trianglePoint();
		
	}

}