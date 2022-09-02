
/*
String 클래스(문자열)
String 수 많은 함수.... 문자열 조작(자르고, 합치고...)
*/
public class Ex05_String_Class {
	public static void main(String[] args) {
		
		String str="";
		String[]strarr= {"aaa","bbb","ccc"};
		for(String s : strarr) {
			System.out.println(s);
		}
		//사용방법 : int , double 값타입 처럼 사용하면 된다.
		
		String st= "홍길동";
		
		System.out.println(st.length());
		//사실은 내부적으로 배열로 관리한다.
		//문자열에 length를 사용하면 문자열의 길이를 알 수 있다.
		System.out.println(st);//toString()이 사실 생략되어 있는 것이다.
		System.out.println(st.toString());//주소로 가서 데이터를 리턴 설계(재정의 )
		//String 클래스는 Object부모 클래스 toString()상속 관계 재정의...
		
		//정석적인 방법
		String sdata = new String("김유신");
		System.out.println(sdata);
		System.out.println(sdata.toString());
		
		String name="가나다라마";
		//String 내부적으로 char[] member field가 있고 [가][나][다][라][마] 배열의 주소값이 있는거다 
		//class String extends{private char[] str...@Overide toString()}
		
		String str1 ="AAA";
		String str2 ="AAA";
		
		// 문자열의 비교
		System.out.println(str1);
		System.out.println(str2.toString());//toString() 재정의 주소값이 아니고 값이 나온다.
		System.out.println(str1==str2);
		// ==연산자는 값을 비교 str1(주소값), str2(주소값)을 가지고 있는거다
		// 근데 왜 true가 나오지???? 서로 다른 주소값인데???
		//같은 주소 판명
		//** 메모리에 실제로 같은 문자열이 있으면 [재사용]되도록 설계되었다.
		//Point
		System.out.println(str1.equals(str2));//주소를 찾아가서 그 안에 있는 값을 비교
		//==과 equals()의 차이!
		//왜 eqauls()를 써야하는 것인가
		String str3= new String("CCC");
		String str4=new String("CCC");
		
		System.out.println(str3==str4);//
		//왜 false가 나오냐?? new를 쓰면 heap메모리에 다른 객체를 만든다 값이 같아도 다른 메모리에 있는 것이기 때문에 false나오는 것//
		//문자열은 값이 중요하다
		System.out.println(str3.equals(str4));//주소를 찾아가서 그 안에 있는 값을 비교하는 것 값은 같기 때문에 true
		//문자열의 비교는 그.래.서. equals()를 쓰자!
		
		String s= "A";
		s+="B";
		s+="C";
		System.out.println(s);
		
		s= "A";
		//문자열의 누적을 하는 것은 바보다!!
		//
	}

}
