package q8;

class Student{
	String name;
	int ban;
	int no;
	int kor;
	int eng;
	int math;
	
	public Student(String name, int ban, int no, int kor, int eng, int math) {
		super();
		this.name = name;
		this.ban = ban;
		this.no = no;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	}
	void info() {
	
	getTotal();
	getAverage();
	
	}
	int getTotal(){
		
		return (math+eng+kor);
	}
	float getAverage(){
		return (getTotal()/3f*10+0.5f)/10f;
	}
}
public class Class_06 {
	public static void main(String[] args) {
		Student s= new Student("홍길동",1,1,100,60,76);
		System.out.println(s.name);
		System.out.println(s.getAverage());
		System.out.println(s.getTotal());
		
	
	}

}
