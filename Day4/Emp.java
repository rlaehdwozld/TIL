package kr.or.kosa;

public class Emp {
	
	
	//member field(instance variable)
	private int empno;
	private String ename;
	private String job;
	private int sal;
	
	//setter, getter method(read, write)기능
	public int getEmpno() {
		return empno;
	}
	public void setEmpno(int empno) {
		this.empno = empno;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public int getSal() {
		return sal;
	}
	public void setSal(int sal) {
		this.sal = sal;
	}
	
		public void empDataPrint(){
		System.out.println("사원 데이터 출력");
		//method(main함수)
		//함수안에 있는 변수는 지역변수라서 접근자를 붙이지 않는다. 
		int data= 0;//local variable
		int input = 0;
		
		}
		
	

}
