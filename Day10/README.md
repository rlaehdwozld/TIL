# 2022.09.01 목요일 못먹어도 고!

### 상속

실무(현업) 환경

한개의 클래스만 설계 사용 경우(x)  
설계도 1장 모든 업무를 구현 현실적으로 불가능  
설계도 여러개로 나눈다.... 문제 발생...(기준, 관계)

쇼핑몰 : 결제관리, 배송관리, 판매처, 회원관리, 관리자관리,  
상품관리>>각각의 업무에 대해서 별도의 설계도를 만든다.  
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
class 원 (점이라는 부품이 member field)

경찰 권총

경찰은 권총이다(x)  
경찰은 권총을 가지고 있다(ㅇ)  
class 권총{}  
class 경찰 {권총 member field}

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

```java
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
```

---

### 다중상속 금지

Tv설계도
Vcr설계도

TvVcr 결합상품을 만들때

class TvVcr extends Tv, Vcr(x) 다중 상속 금지  
 게층적 상속도 조금 이상함(똑같은 자원의 이름이 있어서 어느 하나는 사용을 못한다)

class TvVcr{Tv t; Vcr v;}

답은 한놈은 상속하고 한놈은 포함  
 어떤 놈을 상속하고 어떤 놈을 포함  
 기준Tv(상속) , Vcr(포함)>>많이 사용

메인 기능을 누가 가지고 있느냐( 비중)

```java
//두개의 설계도
class Tv {
	boolean power;
	int ch;

	void power() {
		this.power = !this.power;// 토글링 : 두개의 기능을 하나의 함수로 처리

	}

	void chup() {
		this.ch++;
	}

	void chDown() {
		this.ch--;
	}
}

class Vcr {// 비디오 플레이어
	boolean power;

	void power() {
		this.power = !this.power;
	}

	void play() {
		System.out.println("재생하기");

	}

	void stop() {
		System.out.println("정지하기");

	}

	void rew() {
	}

	void ff() {
	}
}
class TvVcr2 extends Tv {
	Vcr vcr;

	public TvVcr2() {
		vcr = new Vcr();
	}
}

class TvVcr {
	Tv t;
	Vcr v;

	public TvVcr() {
		this.t = new Tv();
		this.v = new Vcr();
	}
}

public class Ex03_Inherit {
	public static void main(String[] args) {
		TvVcr tv = new TvVcr(); //그림
		tv.t.power();
		tv.t.chup();
		System.out.println(tv.t.power);

		TvVcr2 tv2= new TvVcr2();//그림
		tv2.power();
		System.out.println("tv전원 : "+tv2.power);
		tv2.chup();

		tv2.vcr.power();
		System.out.println("비디오전원 :"+tv2.vcr.power);
		tv2.vcr.play();
	}
}

```

### 오버라이딩

    오버로딩 : 하나의 이름으로 여러가지 기능을 하는 것, 타입과 파라메터를 달리한다.
    오버라이드 : 상속 관계에서 부모의 함수의내용을 재정의 하는 것

둘의 구분은 무조건 기억하자@@@

**Today Point**
[상속 관계]에서 override : 상속관계에서 자식이 부모의 함수를 [재정의]  
 [상속관계]에서 [자식 클래스]가 [부모클래스]의 메서드(함수)를 재정의(내용을 바꿈)  
 재정의 : 틀의 변화가 없고(함수의 이름, 타입) 아니고 내용만 바꾸는 거이다. {중괄호 블럭 안에 있는 것 만 수정}

문법)

1. 부모와 함수의 이름 동일
2. 부모 함수 parameter 동일
3. 부모 함수 return type 동일
4. 결국 { 안에 실행블럭 안에 코드만 변경 가능}
   \*/

```java
class Point2{
int x=4;
int y=5;
String getPosition() {
	return this.x +"/"+this.y;
}
}
class Point3D extends Point2	{
	int z=6;

	//String get3D...()() 새로운 함수 추가
	//추가....함수.....
	//Annotation은 Java code만으로 전달할 수 없는 부가적인 정보를 컴파일러나 개발툴로 전달할 수 있다.
	//@Ovrerride 컴파일러나 개발툴에게 지금 이 함수가 재 정의 되었는지 검증해봐라고 알려줌

	// Spring 은 70% Annotation
	String getPosition() {
		return this.x +"/"+this.y+this.z;

//	String get3D....(){}새로운 함수 추가
	//함수 이름이 추가되는게 불편하다!

}
}

public class Ex04_Inherint_Override {
	public static void main(String[] args) {

		Point3D p = new Point3D();
		System.out.println(p.getPosition());
	}




}

---
```

### 오버라이딩 응용

```java
class Test2{
	int x=100;
	void print() {
		System.out.println("부모함수 Test2");
	}
}

class Test3 extends	Test2{
	int x=300;//부모를 무시하는 행동이다. 만약 쓴다면 부모코드는 무시 문법적으로 오류가 아니지만 굳이??

	//재정의
	@Override
	void print() {
		System.out.println("자식이 부모의 함수를 재정의 ");

	}
	void print(String str) {//오버로딩
		System.out.println("나는 오버로딩 함수"+str);
	}
}

public class Ex05_Inherit_Override {
	public static void main(String[] args) {
		Test3 t3= new Test3();
		System.out.println(t3.x);

		t3.print();
		t3.print("오버로딩");

		Emp emp = new Emp(1000 ,"홍길동");
		System.out.println(emp);//kr.or.kosa.Emp@1c4af82c
		System.out.println(emp.toString());//kr.or.kosa.Emp@1c4af82c

		//emp 출력하면 사실은..emp.toString()동일한 효과
		//toString()	은 Object의 자원 ... 주소값 return

		//toString() 재정의 했다면 결과는 재정의된 내용 출력
		//Emp [empno=0, ename=null]
			//	Emp [empno=0, ename=null]

		//JAVA API제공하는 수만은 클래스가  Object클래스의 toString() 재 정의하고있다.

	}

}

```

```java
package kr.or.kosa;
//데이터를 담을 수 있는 클래스(1건)

//DTO, VO, DOMAIN 이름

public class Emp { //extends Object
	private int empno;
	private String ename;



	public Emp(int empno, String ename) {

		this.empno = empno;
		this.ename = ename;
	}

	public int getEmpno() {
		return empno;
	}

	public void setEmpno(int empno) {
		this.empno = empno;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}


	@Override
	public String toString() {
		return "Emp [empno=" + empno + ", ename=" + ename + "]";
	}



	//Object >> toString() 함수는 일반적으로 재정의 가장 많이....
	//만약 재정의를 하지않으면 ... 주소값을 출력

	//toString재정의 필요한대로 코딩 ... 일반적으로 member field정보 출력하는 형태로 ...

}
```

---

### super

this : 객체 자신을 가르키는 this(this.empno, this. ename)  
this : 생성자를 호출하는 this(this(100,"red"))

상속관계  
부모, 자식  
super(현재 자식이 부모의 접근 주소값) : 상속관계에서의 부모에 접근(super 부모객체의 조소값)

1. super>>상속관계에서 부모 자원에 접근
2. super>> 상속관계에서 부모의 생성자를 호출(명시적으로)

Tip)
c# : base()  
java : super()

```java
class Base{
	String basename;
	Base(){
		System.out.println("Base 기본 생성자 함수");
	}
	Base(String basename){
		this.basename=basename;
		System.out.println("basename :"+this.basename);
	}
		void method() {
			System.out.println("부모 메소드");
		}

}

class Derived extends Base{
	String dname;
	Derived(){
		super();// 맞는 문법
		System.out.println("Derived 기본 생성자 함수");
	}

	Derived(String dname){

		//이때 부모의 생성자를 호출 할 수 있는 super
		super(dname);//부모 생성자 호출

		this.dname=dname;
		System.out.println("dname :"+this.dname);
	}
	@Override
	void method() {
		System.out.println("부모자원 재정의");
	}
	//어느날 부모님 그리울 떄가 있다.(부모 자원이 그립다)
	//유일한 방법....super
	void pmethod() {
		super.method();//부모함수
		//재정의 상태에서 부모자원을 부를 수 있는 유일한 방법 : super
	}

}
public class Ex06_Inherit_super {
public static void main(String[] args) {
//	Derived d = new Derived();
	Derived d = new Derived("홍길동");//과연 누가 호출 될 것이냐 39줄, 23줄
	d.method();//자식이 재정의를 하지 않으면 부모자원 호출
	d.pmethod();
	//자식은 오버로딩 생성자가 호출이 되지만 부모는 기본 생성자가 호출된다.


}
}

```

---

### final

변수 -<----> 상수  
 상수 : 한번 값이 [초기화 ]되면 변경 불사  
 상수 자원 : 고유값(주민번호)수학 : PI값. 시스템 번호(버전번호)  
 상수는 관용적으로 [대문자]

java : final int NUM =10;  
c# : const integer NUM = 10;  
final 키워드

1. final class Car{} > 클래스 final> 상속 금지  
   public final class Math  
   extends Object

2. public final void print(){} 함수 final> 상속 관계에서 재정의 (override 금지)

```java

 */

class Vcard {
	final String KIND = "hearr";
	final int NUM = 10;

	void method() {
		System.out.println(Math.PI);
	}
}

class Vcard2 {// 설계자 입장에서 이렇게 만들었다는 것은 만든 카드마다 다른 상수값을 가지게 하겠는 의미
	final String KIND;
	final int NUM;

	// Vcard2(){} 만약에 기본 생성자를 만들면 밑에 생성자가 선택이 안될 수도 있으니깐 엑박뜸

	Vcard2(String kind, int num) {// final은 꼭 초기화 해야하지만 이런 경우에는 인정함
		this.KIND = kind;
		this.NUM = num;

	}


	 @Override public String toString() { return "Vcard2 [KIND=" + KIND + ", NUM="
	 + NUM + "]"; }


}

public class Ex07_final {

	public static void main(String[] args) {
		Vcard vc = new Vcard();
		// vc.KIND = "aaa"변경불가
		System.out.println(vc.KIND);
		vc.method();

		Vcard2 v1 = new Vcard2("spade", 1);
		System.out.println(v1.toString());
		Vcard2 v2 = new Vcard2("spade", 2);
		System.out.println(v2.toString());
		Vcard2 v3 = new Vcard2("spade", 3);
		System.out.println(v3.toString());

	}
}
```

---

### finally

try{

}catch(Exception e){

}finally {  
예외가 발생하던 하지 않던 강제적으로 실행되는 블럭이다(어떤 상황에서든 무조건 실행)

}

나는 예외가 발생하던 , 예외가 발생하지 않던 실행되야 하는 구문을 가지고 있다.
게임cd 설치 pc에다가

1. 설치파일>>C\Temp>> 복사
2. 복사한 파일>> 프로그램 설치
3. 정상 설치 >> C:\Temp복사한 파일 삭제
4. 비정상 설치 >> 강제종료>>복사한 파일 삭제

```java
public class Ex03_finally {
	static void copyFiles() {
		System.out.println("copy files");
	}
	static void startInstall() {
		System.out.println("Install");
	}
	static void fileDelete() {
		System.out.println("file delete");
	}
	//실제로 예외는 아니지만
	// 개발자가 필요에 따라서 어떤 상황을 예외적인 상황이라 정의하고 예외를 발생
	// 사용자 정의 예외 처리
	//throw new IOException
	public static void main(String[] args) {

		try {
			copyFiles();
			startInstall();
			throw new IOException("Install 중 문제가 발생...");
		}catch(Exception e) {
			System.out.println("예외 메시지 출력 :"+e.getMessage());
		}finally{//강제적인 실행 블럭 예외 발생 실행되고, 정상건이어도 실행된다.
			//함수의 강제 종료인 return 만나도 finally 강제 실행 (먼저)
			//의무적으로 실행해야할 부분이 있을때 사용하자!
			fileDelete();

		}
	}

}

```

---

### throws

```java
import java.io.IOException;

import kr.or.kosa.ExClass;

public class Ex04_throws {

	public static void main(String[] args) {
		try {
				ExClass ex = new ExClass("Temp");
		} catch (NullPointerException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
```

```java

package kr.or.kosa;

import java.io.IOException;

/*
설계도를 작성 ...
설계도를 사용하는 개발자에게 어떤 상황에 대해서 반드시 예외를 처리하도록 강제 ...

생성자나 함수 만들었는데 ... 반드시 예외를 처리하는 코드를 생성


*/
public class ExClass {
	public ExClass(String path) throws IOException , NullPointerException {
		System.out.println(path);
	}
}

```

```java

```

```java

```
