import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Ex12_PrintWriter_String_Finder {
	String baseDir = "C:\\Temp";// 검색할 디렉토리
	String word = "HELLO";// 검색할 단어
	String savetxt = "result.txt";// 헬로라는 단어가 들어있는 파일의 정보를 저장할 것이다.

	void Find() throws IOException {// 쓰로우 아이오 익셉션 하는 이유 당신이 find함수를 사용할 때 예외처리를 강제해라(try)
		File dir = new File(baseDir);
		if (!dir.isDirectory()) {// 부정적인 것을 먼저 쓰는게 훨신 쓸것이 줄어든다.
			System.out.println("유효한 폴더가 아니에요");
			System.exit(0);
		}
		PrintWriter writer = new PrintWriter(new FileWriter(savetxt));
		// 프린트 라이터가 파일을 만드는데 파일라이터를 사용해서 만드는것을 보여준거다 굳이 파일라이터 끼지 않아도 독자적으로 파일 만들 수 있따.
		BufferedReader br = null;
		File[] files = dir.listFiles();
		for (int i = 0; i < files.length; i++) {
			if (!files[i].isFile()) {
				continue;// 아래코드 무시하겠단 말
			}
			// 파일이면
			br = new BufferedReader(new FileReader(files[i]));
			// a.txt
			// a.txt 한문장씩 read(한줄)
			String line = "";
			while ((line = br.readLine()) != null) {
				// 여기서 단어 검색 시작
				if (line.indexOf(word) != -1) {
					// a.txt를 한 줄씩 읽어서 그문장안에 HELLO라는 단어가 하나라도 존재하면
					writer.write("word =" + files[i].getAbsolutePath() + "\n");//
				}
			}
			writer.flush();
		}
		br.close();
		writer.close();
	}

	public static void main(String[] args) {

		Ex12_PrintWriter_String_Finder finder = new Ex12_PrintWriter_String_Finder();
		try {
			finder.Find();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			
			//run as - run configuration - Ex10_File_Sublist 확인 - Argument - C:\\Temp - Apply
		}
	}
}
