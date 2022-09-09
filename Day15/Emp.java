package kr.or.kosa;

public class Emp {
	private int empno;
	private String name;
	private String job;
	
	public Emp(int empno, String name, String job) {
		super();
		this.empno = empno;
		this.name = name;
		this.job = job;
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

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	@Override
	public String toString() {
		return "Emp [empno=" + empno + ", name=" + name + ", job=" + job + "]";
	}
	
	

}
