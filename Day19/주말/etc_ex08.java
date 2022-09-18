package 주말;

import java.util.ArrayList;
import java.util.List;

public class etc_ex08 {
	public static void main(String[] args) {
		int i = 100;
		
		List<Integer> li = new ArrayList<Integer>();
		li.add(100);
		
		for( int value : li) {
			System.out.println(value);
		}
		
		Integer i2 = new Integer(100);
		Integer i3= new Integer(100);
		System.out.println(i2==i3);
		System.out.println(i2.equals(i3));
		

		
		int i4= 100;
		int i5=100;
		System.out.println(i4==i5);
		
		
		
		
	}
}
