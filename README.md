
# TIL

## 툴의 종류
2차때부터 툴은 여러가지 툴을 사용해도 괜찮다. 


int c,d // 이 방법은 선호되지 않는다 
// 같은 타입의 변수가 나열 될 때는 배열을 사용

## keypoint 
		//local variable(함수안에 있는 변수 : main() {  안에 있는 변수 }
		// 반드시 초기화가 필요하다.
        //지역변수는 선언과 동시에 초기화를 하고 사용하는 습관을 들이자.

//라인주석   
	/*
	 * 블럭주석 : 해석되지 않아요
	 * /


Ex02_Variable  >>> 클래스 >> 설계도 >> 데이터 타입
      


 ## 클래스의 종류
 1. class Car {  }  >> 독자적인 실행이 불가능 >> 다른 클래스(설계도) 참조하는 클래스 >> main 함수가 없는 클래스  >> 
 다른 말로  라이브러리 Library
 2. class Car{ public static void main(String[] args { } } >> 독자적으로 실행가능한 클래스 
 2-1 static void main{String [] args} >> main이름을 가지는 함수 >> 프로그램의 시작점, 진입점으로 판단하고 실행한다.
 Tip)
 C# 언어 ) public static void Main(String[] args) main 함수에서 대문자 소문자만 다르다.
 
 	Variable : 변수
	데이터(자료) 담을 수 있는 공간의 이름(메모리)
	공간 (크기) : 데이터의 타입(자료형) >> 메모리의 공간은 한정되있다. >> 최소한의 공간으로  최대한의 데이터 
	데이터 타입 변수명 >> int i = 100; (int 값은 4바이트이다. 	int 값의 범위는 –2,147,483,648 ~ 2,147,483,647)


```java
	public class 클래스 이름 {
	public static void main() {
		안에 있는 변수는 초기화를 통해 사용한다.
	}
```
변수가 선언되는 위치(scope : 유효범위)
1. instnance variable :객체변수 >> class Car { int number =2000;}   
2. local variable      : 지역변수 >> class Car{ public void run() { int speed =0;   }}   
3. 함수안에 제어블럭 (if, for)안에 있는 변수 >> class Car{ public void run() { int i =0....} }   
4. static variable    : 공유 자원 (객체간)

![러버덕](https://camo.githubusercontent.com/a123b2c6011765dd07b9b58e40599a0ba15336a9ddd082e85f704781c97baee2/687474703a2f2f6366696c65362e75662e746973746f72792e636f6d2f696d6167652f32343236453634363534334339423435333243374230)



