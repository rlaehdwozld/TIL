package Day4;

import java.util.Scanner;

/*4.int 형의 데 이 터 를 입력 하여 이 수가 2 로 나 눌 수 있 는 지 판단 합 니 다.
2 로 나 눌 수 있다 면'이 수 는 짝수'를 출력 합 니 다.그렇지 않 으 면'이 수 는 홀수'를 출력 합 니 다.
알림:
*/
public class Q13 {
public static void main(String[] args) {
Scanner sc = new Scanner(System.in);
int a = sc.nextInt();
if(a%2==0) {
	System.out.println("짝수");
	}else {
	System.out.println("홀수");
}
}
}
