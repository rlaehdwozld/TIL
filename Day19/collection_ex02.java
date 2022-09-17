package prac_1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class collection_ex02 {
	public static void main(String[] args) {
		/*
		 * arraylist의 특징 순서가 있고 중복이 허용됨
		 * 
		 */
		List arraylist = new ArrayList();
		arraylist.add("100");
		arraylist.add("2002");
		arraylist.add("22211");

		System.out.println(arraylist.toString());

		for (int i = 0; i < arraylist.size(); i++) {
			System.out.println(arraylist.get(i));
		}
		arraylist.add(0, 111);// *** 자리 이동***
		System.out.println(arraylist.toString());
		arraylist.add(4, 444);
		System.out.println(arraylist.toString());

		Object value = arraylist.remove(0);// 101을 지우고 102가 0번쨰 방이 된다. 데이터 값을 보관해준다.
		System.out.println(arraylist.toString());

		List li = new ArrayList();// 습관적으로 부모타입
		// ArrayList li = new ArrayList();
		li.add("가");
		li.add("나");
		li.add("다");
		li.add("라");
		li.add("마");

		List li2 = li.subList(0, 2);
		li2.toString();
		li2.toString();
		System.out.println(li2.toString());

		ArrayList alist = new ArrayList();

		alist.add(50);
		alist.add(1);
		alist.add(7);
		alist.add(40);
		alist.add(46);
		alist.add(3);
		alist.add(15);
		
		System.out.println(alist.toString());

		Collections.sort(alist);
		System.out.println(alist.toString());
		
		Collections.reverse(alist);
		System.out.println(alist.toString());
			
		
			
		}

}
