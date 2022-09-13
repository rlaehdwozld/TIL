import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/*
Set 인터페이스 (원 안에 들어가세요) : 순서보장(x), 중복(x)	
순서가 없고 중복을 허락하지 않는 데이터 집합 
HashSet, TreeSet(자료구조)
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
