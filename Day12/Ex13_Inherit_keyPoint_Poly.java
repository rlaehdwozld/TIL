/*
문제 풀어 보세요 ^^
요구사항
카트 (Cart)
카트에는 매장에 있는 [모든 전자제품]을 담을 수 있다 
카트의 크기는 고정되어 있다 (10개) : 1개  , 2개 담을 수 있고 최대 10개까지 담을 수 있다
고객이 물건을 구매 하면 ... [카트에 담는다]
---------------------------------------
계산대에 가면 전체 계산
계산기능이 필요
summary() 기능 추가해 주세요
당신이 구매한 물건이름 과 가격정보 나열
총 누적금액 계산 출력

hint) 카트 물건을 담는 행위 (Buy() 함수안에서 cart  담는 것을 구현 )
hint) Buyer ..>> summary()  main 함수에서 계산할때

구매자는 default 금액을 가지고 있고 초기금액을 설정할 수 도 있다
*/
class Product2{
	int price;
	int bonuspoint;
	//Product(){}
	Product2(int price){
		this.price = price;
		this.bonuspoint = (int)(this.price/10.0);
	}
}

class KtTv2 extends Product2{
	KtTv2(){
		super(500);
	}
		
	//이름
	@Override
	public String toString() {
		return "KtTv2";
	}
}

class Audio2 extends Product2{
	Audio2(){
		super(100);
	}
	
	@Override
	public String toString() {
		return "Audio2";
	}
}

class Buyer2{
	int money = 5000;
	int bonuspoint;
	//////////////////////////////////////////////////////
	//장바구니(카트) 생성하기 (모든 전자제품을 담을 수 있다) : 10개
	Product2[] cart;
	int index=0;
	//////////////////////////////////////////////////////
	Buyer2() {
		this(1000,0);
	}
	Buyer2(int money , int bonuspoint){
		//초기화
		cart = new Product2[10]; //카드 초기화  (POINT)
		this.money = money;
		this.bonuspoint = bonuspoint;
	}
	
	
	
	
	
	void Buy(Product2 n) { //함수의 parameter 제품객체의 주소를 받아서 ..(가격,포인트)
		if(this.money < n.price) {
			System.out.println("고객님 잔액이 부족합니다^^! " + this.money);
			return; //kttvBuy 함수 종료
		}
		//cart 담기
		//방어적인 코드//////////////////////////////////////////////
		if(this.index >= 10) {
			System.out.println("고객님 그만 사세요 ^^");
			return;
		}
		cart[index++] = n;  //0번 index 담고  후치증가 index=1 ....
		////////////////////////////////////////////////////////
		
		//실 구매행위
		this.money -= n.price;
		this.bonuspoint += n.bonuspoint;
		System.out.println("구매한 물건은 : " + n.toString());
		System.out.println("잔액 : " + this.money);
		System.out.println("포인트 : " + this.bonuspoint);
	}
	
	// 계산대(장바구니)
	// 물건을 계산 
	// 물건의 가격 , 이름
	// 총 구매가격
	void summery() {
		int totalprice=0;
		int totalbonuspoint=0;
		String productlist=""; //누적 (StringBuffer ...)
		/*
		for(int i = 0 ; i < cart.length ;i++) {  //물건이 없으면 null 연산 예외
			//다행이도 10개 샀으면 ...
			if(cart[i] == null) break; //랜덤 continue
			totalprice += cart[i].price;
			totalbonuspoint += cart[i].bonuspoint;
			productlist+= cart[i].toString()+ " ";
		}
		*/
		for(int i = 0 ; i < index ;i++) {
			totalprice += cart[i].price;
			totalbonuspoint += cart[i].bonuspoint;
			productlist+= cart[i].toString()+ " ";
		}
		
		System.out.println("***********");
		System.out.println("구매한 물건 총액: " + totalprice);
		System.out.println("포인트 총액: " + totalbonuspoint);
		System.out.println("구매한 물건 목록: " + productlist);
	}
}

class NoteBook2 extends Product2{
	NoteBook2(){
		super(150);
	}
	//이름
	@Override
	public String toString() {
		return "NoteBook2";
	}
}
public class Ex13_Inherit_keyPoint_Poly {

	public static void main(String[] args) {
		KtTv2 tv2 = new KtTv2();
		Audio2 audio2 = new Audio2();
		NoteBook2 notebook2 = new NoteBook2();
		
		Buyer2 buyer2 = new Buyer2(5000,0);
		
		buyer2.Buy(notebook2);
		buyer2.Buy(notebook2);
		buyer2.Buy(tv2);
		buyer2.Buy(tv2);
		buyer2.Buy(tv2);
		buyer2.Buy(audio2);
		buyer2.Buy(audio2);
		buyer2.summery();

	}

}