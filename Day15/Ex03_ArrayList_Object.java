import java.util.ArrayList;
import java.util.List;

import kr.or.kosa.Account;
import kr.or.kosa.Bank;
import kr.or.kosa.Emp;

public class Ex03_ArrayList_Object {
	public static void main(String[] args) {
		// 1. 사원을 1명 만들자
		Emp emp = new Emp(1000, "김유신", "장군");
		System.out.println(emp.toString());

		// 2. 사원 2명 만들자 배열(Array)
		Emp[] emplist = { new Emp(100, "김씨", "영업"), new Emp(200, "박씨", "IT") };
		for (Emp e : emplist) {
			System.out.println(e.toString());
		}

		// 3. 사원이 1명 더 입사를 했어요(300, "이씨", "IT")
		// 방 3개짜리 배열을 만들고 for문 돌려서 다 옮겨야되서 귀찮다

		// ArrayList
		ArrayList elist = new ArrayList();
		elist.add(new Emp(100, "김씨", "영업"));
		elist.add(new Emp(200, "박씨", "IT"));
		elist.add(new Emp(300, "이씨", "영업"));
		for (int i = 0; i < elist.size(); i++) {
			System.out.println(elist.get(i));
			
			
		}
		
		
		
		elist.add(new Emp(400,"최씨","관리"));
		
		//toString() 사용하지 말고 4명의 사원 사번, 이름, 직종을 출력하세요
		//for문 안에서 getEmpno(),getEname(), getJob()
		for(int j=0;j<elist.size();j++)	{
			Object obj=elist.get(j);
			//obj.toString()
			//Object는 모든 타입의 부모타입(Down casting)
			Emp e=(Emp)obj;
			System.out.println(e.getEmpno()+","+e.getName()+","+e.getJob());//다형성 다운캐스팅 원리 이해하기!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
			
			
		}
		
		//현업개발자 ....(object 타입) ... downcasting ... 자식요소 접근
		//Object 쓰지말자 ....대안
		// 타입 강제( 그 타입 쓰게 하자) 하나의 타입만을 가지고 데이터 관리
		//제너릭 (객체 생성시 타입 강제 방법)
		
		ArrayList<Emp>list2 = new ArrayList<Emp>();
		//list2.add(emp);
		list2.add(new Emp(1, "a", "IT"));
		for(Emp e : list2) {
			System.out.println(e.getEmpno());
		}
		
		
		
		
	}
	
}
