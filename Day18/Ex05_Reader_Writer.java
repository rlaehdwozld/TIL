import java.io.FileReader;
import java.io.FileWriter;

/*
문자기반의 데이터 처리 (char[][)
String 클래스 : String str ="ABC" : 내부적으로 char[] >> [A][B][C]

한글 1자, 영문 1자 >> 2Byte >> Reader, Writer(추상클래스)

대상 파일 
FileReader
FileWriter


*/
public class Ex05_Reader_Writer {
	public static void main(String[] args) {
		FileReader fr = null;
		FileWriter fw = null;

		try {
			fr = new FileReader("Ex01_Stream.java");// read
			fw = new FileWriter("copy_Ex01.txt");// 파일 생성 같은 내용을 write하겠다.

			int data = 0;
			while ((data = fr.read()) != -1) {
//				System.out.println(data);
				if (data != '\n' && data != '\r' && data != '\t' && data != ' ') {
					// 해석 : 엔터와 탭 빈문자값을 파일에 쓰지 않겠다(압축 파일 버전)

					fw.write(data);
				}
			}
		} catch (Exception e) {
		} finally {
			try {
				fw.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
	}
}
