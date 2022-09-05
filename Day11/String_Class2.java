package Day4;

public class String_Class2 {
	public static void main(String[] args) {
		
	//QUiz
	/*
	 * String jumin = "123456-1234567"; //위 주민번호의 합을 구하라
	 * 
	 * String[] result=jumin.replace("-", "").split("");
	 * 
	 * int sum=0;
	 * 
	 * for(String i:result) { sum+=Integer.parseInt(i); } System.out.println(sum);
	 */
		String jumin = "123456-1234567"; //위 주민번호의 합을 구하라
		int sum=0;
		for(int i=0;i<jumin.length();i++) {
			String numstr=jumin.substring(i,i+1);
			if(numstr.equals("-"))continue;	
			
				sum+=Integer.parseInt(numstr);
		}
		System.out.println(sum);
	}
}

