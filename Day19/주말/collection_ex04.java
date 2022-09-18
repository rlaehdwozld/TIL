package prac_1;

import java.util.ArrayList;
import java.util.List;

class EmpData {
	private String name;// default 값은 null
	private int[] numbers;// default 값은 null
	private ArrayList elist;// default 값은 null 초기화 하지 않으면 null값을 가지고 있다.

	// 초기화
	public EmpData() {
		this.name = "아무개";
		// 사용자가 만든 타입 , "Array,ArrayLsit>>초기화가 갖는 의미가 메모리를 갖는 것이다. new를 통해서
		this.numbers = new int[10];
		this.elist = new ArrayList();

	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int[] getNumbers() {
		return this.numbers;
	}

	public void setNumbers(int[] numbers) {
		this.numbers = numbers;
	}

	public ArrayList getElist() {
		return this.elist;
	}

	public void setElist(List li) {
		this.elist = (ArrayList) li;

	}
}
public class collection_ex04 {
	public static void main(String[] args) {
		EmpData e= new EmpData();
		System.out.println(e.toString());
		System.out.println(e.getElist().toString());
		
		List li = new ArrayList();
		li.add(100);
		li.add(200);
		
		e.setElist(li);
		System.out.println(e.getElist().toString());
	}

}
