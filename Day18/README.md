# 2022.09.15 목요일 못먹어도 고!

## I/O

### Stream

IO

Stream (통로)  
데이터 종류 : 이미지, 파일 (바이너리데이터)<> 문자

JAVA API  
[Byte] 단위의 데이터 IO

추상 클래스  
InputStream, OutputStream(재정의... 원하는 추상함수)

당신이 Byte단위의 데이터 작업을 할 때  
[입력 InputStream] 상속받는 클래스 사용하세요 : 대상

대상

1. Memory : ByteArrayInputStream
2. File : FilieInputStream

당신이 Byte 데이터 작업을 할 때  
[출력 OutoutStream] 상속받는 클래스 사용하세요 : 대상

대상

1. Memory : ByteArrayOutputStream..
2. File : FilieOutputStream

```java
public class Ex01_Stream {
	public static void main(String[] args) {
		//byte (-128 ~ 127) 정수를 저장 타입
		byte[] inSrc = {0,1,2,3,4,5,6,7,8,9};
		byte[] outSrc=null;//현재 메모리를 갖고 있지 않다.

		//데이터 read , write 하는 대상 memory

		ByteArrayInputStream input = null;//빨대 (통로) 입력
		ByteArrayOutputStream output = null;//빨대 (통로) 출력

		input = new ByteArrayInputStream(inSrc);//inScr라고하는 대상(힙 메모리에 있는 메모리)으로 부터 데이터를  읽겠다(read)
		output = new ByteArrayOutputStream(); //write..

		System.out.println("outSrc before:"+Arrays.toString(outSrc));

		//암기하자!!
		//공식같은 로직
		int data =0;
		while((data =input.read())!=-1) {//더이상 read할 데이터가 없으면 -1
			//System.out.println("data : "+data);
			//System.out.println(input.read());//13579
			//왜 1,3,5,7,9
			//왜 data에 담아서 처리 했을까???
			//read함수는 내부적으로 이동이라는 기능을 갖고 있따. (next()포함)
			//그래서 데이터에 담아와서 read를 한번만 하겠다는 말이다. 아니면 read가 두번 읽히니깐 짝수는 건너뛰어짐

			//read 한 데이터를 write
			output.write(data);//출력 통로 안에 (빨대) 안에 데이터를 가지고 있는 것
			//write 대상이 data가 아니고 ByteArrayOutputStream 자신의 통로에 data를 가지고 있는 것.

			outSrc= output.toByteArray();//toByteArray함수를 사용하면 Byte[]배열로 값을 전환 해준다.(주소값)

		}
		System.out.println("outSrc after:"+Arrays.toString(outSrc));
	}

}

```

### FileInputStream

Byte 데이터를 read, write >> 그 대상이 >> File  
FileInputStream  
FileOutputStream

(이미지 , 엑셀 파일) read, write 하는 목적 (텍스트 파일은 read, write는 안함)  
File >> 1.txt, data.txt(데이터를 파일에 기록)

I/O 클래스 예외를 강제.... try catch

//I/O자원은 가비지 컬렉터에 올라가지 않기 떄문에 개발자가 직접적으로 자원에 대한 해제를 해야한다. (여러 사용자들이 접근 해서 사용 가능하다)  
close()

### FileOutputStream

1.  write하는 파일이 존재 하지 않으면 >> 자동으로 파일을 생성한다(create)
2.       fos = new FileOutputStream("C:\\Temp\\new.txt",false);

false >> overwrite

3.       fos = new FileOutputStream("C:\\Temp\\new.txt",true);
    true >> append  
    //ex 홍길동의 대출 목록을 관리하려고 하면 append를 해야한다. (대출 목록역사를 기록)

```java
public class Ex02_Point_FileStream {
	public static void main(String[] args) {
		FileInputStream fs =null;
		FileOutputStream fos=null;

		String path = "C:\\Temp\\a.txt";

		try {
			fs= new FileInputStream(path);
			fos = new FileOutputStream("C:\\Temp\\new.txt");

			int data=0;
			while((data = fs.read())!=-1){
			//	System.out.print("정수 : "+data);//정수 : 72정수 : 101정수 : 108정수 : 108정수 : 111
				//문자값 char c= (char)data
				//System.out.print("정수 : "+(char)data);//정수 : H정수 : e정수 : l정수 : l정수 : o
				//read한 데이터를 새로운 파일에 write하는것이 목적이다.
				//출력스트릠이 필요하다
				fos.write(data);//data값을 내부적으로 read해서 new.txt에다가 write하는 것이 목적이다.

			}
		}catch(Exception e) {


		}finally {
			//정상, 비정상 코드 모두 실행
			//함수가 return해도 finally 실행된다. 그만큼 강력
			//자원 해제
			//I/O함수는 가비지 컬렉터가 관리하지 않기 때문에
			//close() 명시적>> 소멸자를 호출해야한다.
			try {
				fos.close();
				fs.close();
			}catch(Exception e) {
				// 이렇게 해야 이쁜 코드이다. 혼자서 할때는 큰문제는 없지만 공유 파일을 이용할 떄는 필수적으로 해야한다.
				// 범종이 파일 수정중 나한테 파일 사용중이라는 메시지 뜨는 것 처럼
			}
		}

	}

}
```

### Image Copy 예제

```java
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Ex03_Stream_ImageCopy {
	public static void main(String[] args) {
		String oriFile ="C:\\Temp\\java.jpg";
		String targetfile ="copy.jpg";
		//default 경로 : C:\\KOSA_IT\JAVA\Labs\Ex09_IO
		//파일이 있는 프로젝트 폴더 경로...

		FileInputStream fs= null;
		FileOutputStream fos= null;
		try {
			fs= new FileInputStream(oriFile);
			fos= new FileOutputStream(targetfile, false);

			int data=0;
			while((data=fs.read())!=-1) {
				fos.write(data);//byte값
			}
		}catch (Exception e) {


		}finally {
			try {
				fs.close();
			fos.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}

		}
	}

}

```

### Buffer

파일 처리를 할 건데 (DISK) : 입력 출력은 Byte단위로(한 Byte)씩 read, write

여러 학생을 모아서 하나의 버스에 태워서 목적지 까지 가서 놀면 좋지 않을까??
버스 : buffer

1. I/O 성능 개선 (접근 횟수)
2. Line 단위 (엔터)

BufferedInputStream (보조 스트림)>> 주 클래스에 의존

```java
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
```

### Reader Writer

문자기반의 데이터 처리 (char[])  
String 클래스 : String str ="ABC" : 내부적으로 char[] >> [A][b][C]

한글 1자, 영문 1자 >> 2Byte >> Reader, Writer(추상클래스)

대상 파일  
FileReader  
FileWriter

```java
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
```

### Buffer를 활용한 FileReader FileWriter

    FileWriter fw = new FileWriter("Lotto.txt"	,true);//true >>append
    BufferedWriter bw = new BufferedWriter(fw);
    bw.write("로또");
    bw.newLine();//엔터 처리
    bw.write("1,3,5,7,9,10");
    bw.newLine();
    bw.flush();

```java
public class Ex06_FileReader_FileWriter_Buffer {
public static void main(String[] args) throws IOException {

	FileReader fr = null;
	BufferedReader br= null;

	try {
		fr = new FileReader("Ex01_Stream.java");
		br= new BufferedReader(fr);
		//line 단위 단위의 처리
		String line="";
		for(int i =0;(line=br.readLine())!=null;i++) {
			//System.out.println(line);
			if(line.indexOf(";")!=-1) {
				System.out.println(line);
				//한줄을 read했는데 ';'있으면 그 줄을 출력하겠다.
			}
		}
	} catch (Exception e) {
		// TODO: handle exception
	}finally {
		try {
			br.close();
			fr.close();
		} catch (Exception e2) {
			// TODO: handle exception
		}
	}
```

### File 폴더를 다루는 클래스

파일 폴더를 다루는 클래스 학습  
Java : 파일( 생성, 삭제), 폴더(생성, 삭제) 하나의 클래스>> File
a.text 생성, 수정, 삭제, 정보 read  
Temp 폴더 생성, 수정, 삭제. 정보 read

c# : 파일 (File), 폴더(Directory)

경로  
절대경로 : C:\\ D:\\ >> C:\\Temp\\a.txt  
상대경로 : 현재 파일을 중심으로 >>../>>/

```java
import java.io.File;
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
```

### File Dir 설정

```java

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
```

### File Dir Formatting해보기

```java
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Ex09_File_Dir_Format {
public static void main(String[] args) {
	File dir = new File ("C:\\Temp");
	File[]files = dir.listFiles();
	for(int i=0;i<files.length;i++) {
		File file = files[i];

		String name = file.getName();//폴더명 or 파일명
		SimpleDateFormat dt= new SimpleDateFormat("yyyy-MM-dd HH-mma"	);
		String  attribute = "";
		String size= "";

		if(files[i].isDirectory())	{//폴더니 질문
			attribute= "<Dir>";

		}else {//다 파일 (1.jpg, data.txt...
			size= file.length()+"byte";
			attribute = file.canRead()  ?"R":"";
			attribute +=file.canWrite()?"W":"";
			attribute +=file.isHidden()?"H":"";


		}
		System.out.printf("%s	%3s	%10s	%s	\n",
									dt.format(new Date(file.lastModified())),
									attribute
									,size
									,name);
	}
}
}

```

### 조별과제\_Lotto 출력

```java
package kr.or.kosa;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Set;
import java.util.TreeSet;

class Lotto2 {
	Calendar cal = Calendar.getInstance();
	SimpleDateFormat dateformat = new SimpleDateFormat("yyyy년MM월 dd일 HH:mm");
	Set<Integer> lotto = new TreeSet<Integer>();
	FileReader fr = null;
	FileWriter fw = null;
	BufferedReader br = null;
	BufferedWriter bw = null;
	String time;

	public Lotto2() {

		for (int i = 0; lotto.size() < 6; i++) {
			lotto.add((int) (Math.random() * 45 + 1));
		}
	}

	void read() {
		try {
			fr = new FileReader("Lotto.txt");

			int data = 0;
			while ((data = fr.read()) != -1) {
				System.out.print((char) data);
			}

		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			try {
				fr.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}

	}

	void write() {
		try {
			this.Time();
			this.number();

			fw = new FileWriter("Lotto.txt", true);
			bw = new BufferedWriter(fw);
			bw.write("로또번호: " + lotto.toString() + " " + time);
			bw.newLine();
			bw.flush();

		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			try {
				fw.close();
				bw.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}

	}

	void number() {

		for (int i = 0; lotto.size() < 6; i++) {
			lotto.add((int) (Math.random() * 45 + 1));
		}
	}

	void Time() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy년mm월dd일 hh:mm");
		time = dateFormat.format(cal.getTime());
	}
}

public class Lotto {

	public static void main(String[] args) {
		Lotto2 lotto2 = new Lotto2();
		lotto2.write();
		lotto2.read();

	}

}

```
