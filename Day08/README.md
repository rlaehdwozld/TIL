# 2022.08.30 화요일 못먹어도 고!

### this

    저희 자동차 매장은 세가지 옵션을 가지고 있는데(기본옵션, 옵션1, 옵션2) 기본 옵션은 레드와 문 하나와 오토를 구매하게 되는 것이고
    색깔과 문 개수는 바꿀 수 있지만 auto는 못바꾼다 옵션1은색깔과 기어 타입을 선택 가능하지만 문 개수는 1개이다. 옵션 2는 모두 선택 가능하다.

```java

class Zcar2{
	String color;
	String geartype;
	int door;

	Zcar2(){	// 기본 옵션 (red,1,auto)
	this("red",1);
	System.out.println("default");
}
	Zcar2(String color, int door){
		this(color,door,"auto");
		System.out.println("overloading param 2개...");


	}//옵션1 ) color, door변경(default auto)
	Zcar2(String color, int door, String geartype){
		this.color=color;
		this.geartype=geartype;
		this.door=door;
		System.out.println("overloading param 3개...");
	}//옵션2 )color, door, geartype

	void print() {
		System.out.println(this.color+" ,"+this.door+", "+this.geartype);
	}
}



```

### 배열

배열에 대해서 알아보자

배열은 객체다.(Array)

1. new를 통해서 생성해야한다.
2. heap메모리에 생성된다. 가비지 컬렉터에서 관리되는 자원이기떄문에 명시적으로 해제해야하는 것은 아니다.
3. 고정 배열(정적배열) : 배열을 한번 선언하면 (크기가 정해지면) 변경 불가<--->collection(동적)
4. 자료구조 (알고리즘) 기초적인 학습

```java
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
```

### Today Point

    	/배열 생성 3가지
    	int[]arr=new int[5];// 기본 암기하자!!!
    	int[]arr2=new int[] {100,200,300};//초기값을 통해서 배열 개수 정의하고 값을 할당
    	int[]arr3= {11,22,33};//컴파일러에게 자동으로 new라는 부분을 부탁하는 것임 컴파닐러가 지가 알아서 new붙여줌
    	***위 3가지는 암기하자***

```java
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

        	char[]carr=new char[5];
	        float[]farr=new float[6];
```

### Array 문제

```java

public class Ex02_Array_Quiz {
	public static void main(String[] args) {
		// 국문과 학생들의 기말고사 시험 점수입니다.
		int[] score = new int[] { 79, 88, 97, 54, 56, 95 };
		int max = score[0];// max<79
		int min = score[0];// min<79
		for (int i = 0; i < score.length; i++) {
			if (max < score[i]) {
				max = score[i];
				System.out.println(max);
			}
			if (min > score[i]) {
				min = score[i];
				System.out.println(min);
			}
		//삼항연산자를 이용
			max = (score[i] > max) ? score[i] : max;
			min = (score[i] < min) ? min : score[i];
		}

		/*
		 * 제어문을 통해서 max라는 변수의 시험점수 중에 최대값을 담고 min이라는 변수에 시험점수중 최솟값을 담으세요 출력결과가 : max>97
		 * , min >54 단) for문을 한번만 사용하세요
		 *
		 */
		int[] numbers = new int[10];
//10개의 방의 값을 1~10까지로 초기화 시켜라
//for 문을 통해서 [0]=1, [9]=10;

		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = i + 1;
		}
		for (int i = 0; i < numbers.length; i++) {
			System.out.println(numbers[i]);
		}

//어느 학생의 기말소가 시험점ㅅ {5과목}
		int[] jumsu = { 100, 55, 90, 60, 78 };
		int sum = 0;
		float avg = 0f;
//1. 총과목의 수
//2. 총 과목의 합
//3. 과목 평균
//4. 단 2.3문제는 하나의for문으로 해결

		System.out.println("총과목의 수: " + jumsu.length);

		for (int i = 0; i < jumsu.length; i++) {
			sum += jumsu[i];
			avg = sum / (float)jumsu.length;
			// if(i==jumsu.length-1){
			//avg=sum/(float)jumsu.length;
			//}
		}
		System.out.println(sum);
		System.out.println(avg);

	}
}

```

### 로또 문제

```java
*
 로또는 1~45까지의 난수를 발생시켜서 배열에 담자
 배열에 담긴 6개의 배열 값은 중복 값이 나오면 안된다
 배열에 있는 6개의 값은 낮은 순으로 정력시키세요 정렬: 자리바꿈 : swap
 위 결과를 답고있는 배열을 출력하세요

 main함수 안에서 모두 작성해도 되고

 static함수를 만들어서 기능을 나누는 것은 허락

 별도의 클래스는 생성 하지 말 것.

 */
public class Ex03_Array_Lotto_Main {

	public static void main(String[] args) {

		int[] lnum = new int[6];

		for (int i = 0; i <= 5; i++) {
			lnum[i] = (int) (Math.random() * 45 + 1);
			for (int j = 1; j < i; j++) {
				if (lnum[i] == lnum[j]) {
					i--;
				}
			}System.out.println(lnum[i]);
		}

	}

//for(int i=0;i<6;i++) {
//	System.out.println(larr[i]);
//}
}
```

### 향상된 for문

Today Point  
for문 >>향상된 for문 , 계선된 for문  
JAVA : for(Type 변수명 : 배열 or Collection){실행블록}  
C# : for(Type 변수명 in 배열 or Collection){실행블록}  
JavaScript : for(Type 변수명 in Collection){실행블록}

```java
public class Ex04_Array_For {
public static void main(String[] args) {

	int[] arr= {5,6,7,8,9};
	for(int i=0;i<arr.length;i++) {
		System.out.println(arr[i]);
	}
	//개선된
	for(int value :arr) {
		System.out.println(value);
	}

	String []strarr= {"A","B","C","D"};

	for(String str:strarr) {
		System.out.println(str);
	}

}
}

```

### 객체

```java
//클래스 == 타입 == 설계도

class Person{
   String name;
   int age;

   //사람을 만들때 반드시 이름, 나이를 가지게 하려면
   //Person(String name, int age) {}

   void print() {
      System.out.println(this.name + "." + this.age);
   }
}


public class Ex05_Array_Object {
   public static void main(String[] args) {
      int[] intarr = new int[10]; //값타입 배열 8가지 + String
      boolean[] booarr = new boolean[5]; //값타입 (5개방에 false)

      Person p = new Person();   // 참조변수 (p 라는 변수는 주소값)
      p.name = "홍길동";
      p.age = 100;

      //사람 3명을 만들어라
      //Person p1 = new Person();
      //Person p2 = new Person();
      //Person p3 = new Person();

      // 이제부터 이렇게 만들면 최악...!



      //int[] intarr = new int[10];
      Person[] persons = new Person[3];
      System.out.println("person: " + persons);
      System.out.println("person[0]" + persons[0]);  //각각의 방은 null default값
      //객체배열은 방을 만들고 방에 객체를 넣어주는 작업....
      //persons[0] 은 person객체의 주소를가진다
      persons[0] = new Person();
      Person p2 = new Person();
      persons[1] = p2;
      persons[2] = new Person();

      System.out.println("person[0]" + persons[0]);
      System.out.println("person[1]" + persons[1]);
      System.out.println("person[2]" + persons[2]);

      persons[0].name = "김유신";
      persons[0].age = 100;

      //객체배열은 방을 만드는것과 방을 채우는 작업은 별도다.
      for(int i = 0; i < persons.length; i++) {
         System.out.println(persons[i].name);
      }




      //객체 배열 3가지 방법으로 만들기

      //1. int[] arr = new int[10];
      Person[] parray1 = new Person[10]; // 방만 생성
      for (int i = 0; i < parray1.length; i++) {
         parray1[i] = new Person();
         System.out.println("주소값: " + parray1[i]);
      }


      //2. int[] arr = new int[]{10,20,30}
      Person[] parray2 = new Person[] {new Person(), new Person(), new Person()};


      //3. int[] arr = {10,20,30}
      Person[] parray3 = {new Person(), new Person(), new Person()};

   }
}

```

객체 배열 실습

```java
import kr.or.bit.Emp;

public class Ex06_Array_Object {
public static void main(String[] args) {
	//사원 세명을 만드세요
	// 단 Array 사용
	// 사원 정보
	//1000, 홍길동
	//2000, 김유신
	//3000, 유관순
	//을 만드시고 사번과 이름을 출력하세요
	Emp[] emp= {new Emp(1000,"홍길동"),new Emp(2000,"김유신"),new Emp(3000,"유관순")};

	/*
	 * for(int i=0;i<emp.length;i++) { emp[i].empInfoPrint(); }
	 */
	for(Emp e : emp	) {
		e.empInfoPrint();
	}


}
}
```

### 객체 배열 응용

```java
class Human {
	String name;

}

class OverTest {
	int add(int i, int j) {
		return i + j;
	}

	void add(Human human) { // Human 객체의 주소값
		System.out.println(human.name);
	}

	// 1.add(new Human());
	// 2.Human h = new Human(); add(h);

	// Today Point(배열도 타입이다.==배열은 객체다)
	int add(int param) {
		return param + 100;
	}

	int[] add(int[] params) {// Today Point params는 int[]배열의 [[주소값]]을 받는다.
		// return null; //int[] 배열의 주소값 return
		int[] target = new int[params.length];
		for (int i = 0; i < target.length; i++) {
			target[i] = params[i] + 1;
		}
		return target;// target 배열의 주소값을 리턴하겠다

	}

	int[] add(int[] so, int[] so2) {
		return null;
	}
}

public class Ex07_Array_method_param {
	public static void main(String[] args) {

		OverTest overtest = new OverTest();
		int[] source = { 10, 20, 30, 40, 50 };
		int[] ta = overtest.add(source);
		for (int value : ta) {
			System.out.println(value);
		}

	}
}

```

### 2차원 배열

```java
public class Ex08_Array_Rank {
public static void main(String[] args) {
/*
 다차원 배열 (2차원)
 [행][열]
영화관 좌석, 지도 좌표값, 오목, 엑셀

영화관 예매하기 취소 관리 프로그램 만들기


 *
 */

	int[][] score= new int[3][2];
	score[0][0]=100;
	score[0][1]=200;

	score[1][0]=300;
	score[1][1]=400;

	score[2][0]=100;
	score[2][1]=100;

	//for문(중첩 for문)
	//행의 개수 : 배열 이름.length>>score.length>>3
	//열의 개수 : 힌트 2차원 배열의 그림>>score[i].length>>열의개수 >> point



	for(int i=0;i<score.length;i++) {
		for(int j=0; j<score[i].length; j++) {
			System.out.printf("score[%d][%d]=%d\n",i,j,score[i][j]);

		}

	}

	int[][]score3=new int[][]{{11,12},{13,14},{15,16}};

	//커피퀴즈
	//개선된 for문 출력
	for(int[]r:score3) {//열의 주소값
		for(int c:r) {//열의 배열 값을 출력
			System.out.println(c);
		}
	}


	}

}

```

### 2차원 배열 응용

```java
public class Ex09_Cinema {

	public static void main(String[] args) {
		String[][] seat = new String[3][5];

		for (int i = 0; i < seat.length; i++) {
			for (int j = 0; j < seat[i].length; j++) {
				// 좌석을 초기화
				seat[i][j] = "__";// 문자열로 초기화
			}
		}
		// 예매
		seat[2][1] = "홍길동";
		seat[0][0] = "김유신";

		// 예매 좌석 현황 보여주기

		for (int i = 0; i < seat.length; i++) {
			for (int j = 0; j < seat[i].length; j++) {
				System.out.printf("[%s]", seat[i][j].equals("__") ? "좌석" : "예매");
			}
			System.out.println();
		}
		// 예매를 하려고 했을 때 그 좌석이 예매 가능한지 아니면 예ㅐ가 되었는지 알려줘야된다.
		int row, col;
		row = 1;
		col = 1;
		if (seat[row][col].equals("__")) {
			System.out.println("예약 가능한 좌석입니다.");
		} else {
			System.out.println("예약 가능한 좌석입니다.");

		}
		// 모든 좌석을 초기화 시킨다"__"로
		for (int i = 0; i < seat.length; i++) {
			for (int j = 0; j < seat[i].length; j++) {
				// 좌석을 초기화
				seat[i][j] = "__";// 문자열로 초기화

			}

		}

}
}
```
