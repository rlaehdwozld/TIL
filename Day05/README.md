# 2022.08.25 목요일 못먹어도 고!

실무에서는 private으로 접근자로 거의 사용 한다. 그리고 필요하면 getter, setter
함수 안에 있는 변수는 지역변수라서 접근자를 붙이지 않는다.

```java

public class Person {
	public String name;//default (자동) null
	public int age;// default(자동) 0
	public boolean power;//default (자동) false
    public void pesronPrint() {
		System.out.printf("이름은 %s 나이는 %d 파워는 %s",name, age, power);

}
```

클래스 == 설계도 == 데이터 타입
설계도는 종이.. 구체화(메모리에 올리는 행위)... 객체

설계도 : field(고유, 상태, 부품) + method(기능) + constructor(생성자 함수)

```java
public class Ex01_Basic{
public static void main(String[] args){
//여기안에다 코드 연습
//main이름을 가진 함수안 지역
String name= "초기화";local variable>접근자 > 함수가 호출 생성>함수종류같이 소멸
int age=0;
```

member field >> instance variable>> 객체 변수  
1.instance variable 초기화를 하지 않아도 된다. >>why>> default값  
초기화 : 변수가 처음으로 값을 할당 받는것  
질문 : 저 name member field초기화 하고싶은 데요 가능?/필요하다면 당연히 초기화 가능  
public int age=100;

### Today point: why 초기화....

생성되는 객체(사람)마다, [다른 이름을 가질 수 있다.]  
Person member field 당신이 사람을 만들떄 마다 다른 값을 가지게 할거 아니야 굳이 초기화...

```java
main() {
person남자 = new Person() ; 사람1명
남자.name="김유신"
남자.age=100;
남자.power=true;


Person여자 = new Person() ; 사람 2명
여자.name="유관순"
여자.age=120;
여자.power=false;

Person 인간 = new Person();
}
```

## METHOD

기능 (행위)만드는 방법
함수(method)

method : 행위 또는 기능의 최소단위로 구현 : 하나의 함수는 하나의 기능만 구현
ex) 먹는다. 잔다. 걷는다.  
 클래스 : field + method

ex) 롯데월드 : 게임방 : 농구, 동전, 동전뽑기
\*\*method 함수는 호출에 의해서만 동작된다.
누군가 이름을 부르지 않으면 동작하지 않는다.

JAVA)

1. void, parameter(0) : void print (String str) {실행코드}
2. void, parameter(x) : void print(){실행코드}
3. return type , parameter(O) : int print(int data) {retrun100; }
4. return type, parameter(x) : int print(){ return 100;}

\*\* void > 돌려주는 것이 없어요> return type이 없어요  
return type >> 기본 8가지 + String + Array , collection, interface
중에서 기본 8가지 + String +class 까지는 인정

boolean print( return true)  
Car print(){Car c= new Car(); return c;} //나는 당신에게 Car의 주소를 return하겠다  
String print(return "A";)

parameter type >> void print (String 파라메터)
기본 8가지+ String + Array, class, collection, interface  
이중에서 기본8가지String + class 인정

    void print(int i ){}
    void print (String str){}
    void print (Car car){}//print 함수는 parameter Car타임의 주소값을 받는다.

ex)  
Car c= new Car();  
void print (Car car){}  
print(c) ; // print 함수 호출시 c라는 변수값 (주소값)

어려워요... 동전구멍이 여러개....

void print( int a, int b int c, int d){}

print (10,20) (x)  
pritn(100,2,4)(X)  
print(1,2,3,4)(O)

void print ( Car c, String str, int i) {}

### 관용적인 표현

코드규칙 : 관용적 표현
class 이름의 첫글자는 대문자 : class Car, class Person
method의 이름은 단어의 첫글자 소문자 이어지는 단어의 첫글자는 대문자.. : getNumber()

사원번호를 가지고 사원의 모든 정보를 가지고 와라(함수 생성)
getEmpListByEmpno()//함수의 이름은 그 이름으로 대략적인 내용 파악 가능하게 하면 좋다.

```java
ublic class Fclass {
	public int data;

	//void m()>>컴파일리가 default를 붙인다 앞에다가>> 같은 폴더 내에서만 사용 가능하다.
	//함수70% public
	//함수30% private:why:hint) public, private 클래스 내부 동등...
	//클래스 내부에서만 사용하는 함수>> 공통함수 >>다른함수를 도와주는 함수

	public void m() {
		// void , parameter(x)
		// 기능 구현
		// main 함수에서 사용했던 코드 그대로 구현...
		System.out.println("일반함수 : void, parameter(x)");
	}

	//void m2(int)
	public void m2 (int i) {//i라는 변수는 함수 내부에서만 유효하다.
		System.out.println("일반함수 : void, parameter(0)");
		System.out.println("parameter값은 활용  i 변수 함수 내부에서만 가능하다 :"+i );



	}


	//return type m3(x)
	public int m3() {
		//무조건 , 강제로.....
		return 10000;//리턴타입이 존재하면 반드시 return키워드를 명시해야한다.
	}


	public int m4(int data) {
		return 100+data;
	}
	//여기까지가 기본 4가지
	//확장
	//return type 있고 parameter여러가지 있는 경우 m4랑 같은 경우
	public int sum(int i, int j, int k) {
		return i + j + k;
	}


	/*
	 함수의 접근자
	 default int subSum(){} 같은 폴더...
	 private int subSum(){} 같은 폴더도 안되요
	 클래스 내부에서 다른 함수를 도와주는 공통함수...
	 private 함수 만들어서 사용


	 */

	private int subSum(int i) {//다른 함수가 호출해서 사용
		return i = 100;				//로직이 모든 함수가 가지고 있다면...변경...유지보수 유용 측면에서
	}

	public void callSubSum() {
		//함수는 다른 함수를 호출할 수 있다.
		int result = subSum(100);
		System.out.println("call result : "+ result);
	}

	private int operationMethod(int data) {
		return data*200;

	}
	public int opSum(int data) {
		int result = operationMethod(data);
		//제어문
		if(result>0) {
			return 1;
		}else	{
			return -1;
		}
	}


	/*
	 Quiz
		a와 b둘중에 큰값을 return하는 함수를 만드세요
		ex)함수 호출 시 max(10,5) return값은 100이 나오면 된다.

	 */
	private int biggerMethod(int a, int b) {
		return a-b;
	}
	public int bigger(int a, int b) {
		return  (a>b) ? a : b;

//		int diff = biggerMethod(a, b);
//		if(diff>0) {
//			return a;
//		}else {
//			return b;
//		}

	}
```

객체지향 언어는 (캡슐화, 은닉화 : 직접적으로 값을 변경하거나 쓰는것을 방지하는 것 방지)  
year 마이너스값을 넣지마 부탁  
설계자 >> 다 막아버릴꺼야>> 사용불가\간접적으로 사용가능 ...>>누군가를 통해서 read, write하게 하겠다.  
간접>> 개발자가 논리를 통해서 제어하겠다.

```java
public class NoteBook {

	//public Mouse mouse=new Mouse();//Mouse 라는 타입은 클래스>>참조변수 mouse>> 주소값
	//노트북하고 마우스는 별개의 상품인데 노트북이 실행되지 않으면 마우스는 만들어질 수 없다.


	//노트북은 마우스를 가지고 있다.
	//마우스>>휠, 버튼 2개, 좌표값.....
	//부품정보...(엔진, 타이어)
	//마우스도 설계도가 있어야한다.(class)
	public String color;


	//약속 캡슐화 (read, write함수)>>표준화>> getYear..,setYear>>setter,getter

	private int year;
	public void setYear(int data) {//간접할당 장점 (내가 원하는 대로)강제할 수 있다. 개발자가 연도에 마이너스 값을 넣을 수 있는 것을 간접적로 방지하는 효과가 있다.
		if(data<0)	{
			year=1999;

		}else {
			year=data;
	}
		}
	// year read 함수
		public int getYear() {//간접적으로 year member field값을 return
			return year;

	}

		public int number;
		//노트북 필요에 따라서 마우스를 가질 수 있다.
		// 가진다의ㅣ : 생성된 객체의 주소를 가진다.

		public void handle(Mouse m) {
			m.x=100;
			m.y=200;
		}



}
```

```java
import kr.or.kosa.Mouse;
import kr.or.kosa.NoteBook;
import kr.or.kosa.VendingMachine;

public class Ex04_Modifier {

	public static void main(String[] args) {
		NoteBook notebook = new NoteBook();
		notebook.setYear(2022);//마이너스 값은 못 넣는다.
		int year=notebook.getYear();
		System.out.println("year :"+year);

//	notebook.mouse.x=5;
//	notebook.mouse.y=4;

		Mouse mouse = new Mouse();//마우스가 heap메모리에 올라감
		System.out.println(mouse.x+":"+mouse.y);

		notebook.handle(mouse);
		System.out.println(mouse.x+":"+mouse.y);

		VendingMachine vs= new VendingMachine();
		vs.ch_up();
		vs.ch_up();
		vs.ch_up();
		vs.ch_up();
		vs.ch_up();

		vs.vd();
	}




}


```

```java

```

```java

```

```java

```

```java

```
