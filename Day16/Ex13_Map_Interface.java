
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

/*
Map 인터페이스
(key ,value) 쌍의 구조를 갖는 배열
ex) 지역번호 (02,서울) , (031,경기)
조건)
key 중복(x)    >> Set
value 중복(0)  >> List

Generic 지원 

Map 인터페이스 구현하는 클래스
구버전 : HashTable (동기화) : 한강 화장실 (lock) 자원 보호 
신버전 : HashMap   (동기화 강제하지 않아요) 성능고려 (Thread 학습 ....)  ****

*/
public class Ex13_Map_Interface {

	public static void main(String[] args) {
		HashMap map = new HashMap();
		map.put("Tiger", "1004");  //id ,pwd 
		map.put("Scott", "1004");
		map.put("Superman", "1007");
		
		System.out.println(map.containsKey("tiger")); //대소문자 구별 (false)
		System.out.println(map.containsKey("Scott"));
		System.out.println(map.containsValue("1004")); //중복 상관없어요 true
		
		System.out.println(map.get("Tiger")); // 1004
		//key 제공 >> value >> map.get(key)
		System.out.println(map.get("hong")); //없는 key return null;
		
		map.put("Tiger", "1008"); // value replace
		System.out.println(map.get("Tiger")); //1008
		System.out.println(map.size()); //3
		
		System.out.println(map.toString()); //재정의 key,value 확인 가능
		//{Superman=1007, Tiger=1008, Scott=1004}
		
		Object value = map.remove("Superman");
		System.out.println("삭제된 value: " + value);
		System.out.println(map.toString());
		
		//응용 (이해)
		Set set = map.keySet(); //이해  (Set 인터페이스를 구현하는 객체를 생성해서 주소리턴)
		//순서(x), 중복(x)
		Iterator it= set.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
		
		Collection clist = map.values(); //value 는 중복데이터 있어서 순서가 있는 데이터 집합
		System.out.println(clist.toString());
	}

}