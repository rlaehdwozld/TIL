package com.victoree2.user;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class User1 {

	public static void main(String[] args) {
		boolean pass = false;
		Scanner scan = new Scanner(System.in);
		System.out.println("아이디와 패스워드를 입력하시오.");
		System.out.println("ID 입력 : ");
		String id = scan.nextLine();
		System.out.println("패스워드 입력 : ");
		String pw = scan.nextLine();
		File file = new File("C:\\Users\\USER\\Desktop\\login\\UserDB.txt");
		try {
			FileReader filereader = new FileReader(file); //file의 정보를 읽어준다.
			BufferedReader bufReader = new BufferedReader(filereader); // filereader의 정보를 가지고 있는 클래스
			String line = "";
			try {
				while((line = bufReader.readLine()) != null) //line에  bufReader값을 메모장의 한 라인들을 확인함. null이 아닌값이여야함.
				{
					System.out.println(line.indexOf(id) + "\t" + line.indexOf(pw)); //아이디와 패스워드 출력해볼꺼임.
					int passId = line.indexOf(id); //위치값을 줄꺼임
					int passPw = line.indexOf(pw);
					if(passId != -1 && passPw != -1) {
						System.out.println("로그인 성공");
					pass = true;
					}
					if(pass == false)
					{
						System.out.println("로그인 실패");
					}
				}
				bufReader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} 
		
	}

}
