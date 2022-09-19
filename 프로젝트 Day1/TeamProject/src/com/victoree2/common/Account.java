
package com.victoree2.common;

import java.io.Serializable;

//계정정보

public class Account implements Serializable{
	private String id; //id
	private String name; //이름
	private String password; //패스워드
	private String birthday; //생일
	private String startday; //가입일
	private String endday; //종료일
	private int status; //계정 상태 (1 : 사용자  0 : 계정 정지  9 : 관리자)
	private static final long serialVersionUID = (long)5746694569156904189.0;
	//serialversionuid 값을 지정을 안하면 로컬과 클라이언트에서 자동으로 생성되는 hash값으로 에러 발생함.
	

	public Account(String id, String name, String password, String birthday, String startday, String endday) {
		this.id = id;
		this.name = name;
		this.password = password;
		this.birthday = birthday;
		this.startday = startday;
		this.endday = endday;
	}
	public Account(String id, String name, String password, String birthday, String startday, String endday, int status) {
		this.id = id;
		this.name = name;
		this.password = password;
		this.birthday = birthday;
		this.startday = startday;
		this.endday = endday;
		this.status = status;
	}
	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}
	public String getPassword() {
		return password;
	}
	public String getBirthday() {
		return birthday;
	}
	public String getStartday() {
		return startday;
	}
	public String getEndday() {
		return endday;
	}
	public int getStatus() {
		return status;
	}

	@Override
	public String toString() {
		return "Account [id=" + id + ", name=" + name + ", password=" + password + ", birthday=" + birthday
				+ ", startday=" + startday + ", endday=" + endday + ", status=" + status + "]";
	}
	
	
	
	
}
