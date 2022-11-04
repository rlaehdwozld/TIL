package Day5;
import kr.or.kosa.Person;

public class Ex01_Ref_Type {
	public static void main(String[] args) {
		//kr.or.kosa안에 있는 person설계도를 가지고 구체화
		//메모리에 올려서 생섯
		
		Person man =new Person();
		System.out.println(man.name);//NULL
		System.out.println(man.age);//age=0
		System.out.println(man.power);//false
		
		Person man2=new Person();
		man2.age=100;
		man2.name="홍길동";
		man2.power=true;
		man2.pesronPrint();
	}

}
