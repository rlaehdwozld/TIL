import java.util.Vector;

/*
Collection Framework
다수의 데이터를 다루는 [표준화된 인터페이스]를 구현하고 있는 [클래스의 집합]

Collection 인터페이스   -->상속 List(구현 : ArrayList)	, Set(구현 : HashSet...)

>>ArrayList 부모타입은 List이다. (OK) >> 다형성
>>Collection는 ArrayList 부모타입이다 (OK)>> 다형성

Map 인터페이스 (Key, value)쌍의 배열 -->(구현 : HashMap)

1.List (줄을 서시오) 약속...
순서(번호표), 중복(허용)>내부적으로 데이터 (자료) > 배열(Array)관리>[홍길동][홍길동][홍길동]
																							[0]     [1]     [2]
중복된 데이터도 관리가 가능하다.

1.1 Vector(구버전)-->동기화 보장 (멀티 스레드)--> Lock (장치)보호-> 성능 조금 ->한강 화장실
1.2 ArrayList(신버전)-->동기화 보장( 멀티 스레드)->Lock옵션(기본Lock(X)) ->성능이 우선시 된다.->한강 비빔밥 축제

기존 다수의 데이터를 다루는 방법 : Array (정적, 고정)
--방의 개수가 한번 정해지면 (방의 크기는 변경 불가)***
int [] arr = new int [5];
arr[0]=100;
int[] arr2={10,20,30};
새로운 크기의 배열 만들고 데이터 이동(코드로 직접 구현)***
Array
1.배열의 크기가 고정 : Car[] cars={new Car() , new Car()};방 2개
2. 접근 방법 (index 첨자) 방 번호 접근 : cars[0]....n(length-1) 방


List 인터페이스 구현하고 있는 (Vector, ArrayLis)
1. 배열의 크기를 동적으로 확장 or 축소 가능>> 진실은 컴파일러가 새로운 배열을 만들고 데이터를 이동시키는 것이다. 
2. 순서를 유지(내부적으로 Array 사용) , 중복값을 사용 가능
3. 데이터 저장공간  : Array 사용

public
*/
public class Ex1_Verctor {
	

	public static void main(String[] args) {
		Vector v= new Vector();
		System.out.println("초기 default 용량 : "+v.capacity());//10
		System.out.println("size : "+v.size());//0 실데이터의 크기
		
		v.add("AA");
		v.add("AA");
		v.add("AA");
		v.add(10);
		
		
		
		System.out.println("Size : "+v.size());
		System.out.println(v.toString());//[AA, AA, AA, 10] 재정의 데이터 출력
		//Array>> length>> 필요하다면 index개념을 만들어서 마치 size처럼 사용을 했다.
		//Collection >> size
		for(int i =0;i<v.size();i++) {
			System.out.println(v.get(i));//Collection에서 데어터를 가져오는 방법 get(index) 값을 return : 정적 array[index]
		}
		//개선된 for문 출력
		for(Object obj : v	) {
			System.out.println(obj);
		}
		//단점 : 작은 데이터 ( 같은 타입의 데이터)... 가장 큰 타입을 사용 하는 것 불합리
		//제너릭 >>타입을 강제>> 추후 별도 학습(Point)
		//제너릭은 현업에서 100프로 사용 함 안쓰면 왕따 당한다.
		Vector<String>v2=new Vector<String>();
		v2.add("Hello");
		v2.add("king");
		v2.add("king");
		//v2.add(45);//문자열 아니면 못담음
		
		for(String str:v2) {
			System.out.println(str);
		}
		
		Vector v3 =new Vector();
		System.out.println(v3.capacity());
		v3.add("A");
		v3.add("A");
		v3.add("A");
		v3.add("A");
		v3.add("A");
		v3.add("A");
		v3.add("A");
		v3.add("A");
		v3.add("A");
		v3.add("A");
		v3.add("B");//11
		v3.add("B");
		
		System.out.println(v3.toString());
		System.out.println(v3.capacity());//증명 : 그냥 쓰면 된다.(지가 알아서 늘리고 지우고 한다)
		
		
	}

}
