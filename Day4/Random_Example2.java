package Day4;

import java.util.Random;
import java.util.Scanner;
//수맞추기게임
//세번쨰 시도에 다시 입력하세요가 아닌 다시 시도하세요가 나오면 좋겠는데 구현 못했다.
//참고자료
/*
        Random random = new Random();// 랜덤 수 만드는 객체 생성
        int answer = random.nextInt(100); // 100까지의 수만 랜덤
        System.out.println(("정답 미리보기: ") + answer);
        int input_number;
        int repeat_count = 0;
        Scanner scan = new Scanner(System.in);
        System.out.println("1~100사이의 숫자중 하나로 배정된 숫자를 맞추시오.");
        do {
            System.out.print("정답: ");
            input_number = scan.nextInt();
            repeat_count++;
            if (input_number > answer) {
                System.out.println("좀 더 낮은 수를 입력하세요.");
            }
            if (input_number < answer) {
                System.out.println("좀 더 높은 수를 입력하세요.");
            }
        } while (input_number != answer);
        System.out.printf("정답입니다. 총 시도횟수는 %d회 입니다.\n", repeat_count);
 
    }
    }
    }
 */
public class Random_Example2 {
	public static void main(String[] args) {
		Random rd = new Random();
		Scanner sc = new Scanner(System.in);
		int answer = rd.nextInt(50);
		System.out.println(answer);
		System.out.println("숫자를 입력하시오");
		int chance = 1;
		while (chance <= 3) {
			int apply = sc.nextInt();
			if (apply == answer) {
				System.out.println("정답");
				break;
			} else {
				if (chance <= 3) {
					System.out.println("다시 입력하세요");
				} else {
					System.out.println("다시 도전하세요");
				}

				chance = chance + 1;

			}

		}

	}
}
