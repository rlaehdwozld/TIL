import java.io.File;

/*
파일 폴더를 다루는 클래스 학습
Java : 파일( 생성, 삭제), 폴더(생성, 삭제) 하나의 클래스>> File
>>a.text 생성, 수정, 삭제, 정보 read
>>Temp 폴더 생성, 수정, 삭제. 정보 read

c# : 파일 (File), 폴더(Directory)

경로
절대경로 : C:\\ D:\\	>> C:\\Temp\\a.txt
상대경로 : 현재 파일을 중심으로 >>../>>/

*/
public class Ex07_File {
	public static void main(String[] args) {
		String path = "C:\\Temp\\file.txt";
	//	String path = "data.txt";
		File f = new File(path);
		
//		File 클래스를 사용하는 목적 : 다양한 정보를 취득하기 위해
		System.out.println("파일 존재 여부(파일, 폴더):"+f.exists());
		System.out.println("너 폴더니 :"+f.isDirectory());//f
		System.out.println("너 파일이니 :"+f.isFile());//t
		
		System.out.println("파일 명 : "+f.getName());//파일 명 : file.txt
		System.out.println("절대 경로 : "+f.getAbsolutePath());//절대 경로
		
		System.out.println("파일 크기 : "+f.length()+"byte");//length를 하면 바이트 형태로 리턴할 수 있다. 
		System.out.println("부모경로 : "+f.getParent());
		
	}

}
