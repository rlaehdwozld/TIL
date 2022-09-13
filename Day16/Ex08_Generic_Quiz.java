import java.util.ArrayList;
import java.util.List;

import kr.or.kosa.CopyEmp;
import kr.or.kosa.Emp;

class Product{
	int price;
	int bonuspoint;
	//Product(){}
	Product(int price){
		this.price = price;
		this.bonuspoint = (int)(this.price/10.0);
	}
}

class KtTv extends Product{
	KtTv(){
		super(500);
	}
	//KtTv(int price){
	//	super(price);
	//}
	
	//이름
	@Override
	public String toString() {
		return "KtTv";
	}
}

class Audio extends Product{
	Audio(){
		super(100);
	}
	
	@Override
	public String toString() {
		return "Audio";
	}
}


class NoteBook extends Product{
	NoteBook(){
		super(150);
	}
	//이름
	@Override
	public String toString() {
		return "NoteBook";
	}
}
public class Ex08_Generic_Quiz {

	public static void main(String[] args) {
		//****아래 문제 풀어보세요^^**** 2시 10분까지요
		//1. Array 사용해서 tv, audio , notebook을 담을 수 있는 cart 배열을 생성하고 제품을 담으세요
		Product[] cart = new Product[3];
		cart[0] = new KtTv();
		cart[1] = new Audio();
		cart[2] = new NoteBook();
		
		//2. ArrayList Generic 사용해서 cart 배열을 만들고 제품을 담으세요
		//ArrayList<Product> pcart = new ArrayList<Product>();
		List<Product> pcart = new ArrayList<Product>();
		pcart.add(new KtTv());
		pcart.add(new KtTv());
		pcart.add(new KtTv());
		pcart.add(new NoteBook());
		
		for(Product product : pcart ) {
			System.out.println(product);
		}
		
		//3. Emp 클래스 (kr.or.kosa)
		//ArrayList Generic 사용해서 사원 3명을 만드세요
		ArrayList<Emp> emplist = new ArrayList<Emp>();
		emplist.add(new Emp(1000,"김씨","IT"));
		emplist.add(new Emp(2000,"박씨","SALES"));
		emplist.add(new Emp(3000,"이씨","MANAGER"));
		//3.1 사원의 정보를 toString() 사용하지 말고 사번 , 이름, 직종을 출력하세요 (개선된 for문)
		for(Emp emp : emplist) {
			System.out.println(emp.getEmpno() + " / " + emp.getName() + " / " + emp.getJob());
		}
		//3.2 위와 동일한데 개선된 for문이 아니고 일반 for문을 사용해서 사번 , 이름, 직종을 출력하세요
		for(int i = 0 ; i < emplist.size() ; i++) {
			  System.out.println(emplist.get(i).getEmpno()  + " / " + emplist.get(i).getName());
		}
		
		List<CopyEmp> clist = new ArrayList<CopyEmp>();
		clist.add(new CopyEmp(100, "김씨",1000));
		clist.add(new CopyEmp(200, "이씨",2000));
		clist.add(new CopyEmp(300, "박씨",5000));
		
		//1. 200번 사원의 급여를 6000으로 수정하세요 (일반 for문을 통해서) getter, setter
		for(int i = 0 ; i < clist.size() ;i++) {
			if(clist.get(i).getEmpno() == 200) {
				clist.get(i).setSal(6000);
				System.out.println(clist.get(i).toString());
			}
		}
		
		//2. 300번 사원의 이름을 박씨에서 "궁금해씨" 수정해서 그 결과를 출력하세요 (개선된 for)
		for(CopyEmp emp : clist) {
			if(emp.getEmpno() == 300) {
				emp.setName("궁금해씨");
				System.out.println(emp.toString());
			}
		}
		
		
		
		
		
		
		

	}

}