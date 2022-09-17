# 2022.09.16 금요일 못먹어도 고!

### SubList

Dos 프로그램의 하위 폴더 표시 방법에 대한 공부

```java
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

```

### 출력 형식을 저장하는 방법

출력 형식 저장

1. printf
2. String.format
3. PrintWriter(레포팅)
4. 현업 : 레포팅 소프트웨어(양식지 : 전표, 세금 계산서, 인사(휴가지원서)  
   4.1 크리스탈 레포트, 오즈

```java
public class Ex11_PrintWriter {

	public static void main(String[] args) {
		try {
			/*
			 * PrintWriter pw = new PrintWriter("C:\\Temp\\homework.txt"); pw.println(
			 * "************************************************************************");
			 * pw.
			 * println("**                                                    HOMEWORK                                                    **"
			 * ); pw.println(
			 * "************************************************************************");
			 * pw.printf("%3s : %5d %5d %5d %5.1f", "아무개",
			 * 100,99,80,(float)((100+99+80))/3); pw.println(); pw.close();
			 */
			FileReader fr= new FileReader("C:\\Temp\\homework.txt");
				BufferedReader br = new BufferedReader(fr);
				String s="";
				while((s=br.readLine())!=null) {
					System.out.println(s);
				}
				br.close();
				fr.close();

		} catch (Exception e) {
			// TODO: handle exception
		}



	}


}

```

### String Finder HELLO 들어있는 파일 정보 저장하기

```java
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


```

### DataOutputStrem

내가 성적데이터를 파일로 저장할 때 한명의 성적 데이터와 다음 사람의 성적데이터를 나누는것에 대한고민  
엔터로 구분 할지  
컴마로 구분할지  
탭으로 할지  
파일처리의 단점은 기준이 있어야한다.  
만약에 김.이.박 이렇게 되어 있을 때 .을 빼고 가지고 와야한다.  
그래서 나온 것이 스트링 값을 "123"을 int 값으로 저장해줄 수 있는 기능이 있는 스트림이다.

DataoutputStream  
DataInputStream

java 8가지 기본 타입 ( 타입별로 writer, read)할 수 있다.  
단!!!! 조건은 (DataoutputStream , DataInputStream) 둘이 같이 쓰여야한다.

만약 )  
성적.txt  
100,20,60,88은 문자열 데이터이다. 이것을 split을 해서 >배열에 넣어서> 연산하려면 integer.pareint해서 정수로 바꿔야한다.  
//이 과정이 너무 기니깐 필요한 방법이다  
//일단 읽는 것을

```java
public class Ex13_DataOutPutStream {
	public static void main(String[] args) {
		int []score = {100,60,55,95,55};
		//배열안에 들어있는 수학점수
		FileOutputStream fos=null; // 일단 기본 초기화
		DataOutputStream dos = null;//버퍼 처럼 혼자서는 못사용한다 보조스트림이라서

		try {
			fos = new  FileOutputStream("score.txt");//score라는 텍스트 파일을 만드는 방법이다.
			dos= new DataOutputStream(fos);
			for(int i=0;i<score.length;i++) {
				dos.writeInt(score[i]);//타입을 그대로 살려서 정수 형태로 그대로 write해야한다.
				//조건 read할 경우에는 반드시 DatatInputStream을 써야한다. 이번에는 그냥 해보자
				//dos.writeUTF(null);//채팅 입력출력을 쉽게 가능하게 해준다.
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());//예외가 났을 때 여기에서 e.getMessage를 해줘야 예외 내용을 볼 수 있다.
			//문제가 일어났을 때 기록하고 trouble shooting을 하는 것을 기업에서 훨씬 좋아한다.
			//실수 한거 정리해서 어떻게 처리했는지 기록하자!!
		}finally {
			try {
				dos.close();
			} catch (Exception e2) {
System.out.println();
System.out.println();

			}
		}
	}
	//


}

```

### DataInputStream

```java
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

```

### 직렬화

직렬화 : 객체를 연속적인 데이터로 변환하는 것 반대과정은 역직렬화하고 한다.  
객체의 배열을 일렬로 나열하는 것.  
일단 데이터를 쓰는 작업부터한다.

```java
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


```

### 역직렬화

UserData.txt 직렬화된 객체가 2개  
이 객체들을 read원상태로 복원(역직렬화)

```java
public class Ex16_ObjectDataInPutStream {
	public static void main(String[] args) {
		String filename = "UserData.txt";

		FileInputStream fis = null;
		BufferedInputStream bis = null;
		ObjectInputStream in = null;

		try {
			fis = new FileInputStream(filename);
			bis = new BufferedInputStream(fis);
			in = new ObjectInputStream(bis);

			// 복원
			/*
			 * UserInfo r1 = (UserInfo)in.readObject();
			 * UserInfo r2 = (UserInfo)in.readObject();
			 *
			 * System.out.println(r1.toString());
			 * System.out.println(r2.toString());
			 */
			Object users = null;
			while ((users = in.readObject()) != null) {
				System.out.println(((UserInfo) users).toString());
			}
		} catch (FileNotFoundException e) {
			System.out.println("파일이 존재하지 않아요");
		} catch (EOFException e) {
			System.out.println("끝" + e.getMessage());
		} catch (IOException e) {
			System.out.println("파일을 읽을 수 없어요");
		} catch (ClassNotFoundException e) {
			System.out.println("해당 객체가 존재하지 않아요");
		} catch (Exception e) {
			System.out.println("나머지 예외");
		} finally {
			try {
				in.close();
				bis.close();
				fis.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}

		}

	}
}


```

### 조별과제\_Dos 창 기능 구현하기

내가 맡은 부분 dir(리스트 보여주기), delete(삭제)

```java
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

	public static void main(String[] args) throws Exception {

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


```

### 조별과제\_BookManager

핵심 내용

1. 직렬화된 파일 내용을 새로운 내용의 직렬화로 초기화 하지 않기 위해서는 시스템 시작 첫 번째 내용에 직렬화된 파일을 불러와 기존 내용을 가지고 있어야한다.
2. 직렬화 내용
3. HashMap을 이용

```java
package Book;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
//도서 관리자 클래스

public class BookManager {

	Scanner scan = new Scanner(System.in);

	Map<String, Book> book_dic = new HashMap<String, Book>();
	String filename = "Book.txt";

	FileOutputStream fos = null;
	BufferedOutputStream bos = null;
	ObjectOutputStream out = null;

	FileInputStream fis = null;
	BufferedInputStream bis = null;
	ObjectInputStream in = null;

	public void Run() {
		this.load();

		int key = 0;

		while ((key = selectMenu()) != 0) {

			switch (key) {

			case 1:
				addBook();
				break;

			case 2:
				removeBook();
				break;

			case 3:
				searchBook();
				break;

			case 4:
				listBook();
				break;

			case 5:
				listISBN();
				break;

			default:
				System.out.println("잘못 선택하였습니다.");
				break;

			}

		}

		System.out.println("종료합니다...");

	}

	int selectMenu() {

		System.out.println("1:추가 2:삭제 3:검색 4:도서 목록 5:ISBN 목록0:종료");

		int key = scan.nextInt();

		scan.nextLine();

		return key;

	}

	void addBook() {

		String isbn;

		System.out.print("추가할 도서 ISBN:");

		isbn = scan.nextLine();

		if (book_dic.containsKey(isbn)) {

			System.out.println("이미 존재하는 ISBN입니다.");

			return;

		}

		String title;

		int price;

		System.out.print("도서 제목:");

		title = scan.nextLine();

		System.out.print("가격:");

		price = scan.nextInt();

		scan.nextLine();

		Book book = new Book(isbn, title, price);

		book_dic.put(isbn, book);

		save(book_dic);

		System.out.println(book.toString() + " 생성하였습니다.");

	}

	void removeBook() {

		String isbn;

		System.out.print("삭제할 도서 ISBN:");

		isbn = scan.nextLine();

		if (book_dic.containsKey(isbn)) {

			book_dic.remove(isbn);

			System.out.println("삭제하였습니다.");
			save(book_dic);
		}

		else {

			System.out.println("존재하지 않습니다.");

		}

	}

	void searchBook() {

		String isbn;

		System.out.print("검색할 도서 ISBN:");

		isbn = scan.nextLine();

		if (book_dic.containsKey(isbn)) {

			Book book = book_dic.get(isbn);
			System.out.println("검색 결과>>" + book.toString());

		}

		else {

			System.out.println("존재하지 않습니다.");

		}

	}

	void listBook() {

		System.out.println("도서 목록");

		int cnt = book_dic.size();

		System.out.println("도서 수:" + cnt);
		for (Book book : book_dic.values()) {

			System.out.println(book.toString());

		}

	}

	void listISBN() {

		System.out.println("ISBN 목록");

		int cnt = book_dic.size();

		System.out.println("도서 수:" + cnt);

		for (String isbn : book_dic.keySet()) {

			System.out.println(isbn);

		}

	}

	void save(Map<String, Book> book_dic2) {
		try {
			fos = new FileOutputStream(filename);
			bos = new BufferedOutputStream(fos);
			// 직렬화
			out = new ObjectOutputStream(bos);

			out.writeObject(book_dic2);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				out.close();
				bos.close();
				fos.close();
				System.out.println("파일 생성 -> buffer-> 직렬화 -> 파일 wirite");

			} catch (Exception e) {
				// TODO: handle exception
			}
		}

	}

	void load() {
		try {
			fis = new FileInputStream(filename);
			bis = new BufferedInputStream(fis);
			in = new ObjectInputStream(bis);
			/*
			 * Object users = null; while((users = in.readObject())!=null) {
			 * System.out.println(("직렬화된 도서는 : " +(Book)users).toString());
			 *
			 * }
			 */
			book_dic = (HashMap) in.readObject();

			Set<String> set = book_dic.keySet();

			for (String number : set) {
				String isbn = book_dic.get(number).getIsbn();
				String title = book_dic.get(number).getTitle();
				int price = book_dic.get(number).getPrice();


			}

		} catch (FileNotFoundException e) {
			System.out.println("파일이 존재하지 않아요");
		} catch (EOFException e) {
			System.out.println("끝" + e.getMessage());
		} catch (IOException e) {
			System.out.println("파일을 읽을 수 없어요");
		} catch (ClassNotFoundException e) {
			System.out.println("해당 객체가 존재하지 않아요");
		} catch (Exception e) {
			System.out.println("나머지 예외");
		} finally {
			try {
				in.close();
				bis.close();
				fis.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
	}

}

```

```java
package Book;

import java.io.Serializable;

//도서 클래스

public class Book implements Serializable{

      final String isbn;
      String title;
      int price;

      public Book(String isbn, String title,int price){
             this.isbn = isbn;
             this.title = title;
             this.price = price;
      }

      public String getIsbn() {
		return isbn;
	}

	public String getTitle() {
		return title;
	}

	public int getPrice() {
		return price;
	}

	public String ISBN(){
             return isbn;
      }

      public String toString(){
             return String.format("ISBN:%s 이름:%s 가격:%d", isbn, title,price);        }
}
```

```java
package Book;

//처음 하시는 분
//추가사항 : 파일 저장 , 파일 읽기
public class BookMain {
	public static void main(String[] args) {
		BookManager bm = new BookManager();
      bm.Run();
//      bm.직렬화();
	}

}

```

### WeightManager 직렬화 참고자료

```java
package kr.or.data.object;



import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Weight_Manager {
    public Scanner keyboard = new Scanner(System.in);
    public String str_name="기본값";
    public String str_weight="기본값";
    public String str_password="기본값";
    String[] txt_data=null;
    File f;
    File fd= new File("C://WeightMgData/"); //파일이 생성될곳

    public static void main(String[] args) {
    	Weight_Manager wm = new Weight_Manager();
        int choiceInt;

        while (true) {

            try {
                wm.showMenu();
                choiceInt = wm.keyboard.nextInt();
                wm.keyboard.nextLine(); //다음 입력을 위해 날림
                System.out.println();

                if (choiceInt < 1 || choiceInt > 5) // 주어진 메뉴의 범위를 벗어나면
                    throw new MenuChoiceException(choiceInt); // 정의해놓은 Exception발생

                switch (choiceInt) {
                case 1: wm.inputWeight();break;
                case 2: wm.searchWeight();break;
                case 3: wm.changeWeight();break;
                case 4: wm.changePassword();break;
                case 5:
                    System.out.println("프로그램을 종료합니다.");
                    return;
                    // System.exit(0);
                }// switch문 닫기
            } catch (MenuChoiceException e) {
                e.showWrongChoice();
                System.out.println("메뉴 선택을 처음부터 다시 진행합니다.");
                System.out.println();

            } catch(IOException e){
                System.out.println(e + "오류발생");

            } catch(Exception e){
                 String temp = wm.keyboard.nextLine();  //재입력을 위해 키보드로 입력받은 값을 문자로 다시 받음
                 System.out.println("입력하신 "+temp+"는 숫자가 아닙니다.");
                System.out.println("메뉴 선택을 처음부터 다시 진행합니다.");
                System.out.println();
            }// catch문닫기

        }// while문 닫기
    }

    //===========================================메뉴를 보여주는 메서드
 public void showMenu() {

        str_name="기본값";
        str_weight="기본값";
        str_password="기본값";

        System.out.println("\n다음 사항에 맞게 입력하여 주십시요");
        System.out.println("======> 몸무게 입력은  1번");
        System.out.println("======> 몸무게 검색은  2번");
        System.out.println("======> 몸무게 변경은  3번");
        System.out.println("======> 비밀번호변경은 4번");
        System.out.println("======> 프로그램종료는 5번");
        System.out.println("을 입력한후 Enter을 눌러주십시요");
        System.out.print("메뉴 선택 : ");
    }
    //==============================================================

    //===============================================//몸무게 입력하기
 public void inputWeight() throws IOException{
        boolean fileExist;

        System.out.println("이름을 입력하여 주십시요.");
        System.out.print("이름 : ");
        this.str_name = keyboard.nextLine();
        System.out.println();//@@

        File f= new File("C://WeightMgData/"+this.str_name+".txt"); //기록할 파일객체 생성

        if( !f.exists()){

            System.out.println("몸무게를 입력하여 주십시요.");
            System.out.print("몸무게 : ");
            this.str_weight = keyboard.nextLine();
            System.out.println();
            System.out.println("비밀번호를 입력하여 주십시요.");
            System.out.print("비밀번호 : ");
            this.str_password = keyboard.nextLine();
            System.out.println();

            showResult(); //입력한 값 보여주기

            //File fd= new File("C://WeightMgData/");
            //File f= new File("C://WeightMgData/"+this.str_name+".txt"); //파일생성
            if (!fd.exists()) fd.mkdir(); // C://WeightMgData/폴더 생성//@@
            FileWriter fw = new FileWriter(f);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(this.str_weight+":");  //생성한 파일에 쓰기
            bw.write(this.str_password);

            bw.close();
            System.out.println("___입력이 완료되어_..[ C://WeightMgData/"+this.str_name+".txt ]._가(이) 생성되었습니다.");
        }else{
            System.out.println("현재 ["+this.str_name+"] 사용자가 존재합니다.");
            System.out.println("메뉴 선택을 처음부터 다시 진행합니다.");
            System.out.println();
        }

    }//inputWeight닫기

    //===============================================//몸무게 검색하기
 public void searchWeight() throws IOException{

        boolean passcheck = fileCheck();

        if (passcheck) {
            System.out.println("*****************************************************************");
            System.out.println("\t\t" + this.str_name + "님의 몸무게는 "+ txt_data[0] + " kg 입니다.");
            System.out.println("*****************************************************************");
            System.out.println();

        } else {
                return;
        }
        System.out.println();
    }//searchWeight() 닫기

    //===============================================//몸무게 변경하기
 public void changeWeight() throws IOException{

        boolean passcheck = fileCheck();

        if (passcheck) {
            System.out.println("*****************************************************************");
            System.out.println("\t\t"+this.str_name+"님의 몸무게는 "+this.txt_data[0]+" kg 입니다.");
            System.out.println("*****************************************************************");
            System.out.println("\t\t변경할 몸무게를 입력하여 주십시요.");
            System.out.print("\t\t변경할 몸무게 : ");
            this.str_weight = keyboard.nextLine();

            FileWriter fw = new FileWriter(f);
            BufferedWriter bw = new BufferedWriter(fw);
            //int str_num = txt_data[1].length();
            //System.out.println(str_num);
            bw.write(this.str_weight+":");
            //bw.write(this.str_weight, 1, str_num-1);
            bw.write(this.str_password);

            bw.close();
        }else{
            return;
        }

        showResult();

    }//changeWeight() 닫기

    //===============================================//패스워드 변경하기
  public void changePassword() throws IOException{

        boolean passcheck = fileCheck();

        if (passcheck) {
            System.out.println("*****************************************************************");
            System.out.println("\t\t"+this.str_name+"님의 비밀번호는는 "+this.str_password+" 입니다.");
            System.out.println("*****************************************************************");
            System.out.println("\t\t변경할 패스워드를 입력하여 주십시요.");
            System.out.print("\t\t변경할 패스워드 : ");
            this.str_password = keyboard.nextLine();

            FileWriter fw = new FileWriter(f);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(this.str_weight+":");
            bw.write(this.str_password);
            bw.close();

        }else{
            return;
        }

        showResult();

    }//changePassword()닫기

  public boolean fileCheck() throws IOException{
        //검색, 몸무게 변경, 패스워드 변경시 입력받은 이름에 대한 파일존재여부체크 ,입력받은 패스워드에 대한 체크
        FileReader fr=null;
        BufferedReader br=null;
        String cmp_data;        //txt파일에서 한줄 읽어오기
        boolean boo = false;    //상태 체크

        System.out.println("검색할 이름을 입력하여 주십시요.");
        System.out.print("이름 : ");
        this.str_name = keyboard.nextLine();
        System.out.println();

        f= new File(fd.getAbsolutePath()+"/"+this.str_name+".txt"); //입력받은이름으로 파일경로 생성

        if(f.exists()){ //파일이 존재하면//@@
            fr= new FileReader(f);  //파일 읽을 준비
            br= new BufferedReader(fr);
            cmp_data = br.readLine(); //읽어온 파일에서 한줄을 cmp_data에 저장한다.
            txt_data = cmp_data.split(":"); // ':' 로 쪼개 txt_data배열에 저장
            //System.out.println(txt_data.length); //txt_data배열 크기 보기
            br.close(); //닫기



            //int cnt = 2;  //비밀번호 체크를 3회만 한다.
            //while(cnt>0){
            for( int cnt = 3;cnt>0;cnt--){

                System.out.println("비밀번호를 입력하여 주십시요.");
                System.out.print("비밀번호 : ");
                this.str_password = keyboard.nextLine();
                System.out.println();

                if (txt_data[1].equals(this.str_password)) {
                    this.str_weight = txt_data[0];
                    boo =  true;
                    break;
                } else {

                    if(cnt > 1) {
                    System.out.println("입력하신 비밀번호가 일치하지 않습니다.");
                    System.out.print((cnt-1) + "번의 기회가 남았습니다. 올바른 ");
                    }else{

                    System.out.println("입력하신 비밀번호가 일치하지 않습니다.");
                    System.out.println("메뉴 선택을 처음부터 다시 진행합니다.");
                    System.out.println("======================================");
                    System.out.println();

                    }

                    /*System.out.print("비밀번호 : ");
                    this.str_password = keyboard.nextLine();
                    --cnt;*/
                }
            }
        }else{//f.getName()
            System.out.println(str_name+"님 이(가) 존재하지 않습니다.");
            boo = false;
            }
        return boo;
    }


 public void showResult(){   //입력받은 값을 보여주기
    System.out.println();
    System.out.println("*****************************************************************");
    System.out.println("\t이름 : "+this.str_name +", \t몸무게 : "+ this.str_weight + ",\t 비밀번호 : "+this.str_password);
    System.out.println("*****************************************************************");
    System.out.println();
}



}//WeightManagExam000 class닫기



class MenuChoiceException extends Exception { //잘못된 선택을 하게되면 생성될 Exception
    int wrongChoice; // 잘못된 입력값저장하기 위한 변수

    public MenuChoiceException(int choice) // 입력값을 받는 생성자
    {
        super("잘못된 선택이 이뤄졌습니다.");
        // Exception(String message)
        wrongChoice = choice; // 전달 받은 인자값을 전역변수 wrongChoice에 저장
    }

    public void showWrongChoice() {
        System.out.println(wrongChoice + "에 해당하는 선택은 존재하지 않습니다.");
    }


}// class MenuChoiceException 닫기
```
