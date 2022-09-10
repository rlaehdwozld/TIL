package q6;

public class Array_03 {
	public static void main(String[] args) {
		double []di = new double[5];
		for(int i=0;i<di.length;i++) {
			
			di[i]=(i+1)*1.1;
		}
		for(double j :di) {
			System.out.println(j);
		}
	}

}
