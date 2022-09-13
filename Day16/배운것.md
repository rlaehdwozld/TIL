# 2022.09.13 화요일 못먹어도 고!

## Collection Framework

### ArrayList, Generic연습

```java
import java.util.ArrayList;

//연습용이니까...
class EmpData {
	private String name;// default 값은 null
	private int[] numbers;// default 값은 null
	private ArrayList elist;// default 값은 null 초기화 하지 않으면 null값을 가지고 있다.

	// 초기화
	public EmpData() {
		this.name = "아무개";
		// 사용자가 만든 타입 , "Array,ArrayLsit>>초기화가 갖는 의미가 메모리를 갖는 것이다. new를 통해서
		this.numbers = new int[10];
		this.elist = new ArrayList();

	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int[] getNumbers() {
		return this.numbers;
	}

	public void setNumbers(int[] numbers) {
		this.numbers = numbers;
	}

	public ArrayList getElist() {
		return this.elist;
	}

	public void setElist(ArrayList elist) {
		this.elist = elist;

	}
}

public class Ex04_ArrayList {
	public static void main(String[] args) {
	 EmpData  empdata = new EmpData()	;
		System.out.println(empdata.toString());
		System.out.println(empdata.getElist().toString());//재정의 >>[] 재정의를 했다는 것이 Object 클래스에서 재정의가 자동으로 되기 떄문

		ArrayList li = new ArrayList();
		li.add(100);
		li.add(200);

		empdata.setElist(li);
		System.out.println(empdata.getElist().toString());//[100, 200]

		ArrayList<String> slist = new ArrayList<String>();
		slist.add("superman");//제네릭을 string으로 하면 데이터 값을 string만 넣을 수 있다.
		slist.add("Hulk");
		slist.add("captain");
		System.out.println(slist.toString());
		System.out.println(slist);

		ArrayList<Integer>intList =new ArrayList<Integer>(20);
		System.out.println(intList.size());//0
		System.out.println(intList.add(100));//true 정상적으로 처리되었어
		System.out.println(intList.size());//1


	}
}
```

### Generic

Today Point
Generic jdk 1.5

C#, Java(둘다 필수 기능이다.)

Why  
 Collection 타입의 클래스 >> 데이터 기본 저장 공간에 타입을 Object 로 만들었다.  
 장점 : 어떤 값을 넣어도 다 소화한다. (String, Emp, int)  
 단점 : 가장 작은 데이터를 사용하는 데도 가장 큰 타입을 사용해야한다.  
 원하는 데이터 타입으로 변경할 때 항상 다운캐스팅을 해줘야한다.  
 (int) (String)...불편하다

1.  그러면 타입을 처음부터 강제...
2.  타입을 강제하면 안정적이다(요구한 값만 들어오니깐)
3.  강제 형변환 필요없다. : (Car) Object (필요없다)

제너릭 적용을 위해서는 설계도부터 적용...

```java
import java.util.ArrayList;
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

```

### Stack&Queue

```java
import java.util.Stack;

 class MyStack {
	private Object[] stackarr;
	private int maxsize;
	private int top;

	public MyStack(int maxsize) {
		this.maxsize=maxsize;
		stackarr= new Object[maxsize];
		top=-1;//배열의 시작값 0 (index)
	}

	public boolean isEmpty() {
		return(top==-1);//true
	}
	public boolean isFull() {
		return(top==maxsize-1);//5개 방을 만들면[0][1][2][3][4]
	}
	public void push(Object i) {
		if(isFull()) {
			System.out.println("stack full");
			return;
		}else {
			//Point
			stackarr[++top]=i;//처음 top =-1>>[0]

		}

	}
	public Object pop() {
		Object value= null;
		if(isEmpty()) {
			System.out.println("stack empty");
		}else {
			value=stackarr[top];
			top--;

		}
		return value;
	}



	// push(), pop(), boolean empty(), boolean pop()직접 구현

}

public class Ex06_Stack_Queue {

	public static void main(String[] args) {
		// JAVA API 제공하는 클래스
		// Collection JAVA API 제공
		// Stack 자료구조 가지는 클래스 제공 받아요

		Stack stack = new Stack();// LIFO
		stack.push("A");
		stack.push("B");
		stack.push("C");

		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());

		// System.out.println(stack.pop());//java.util.EmptyStackException

		stack.empty();

		// JAVA API구현하는 stack직접 구현하기
		//LIFO 구조를 코드....
		// 1.stack 저장공간(Array), 저장공간 타입(Object)
		// 2. 위치정보 : 저장되는 값이 잇는 위치(index) hint)전자제품 매장 cart사용해서 처리
		// 3. 가능 : push(), pop(), boolean empty(), boolean full()

	}
}
```

### stack 연습

```java

public class Ex07_Mystack_Main {
public static void main(String[] args) {
	MyStack stack = new MyStack(5);
	stack.push(10);
	stack.push(20);
	stack.push(30);
	stack.push(40);
	stack.push(50);
	stack.push(60);

	System.out.println(stack.pop());
	System.out.println(stack.pop());
	System.out.println(stack.pop());
	System.out.println(stack.pop());
	System.out.println(stack.pop());
	System.out.println(stack.pop());
}
}

```

### Generic Quiz

```java
import java.util.ArrayList;
import java.util.List;

import kr.or.kosa.CopyEmp;
import kr.or.kosa.Emp;

class Product{
	int price;
	int bonuspoint;
	//Product(){}
	Product(int price){
		this.price = price;
		this.bonuspoint = (int)(this.price/10.0);
	}
}

class KtTv extends Product{
	KtTv(){
		super(500);
	}
	//KtTv(int price){
	//	super(price);
	//}

	//이름
	@Override
	public String toString() {
		return "KtTv";
	}
}

class Audio extends Product{
	Audio(){
		super(100);
	}

	@Override
	public String toString() {
		return "Audio";
	}
}


class NoteBook extends Product{
	NoteBook(){
		super(150);
	}
	//이름
	@Override
	public String toString() {
		return "NoteBook";
	}
}
public class Ex08_Generic_Quiz {

	public static void main(String[] args) {
		//****아래 문제 풀어보세요^^**** 2시 10분까지요
		//1. Array 사용해서 tv, audio , notebook을 담을 수 있는 cart 배열을 생성하고 제품을 담으세요
		Product[] cart = new Product[3];
		cart[0] = new KtTv();
		cart[1] = new Audio();
		cart[2] = new NoteBook();

		//2. ArrayList Generic 사용해서 cart 배열을 만들고 제품을 담으세요
		//ArrayList<Product> pcart = new ArrayList<Product>();
		List<Product> pcart = new ArrayList<Product>();
		pcart.add(new KtTv());
		pcart.add(new KtTv());
		pcart.add(new KtTv());
		pcart.add(new NoteBook());

		for(Product product : pcart ) {
			System.out.println(product);
		}

		//3. Emp 클래스 (kr.or.kosa)
		//ArrayList Generic 사용해서 사원 3명을 만드세요
		ArrayList<Emp> emplist = new ArrayList<Emp>();
		emplist.add(new Emp(1000,"김씨","IT"));
		emplist.add(new Emp(2000,"박씨","SALES"));
		emplist.add(new Emp(3000,"이씨","MANAGER"));
		//3.1 사원의 정보를 toString() 사용하지 말고 사번 , 이름, 직종을 출력하세요 (개선된 for문)
		for(Emp emp : emplist) {
			System.out.println(emp.getEmpno() + " / " + emp.getName() + " / " + emp.getJob());
		}
		//3.2 위와 동일한데 개선된 for문이 아니고 일반 for문을 사용해서 사번 , 이름, 직종을 출력하세요
		for(int i = 0 ; i < emplist.size() ; i++) {
			  System.out.println(emplist.get(i).getEmpno()  + " / " + emplist.get(i).getName());
		}

		List<CopyEmp> clist = new ArrayList<CopyEmp>();
		clist.add(new CopyEmp(100, "김씨",1000));
		clist.add(new CopyEmp(200, "이씨",2000));
		clist.add(new CopyEmp(300, "박씨",5000));

		//1. 200번 사원의 급여를 6000으로 수정하세요 (일반 for문을 통해서) getter, setter
		for(int i = 0 ; i < clist.size() ;i++) {
			if(clist.get(i).getEmpno() == 200) {
				clist.get(i).setSal(6000);
				System.out.println(clist.get(i).toString());
			}
		}

		//2. 300번 사원의 이름을 박씨에서 "궁금해씨" 수정해서 그 결과를 출력하세요 (개선된 for)
		for(CopyEmp emp : clist) {
			if(emp.getEmpno() == 300) {
				emp.setName("궁금해씨");
				System.out.println(emp.toString());
			}
		}








	}

}
```

### Iterator

Collection FrameWork  
(수많은 인터페이스와 그 것을 구현하고 있는 수 많은 클래스가 있다)

Iterator 인터페이스  
(반복자)  
[나열된 자원에 대해 순차적으로 접근해서 값을 리턴하는 **표준**을 정의 ]  
추상함수로 정의하고 있다>> 누군가는(ArrayList)>> 추상함수를 구현(표준화된)

Iterator 인터페이스 가지고 있는 추상함수  
hasNext(), Next(), remove() 추상  
ArrayList implements Iterator{ hasNext()을 재정의 구현하고 있다 }

```java
import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

public class Ex09_Collection_Iterator {
	public static void main(String[] args) {

		ArrayList list = new ArrayList();
		list.add(100);
		list.add(200);
		list.add(300);
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
		// 표준화된 출력 방식( 순서대로 나열된 데이터에 대해서)
		Iterator it = list.iterator();// 호출하면 함수안에서 인터페이스를 구현하는 객체가 생성되고
		// Iterator it 부모타입
		while (it.hasNext()) {// 현업 코드 권장사항(표준화)
			System.out.println(it.next());
		}

		ArrayList<Integer>intlist=new ArrayList<Integer>()	;

		intlist.add(1);
		intlist.add(2);
		intlist.add(3);

		//인터페이스 generic 명시 (주의)
		Iterator<Integer>it2=intlist.iterator();
				while(it2.hasNext()) {
					System.out.println(it2.next());
				}
				System.out.println("********************");
				for(int i=intlist.size()-1;i>=0;i--) {
					System.out.println(intlist.get(i));

				}

				//////////////////////////////////////
				//Iterator 인터페이스 표준화 준 순방향 출력...
				//역방향 조회 표준화?
				ListIterator<Integer> it3=intlist.listIterator()	;

				//순방향
			while(it3.hasNext()) {
				System.out.println(it3.next());

			}
			//역방향
			while(it3.hasPrevious()) {
				System.out.println(it3.previous());

			}
			//참고 (삭제도 표준화된 구형니 가능합니다)
			while(it3.hasNext());
			int i=it3.next();
			if(i==3) {
				it3.remove();
			}

	}

}

```

### HashSet

Set 인터페이스 (원 안에 들어가세요) : 순서보장(x), 중복(x)
순서가 없고 중복을 허락하지 않는 데이터 집합  
HashSet, TreeSet(자료구조)

```java
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/*

*/
public class Ex10_Set {

	public static void main(String[] args) {
		HashSet<Integer> hs= new HashSet<Integer>();

		//순서가 없는 [중복되지 않는] 데이터 집합
		hs.add(1);
		hs.add(100);
		boolean bo=hs.add(55);
		System.out.println("정상 :"+bo);

		bo=hs.add(1);
		System.out.println("결과 :"+bo);//이미 원안에는 1이라는 데이터가 존재

		//중복..... 로또, 차량번호
		System.out.println(hs.toString());//재정의[1, 100, 55]

		HashSet<String>hs2= new HashSet<String>();
		hs2.add("b");
		hs2.add("A");
		hs2.add("F");
		hs2.add("C");
		hs2.add("Z");
		hs2.add("bA");
		hs2.add("H");
		hs2.add("b");
		hs2.add("b");

		System.out.println(hs2.toString());

		String []strobj= {"A","B","C","D","B","A"};//1000건 (1건씩 중복)
		HashSet<String> hs3=new HashSet<String>();
		for(int i=0;i<strobj.length;i++) {
			hs3.add(strobj[i]);//중복 데이터를 add하지 않는다.

		}

		System.out.println(hs3.toString());//A,B,C,D가 몇건 있는 지는 모른다.

		//Quiz
		//hashSet 1~45까지의 난수 6개ㅐ를 넣으세요
/*		int[] lnum = new int[6];
		for (int i = 0; i <= 5; i++) {

			lnum[i] = (int) (Math.random() * 45 + 1);
			for (int j = 1; j < i; j++) {
				if (lnum[i] == lnum[j]) {
					i--;
					break;
				}
			}System.out.println(lnum[i]);
		}
	}
*/

		HashSet<Integer>lotto= new HashSet<Integer>();
		for(int i=0;lotto.size()<6;i++) {
			int num=(int)(Math.random()*45+1);
		lotto.add(num);
		System.out.println("i: "+i+"num :"+num);
	}System.out.println(lotto.toString());

	//HashSet 다형성 >>부모>>Set
	Set set2=new HashSet();
	int index=0;
	while(set2.size()<6) {
		int num= (int)(Math.random()*45+1);
		set2.add(num);//add 추상함수를 HashSet 클래스 재정의

	}
	System.out.println(set2.toString());
//HashSet<String>set3=new HashSet<String>();
	Set<String>set3 = new HashSet<String>();

	set3.add("AA");
	set3.add("DD");
	set3.add("ABC");
	set3.add("FFF");

	System.out.println(set3.toString());

	Iterator<String> st=set3.iterator();
	while(st.hasNext()) {
		System.out.println(st.next());
	}
	}
}

```

```java

```
