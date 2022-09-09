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
