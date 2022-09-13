import java.util.ArrayList;

//연습용이니까...
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

	public void setElist(ArrayList elist) {
		this.elist = elist;

	}
}

public class Ex04_ArrayList {
	public static void main(String[] args) {
	 EmpData  empdata = new EmpData()	;
		System.out.println(empdata.toString());
		System.out.println(empdata.getElist().toString());//재정의 >>[] 재정의를 했다는 것이 Object 클래스에서 재정의가 자동으로 되기 떄문
		
		ArrayList li = new ArrayList();
		li.add(100);
		li.add(200);
		
		empdata.setElist(li);
		System.out.println(empdata.getElist().toString());//[100, 200]
		
		ArrayList<String> slist = new ArrayList<String>();
		slist.add("superman");//제네릭을 string으로 하면 데이터 값을 string만 넣을 수 있다.
		slist.add("Hulk");
		slist.add("captain");
		System.out.println(slist.toString());
		System.out.println(slist);
		
		ArrayList<Integer>intList =new ArrayList<Integer>(20);
		System.out.println(intList.size());//0
		System.out.println(intList.add(100));//true 정상적으로 처리되었어
		System.out.println(intList.size());//1
		
		
	}
}
