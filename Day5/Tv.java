package Day5;

public class Tv {
	/*
	티비는 설계도 요구사항 정의 
	티비는 채널 정보를 가지고 있다 (예를등면 1~299값을 가질 숭 있가)public
	티비는 브랜드 이름을 가지고 있다(예를들면 엘지 삼성)public
	티비는 채널전환기능을 가지고 있가(채널은 한채널씩 이동이 가능하다)
	.->채널을 증가 시키는 기능을 가지고 있다.
	.->채널을 감소시키는 기능을 가지고 있다. 
	티비의 채널정보와 브랜드 이름을 볼 수 있는 기능을 가지고 있다.
*/
	public int ch;//default>0
	public String brandname;
	
	public void ch_Up() {
		ch++;
	}
	public void ch_Down() {
		ch++;
	}
	
	public void tvInfo() {
		System.out.printf(" %s %d  \n",brandname,ch);
		
		
	}
	
}
