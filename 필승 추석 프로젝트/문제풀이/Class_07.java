package q8;
class MyPoint{
	int x; 
	int y;
	MyPoint(int x, int y){
		this.x=x;
		this.y=y;
	}
	double getDistande(int x1, int y1){
		
		return Math.sqrt((x-x1)*(x-x1) + (y-y1)*(x-y1));
		
	}
}
public class Class_07 {
	/*
	 * static double getDistanse(int x, int y, int x1,int y1) { return
	 * Math.sqrt((x-x1)*(x-x1) + (y-y1)*(y-y1)); }
	 */
	public static void main(String[] args) {
//		System.out.println(getDistanse(1, 1, 2, 2));
		MyPoint p= new MyPoint(1,1);
System.out.println(p.getDistande(2,2));
	}

}
