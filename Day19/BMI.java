package kr.or.data.object;


import java.io.Serializable;
import java.util.Scanner;


public class BMI implements Serializable{
	private double length = 0;
	private double weight = 0;
	private double result = 0;
	private String you = null;
	
	public BMI input(BMI bmi){
		Scanner scan = new Scanner(System.in);
		System.out.print("키를 입력하세요 : ");
		this.length = scan.nextInt();
		System.out.print("몸무게를 입력하세요 : ");
		this.weight = scan.nextInt();
		this.result = this.weight/((this.length/100.0)*(this.length/100.0));
		if(this.result<18.5){
			this.you = "체중 부족";
		}else if(18.5<=this.result && this.result<=22.9){
			this.you = "정상";
		}else if(23.0<=this.result && this.result<=24.9){
			this.you = "과체중";
		}else if(25.0<=this.result){
			this.you = "비만";
		}
		return bmi;
	}

	public double getLength() {
		return length;
	}

	public void setLength(double length) {
		this.length = length;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public double getResult() {
		return result;
	}

	public void setResult(double result) {
		this.result = result;
	}

	public String getYou() {
		return you;
	}

	public void setYou(String you) {
		this.you = you;
	}

	@Override
	public String toString() {
		return length+"\t"+weight+"\t"+result+"\t"+you;
	}
	
	
}//class