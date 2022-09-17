import java.io.BufferedReader;
import java.io.FileReader;

/*
출력 형식 저장
1. printf
2. String.format
3. PrintWriter(레포팅)
4. 현업 : 레포팅 소프트웨어(양식지 : 전표, 세금 계산서, 인사(휴가지원서)
4.1 크리스탈 레포트, 오즈

*/
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
