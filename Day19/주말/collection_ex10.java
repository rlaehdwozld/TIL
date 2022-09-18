package prac_1;

import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class collection_ex10 {
	public static void main(String[] args) {
		HashSet<Integer> hs = new HashSet<Integer>();

		hs.add(1);
		hs.add(2);

		boolean bo = hs.add(55);
		System.out.println(bo);

		bo = hs.add(1);
		System.out.println(bo);
		System.out.println(hs.toString());

		HashSet<String> h2 = new HashSet<String>();

		h2.add("a");
		h2.add("b");
		h2.add("c");
		h2.add("d");
		h2.add("e");
		h2.add("f");
		h2.add("a");
		h2.add("a");
		System.out.println(h2.toString());

		int[] strobj = { 1, 2, 3, 4, 5, 6, 7, 8 };
		HashSet<Integer> hs3 = new HashSet<Integer>();
		for (int i = 0; i < strobj.length; i++) {
			hs3.add(strobj[i]);

		}
		System.out.println(hs3.toString());

		// Quiz
		// hashSet 1~45까지의 난수 6개ㅐ를 넣으세요

		HashSet<Integer> hs4 = new HashSet<Integer>();

		for (int i = 0; i <= 6; i++) {
			int num = (int) (Math.random() * 45 + 1);
			hs4.add(num);
		}

		System.out.println(hs4.toString());

		Set<String>set3 = new HashSet<String>();
		
		set3.add("AA");
		set3.add("DD");
		set3.add("ABC");
		set3.add("FFF");
		
		System.out.println(set3.toString());
		
		Iterator<String>it1= set3.iterator();
		while(it1.hasNext()) {
			System.out.println(it1.next());
		}
	}
}
