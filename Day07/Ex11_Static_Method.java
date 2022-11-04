
public class Ex11_Static_Method {
	
	public void method(//heap메모리에 로드 되고 나서 사용
			) {
		System.out.println("나 일반함수야");
	}
	
	public static void smethod() {
		System.out.println("나 static함수야");
	}
	public static void main(String[] args) {
		//안에서 smethod를 바로 사용 할 수 있을까??
		//yes!
		//Ex11_Static_Method(); Ex11_Static Method의 자원
		smethod();
		Ex11_Static_Method ex11 = new Ex11_Static_Method();
		//ex11 참조변수 (주소를 가지고 있는 변수) 는 static접근,일잔 접근 가능
		ex11.method();
	}

}
