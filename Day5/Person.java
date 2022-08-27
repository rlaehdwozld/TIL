package Day5;

/*
 클래스 == 설계도 == 데이터 타입
 설계도는 종이.. 구체화(메모리에 올리는 행위)... 객체
 
 설계도 : field(고유, 상태, 부품) + method(기능) + constructor(생성자 함수)
 
 public class Ex01_Basic{
 public static void main(String[] args){
 여기안에다 코드 연습
 main이름을 가진 함수안 지역
 String name= "초기화";local variable>접근자 > 함수가 호출 생성>함수종류같이 소멸
 int age=0;
 */
public class Person {
	public String name;//default (자동) null
	public int age;// default(자동) 0
	public boolean power;//default (자동) false
	
	//member field >> instance variable>> 객체 변수
	//1.instance variable 초기화를 하지 않아도 된다. >>why>> default값
	//초기화 : 변수가 처음으로 값을 할당 받는것
	//질문 : 저 name member field초기화 하고싶은 데요 가능?
	//필요하다면 당연히 초기화 가능 public int age=100;
	
	//Today point: why 초기화....
	//****생성되는 객체(사람)마다, [다른 이름을 가질 수 있다.]****
	//Person member field 당신이 사람을 만들떄 마다 다른 값을 가지게 할거 아니야 굳이 초기화...
	
	/*
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

*/
	//기능
	//정보를 출력하는 기능
	public void pesronPrint() {
		System.out.printf("이름은 %s 나이는 %d 파워는 %s",name, age, power);
	}
	
	
}