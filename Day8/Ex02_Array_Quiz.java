
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
