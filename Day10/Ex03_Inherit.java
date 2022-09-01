//두개의 설계도
class Tv {
	boolean power;
	int ch;

	void power() {
		this.power = !this.power;// 토글링 : 두개의 기능을 하나의 함수로 처리

	}

	void chup() {
		this.ch++;
	}

	void chDown() {
		this.ch--;
	}
}

class Vcr {// 비디오 플레이어
	boolean power;

	void power() {
		this.power = !this.power;
	}

	void play() {
		System.out.println("재생하기");

	}

	void stop() {
		System.out.println("정지하기");

	}

	void rew() {
	}

	void ff() {
	}
}

// Tv설계도
// Vcr설계도
//
// TvVcr 결합상품을 만들때
//
// class TvVcr extends Tv, Vcr(x) 다중 상속 금지
// 게층적 상속도 조금 이상함(똑같은 자원의 이름이 있어서 어느 하나는 사용을 못한다)
//
// class TvVcr{Tv t; Vcr v;}
//
// 답은 한놈은 상속하고 한놈은 포함
// 어떤 놈을 상속하고 어떤 놈을 포함
// 기준Tv(상속) , Vcr(포함)>>많이 사용
//
// 메인 기능을 누가 가지고 있느냐( 비중)

class TvVcr2 extends Tv {
	Vcr vcr;

	public TvVcr2() {
		vcr = new Vcr();
	}
}

class TvVcr {
	Tv t;
	Vcr v;

	public TvVcr() {
		this.t = new Tv();
		this.v = new Vcr();
	}
}

public class Ex03_Inherit {
	public static void main(String[] args) {
		TvVcr tv = new TvVcr(); //그림
		tv.t.power();
		tv.t.chup();
		System.out.println(tv.t.power);
		
		TvVcr2 tv2= new TvVcr2();//그림
		tv2.power();
		System.out.println("tv전원 : "+tv2.power);
		tv2.chup();

		tv2.vcr.power();
		System.out.println("비디오전원 :"+tv2.vcr.power);
		tv2.vcr.play();
	}
}
