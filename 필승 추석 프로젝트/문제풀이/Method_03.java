package q7;

import java.util.Scanner;

class Plus{
	int sum=0;
	int plus1(int n) {
		for(int i=0;i<=n;i++) {
			
			sum=sum+i;
			
		}return sum;
		
		
	}
	
}
public class Method_03 {
	public static void main(String[] args) {
		System.out.println("hi");
		Plus p= new Plus();
		Scanner sc= new Scanner(System.in);
		int n=sc.nextInt();
		
		System.out.println(p.plus1(n));
	}

}
