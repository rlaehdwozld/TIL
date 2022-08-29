class Human2 {
	String name;
	int age;
}

class Test2 {
	Human2 add(Human2 h) {
		// 여기 코드는 내 마음

		h.name = "김동재";
		h.age = 29;
		return h;
	}

	Human2 add(Human2 h, Human2 h2) {
		h2.name=h.name;
		h2.age=h.age;
		
		return h2;
		//매개변수의 갯수가 달라서 오버로딩이다.
		
	}
	}
	public class Ex14_Method_Overloading {
		public static void main(String[] args) {
			Test2 t = new Test2();
			
			Human2 man = new Human2( );//man 0x123주소값을 가지고 있으면
			
			Human2 man2=t.add(man);//man2 0x123주소값
			System.out.println(man==man2);//true
		}

	
	


}