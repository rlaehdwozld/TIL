package Day8;

//설계도	
public class Emp {
	private int empno;
	private String name;
	
	//public Emp() {}
	public Emp(int empno, String name) {

		this.empno = empno;
		this.name = name;
	}

	public int getEmpno() {
		return empno;
	}

	public void setEmpno(int empno) {
		this.empno = empno;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	//기능 출력
	public void empInfoPrint() {
		System.out.println(this.empno+"/"+this.name);
	}
	

}
