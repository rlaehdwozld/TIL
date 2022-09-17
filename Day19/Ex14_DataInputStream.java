import java.io.DataInputStream;
import java.io.FileInputStream;

public class Ex14_DataInputStream {
	public static void main(String[] args) {
		// 파일 학생 점수 기록
		// read합계 평균
		// DataOutputStream>>dos.writeInt 정수값으로 썼다.
		// DataOutputStream얘로 쓴 것은 DataInputstream으로 읽어야한다!!

		int sum = 0;
		int score = 0;
		FileInputStream fis = null;
		DataInputStream dis = null;

		try {
			fis = new FileInputStream("score.txt");//score에 있는 내용을 읽어온다.
			dis = new DataInputStream(fis);//데이터 아웃풋 스트림으로 정수타임으로 썼던 내용이니 데이터 인풋스트림으로 읽어야된다.
			while (true) {
				score = dis.readInt();
				System.out.println("score int 타입 :" + score);
				sum += score;// 이게 가능하다 정수타입으로 썻기때문에 연산이 가능하다.
				// read 할 자원이 없으면 IOException이 발생한다.
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println("sum 결과 : " + sum);
		}finally {
			try {
				dis.close();
				fis.close();
			} catch (Exception e2) {
	
			}
		}

	}
}
