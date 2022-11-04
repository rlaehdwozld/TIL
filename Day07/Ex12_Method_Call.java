/*
 함수 사용시 parameter값을 전달 ,주소 전달
 void m (int x){}  >> x변수는 값을 받는다.
 int y = 200;
 호출 m(y);
 
 y=1000;변경....
 
 call by value
 -----------------------------------------
 void m2(Car c)	{c.color="red";} >> c변수는 주소를 받는다. 메모리에 있는 Car의 주소값을 줘야하는데 주소가 없으면
 
 Car c2=new Car();//메모리에 올리고
 호출 m(c2);//같은 타입의 주소값을 전달한다(Today Point)!!!!!!!!!!!!!!!!!!!!!★★★★★★★★★★★
 
 call by ref
 */



class Data{
	int i;
	int e;
}


public class Ex12_Method_Call {
	static void scall(Data sdata) {//default static
		System.out.println("함수 : "+sdata.e);
		sdata.i=111;//0xA번지 i을값111로
		
	}
	static void vcall(int x) {//default static
		System.out.println("before x "+x);
		x=8888;
		System.out.println("after x : "+x);
	}

	public static void main(String[] args) {
		Data d=new Data();//d의 주소값 0xA번지....
		d.i =100;
		System.out.println("d.i : "+d.i);
		
//		scall(d);//주소값 전달(0xA번지
//		
//		System.out.println("after d.i :"+d.i); ///111
		///////////////////////////////////////////////////
		vcall(d.i); //값만 전달(100)
		System.out.println("d.i "+d.i);//값은 변경되지 않아요
		//책에서 call by value, call by ref를 찾자

	}

}
