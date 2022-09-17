# 2022.09.08 목요일 못먹어도 고!

## Collection Framework

다수의 데이터를 다루는 [표준화된 인터페이스]를 구현하고 있는 [클래스의 집합]

Collection 인터페이스 -->상속 List(구현 : ArrayList) , Set(구현 : HashSet...)

ArrayList 부모타입은 List이다. (OK) >> 다형성  
Collection는 ArrayList 부모타입이다 (OK)>> 다형성

Map 인터페이스 (Key, value)쌍의 배열 -->(구현 : HashMap)

1.List (줄을 서시오) 약속...  
순서(번호표), 중복(허용)>내부적으로 데이터 (자료) > 배열(Array)관리> [홍길동][홍길동][홍길동]  
 [0] [1] [2]  
중복된 데이터도 관리가 가능하다.

1.1 Vector(구버전)-->동기화 보장 (멀티 스레드)--> Lock (장치)보호-> 성능 조금 ->한강 화장실  
1.2 ArrayList(신버전)-->동기화 보장( 멀티 스레드)->Lock옵션(기본Lock(X)) ->성능이 우선시 된다.->한강 비빔밥 축제

기존 다수의 데이터를 다루는 방법 : Array (정적, 고정)  
--방의 개수가 한번 정해지면 (방의 크기는 변경 불가)**_  
int [] arr = new int [5];  
arr[0]=100;  
int[] arr2={10,20,30};  
새로운 크기의 배열 만들고 데이터 이동(코드로 직접 구현)_**

Array

1. 배열의 크기가 고정 : Car[] cars={new Car() , new Car()};방 2개
2. 접근 방법 (index 첨자) 방 번호 접근 : cars[0]....n(length-1) 방

List 인터페이스 구현하고 있는 (Vector, ArrayLis)

1. 배열의 크기를 동적으로 확장 or 축소 가능>> 진실은 컴파일러가 새로운 배열을 만들고 데이터를 이동시키는 것이다.
2. 순서를 유지(내부적으로 Array 사용) , 중복값을 사용 가능
3. 데이터 저장공간 : Array 사용

### Vector

```java
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
```

### ArrayList

```java
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//The most important things ever we learn

public class Ex02_ArrayList {
	public static void main(String[] args) {
		//ArrayList : List 인터페이스 구현(순서 보장, 중복데이터 허락)

		ArrayList arraylist = new ArrayList();
		//Object 타입으로 사용하면 된다.
		arraylist.add(100);
		arraylist.add(200);
		arraylist.add(300);

		for( int i=0;i<arraylist.size();i++	) {
			System.out.println(arraylist.get(i));

		}
		System.out.println(arraylist.toString());

		//add 함수는 순차적으로 데이터 넣기
		arraylist.add(0,111	);//*** 자리 이동***
		System.out.println(arraylist.toString());
		arraylist.add(4,444);
		System.out.println(arraylist.toString());

		//**비 순차적인 데이터 추가 삭제>>ArrayList 자료구조에 적합하진 않다>> 그래서 순서가 있는 데이터 집합이 좋다.
		//** 순차적인 데이터 추가, 삭제^^

//		arraylist.remove(111);//index 데이터를 삭제할지 데이터 데이터를 삭제할지 헷갈린다.
//		System.out.println(arraylist.toString());//java.lang.IndexOutOfBoundsException 데이터 값으로 인식한게 안리ㅏ 인덱스값으로 인식해서 오류가 난다.

		//[111,100,200,300,444]
		//ArrayList 함수 공부 (초급)
		System.out.println(arraylist.contains(200));
		System.out.println(arraylist.contains(2000));

		arraylist.clear();//데이터만 지우고 capacity는 그대로 남아있다
		System.out.println(arraylist.size());//0
		System.out.println(arraylist.isEmpty());//true

		arraylist.add(101);
		arraylist.add(102);
		arraylist.add(103);
		System.out.println(arraylist.isEmpty());//너 데이터 비었니?? 아니!!
		System.out.println(arraylist.size());//3
		Object value = arraylist.remove(0);//101을 지우고 102가 0번쨰 방이 된다. 데이터 값을 보관해준다.
		System.out.println(arraylist.toString());

		//Point
		//인터페이스 부모타입
		//개발자 습관적으로.. 다형성(확장성, 유연성)
		List li = new ArrayList();//습관적으로 부모타입
		//ArrayList li = new ArrayList();
		li.add("가");
		li.add("나");
		li.add("다");
		li.add("라");
		li.add("마");

		List li2=li.subList(0, 2);//subList 함수는 내부적으로 new ArrayList() 생성
		System.out.println(li2.toString());//[가, 나]

		ArrayList alist = new ArrayList();

		alist.add(50);
		alist.add(1);
		alist.add(7);
		alist.add(40);
		alist.add(46);
		alist.add(3);
		alist.add(15);

		System.out.println(alist.toString());
		Collections.sort(alist);//내부적으로 정렬 >> 초급 개발자 프로젝트 시 쓰면 감점...
		System.out.println(alist.toString());
		//높은 값으로 정렬
		// 함수
		Collections.reverse(alist);
		System.out.println(alist.toString());//내림차순




	}

}
```
