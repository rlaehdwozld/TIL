package 명품자바;


/*
다음 프로그램에 대해 물음에 답하라?

int sum = 0, 
i = 0;
while (i < 100) {
    sum = sum + i;
    i += 2;
}
System.out.println(sum);
(1) 무엇을 계산하는 코드이며 실행 결과 출력되는 내용은?

- 0부터 100까지의 짝수를 더하는 코드이며 실행 결과는 2450이다.

(2) 위의 코드를 main() 메소드를 만들고 WhileTest 클래스로 완성하라.
*/


public class Array_1 {
	public static void main(String[] args) {

		int sum = 0;
		int i = 0;
		
		do {
			sum+=i;
			i+=2;
		}while(i<100);
		System.out.println(sum);
		
	}
	
	
}
//		(1) 무엇을 계산하는 코드이며 실행 결과 출력되는 내용은?
//
//		- 0부터 100까지의 짝수를 더하는 코드이며 실행 결과는 2450이다.
//
//		(2) 위의 코드를 main() 메소드를 만들고 WhileTest 클래스로 완성하라.
		/*
		 * while (i < 100) { sum = sum + i; i =i+2; }
		 */
		
//		(3) for 문을 이용하여 동일하게 실행되는 ForTest 클래스를 작성하라.
//		for(i=0;i<100;i+=2) {
//			sum+=i;
//			}
		
		
			
