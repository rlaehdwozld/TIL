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
