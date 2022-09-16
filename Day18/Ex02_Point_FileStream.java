import java.io.FileInputStream;
import java.io.FileOutputStream;

/*
Byte 데이터를 read, write >> 그 대상이 >> File
FileInputStream
FileOutputStream


(이미지 , 엑셀 파일) read, write 하는 목적 (텍스트 파일은 read, write는 안함)
File >> 1.txt, data.txt(데이터를 파일에 기록) 

I/O 클래스 예외를 강제.... try catch 

//I/O자원은 가비지 컬렉터에 올라가지 않기 떄문에 개발자가 직접적으로 자원에 대한 해제를 해야한다. (여러 사용자들이 접근 해서 사용 가능하다)
 >>close()
//
*/
public class Ex02_Point_FileStream {
	public static void main(String[] args) {
		FileInputStream fs =null;
		FileOutputStream fos=null;
		
		String path = "C:\\Temp\\a.txt";
		
		try {
			fs= new FileInputStream(path);
			fos = new FileOutputStream("C:\\Temp\\new.txt");
				
				
				
				/*
				FileOutputStram 
				1. write하는 파일이 존재 하지 않으면 >> 자동으로 파일을 생성한다(create)
				2. 	fos = new FileOutputStream("C:\\Temp\\new.txt",false);
					false >> overwrite
					
				3. 	fos = new FileOutputStream("C:\\Temp\\new.txt",true);
					true >> append 
					//ex 홍길동의 대출 목록을 관리하려고 하면 append를 해야한다. (대출 목록역사를 기록)
				*/
			
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
				fs.close();
				fos.close();
			}catch(Exception e) {
				// 이렇게 해야 이쁜 코드이다. 혼자서 할때는 큰문제는 없지만 공유 파일을 이용할 떄는 필수적으로 해야한다. 
				// 범종이 파일 수정중 나한테 파일 사용중이라는 메시지 뜨는 것 처럼
			}
		}
		
	}

}
