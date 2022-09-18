package prac_1;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

class Myclass {
	private int id;
	private String name;

	public Myclass() {
	}

	public Myclass(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Myclass [학번=" + id + ", 이름=" + name + "]";
	}

}

public class collection_ex11 {
	public static void main(String[] args) {
		Set<Myclass>hset= new HashSet<Myclass>();
		Myclass mc1= new Myclass(1,"111");
		Myclass mc2= new Myclass(12,"1111");
		Myclass mc3= new Myclass(13,"1112");
		Myclass mc4= new Myclass(1,"111");
		
		hset.add(mc4);
		hset.add(mc1);
		hset.add(mc1);
		hset.add(mc2);
		hset.add(mc3);
		
		System.out.println(hset.toString());
		
		for(Myclass m : hset) {
			System.out.println(m.toString());
		}
		System.out.println();
		Iterator<Myclass> it4 = hset.iterator();
		while(it4.hasNext()) {
			Myclass mc=it4.next();
			System.out.println(mc.getId()+","+mc.getName());
			System.out.println(it4.next());
			
		}

	}

}
