package Day4;

public class String_Class1 {
public static void main(String[] args) {
	String str3="ABCDADDDDDA";
	String result3=str3.replace("DDDDD", "월요일");
	System.out.println(result3);
	
	System.out.println(str3.charAt(2));
	System.out.println(str3.endsWith("DDDA"));
	System.out.println(str3.endsWith("DDDB"));
	System.out.println(str3.equalsIgnoreCase("abCDAdDDDD"));
	
	String str4="슈퍼맨,팬티,노랑색,우하하,우하하";
	String[]namearray= str4.split(",");
	for(String s: namearray) {
		System.out.println(s);
	}
	
	String str5="슈퍼맨.팬ㅌ. 노랑색.우하하.우하하";
	String[]namearray2=str5.split("\\.");
	for(String s : namearray2) {
		System.out.println(s);
	}
		
		
		String filename3 = "kosa.hwp";
		// 파일명과 확장자를 분리
		String[] filearray = filename3.split("\\.");
		for (String w : filearray) {
			System.out.println(w);
		}
		
		String str7="홍    길    동";
		String result10=str7.replace(" ", "");
		System.out.println(result10);
		
		String str8="      홍길동          ";
		System.out.println(str8.trim());
		
		String str9 = "           홍           길         동             ";
		System.out.println(str9.trim().replace(" ", ""));
	
		int sum=0;
		
		String[]numarr= {"1","2","3","4"};
		for(String s: numarr) {
			sum+=Integer.parseInt(s);
			
		}
		System.out.println(sum);
	
	
	
}
}
