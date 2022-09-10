package q6;

public class Array_02 { 
	public static void main(String[] args) {
		double [] di = new double[5];
		for(int i = 0; i<di.length;i++) {
			di[i]=di.length-i;
			System.out.println(di[i]);
		}
		
	}

}
