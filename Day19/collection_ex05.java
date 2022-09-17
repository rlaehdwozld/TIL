package prac_1;

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
public class collection_ex05 {
	public static void main(String[] args) {
		MyGen<String>mygen = new MyGen<String>();
		mygen.add("문자열");
		mygen.add("ede");
		String str = mygen.get();
		System.out.println(str);
		
		ArrayList list = new ArrayList();
		list.add(10);
		list.add("홍길동");
		list.add(new Person());
	
		for(Object obj :list) {
			System.out.println(obj);
			if(obj instanceof Person) {
				Person p= (Person)obj;
				System.out.println(p.age);
			}else {
				System.out.println(obj);
			}
		}
		ArrayList<Person>plist = new ArrayList<Person>();
		plist.add(new Person());
		plist.add(new Person());
		System.out.println();
		for(Person p:plist ) {
			System.out.println(p.age);
			System.out.println(p.name);
			System.out.println(p.);
		}
		ArrayList<String>slist = new ArrayList<String>();
		slist.add("문자열");
		System.out.println(slist.get(0));
		
		
		
	}
	

}
