package prac_1;

import java.util.Vector;

public class collection_ex01 {
	public static void main(String[] args) {
		Vector v= new Vector();
		
		System.out.println(v.capacity());
		System.out.println(v.size());
		
		v.add("AA"	);
		v.add(10);
		
		System.out.println(v.size());
		
		for(int i=0;i<v.size();i++) {
			System.out.println(v.get(i));
		}
		
		for(Object obj : v) {
			System.out.println(obj);
			
		}
		Vector<String > v2 = new Vector<String>()	;
		
		v2.add("rla");
		v2.add("aaasdads)");
		v2.add("aaasdads)");
		v2.add("aaasdads)");
		
		for( String str : v2) {
			
			System.out.println(str);
			
		}
		System.out.println(v2.toString());
	}

}
