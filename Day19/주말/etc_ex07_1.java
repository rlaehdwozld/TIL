package 주말;

public class etc_ex07_1 {
	public static void main(String[] args) {
		
		  String jumin="123456-1234567";
		   //위 주민번호의 합을 구하세요_1
		  
		  int sum = 0;
		  for(int i =0;i<jumin.length();i++) {
			  String numstr = jumin.substring(i,i+1);
			  if(numstr.equals("-")) {
				  continue;
			  }
			  sum+=Integer.parseInt(numstr	);
		  }System.out.println(sum);
		  
			/*
			 핵심 substring에 대한 이해
			 "-"를 빼야하는 데 조건문으로 연산을 건너띄어줌
			 */
		  
		  String[] numarr2 = jumin.replace("-","").split("");
		  int sum1 = 0;
		  for(String i:numarr2) {
			  sum1+=Integer.parseInt(i);
		  }
		  System.out.println(sum1);
			/*
			 핵심
			 1. String 클래스를 활용해서 모든 String 값을 배열에 담는다.
			 2. "-"는 ""로 replace해준다.
			 3. 합쳐져있는 String 값은 split으로 쪼개준다.""
			 4. 향상된 for문을 활용해 전부 합쳐준다.
			*/
		  
		  String jumin1=jumin.replace("-", "");
		  int sum2=0;
		  for(int i=0;i<jumin1.length();i++) {
			  sum2+=Integer.parseInt(String.valueOf(jumin1.charAt(i)));
		  }System.out.println(sum2);
			/*
			 핵심
			 1. 메소드 체인 기법을 활용한다.
			 valueof위의 valueOf() 메소드는 ()괄호 안의 해당 객체를 String 객체로 변환시키는 역활을 합니다. 
			 말그대로 String의 객체로 형변환입니다. 
			예를들어 정수인 int a=5; 라면 이것을 String의 객체로 표현하고 싶으면 valueOf(5); 
			를 이용하면 5라는 정수는 String이라는 "5" 로 인식하게 됩니다.
 				이렇듯 어떤 객체를 String으로 형변환하는 valueOf() 메소드입니다.
			*/
	}
	

}
