package 명품자바;

import java.util.Scanner;

class Day{
	private String work;//하루의 할일을 나타내는 문자열
	public void set(String work){
		this.work=work;
	}
	public String get() {
		return work;
	}
	public void show() {
		if( work==null) {
			System.out.println("없습니다.");}
		else{
			System.out.println(work+"입니다");
				
			}
		
	}
}
class MonthSchedule{
	Scanner sc = new Scanner(System.in);
	
	int []day = new int[29];
	public MonthSchedule(int day) {
	}
	void input() {
		
	}
	void view() {
		
	}
	void finish() {
		
	}
	void run() {
		System.out.println("이번ㄴ달 스케쥴 관리 프로그램");
		
		
	}
}
public class Class_7 {

}
