import java.util.Properties;

/*
Map 인터페이스 구현한 클래스
특수한 목적 : <String><String> key 와 value타입이 고정되어 있는 클래스가 바로  properties다.
//제네릭 타입을 적지 않아도 String String이다.
사용 목적
1.App 전체에 사용되는 자원 관리
2. 환경변수
3. 프로그램 버전
4. 파일 경로
5. 공통 변수

*/
public class Ex17_Properties {
public static void main(String[] args) {
	Properties prop = new Properties();
	prop.setProperty("admin", "kosa@or.kr");
	prop.setProperty("version", "1.x.x.x");
	prop.setProperty("downpath", "C:\\Temp|images");
	//각각의 개발 페이지에서 
	System.out.println(prop.getProperty("admin"));
	System.out.println(prop.getProperty("version"));
	System.out.println(prop.getProperty("downpath"));
	
}
}
