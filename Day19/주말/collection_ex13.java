package prac_1;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class collection_ex13 {
public static void main(String[] args) {
	HashMap map = new HashMap();
	map.put("tiger", "1004");
	map.put("kim", "1005");
	map.put("dong", "1006");
	
	System.out.println(map.containsKey("tiger"));
	System.out.println(map.containsKey("kim"));
	System.out.println(map.containsKey("dong"));
	System.out.println(map.containsKey("lee"));

	System.out.println(map.get("tiger"));
	
	System.out.println(map.get("lee"));
	
	map.put("tiger", "1007");
	System.out.println(map.get("tiger"));
	
	Set set= map.keySet();
	System.out.println(set);
	
	Iterator it = set.iterator();
	while(it.hasNext()) {
		System.out.println(it.next());
	}
	
	Collection clist = map.values();
	
	System.out.println(clist.toString());
	System.out.println();
	
	/*
	 * for(String i : clist) { System.out.println(map.values(i)); }
	 */

}
}
