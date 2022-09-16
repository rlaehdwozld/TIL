
import java.io.File;

public class Ex08_File_Dir {

	public static void main(String[] args) {
		//System.out.println(args[0]);
		if(args.length != 1) {
			System.out.println("사용법 : java 파일명 [디렉토리명]");
			System.exit(0);//강제종료
		}
		//java Ex08_File_Dir C:\\Temp
		File f = new File(args[0]);
		if(!f.exists() || !f.isDirectory()) {
			//둘중에 하나라도 만족하지 않으면
			//존재하지 않거나 또는 디렉토리가 아니라면
			System.out.println("유효하지 않은 경로입니다");
			System.exit(0);
		}
		
		//실제 존재하는 경로이고 제시한것이 폴더라면
		//POINT
		File[] files = f.listFiles(); 
		//C:\\Temp 안에 폴더나 파일을 배열에 담아서 ....
		//[a.txt][b.txt][][]
		//System.out.println(files.length);
		for(int i = 0 ; i < files.length ;i++) {
			String name= files[i].getName();
			System.out.println(files[i].isDirectory() ? "[DIR]" + name : name);
		}
		
	}

}