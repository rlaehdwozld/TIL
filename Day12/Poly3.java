package Day4;

/*시나리도(요구사항)
저희는 가전제품 매장 솔루션을 개발하는 사업팀입니다.
A라는 전자제품 매장이 오픈되면 

[클라이언트 요구사항]
가전제품은 제품의 가격, 제품의 포인트 정보를 모든 제품이 가지고 있다. 
각각의 가전제품은 제품별 고유한 이름 정보를 가지고 있다. 
ex)
각각의 전자제품은 이름을 가지고 있다(ex) Tv, Audio, Computer
각각의 전자제품은 다른 가격정보를 가지고 있다.( TV : 5000, Audio : 6000)
제품의 포인트는 가격의 10% 적용한다.

시뮬레이션 시나리오
구매자 : 제품을 구매하기위해서 금액정보, 포인트 정보를 가지고 있다. 
ex)10만원, 포인트 0
구매자는 제품을 구매할 수 있다., 구매행위를 하게되면 가지고 있는 돈은 감소하고( 가격) 포인트는 증가한다. 
구매자는 처음에 초기금액을 가질 수 있다. 



1차 오픈 ....
하와이 휴가....

공식 오픈 
매장에 제품 1000개 다른 제품이 추가(마우스, 토스트기) 제품 등록 POS(자동등록)
매장에 1000개의 제품이 전시(Product 상속하는 제품)
1. 매장에서 3개의 제푸만 구매 가능 나머지 997개의 제품에 대한 구매기능이 없다. 
>>pc 방 >> 국내 전산망>> 개발 서버 접속>>997개를 구매할 수 있는 함수를 추가해야한다. 

개발자의 실수 : 변화에 대응하는 코드를 짜지 않음 (다형성 결핍) 

즐거운 휴가를 보내기 위한 방법 제시( 제품이 100000개 추가되더라도)
1. 함수의 paramter 를 부모 (Product)  */
class Product {
	int price ;
	int bonusnum;
	
	
	Product(int price){
		this.price=price;
		this.bonusnum=(int)(this.price/10);
		
	}
}

class KtTv2  extends Product{

	KtTv2(){
		super(500);
	}

	// 이름
	@Override
	public String toString() {
		return "KtTv2";
	}
}

class Audio2  extends Product{
	Audio2(){
		super(1000);
	}

	@Override
	public String toString() {
		return "Audio2";
	}
}

class NoteBook2 extends Product {
NoteBook2(){
	super(2000);
}
	

	// 이름
	@Override
	public String toString() {
		return "NoteBook2";
	}
}

//구매자
class Buyer {
int money=5000;
int bonusnum;
		
void Buy(Product n){
	if(n.price>this.money) {
		System.out.println("고객님 돈이 부족합니다.");
		return;
	}
	this.money-=n.price;
	this.bonusnum+=n.price/10;
	System.out.println("구매 완료: "+n.toString());
	}

}

public class Poly3 {
	public static void main(String[] args) {
		KtTv2 kt = new KtTv2();
		Buyer buyer = new Buyer();
		Audio2 audio=new Audio2();
		NoteBook2 notebook= new NoteBook2();
		
buyer.Buy(kt);
buyer.Buy(audio);
buyer.Buy(notebook);
buyer.Buy(kt);
buyer.Buy(kt);
buyer.Buy(kt);
buyer.Buy(kt);
buyer.Buy(kt);

buyer.Buy(kt);
buyer.Buy(kt);

buyer.Buy(kt);
buyer.Buy(kt);

		
	}

}
