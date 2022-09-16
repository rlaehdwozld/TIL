import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;

import javax.swing.plaf.metal.MetalBorders.Flush3DBorder;

/*
파일 처리를 할 건데 (DISK) : 입력 출력은 Byte단위로(한 Byte)씩 read, write

여러 학생을 모아서 하나의 버스에 태워서 목적지 까지 가서 놀면 좋지 않을까??
버스 : buffer
1. I/O 성능 개선 (접근 횟수)
2. Line 단위 (엔터)

BufferedInputStream (보조 스트림)>> 주 클래스에 의존 

*/

public class Ex04_Stream_Buffer {

	public static void main(String[] args) {
		FileOutputStream fos = null;
		BufferedOutputStream bos = null;

		try {
			fos = new FileOutputStream("data.txt");// 파일 없으면 파일 create
			bos = new BufferedOutputStream(fos);// FileOutputStream 버퍼 사용
			
			for( int i=0;i<10;i++) {
				bos.write('A');//data.txt 파일 안에
				// 이렇게만 하면 data에 write 안된다 왜냐하면 8150바이트 안되기 때문에 그래서 
				//bos.flush();
			}
			/*
			JAVA Buffer 크기(8kbyte : 8192byte)
			1. buffer 안에 내용이 다 채워지면 스스로 출발(Buffer를 비워 버림)
			2. 강제로 출발(buffer 강제로 비우기) : flush()	 or close() 
			3. close() 자원해제>> 내부적으로 flush() 호출 >> 자원 해제
			*/
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			try {
				bos.close();
				fos.close();//내부적으로 bos.flush() 포함
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}

	}

}
