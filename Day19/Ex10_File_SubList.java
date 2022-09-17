import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Ex10_File_SubList {
	static int totalfiles=0;//파일개수
	static int totaldirs=0;//폴더개수
	
	static void printFileList(File dir) {
		System.out.println("Full path :"+dir.getAbsolutePath());
		
		//코드 .... 자유...
		List<Integer>subdir	= new ArrayList<>();
		File[]files = dir.listFiles();//하위 자원 정보를 다 ... 하나하나를 file 객체로 보는 것
		//[0] >a.txt >> 각 방의 타입은 File 타입
		//[1] >aaa폴더
		//[2] > bbb폴더
		//[3] > java.jpj
		for(int i=0;i<files.length;i++)
		{
			String filename= files[i].getName();	//폴더명 또는 파일명으로 나옴
			if(files[i].isDirectory()) {//폴더
				filename="[ Dir ]"+filename;
				//Point
				subdir.add(i);//왜 이렇게 할까?? >>>>>> 폴더인 것의 index값을 (i)를 ArrayList에 저장 시켰다.
				//sudir [0]방에는 뭐가 있을 까? ---->1
				//subdir [1] ---->2
			}else {
				filename=filename+" / "+files[i]+"byte";
			}
		}
		
		//질문 
		// 이상태에서 폴더의 개수를 확인 할 수 있나???
		int dirnum=subdir.size();//현재 주어진 폴더의 하위 폴더의 갯수이다.
		//파일 개수는
		int filenum=files.length-dirnum;//files가 폴더와 파일을 모두 가지고 있으니 files에서 폴더의 개수를 빼며 파일의 갯수가 된다.
		//우리가 원하는 것은 누적 갯수이다.
		//하위 폴더 안에 있는 자원까지 모두 포함시키고 싶다.
		totaldirs+=dirnum;// 이 것은 총 누적된 '폴더'의 갯수이다. (하위폴더의 하위 폴더까지)
		totalfiles +=filenum;// 총 누적 '파일' 개수(하위의 하위까지)
		System.out.println("[Current DirNum] : "+ dirnum);
		System.out.println("[Current FileNum] : "+	filenum);
		System.out.println("*************************");
		
		//Point  하위 폴더의 다시 하위 폴더정보까지 보고싶다.
		//[0] >a.txt >> 각 방의 타입은 File 타입
		//[1] >aaa폴더 >> a-1폴더, a-2폴더
		//[2] > bbb폴더 >>b-1 폴더, b.txt, b2.txt
		//[3] > java.jpj
		for(int i=0;i<subdir.size();i++) {
			//왜 subdir 쓸까 25번 줄에서 add를 시켰기 때문에 하위 폴더의 갯수이다. 
			int index=subdir.get(i);
			//한줄의 코드가 재귀호출을 할 수 있다.
			printFileList(files[index]);//재귀호출 ( 내가 내 자신을 또 부르는 것)
			//처음에는 C:\\Temp\aaa을 get하고 ㅔprintFileList(files[index])가 다시 불러내 다음 폴더를 불러낸다.
			
		}
		
	}
	
	
	public static void main(String[] args) {
		if(args.length !=1) {
			System.out.println("사용법 : java [실행파일명] [경로명]");
			System.out.println("예시 : java Ex_10_File_SubList C:\\Temp");
			System.exit(0);
			
		}
		File f= new File(args[0]);//File f= new File("C:\\Temp);
		if(!f.exists() ||!f.isDirectory()) {
			//존재하지 않거나 또는 디렉토리가 아니라면 
			System.out.println("유효하지 않은 디렉토리");
			System.exit(0);
		}
		//정상적인 경로 그리고 폴더구나...
		printFileList(f);//호출(반복)
		//하위 폴더 안까지의 폴더 개수, 파일 개수 누적시켜놨다
		System.out.println("누적된 총 파일 수 :"+totalfiles);
		System.out.println("누적 총 폴더 수 :"+totaldirs);
	}

}
