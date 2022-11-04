package Day5;

/*
 기능 (행위)만드는 방법
 함수(method)
 
 method : 행위 또는 기능의 최소단위로 구현 : 하나의 함수는 하나의 기능만 구현
 ex) 먹는다. 잔다. 걷는다.
 클래스 : field + method
 
 ex) 롯데월드 : 게임방 : 농구, 동전, 동전뽑기
 
 **method 함수는 호출에 의해서만 동작된다.
	누군가 이름을 부르지 않으면 동작하지 않는다.
	
	JAVA)
	1.void, parameter(0) : void print (String str) {실행코드}
	2. void, parameter(x) : void print(){실행코드}
	3. return type , parameter(O) : int print(int data) {retrun100;	}
	4. return type, parameter(x) : int print(){ return 100;}
	
	** void > 돌려주는 것이 없어요> return type이 없어요
	return type >> 기본 8가지 + String + Array , collection, interface
	중에서 기본 8가지 + String +class 까지는 인정
	
	boolean print() {return true}
	Car print () {Car c = new Car() ; return c;}
	//나는 당신에게 Car객체의 주소를 return 하겠다.
	 String print() {return "A"}
	 
	 parameter type >> void print (String 파라메터)
	 >> 기본 8가지+ String + Array, class, collection, interface
	 이중에서 기본8가지String + class 인정
	 void print(int i ){}
	 void print (String str){}
	 void print (Car car){}//print 함수는 parameter Car타임의 주소값을 받는다.
	 
	 	ex)
	 	Car c= new Car();
	 	void print (Car car){}
	 	print(c) ; // print 함수 호출시 c라는 변수값 (주소값)
	 	
	 	어려워요... 동전궝이 여러개....
	 	
	 	void print( int a, int b int c, int d){}
	
		print (10,20)  (x)
		print(100,2,4)(X)
		print(1,2,3,4)(O)
		
		void print ( Car c, String str, int i) {}
		
		관용적인 표현
		코드규칙 : 관용적 표현 
		class 이름의 첫글자는 대문자 : class Car, class Person
		method의 이름은 단어의 첫글자 소문자 이어지는 단어의 첫글자는 대문자.. : getNumber()
		
		사원번호를 가지고 사원의 모든 정보를 가지고 와라(함수 생성)
		getEmpListByEmpno()//함수의 이름은 그 이름으로 대략적인 내용 파악 가능하게 하면 좋다.
		
 */
public class Fclass {
	public int data;
	
	//void m()>>컴파일리가 default를 붙인다 앞에다가>> 같은 폴더 내에서만 사용 가능하다.
	//함수70% public
	//함수30% private:why:hint) public, private 클래스 내부 동등...
	//클래스 내부에서만 사용하는 함수>> 공통함수 >>다른함수를 도와주는 함수

	public void m() {
		// void , parameter(x)
		// 기능 구현
		// main 함수에서 사용했던 코드 그대로 구현...
		System.out.println("일반함수 : void, parameter(x)");
	}
	
	//void m2(int)
	public void m2 (int i) {//i라는 변수는 함수 내부에서만 유효하다.
		System.out.println("일반함수 : void, parameter(0)");
		System.out.println("parameter값은 활용  i 변수 함수 내부에서만 가능하다 :"+i );
	
		
		
	}
	
	
	//return type m3(x)
	public int m3() {
		//무조건 , 강제로.....
		return 10000;//리턴타입이 존재하면 반드시 return키워드를 명시해야한다. 
	}
	
	
	public int m4(int data) {
		return 100+data;
	}
	//여기까지가 기본 4가지
	//확장
	//return type 있고 parameter여러가지 있는 경우 m4랑 같은 경우
	public int sum(int i, int j, int k) {
		return i + j + k;
	}
	
	
	/*
	 함수의 접근자 
	 default int subSum(){} 같은 폴더...
	 private int subSum(){} 같은 폴더도 안되요
	 클래스 내부에서 다른 함수를 도와주는 공통함수...
	 private 함수 만들어서 사용
	 
	 
	 */
	
	private int subSum(int i) {//다른 함수가 호출해서 사용
		return i = 100;				//로직이 모든 함수가 가지고 있다면...변경...유지보수 유용 측면에서
	}
	
	public void callSubSum() {
		//함수는 다른 함수를 호출할 수 있다.
		int result = subSum(100);
		System.out.println("call result : "+ result);
	}
	
	private int operationMethod(int data) {
		return data*200;	
		
	}
	public int opSum(int data) {
		int result = operationMethod(data);
		//제어문
		if(result>0) {
			return 1;
		}else	{
			return -1;
		}
	}
	
	
	/*
	 Quiz
		a와 b둘중에 큰값을 return하는 함수를 만드세요
		ex)함수 호출 시 max(10,5) return값은 100이 나오면 된다.
		
	 */
	private int biggerMethod(int a, int b) {
		return a-b;
	}
	public int bigger(int a, int b) {
		return  (a>b) ? a : b;
		
//		int diff = biggerMethod(a, b);
//		if(diff>0) {
//			return a;
//		}else {
//			return b;
//		}
		
	}
}
