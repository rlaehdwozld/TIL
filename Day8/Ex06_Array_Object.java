import kr.or.bit.Emp;

public class Ex06_Array_Object {
public static void main(String[] args) {
	//사원 세명을 만드세요
	// 단 Array 사용
	// 사원 정보 
	//1000, 홍길동
	//2000, 김유신
	//3000, 유관순
	//을 만드시고 사번과 이름을 출력하세요
	Emp[] emp= {new Emp(1000,"홍길동"),new Emp(2000,"김유신"),new Emp(3000,"유관순")};
	
	/*
	 * for(int i=0;i<emp.length;i++) { emp[i].empInfoPrint(); }
	 */
	for(Emp e : emp	) {
		e.empInfoPrint();
	}
	

}
}