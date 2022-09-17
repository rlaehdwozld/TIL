package prac_1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class collection_ex09 {
	public static void main(String[] args) {
		
		List<Integer>list = new ArrayList<Integer>();
		list.add(100);
		list.add(200);
		list.add(300);
		
		
		for(int i=0;i<list.size();i++) {
			System.out.println(list.get(i));
			
		}
		System.out.println();
		Iterator it = list.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
System.out.println();
		ArrayList<Integer>intlist=new ArrayList<Integer>()	;
		
		intlist.add(1);
		intlist.add(2);
		intlist.add(3);
		
		Iterator<Integer> it2= intlist.iterator();
		while(it2.hasNext()) {
			System.out.println(it2.next());
		}	ListIterator<Integer> it3=intlist.listIterator()	;
		
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
