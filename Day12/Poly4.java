package Day4;
class Product2{
	int price;
	int bonuspoint;
	//Product(){}
	Product2(int price){
		this.price = price;
		this.bonuspoint = (int)(this.price/10.0);
	}
}

class KtTv3 extends Product2{
	KtTv3(){
		super(500);
	}
		
	//이름
	@Override
	public String toString() {
		return "KtTv3";
	}
}

class Audio3 extends Product2{
	Audio3(){
		super(100);
	}
	
	@Override
	public String toString() {
		return "Audio3";
	}
}

class Buyer2{
	int money =5000;
	int bonuspoint;
	
	Product2[]cart;
	int index=0;
	
	Buyer2(){
		this(1000,0);
	}
	Buyer2(int money, int bonuspoint){
		cart=new Product2[10];
		this.money=money;
		this.bonuspoint=bonuspoint;
	}
	void Buy(Product2 n) { //함수의 parameter 제품객체의 주소를 받아서 ..(가격,포인트)
		if(this.money < n.price) {
			System.out.println("고객님 잔액이 부족합니다^^! " + this.money);
			return; //kttvBuy 함수 종료
		}
	

		if(this.index>=10) {
			System.out.println("고객님 그만사세요");
			return;
		}
		
		cart[index++]=n;
		
		this.money-=n.price;
		this.bonuspoint+=n.bonuspoint;
		System.out.println("구매한 물건은 :"+n.toString());
		System.out.println("잔액"+this.money);
		System.out.println("포인트 :"+this.bonuspoint);
	}
	
	void summery() {
		int totalprice=0;
		int totalbonuspoint=0;
		String productlist="";
		
		for(int i=0;i<index;i++) {
			totalprice+=cart[i].price;
			totalbonuspoint+=cart[i].bonuspoint;
			productlist+=cart[i].toString();
		}
		System.out.println("***********");
		System.out.println("구매한 물건 총액: " + totalprice);
		System.out.println("포인트 총액: " + totalbonuspoint);
		System.out.println("구매한 물건 목록: " + productlist+" ");
	}
}
public class Poly4 {
public static void main(String[] args) {
	KtTv3 tv2 = new KtTv3();
	Audio3 audio2 = new Audio3();
	
	
	Buyer2 buyer2 = new Buyer2(5000,0);
	
	
	buyer2.Buy(tv2);
	buyer2.Buy(tv2);
	buyer2.Buy(tv2);
	buyer2.Buy(audio2);
	buyer2.Buy(audio2);
	buyer2.summery();
}
}
