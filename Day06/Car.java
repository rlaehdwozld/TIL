package kr.or.kosa;

//원칙적으로 실무에서 사용하는 것과 동일한 방식으로...
// 1. 캡슐화 : 정보를 저장하는 (memeber field)에 대해서
// 2. 캡슐화 	: 간접적으로 처리할 수 있는 코드가 필요---> setter, getter함수)
// 3. 이런 데이터를 담을 수 있는 클래스 (DTO, VO, DOMAIN) 보통은 DTO를 많이 쓴다.--->MVC패턴
public class Car {
	private int window;//굳이 초기화가 필요없다 default값을 가지기 때문에
	private  int  speed;
	//필요에 따라서 getter만 만드는 경우가 있고-->write만 하겠따
	//필요에 따라서 setter만 만드는 경우가 있고-->read만 하겠다
	//둘다 만드는 경우가 있다.--> 둘다 하겠다
	//쉽게 만드는 방법
	//1.IDE를 사용해서 source--> generate getter setter
	//2. spring 때 배울것이지만  lombook라이브러리를 이용
	//Lombok 이란 Java 라이브러리로 반복되는 getter, setter, toString .
	// 등의 반복 메서드 작성 코드를 줄여주는 코드 다이어트 라이브러리 이다.
	//Getter
	//Setter
	//컴파일러에게 자동으로 setter, getter함수를 만들어 달라는 요청이다.
	//필요하다면 별도의 함수를 생성
	//speed를 10씩 올리거나 감소하는 기능을 만들어라
	//일반적으로 아래처러므 별도의 함수를 만들기 보다는 read와 write를 한다면
	//	setter와 getter를 통해서 제어하는 것이 일반적이다.
	
	public void speedUp() {
		speed+=10;
	}
	public void speedDown() {
		
		if(speed>0) {
			speed-=10;
		}else {
			speed=0;
		}
	}
	public int getWindow() {
		return window;	
		
	}
	public void setWindow(int data) { //this를 안배워서 이렇게 쓰는데 원해는 setWindow (int window){this...}
		window = data;//setter 함수
		
		
	}
	
	public int getSpeed() {
		return speed;
	}
	public void setSpeed(int speed) {
		this.speed = speed;
	}

}
