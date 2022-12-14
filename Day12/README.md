# 2022.09.05 월요일 못먹어도 고!

### 다형성

다형성( 상속관계에서 존재)  
다형성 : 여러가지 성질(형태) 가질 수 있는 능력

c# :다형성 (Overloading, override)

JAVA : [상속 관계]에서 [하나의 참조변수]가 [여러개의 타입]을 가질 수 있는 것  
[하나의 참조변수] : 부모 타입  
[여러개의 타입] : 부모를 상속 받은 자식

다형성 : 현실 >> 부모는 자식에게 모든 것을 준다.  
프로그램 >> 자식이 부모에게 조건없이 드린다.

```java
class Tv2{
	boolean power;
	int ch;

	void power() {
		this.power= !this.power;
	}
	void chUp() {
		this.ch++;
	}

	void chDown() {
		this.ch--;
	}
}
	class CapTv extends Tv2{//CapTv특수화, 구체화, 고유한
		String text;
		String captionText() {
			return this.text="현재 자막 처리중";
		}

	}

public class Ex10_Inherit_Poly {
	public static void main(String[] args) {


		CapTv ct=new CapTv();
		ct.power();
		ct.chUp();
		ct.captionText();
		System.out.println(ct.captionText());

///////////////////////////////////////////////////////////
		Tv2 tv2 = ct;
		//상속 관계에서 [부모타입]은 [자식타입]의 주소를 가질 수 있다.
		//단 부모는 자신의 자원만 접근 가능하다.
		// 단 재정의는 제외하고....

		System.out.println(ct.toString());//
		System.out.println(tv2.toString());//

		//tv2.captionText()  //자식자원은 접근 불가(부모타입의 자원 접근)
									 //단 재정의는 제외하고

	}

}
```

```java
class Pbase{
	int p=100;
}
class Cbase extends Pbase{
	int c=200;
}

class Dbase extends Pbase{

}
public class Ex11_Inherit_Poly {

	public static void main(String[] args) {

Cbase cbase = new Cbase();
System.out.println(cbase.toString());

Pbase p=cbase;//상속 관계에서 부모타입의 변수는 자식타입의 주소를 가질 수 있다.


Dbase dbase= new Dbase();


p=dbase;//다형성
//부모타입의 참조변수가 어떨 때는 dbase 어떨때는 cbase-->다형
System.out.println(p.toString());

Cbase c=(Cbase)p;//down(부모 > 자식으로)
	}

}

```

### 예제

시나리도(요구사항)  
저희는 가전제품 매장 솔루션을 개발하는 사업팀입니다.  
A라는 전자제품 매장이 오픈되면

클라이언트 요구사항  
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
매장에서 3개의 제푸만 구매 가능 나머지 997개의 제품에 대한 구매기능이 없다.  
pc 방 >> 국내 전산망>> 개발 서버 접속>>997개를 구매할 수 있는 함수를 추가해야한다.

개발자의 실수 : 변화에 대응하는 코드를 짜지 않음 (다형성 결핍)

즐거운 휴가를 보내기 위한 방법 제시( 제품이 100000개 추가되더라도)  
함수의 paramter 를 부모 (Product)

```java
class Product{
	int price;
	int bonuspoint;
	//Product(){}
	Product(int price){
		this.price = price;
		this.bonuspoint = (int)(this.price/10.0);
	}
}

class KtTv extends Product{
	KtTv(){
		super(500);
	}
	//KtTv(int price){
	//	super(price);
	//}

	//이름
	@Override
	public String toString() {
		return "KtTv";
	}
}

class Audio extends Product{
	Audio(){
		super(100);
	}

	@Override
	public String toString() {
		return "Audio";
	}
}


class NoteBook extends Product{
	NoteBook(){
		super(150);
	}
	//이름
	@Override
	public String toString() {
		return "NoteBook";
	}
    	void Buy(Product n) { //함수의 parameter 제품객체의 주소를 받아서 ..(가격,포인트)
		if(this.money < n.price) {
			System.out.println("고객님 잔액이 부족합니다^^! " + this.money);
			return; //kttvBuy 함수 종료
		}
		//실 구매행위
		this.money -= n.price;
		this.bonuspoint += n.bonuspoint;
		System.out.println("구매한 물건은 : " + n.toString());
	}
}

public class Ex12_Inherit_keyPoint_Poly {

	public static void main(String[] args) {
		//매장이라고 가정하고
		//KtTv kt = new KtTv();
		//System.out.println(kt.price);
		//System.out.println(kt.bonuspoint);
		//System.out.println(kt);

		KtTv kt = new KtTv();
		Audio audio = new Audio();
		NoteBook notebook = new NoteBook();

		Buyer buyer = new Buyer();
		/*
		buyer.kttvBuy(kt);
		buyer.kttvBuy(kt);
		buyer.NoteBookBuy(notebook);
		buyer.kttvBuy(kt);
		buyer.kttvBuy(kt);
		buyer.kttvBuy(kt);
		buyer.kttvBuy(kt);
		buyer.kttvBuy(kt);
		buyer.kttvBuy(kt);
		buyer.kttvBuy(kt);
		buyer.kttvBuy(kt);
		buyer.kttvBuy(kt);
		buyer.kttvBuy(kt);
		buyer.kttvBuy(kt);
		*/
		buyer.Buy(kt);
		buyer.Buy(kt);
		buyer.Buy(notebook);
		buyer.Buy(kt);
		buyer.Buy(kt);
		buyer.Buy(kt);
		buyer.Buy(kt);
		buyer.Buy(kt);

	}

}
}

//구매자
class Buyer{
	int money = 5000;
	int bonuspoint;
```

```java
구매자 구매행위 (기능 : method)
	//구매행위 (구매자의 잔액에서 - 제품의 가격 , 포인트 정보 갱신 +)
	//**구매자는 매장에 있는 모든 전자제품을 구매할 수 있다 ** 3개 구매가능
	void kttvBuy(KtTv n) { //함수의 parameter 제품객체의 주소를 받아서 ..(가격,포인트)
		if(this.money < n.price) {
			System.out.println("고객님 잔액이 부족합니다^^! " + this.money);
			return; //kttvBuy 함수 종료
		}
		//실 구매행위
		this.money -= n.price;
		this.bonuspoint += n.bonuspoint;
		System.out.println("구매한 물건은 : " + n.toString());
	}
	void AudioBuy(Audio n) { //함수의 parameter 제품객체의 주소를 받아서 ..(가격,포인트)
		if(this.money < n.price) {
			System.out.println("고객님 잔액이 부족합니다^^! " + this.money);
			return; //kttvBuy 함수 종료
		}
		//실 구매행위
		this.money -= n.price;
		this.bonuspoint += n.bonuspoint;
		System.out.println("구매한 물건은 : " + n.toString());
	}

	void NoteBookBuy(NoteBook n) { //함수의 parameter 제품객체의 주소를 받아서 ..(가격,포인트)
		if(this.money < n.price) {
			System.out.println("고객님 잔액이 부족합니다^^! " + this.money);
			return; //kttvBuy 함수 종료
		}
		//실 구매행위
		this.money -= n.price;
		this.bonuspoint += n.bonuspoint;
		System.out.println("구매한 물건은 : " + n.toString());
	}

	*/
	//1차 개선
	//하나의 이름으로 여러가지 기능(method overloading)
	/*
	void Buy(KtTv n) { //함수의 parameter 제품객체의 주소를 받아서 ..(가격,포인트)
		if(this.money < n.price) {
			System.out.println("고객님 잔액이 부족합니다^^! " + this.money);
			return; //kttvBuy 함수 종료
		}
		//실 구매행위
		this.money -= n.price;
		this.bonuspoint += n.bonuspoint;
		System.out.println("구매한 물건은 : " + n.toString());
	}
	void Buy(Audio n) { //함수의 parameter 제품객체의 주소를 받아서 ..(가격,포인트)
		if(this.money < n.price) {
			System.out.println("고객님 잔액이 부족합니다^^! " + this.money);
			return; //kttvBuy 함수 종료
		}
		//실 구매행위
		this.money -= n.price;
		this.bonuspoint += n.bonuspoint;
		System.out.println("구매한 물건은 : " + n.toString());
	}

	void Buy(NoteBook n) { //함수의 parameter 제품객체의 주소를 받아서 ..(가격,포인트)
		if(this.money < n.price) {
			System.out.println("고객님 잔액이 부족합니다^^! " + this.money);
			return; //kttvBuy 함수 종료
		}
		//실 구매행위
		this.money -= n.price;
		this.bonuspoint += n.bonuspoint;
		System.out.println("구매한 물건은 : " + n.toString());
	}
	*/

	//2차개선
	//제품이 추가 되더라도 구매행위는 계속 되어야 한다
	//하나의 이름 , 중복되는 코드 (중복코드 제거)
	//모든 제품은 Product상속 >> 부모타입의 참조변수는 자식객체의 주소를 받을 수 있다
```

### 카트 추가문제

문제 풀어 보세요 ^^  
요구사항  
카트 (Cart)  
카트에는 매장에 있는 [모든 전자제품]을 담을 수 있다  
카트의 크기는 고정되어 있다 (10개) : 1개 , 2개 담을 수 있고 최대 10개까지 담을 수 있다  
고객이 물건을 구매 하면 ... [카트에 담는다]

계산대에 가면 전체 계산  
계산기능이 필요  
summary() 기능 추가해 주세요  
당신이 구매한 물건이름 과 가격정보 나열  
총 누적금액 계산 출력

hint) 카트 물건을 담는 행위 (Buy() 함수안에서 cart 담는 것을 구현 )  
hint) Buyer ..>> summary() main 함수에서 계산할때

구매자는 default 금액을 가지고 있고 초기금액을 설정할 수 도 있다

```java
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
```

### Singleton

싱글톤(Singleton) 패턴이란?  
객체의 인스턴스가 오직 1개만 생성되는 패턴을 의미한다.  
가장 먼저 떠올릴 수 있는 이점은 아무래도 메모리 측면일 것이다. 최초 한번의 new 연산자를 통해서 고정된 메모리 영역을 사용하기 때문에 추후 해당 객체에 접근할 때 메모리 낭비를 방지할 수 있다. 뿐만 아니라 이미 생성된 인스턴스를 활용하니 속도 측면에서도 이점이 있다고 볼 수 있다.

또다른 이점은 다른 클래스 간에 데이터 공유가 쉽다는 것이다. 싱글톤 인스턴스가 전역으로 사용되는 인스턴스이기 때문에 다른 클래스의 인스턴스들이 접근하여 사용할 수 있다. 하지만 여러 클래스의 인스턴스에서 싱글톤 인스턴스의 데이터에 동시에 접근하게 되면 동시성 문제가 발생할 수 있으니 이점을 유의해서 설계하는 것이 좋다.

디자인 패턴(생성패턴) >> new

싱글톤 ...(객체 하나를 만들어 공유)  
의도 : 하나의 객체를 공유하는 보장 코드...

공유 IP  
공유 프린터  
설계할때....

```java
public class Ex14_Singleton_main {
	public static void main(String[] args) {
		//Singleton singleton = new Singleton();
		Singleton s = Singleton.getInstance();
		System.out.println(s);
		Singleton s2 = Singleton.getInstance();
		System.out.println(s2);
		Singleton s3 = Singleton.getInstance();
		System.out.println(s3);
	}

}

public class Singleton {
	private static Singleton p;//p라는 변수가 주소를 가지게... new
	private Singleton() {
		//생성자에서 전근자 private ... 생성자 함수 호출 못하니 객체 생성 불가 new...


	}
	public static Singleton getInstance() {
		if(p==null) {
			p=new Singleton();
		}
		return p;
	}


}

```
