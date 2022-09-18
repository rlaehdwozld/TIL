package prac_1;

import java.util.ArrayList;
import java.util.List;



class Product {
	int price;
	int bonuspoint;
	// Product(){}

	Product(int price) {
		this.price = price;
		this.bonuspoint = (int) (this.price / 10.0);
	}
}

class KtTv extends Product {
	KtTv() {
		super(500);
	}
	// KtTv(int price){
	// super(price);
	// }

	// 이름
	@Override
	public String toString() {
		return "KtTv";
	}
}

class Audio extends Product {
	Audio() {
		super(100);
	}

	@Override
	public String toString() {
		return "Audio";
	}
}

class NoteBook extends Product {
	NoteBook() {
		super(150);
	}

	// 이름
	@Override
	public String toString() {
		return "NoteBook";
	}
}

class Emp1 {
	private int empno;
	private String name;
	private String job;

	public Emp1(int empno, String name, String job) {
		super();
		this.empno = empno;
		this.name = name;
		this.job = job;
	}

	public int getEmpno() {
		return empno;
	}

	public void setEmpno(int empno) {
		this.empno = empno;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	@Override
	public String toString() {
		return "Emp [empno=" + empno + ", name=" + name + ", job=" + job + "]";
	}

}

 class CopyEmp1 {
	private int empno;
	private String name;
	private int	sal;
	
	public CopyEmp1(int empno, String name, int sal) {
		super();
		this.empno = empno;
		this.name = name;
		this.sal = sal;
	}

	public int getEmpno() {
		return empno;
	}

	public void setEmpno(int empno) {
		this.empno = empno;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSal() {
		return sal;
	}

	public void setSal(int sal) {
		this.sal = sal;
	}

	@Override
	public String toString() {
		return "Emp [empno=" + empno + ", name=" + name + ", sal=" + sal + "]";
	}
	
	

}


public class collection_ex08 {

	public static void main(String[] args) {

		// 1. Array 사용해서 tv, audio , notebook을 담을 수 있는 cart 배열을 생성하고 제품을 담으세요
		Product[] cart = { new Audio(), new KtTv(), new NoteBook() };
		// 2. ArrayList Generic 사용해서 cart 배열을 만들고 제품을 담으세요
		List<Product> cart1 = new ArrayList<Product>();
		cart1.add(new KtTv());
		cart1.add(new Audio());
		cart1.add(new Audio());

		for (Object obj : cart1) {
			System.out.println(cart1.toString());
		}

		// 3. Emp 클래스 (kr.or.kosa)
		// ArrayList Generic 사용해서 사원 3명을 만드세요
List<Emp1>elist = new ArrayList<Emp1>();
elist.add(new Emp1(5000, "김동재", "개발자"));
elist.add(new Emp1(5010, "김동재1", "개발자1"));
elist.add(new Emp1(5020, "김동재11", "개발자11"));

		// 3.1 사원의 정보를 toString() 사용하지 말고 사번 , 이름, 직종을 출력하세요 (개선된 for문)
for(Emp1 emp : elist) {
System.out.println(emp.getEmpno()+" . "+emp.getJob()+","+emp.getName());
		
}
		// 3.2 위와 동일한데 개선된 for문이 아니고 일반 for문을 사용해서 사번 , 이름, 직종을 출력하세요
for(int i=0;i<elist.size();i++) {
	
	System.out.println(elist.get(i).getEmpno());
}


List<CopyEmp1> clist = new ArrayList<CopyEmp1>();
clist.add(new CopyEmp1(100, "김씨",1000));
clist.add(new CopyEmp1(200, "이씨",2000));
clist.add(new CopyEmp1(300, "박씨",5000));

		// 1. 200번 사원의 급여를 6000으로 수정하세요 (일반 for문을 통해서) getter, setter
//for(int i=0;i<elist.size();i++) {
//	if(clist.get(i).getEmpno()==200) {
//		clist.set(i, new CopyEmp(200, "이씨", 6000));
//	}
//}
//System.out.println(clist.toString());
for(int i=0;i<clist.size();i++) {
	if(clist.get(i).getEmpno()==200) {
		clist.get(i).setSal(6000);
		System.out.println(clist.get(i).toString());
		
	}
}

		// 2. 300번 사원의 이름을 박씨에서 "궁금해씨" 수정해서 그 결과를 출력하세요 (개선된 for)
for(CopyEmp1 c: clist) {
	if(c.getName().equals("박씨")){
			c.setName("궁금해씨");
			System.out.println(c.toString());
}
}
	}

}
