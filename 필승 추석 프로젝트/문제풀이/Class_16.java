package q8;

public class Class_16 {

	public static void main(String args[]) {
		Buyer b = new Buyer();
		b.buy(new Tv());
		b.buy(new Computer());
		b.buy(new Tv());
		b.buy(new Audio());
		b.buy(new Computer());
		b.buy(new Computer());
		b.buy(new Computer());
		b.summary();
	}
}

class Buyer {
	int money = 1000;
	Product[] cart = new Product[3]; // 구입한 제품을 저장하기 위한 배열
	int i = 0; // Product cart index 배열 에 사용될

	void buy(Product p) {
		if(money<p.price) {
			System.out.println("잔액이 부족하셔 "+p+"를 살 수 없습니다.");
			return;
		}
		money-=p.price;
		add(p);
		
		/*
		 * (1) . 아래의 로직에 맞게 코드를 작성하시오 1.1 . 가진 돈과 물건의 가격을 비교해서 가진 돈이 적으면 메서드를 종료한다 1.2 ,
		 * 가진 돈이 충분하면 제품의 가격을 가진 돈에서 빼고 1.3 .(add ) } } void add(Product p) { /* (2) .
		 * 아래의 로직에 맞게 코드를 작성하시오 1.1 i의 값이 장바구니의 크기보다 같거나 크면 1.1.1 2 . 기존의 장바구니보다 배 큰 새로운
		 * 배열을 생성한다 1.1.2 . 기존의 장바구니의 내용을 새로운 배열에 복사한다 1.1.3 . 새로운 장바구니와 기존의 장바구니를 바꾼다
		 * 1.2 (cart) . i 1 . 물건을 장바구니 에 저장한다 그리고 의 값을 증가시킨다
		 */
	} 
	void add(Product p){
		if(i>=cart.length) {
			Product [] tmp= new Product[cart.length];
			System.arraycopy(cart, 0, tmp, 0, cart.length);
			
			cart=tmp;
			}
		cart[i++]=p;
	}

	 void summary() {
		String itemList = "";
		int sum = 0;
		for(int i=0; i < cart.length;i++) {
		if(cart[i]==null)
		break;
		itemList += cart[i] + ",";
		sum += cart[i].price;
		}
		System.out.println(" :"+itemList); 
		System.out.println(" :"+sum); 
		System.out.println(" :"+money);
	} 
}

class Product {
	int price; // 제품의 가격

	Product(int price) {
		this.price = price;
	}
}

class Tv extends Product {
	Tv() {
		super(100);
	}

	public String toString() {
		return "Tv";
	}
}

class Computer extends Product {
	Computer() {
		super(200);
	}

	public String toString() {
		return "Computer";
	}
}

class Audio extends Product {
	Audio() {
		super(50);
	}

	public String toString() {
		return "Audio";
	}
}
