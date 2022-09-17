package prac_1;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class collection_ex12 {
public static void main(String[] args) {
	
	HashSet<String> hs = new HashSet<String>();
	hs.add("B");
	hs.add("A");
	hs.add("F");
	hs.add("K");
	hs.add("G");
	hs.add("D");
	hs.add("P");
	
	System.out.println(hs.toString());
	
	Set<Integer> lotto = new TreeSet<Integer>();
	for(int i = 0 ; lotto.size() < 6 ; i++) {
		int num = (int)(Math.random()*45 + 1);
		lotto.add(num);
		System.out.println("num : " + num);
	}
	System.out.println(lotto.toString());
}
}
