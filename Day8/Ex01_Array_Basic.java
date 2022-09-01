import java.lang.reflect.Array;
import java.util.Arrays;

/*
 배열에 대해서 알아보자
 
 배열은 객체다.(Array)
 1. new를 통해서 생성해야한다.
 2. heap메모리에 생성된다. 가비지 컬렉터에서 관리되는 자원이기떄문에 명시적으로 해제해야하는 것은 아니다.
 3. 고정 배열(정적배열) : 배열을 한번 선언하면 (크기가 정해지면) 변경 불가<--->collection(동적)
 4. 자료구조 (알고리즘) 기초적인 학습
 
 */
public class Ex01_Array_Basic {

	public static void main(String[] args) {
		//같은 타입의 변수 여러개를 선언해서 데이터를 처리하세요
		
		int s; 
		int s1;
		int s2;
		int s3;
		
		int a,a1,a2,a3;
		//위와 같은 방법은 바람직 하지 않다
		
		//배열을 만들자
		
		int[]	score= new int[5];
		//score(101동)--> 101호, 102호,
		//int 타입의 방 4개 생성... heap연속된 공간에>> 방 이름(index(첨자): [0][1][2])
	
		score[0]=101;
		score[1]=20;
		score[2]=300;
		score[3]=500;
		score[4]=111;
		
		System.out.println(score[4]);
		//exception ArrayIndexOutOfBoundsException
		
		System.out.println(score[4]);
		//Array 배열 궁합 제어문 (for문)
		for(int i=0;i<4;i++) {
			System.out.printf("[%d]=[%d]",i,score[i]);
			
		}
		System.out.println();
		
		for(int i=0;i<score.length;i++) {//score.length 배열의 개수
			System.out.printf("[%d]=[%d]",i,score[i]);
		}
		System.out.println();
		//Tip : Arrays.toString(score) 쓰지마세요(실력이 감소)
		
		String resultArray=Arrays.toString(score);
		System.out.println(resultArray);
		
		//Tip : sort당분간 쓰지 말기
		Arrays.sort(score);
		resultArray = Arrays.toString(score);
		System.out.println(resultArray);//[20,101,300,500
		
		
		//Today Point 
		// 배열 생성 3가지
		int[]arr=new int[5];// 기본 암기하자!!!
		int[]arr2=new int[] {100,200,300};//초기값을 통해서 배열 개수 정의하고 값을 할당
		int[]arr3= {11,22,33};//컴파일러에게 자동으로 new라는 부분을 부탁하는 것임 컴파닐러가 지가 알아서 new붙여줌
		//위 3가지는 암기하자
		
		//tip) javascript : let cararr=[1,2,3,4,5];
		
		
		for(int i=0;i<arr2.length;i++) {
			System.out.println(arr2[i]);
		}

		//배열은 객체다 (new ...heap로드)
		int[]arr4;
		arr4=new int[] {21,22,23,24,25};
		System.out.println(arr4);//I@365185bd
		
		int[]arr5=arr4;
		System.out.println(arr4==arr5);
		
		//배열의 타임은 : 8가지 기본타입 + String + 클래스(타입)
		String[]strarrr= new String[] {"가","나","다라마"};
		for(int i=0;i<strarrr.length;i++	) {
			System.out.println(strarrr[i]);
		}
	}
	
	char[]carr=new char[5];
	float[]farr=new float[6];
	
	/*
	 class Car{}
	 
	 */

}
