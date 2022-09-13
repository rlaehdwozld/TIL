import java.util.ArrayList;

/*
 Today Point
 Generic jdk 1.5
 
 C#, Java(둘다 필수 기능이다.)
 
 Why
 Collection 타입의 클래스 >> 데이터 기본 저장 공간에 타입을 Object 로 만들었다. 
 장점 : 어떤 값을 넣어도 다 소화한다. (String, Emp, int)
 단점 : 가장 작은 데이터를 사용하는 데도 가장 큰 타입을 사용해야한다., 원하는 데이터 타입으로 변경할 때 항상 다운캐스팅을 해줘야한다.(int) (String)...불편하다
 
 1. 그러면 타입을 처음부터 강제...
 2. 타입을 강제하면 안정적이다(요구한 값만 들어오니깐)
 3. 강제 형변환 필요없다. : (Car) Object (필요없다)
 
 제너릭 적용을 위해서는 설계도부터 적용...
 
*/

class MyGen<T>{//T>> type parameter}
	T obj;
	
	void add(T obj) {
		this.obj=obj;
	}
	T get() {
		return this.obj;
	}
	
}
class Person{
	int age=100;
	int name;
	
}
public class Ex05_Generic {

	public static void main(String[] args) {
		MyGen<String>mygen = new MyGen<String>	();
		mygen.add("문자열");
		String str=mygen.get();
		System.out.println("문자열 데이터 : "+str);
		
		ArrayList list = new ArrayList();
		list.add(10);
		list.add("홍길동");
		list.add(new Person());
		
		//list 값을 출력하세요
		//Person 객체는 나이 출력하고 나머지는 값을 출력
		//개선된 for
		for(Object obj :list) {
			System.out.println(obj);
			if(obj instanceof Person) {
				Person p=(Person)obj	;
				System.out.println(p.age);
			}else {
				System.out.println(obj);
			}
		}
		//Generic 타입을 강제 : 다 먹지는 못하지만 ( 한 종류만 먹어야한다.)>>
		ArrayList<Person>plist = new ArrayList<Person>();
		plist.add(new Person());
		plist.add(new Person());
		
		for( Person p :plist) {//장점 타입을 명확하게 알고있다(강제)
			System.out.println(p.age);
		}
		ArrayList<String>slist = new ArrayList<String>();
		slist.add("문자열");
	}

}
