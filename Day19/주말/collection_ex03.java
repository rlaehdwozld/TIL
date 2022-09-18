package prac_1;

import java.util.ArrayList;



class Emp{
	int num;
	String name;
	String job;
	public Emp(int num, String name, String job) {
		super();
		this.num = num;
		this.name = name;
		this.job = job;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	@Override
	public String toString() {
		return "Emp [num=" + num + ", name=" + name + ", job=" + job + "]";
	}
	
	
}
public class collection_ex03 {
	
	public static void main(String[] args) {
		
	Emp emp = new Emp(1000,"김유신","장군");
	System.out.println(emp.toString());
	
	Emp[]emplist = {new Emp(100,"r","re"),new Emp(1000,"r","re")};
	for(Emp i:emplist) {
		System.out.println(i.toString());
	}
	
	
	ArrayList elist = new ArrayList();
	elist.add(new Emp(100, "김씨", "영업"));
	elist.add(new Emp(200, "박씨", "IT"));
	elist.add(new Emp(300, "이씨", "영업"));
	for (int i = 0; i < elist.size(); i++) {
		System.out.println(elist.get(i));
		
		
	}
	
	for(int i=0;i<elist.size();i++) {
		Object obj=elist.get(i);
		Emp e=(Emp)obj;
		System.out.println(e.getNum()+","+e.getName()+","+e.getJob());
	}
	
	ArrayList<Emp>list2 = new ArrayList<Emp>();
	//list2.add(emp);
	list2.add(new Emp(1, "a", "IT"));
	for(Emp e : list2) {
		System.out.println(e.getNum());
	}
	}
	
	

}
