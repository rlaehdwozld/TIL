package kr.or.kosa;
//디자인 패턴(생성패턴) >> new

//싱글톤 ...(객체 하나를 만들어 공유)
//의도 : 하나의 객체를 공유하는 보장 코드...

//공유 IP
//공유 프린터
//설계할때....

public class Singleton {
	private static Singleton p;//p라는 변수가 주소를 가지게... new
	private Singleton() {
		//생성자에서 전근자 private ... 생성자 함수 호출 못하니 객체 생성 불가 new...
		
		
	}
	public static Singleton getInstance() {
		if(p==null) {
			p=new Singleton();
		}
		return p;
	}
	

}
