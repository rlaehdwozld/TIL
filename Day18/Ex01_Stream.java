import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.Arrays;

/*
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


*/
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
