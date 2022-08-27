package Day5;
import kr.or.kosa.Fclass;

public class Ex02_Method_Call {

	public static void main(String[] args) {
		//Fclass생성 ... 메모리에 올려야한다(객체를 생성해야한다)
		Fclass fclass = new Fclass();
		fclass.m(); //fclass의 변수중 m이라는 메서드를 호출한것
		
		fclass.m2(100);
		
		fclass.m3();//리턴값을 안받아도 상관은 없음
		 int result = fclass.m3();
		 System.out.println("m3 함수 호출시 돌려받은 값 : "+result);
		 
		 int result2 = fclass.m4(100);
		 System.out.println("m4함수 호출시 돌려받은 값 : "+ result2);
		 
		 result2 = fclass.sum(11, 1, 12);
		 System.out.println("sum: "+result2);
		 
		 fclass.callSubSum();
		 
		 result2=fclass.opSum(1000);
		 System.out.println("opSum함수 호출시 돌려받은 값 :"+result2);
		 
		 
		 result2= fclass.bigger(10, 20);
		 System.out.println("더 큰 함수는 "+result2+"이다");
		
	}

}
