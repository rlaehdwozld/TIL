package Day5;

//객체지향 언어는 (캡슐화, 은닉화 : 직접적으로 값을 변경하거나 쓰는것을 방지하는 것 방지)
//year 마이너스값을 넣지마 부탁
//설계자 >> 다 막아버릴꺼야>> 사용불가\간접적으로 사용가능 ...>>누군가를 통해서 read, write하게 하겠다.
//간접>> 개발자가 논리를 통해서 제어하겠다.
//
public class NoteBook {
	
	//public Mouse mouse=new Mouse();//Mouse 라는 타입은 클래스>>참조변수 mouse>> 주소값
	//노트북하고 마우스는 별개의 상품인데 노트북이 실행되지 않으면 마우스는 만들어질 수 없다.
	
	
	//노트북은 마우스를 가지고 있다.
	//마우스>>휠, 버튼 2개, 좌표값.....
	//부품정보...(엔진, 타이어)
	//마우스도 설계도가 있어야한다.(class)
	public String color;
	
	
	//약속 캡슐화 (read, write함수)>>표준화>> getYear..,setYear>>setter,getter
	
	private int year;
	public void setYear(int data) {//간접할당 장점 (내가 원하는 대로)강제할 수 있다. 개발자가 연도에 마이너스 값을 넣을 수 있는 것을 간접적로 방지하는 효과가 있다.
		if(data<0)	{
			year=1999;
			
		}else {
			year=data;
	}
		}
	// year read 함수
		public int getYear() {//간접적으로 year member field값을 return
			return year;
		
	}
		
		public int number;
		//노트북 필요에 따라서 마우스를 가질 수 있다.
		// 가진다의ㅣ : 생성된 객체의 주소를 가진다.
		
		public void handle(Mouse m) {
			m.x=100;
			m.y=200;
		}

	

}
