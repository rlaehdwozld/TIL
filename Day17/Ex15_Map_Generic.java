import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/*
HashMap<k,v>


HashMap<String , String>
HashMap<Integer , Integer>
HashMap<String ,Student > Point!!!!


Student st = new Student();
>>put("kglim", st);
		or
		put("kglim",new Student());
class Student{ // 클래스 == 데이터 타입
*/
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
public class Ex15_Map_Generic {
	public static void main(String[] args) {
		HashMap<String, String >sts = new HashMap<String, String>();
		sts.put("A", "AAA");
		System.out.println(sts.get("A"));
		
		
		//실무 에서의 Map
		//학생의 성적 데이터
		//kim , 국어, 영어, 수학>>Array, Collection(ArrayList(0))
		//Value 값은 객체 타입 (Emp, Student)
		
		//Map<String, Student>smap = new HashMap<String, Student>(); 더 좋은 코드

		//TodayPoint
		HashMap<String, Student>smap = new HashMap<String, Student>();
		
		smap.put("hong", new Student(100, 80, 50, "홍길동"));
		smap.put("kim",new Student(50, 30, 60, "김유신"));
		
		Student sd=smap.get("hong");
		System.out.println(sd.kor);
		System.out.println(sd.math);
		
		
		ArrayTest at= new ArrayTest();
	String []starr = {"A","B","c"};
		at.al.add(starr);
		
		//Tip 
		Set set=smap.entrySet();//entrySet은 Map key, value 가공 >> key +"="+value
		Iterator it= set.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
//		hong=Student@3e57cd70
//		kim=Student@9a7504c
		
		//Tip key, value 분리되서 결과를 보고 싶어요
		//class Entry{Object key, object value}
		//Map { Entry[] elements}>>Map.Entry
		for(Map.Entry m : smap.entrySet()) {
			System.out.println(m.getKey()+"/"+((Student)m.getValue()).name);
		}
		
	}

}
