import kr.or.kosa.AirPlane;

/*
 instance variable >> class Car{private Stirng color;}
 >>생성되는 객체마다 다른 색상을 가질 수 있다.
 
 local variable>> class Car{public void move(){ int speed=0;}}
 습관적으로 지역안에 있는 변수는 초기화를 하자
  
 block variable >> class Car{public void move(){for(int t;i<10.....)}제어생성... 소멸
  
 static variable >> 공유자원 (객체간), 객체 생성 이전에 memory 올라가는 자원( 영역 : class area, method area)
 
 객체를 만드는 유일한 방법은 new를 통해서 memory에 올리는 것이라고 하셨지만
 static은 new없이도 memory에 올라간다
 
 Ex06_Variable_Scope 클래스 >> 구체화(메모리)>>Ex06_Variable_Scope>> 이 클래스는 new를 한 적이 없었다 한번도
 
 
 
 */

class Variable{
	int iv;//instance Variable
	
	//1. member field, instance varivable
	//2. iv 언제 사용 가능 할깐요(메모리에 언제 올라갈까요)
	//2-1 Variable v= new Variable()	;>>heap객체 생성>> 객체 안에 iv생성
	//		Variable v= new Variable()	;
	//3.목적 : 데이터(정보), 자료를 담을 목적
	//3.1 정보 : 고유, 상태, 부툼(class)
	//-생성되는 객체마다 다른 값을 가질 수 있다.
	//-그래서 초기화 해서 값을 강제하지 않는다. 
	//-대신에 default값은 가지고 있다. (int>0, double>0.0, char >빈문자'\u0000',
	// 											boolean>false, String>null, Car>null)
	//iv 변수의 생성 시점 : new라는 연산자를 통해서heap Variable이름의 객체가 만들어지고 나서 바로 생성(그 안에)
	
	
	/*
	 
	 */
	
	static int cv;//
	/*
	 1. class variable(클래스 변수) ,일반적으로 static variable(객체간 공유자원)
	 2. 목적 : 정보를 담는것 (생성되는 모든 객체가 공유하는 자원)
	 	>>생성되는 모든 객체라는 것은 (heap영역에 생성된 객체들이 공유하는 자원)
	 3. 접근방법 
	 	1.class 이름.static변수명>>  Variable.cv>>why(객체가 생성되기 전에...접근)
	 	2. Variable v =new Variable();>>c.cv
	 	    Variable v2 =new Variable();>>v2.cv
	 	    >>v.cv의 주소값과 v2.cv(같은 주소를 바라본다 : static 변수 주소)   
	 4. 생성시점
	 	Hello.java>javac Hello.java>Hello.class
	 	>java.exe Hello 엔터 실행
	 	>JVM>OS>Memory빌려 > 정리(영역을 나누어요)>class Loader system 분석
	 	>클래스 정보(metadata : 설명) >> clss area(method area)메모리에 올림( 언제. 어떤 자원, 버전..)
	 	>그 클래스 안에 static variable 또는 static method있다면 두녀석을 class area(method area) 영역에 할당합니다.
	 	> 그런데 그 함수의 이름이 만약에 main() 이라면 정해진 규칙에 따라서 실행합니다(Stack영역) 자원 할당...
	 */
	void method() {
		int lv=0;//local variable
		/*
		local Variable(함수안에 : 지역변수 : 사용전에 반드시 초기화)
		생명주기) 함수가 호출되면 (stack생성되었다고 함수가 끝나면, 강제 return되면 같이 소멸)
		 */
		
		for(int i =0; i<10;i++) {
			//int i>> block변수>>for문이 생성되면 생성되었다가 for문이 끝나면 소멸
		}
		for(int i =0; i<10;i++) {
			
		}
	
		
	}
	
}

public class Ex06_Variable_Scope {

	public static void main(String[] args) {
		//어떤 객체도 생성하지 않아요
		Variable.cv =100;
		Ex06_Variable_Scope ex06= new Ex06_Variable_Scope();
		
		
	}
	public void method() {
		System.out.println("나 일반 함수");
		
	}
	
	

}
