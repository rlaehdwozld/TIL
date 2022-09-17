import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

import org.w3c.dom.UserDataHandler;

import kr.or.kosa.UserInfo;

/*
직렬화 : 객체를 연속적인 데이터로 변환하는 것 반대과정은 역직렬화하고 한다. 
객체의 배열을 일렬로 나열하는 것.
일단 데이터를 쓰는 작업부터
*/
public class Ex15_ObjectDataOutPutStream {
	public static void main(String[] args) {
		String filename = "UserData.txt";

		FileOutputStream fos = null;
		BufferedOutputStream bos = null;
		ObjectOutputStream out = null;// 객체 통신

		try {
			fos = new FileOutputStream(filename, true);
			bos = new BufferedOutputStream(fos);
			// 직렬화
			out = new ObjectOutputStream(bos);

			UserInfo u1 = new UserInfo("홍길동", "super", 500);// 완제품
			UserInfo u2 = new UserInfo("scott", "tiger", 50);// 완제품

			// 직렬화 과정
			out.writeObject(u1);// UserInfo라는 객체를 분해해서 한줄로 세워서 파일에 기록하는 것.
			out.writeObject(u2);
			// 파일에 userinfo 객체 2개를 직렬화해서 write한 것이다.

		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {

			try {
				out.close();
				bos.close();
				fos.close();
				System.out.println("파일 생성 -> buffer-> 직렬화 -> 파일 wirite");
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}

	}

}
