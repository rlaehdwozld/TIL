package prac_1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

class Student{
	int kor;
	int math;
	int eng;
	String name;
	
	public Student(int kor, int math, int eng, String name) {
		super();
		this.kor = kor;
		this.math = math;
		this.eng = eng;
		this.name = name;
	}
	
	
}
class ArrayTest{
	//알아두자!!
	//genenric으로 배열도 가능 하다!!
	ArrayList<String[]>al=new ArrayList<String[]>();
}
class ArrayTest1{
	ArrayList<String[]>a= new  ArrayList<String[]>();
	
}
public class collection_ex15 {
	public static void main(String[] args) {
		HashMap<String, String >sts = new HashMap<String, String>();
		sts.put("A", "AAA");
		System.out.println(sts.get("A"));
		
		HashMap<String , Student> smap = new HashMap<String, Student>();
		
		smap.put("hong", new Student(100,80, 50, "홍길동"));
		smap.put("kim", new Student(50,60, 40, "김유신"));

		Student sd =smap.get("hong");
		System.out.println(sd.kor);
		
		ArrayTest at= new ArrayTest();
		String []starr= {"a","b","c"};
		at.al.add(starr);
		
		Set set = smap.entrySet();
		Iterator it = set.iterator();
		while(it.hasNext()) {
			System.out.println( it.next());
			
			
		}
		
		//Tip key, value 분리되서 결과를 보고 싶어요
		//class Entry{Object key, object value}
		//Map { Entry[] elements}>>Map.Entry
		for(Map.Entry m : smap.entrySet()) {
			System.out.println(m.getKey()+"/"+((Student)m.getValue()).name);
		}
		
	}

}
