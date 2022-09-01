import kr.or.kosa.Emp;

class Test2{
	int x=100;
	void print() {
		System.out.println("부모함수 Test2");
	}
}

class Test3 extends	Test2{
	int x=300;//부모를 무시하는 행동이다. 만약 쓴다면 부모코드는 무시 문법적으로 오류가 아니지만 굳이??
	
	//재정의
	@Override
	void print() {
		System.out.println("자식이 부모의 함수를 재정의 ");
		
	}
	void print(String str) {//오버로딩
		System.out.println("나는 오버로딩 함수"+str);
	}
}

public class Ex05_Ingherit_Override {
	public static void main(String[] args) {
		Test3 t3= new Test3();
		System.out.println(t3.x);
		
		t3.print();
		t3.print("오버로딩");
		
		Emp emp = new Emp(1000 ,"홍길동");
		System.out.println(emp);//kr.or.kosa.Emp@1c4af82c
		System.out.println(emp.toString());//kr.or.kosa.Emp@1c4af82c
		
		//emp 출력하면 사실은..emp.toString()동일한 효과
		//toString()	은 Object의 자원 ... 주소값 return
		
		//toString() 재정의 했다면 결과는 재정의된 내용 출력
		//Emp [empno=0, ename=null]
			//	Emp [empno=0, ename=null]
		
		//JAVA API제공하는 수만은 클래스가  Object클래스의 toString() 재 정의하고있다.

	}

}
