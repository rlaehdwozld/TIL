package Day4;

public class Gugudan2 {

	public static void main(String[] args) {
		int i=2;
		int j= 1;
		while(i<=9){
			 j=1;
			 System.out.println(i+"단 시작");
			 while(j<=9) {
				 System.out.println(i+"*"+j+"="+(i*j));
				 j++;
			 }System.out.println(i);
			 i++;
		}
		

	}

}
