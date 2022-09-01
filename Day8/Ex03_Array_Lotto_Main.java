import java.util.Random;

/*
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
