package com.victoree2.user;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserDB1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		File file = new File("C:\\Users\\USER\\Desktop\\login\\UserDB.txt"); //회원 정보를 넣을 파일 생성.
		String regex = "^[a-zA-Z]{1}[a-zA-Z0-9_]{4,11}";
		boolean regexCheck;
		//^문자열 구분 : 아이디값 하나만 구분하기위하여 사용할꺼임
		//앞에는 영(대/소문자)만 가능 나머지는 4~11자리 임의의 영문숫자를 사용할것.
		//Matcher matcher = pattern.matcher(input)
		//matches() : 대상 문자열과 패턴이 일치하는 경우 true 반환
	
		try {
			FileWriter filewriter = new FileWriter(file, true); //true 누적으로 이어쓰기이다. true가 없으면 덮어 쓰기.
			if(file.isFile() && file.canWrite()) //파일이 진짜 파일이며, 사용가능한 파일인지 조건 검사.
			{
				System.out.println("회원가입을 위한 ID와 패스워드를 입력하시오.");
				System.out.println("ID 입력 : ");
				String test = scan.nextLine();
				//정규식성공!
				regexCheck = Pattern.matches(regex, test);
				System.out.println(regexCheck);
				
				
				filewriter.append(test); //엔터를 칠떄까지 아이디값 입력 가능하게
				
				
				filewriter.append("\t"); // ID와 패스워드를 구분하기 위해 tab키를 줄꺼임. >> tab도 배열값으로 넣을꺼다.
				System.out.println("패스워드 입력 : ");
				filewriter.append(scan.nextLine()); //엔터를 칠떄까지 패스워드값 입력 가능하게
				filewriter.append("\r"); //다음사람도 회원가입 가능하게 개행문자를 넣어줌. 윈도우에선 \r 값을 받는듯 ??실제로는 \n가능했다.
			}
			filewriter.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		
	}

}
