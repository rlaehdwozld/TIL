package 명품자바;



class Tv{
	
	int year; 
	int inch;
	String name;
	
	

	Tv(String name, int year, int inch)	{
		this.name=name;	
		this.year=year;
		this.inch=inch;
		
	}
	
	public void show() {
		System.out.printf("%s에서 만든 %d년형%d인치Tv",name,year,inch);
	}
	
}
public class Class_1 {
	public static void main(String[] args) {
		
	Tv myTv = new Tv("LG",2017,32);//LG에서 만든 2017년 32인치
	myTv.show();

	}
}
