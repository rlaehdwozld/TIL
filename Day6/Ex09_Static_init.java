// static 변수는 객체마다 같은 값을 가지게 할꺼야
// instance변수는 객체마다 다른 값을 가지게 할꺼야 목적으로 설계

//두 변수에 대해서 초기화를 하는 방법이 두가지가 있따.
class InitTest{
	static int cv=10;
	static int cv2;
	int iv= 11;
	//3놈은 사실 default값은 초기화 하지 않아도 된다.
	static{
		//static 자원에 초기화 블럭
		//초기화 블럭은 언제 실행이 될까?
		//static int cv=10, static int cv2이 메모리에 올라간 직후 
		cv=1111;
		cv2=cv+2222;//조작된 값의 표현이 가능하다.
		1
	}
	
	{
		
	//초기자 블럭 (member field초기화)
	//객체가 생성되고 나서 int iv 메모리에 올라가고 나서 바로 호출 {블럭}
		//인위적인 코드 //if(iv>10) iv =100
		System.out.println("초기자블럭");
		//iv=2222;;
		if(iv>10) iv=1000;
			
			cv=100;//객체가 new되지 않으면 초기화 안되요(static)
			
		
	}
}
public class Ex09_Static_init {
	public static void main(String[] args) {
//		InitTest t = new InitTest();
//		System.out.println(t.iv);
		System.out.println(InitTest.cv);	
		System.out.println(InitTest.cv2);
	}
}
