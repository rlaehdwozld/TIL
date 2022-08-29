package Day4;

public class Q2 {
	public static void main(String[] args) {
		int dan=2;
		
		while(dan<10) {
			int gob=1;
			while(gob<10) {
				System.out.printf("[%d}*[%d]=[%d] \n",dan,gob,dan*gob);
				gob++;
			}dan++;
		}
	}

}
