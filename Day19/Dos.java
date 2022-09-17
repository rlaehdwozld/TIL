
import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;

public class Dos {
	static boolean delete(File newfile) {
		File[] files = newfile.listFiles();
		if (files != null) {
			for (File file : files) {
				delete(file);
				System.out.println(newfile);
			}
		}
		return newfile.delete();
	}


		// java ExDos C:\Temp mkdir newDir
		// java ExDos C:\Temp rename file.txt file2.txt
		// java ExDos C:\Temp delete new.txt

		if (args.length != 3 && args.length != 4 && args.length != 2) {

			System.out.println("사용법 : [java파일명] [디렉토리경로] mkdir [생성디렉토리명]");

			System.out.println("사용법 : [java파일명] [디렉토리경로] rename [파일명] [새로운 파일명]");

			System.out.println("사용법 : [java파일명] [디렉토리경로] delete [파일명]");

			System.out.println("사용법 : [java파일명] [디렉토리경로] hidden [파일명]");

			System.out.println("사용법 : [java파일명] [디렉토리경로] dir");

			System.exit(0);

		}

		File f = new File(args[0]);

		if (!f.exists() || !f.isDirectory()) { // 존재하지 않거나 디렉토리 아니라면

			System.out.println("유효하지 않은 디렉토리입니다");

			System.exit(0);

		}

		if (args[1].equals("mkdir")){

			String path = "";

			path = f + "\\" + args[2];

			File newfile = new File(path);

			if (newfile.exists()) {

				System.out.println("이미 존재하는 디렉토리입니다");

			}

			else {

				newfile.mkdir();

			}

		}
		
		
		
		

		else if (args[1].equals("hidden")) {
			String path = "";
			path = f + "\\" + args[2];
			System.out.println(path);
			
			File newfile = new File(path);
			System.out.println(newfile);

			if (!newfile.exists()) {
				Runtime rt = Runtime.getRuntime();
				newfile.createNewFile();
				Process ps = rt.exec("attrib +h " + path);
				BufferedReader br = new BufferedReader(new InputStreamReader(ps.getInputStream()));
			} else {
				System.out.println("이미 파일이 존재합니다.");
			}

		}
		
		
		
		
		else if (args[1].equals("rename")) {
			try {
				File originFileName = new File(f + "\\" + args[2]);
				File newFileName = new File(f + "\\" + args[3]);

				if (!originFileName.exists()) {
					System.out.println("존재하지 않습니다.");
					System.exit(0);
				}
				if (newFileName.exists()) {
					System.out.println("이미 존재하는 이름입니다");
					System.exit(0);
				}

				boolean scc = originFileName.renameTo(newFileName);
				if (scc) {
					System.out.println("수정 완료");
				}
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("rename 중 예외 발생 : " + e.getMessage());
			}

		} 
		
		
		
		
		else if (args[1].equals("delete")) { // args[1] 번째 값이 delete면? (equals: boolean)
			String path = "";
			path = f + "\\" + args[2];
			File newfile = new File(path);
			delete(newfile);

		} else if (args[1].equals("dir")) { // 목록 조회
			File[] file = f.listFiles();
			for (int i = 0; i < file.length; i++) {
				System.out.println(file[i]);
			}
		}

	}

}
