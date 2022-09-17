import java.io.DataOutputStream;
import java.io.FileOutputStream;

/*
내가 성적데이터를 파일로 저장할 때 한명의 성적 데이터와 다음 사람의 성적데이터를 나누는것에 대한고민
엔터로 구분 할지
컴마로 구분할지 
탭으로 할지
파일처리의 단점은 기준이 있어야한다.
만약에 김.이.박 이렇게 되어 있을 때 .을 빼고 가지고 와야한다.
그래서 나온 것이 스트링 값을 "123"을 int 값으로 저장해줄 수 있는 기능이 있는 스트림이다.

DataoutputStream
DataInputStream

java 8가지 기본 타입 ( 타입별로 writer, read)할 수 있ㄷ가
단!!!! 조건은 (DataoutputStream , DataInputStream) 둘이 같이 쓰여야한다.

만약 )
성적.txt
100,20,60,88은 문자열 데이터이다. 이것을 split을 해서 >배열에 넣어서> 연산하려면 integer.pareint해서 정수로 바꿔야한다.
//이 과정이 너무 기니깐 필요한 방법이다
 //일단 읽는 것을 
*/
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
