package com.victoree2.user;


import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.EOFException;
import java.io.File;
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

import com.victoree2.common.Account;
import com.victoree2.common.AccountInterface;

public class SignupSystem implements AccountInterface{
	
	Scanner scan = new Scanner(System.in);
	
	//key 값으로 id 값을 줄것이며 id값은 중복이 불가능하다.
	HashMap<String, Account> account = new HashMap<String, Account>();
	boolean admin_check = true;
	private String id;
	private String password;

	
	//파일 직렬화
	FileOutputStream fos = null;
	BufferedOutputStream bos = null;
	ObjectOutputStream out = null;
	
	//파일 역 직렬화
	FileInputStream fis = null;
	BufferedInputStream bis = null;
	ObjectInputStream in = null;
	
	
	Set<String> set;
	
	String filename = "C:\\KOSA_IT\\login\\UserDB.txt";	
	File file = new File(filename);
	

	@Override
	public void signUP(){
		String regex = "^[a-zA-Z]{1}[a-zA-Z0-9_]{4,11}";
		boolean regexCheck;
		if(!admin_check) {
			System.out.println("관리자 계정이 없습니다. 관리자 계정을 만들어주세요.");
			System.out.println("ID 입력 : ");
			String id = scan.nextLine();
			System.out.println("패스워드 입력 : ");
			String password = scan.nextLine();
			Account admin = new Account(id, "관리자", password, "00000000", "00000000", "99999999", 9);
			account.put(id, admin); 
			
			System.out.println("관리자 계정을 생성하였습니다.\n");
			admin_check = true;
		}
		else {
			System.out.println("아이디와 패스워드를 입력하시오.");
			System.out.println("ID 입력 : ");
			String id = scan.nextLine();
			System.out.println("패스워드 입력 : ");
			String password = scan.nextLine();
			Account admin = new Account(id, "관리자", password, "00000000", "00000000", "99999999");
			account.put(id, admin);
		}
		save();
	}


	@Override
	public int login() {
		System.out.println("아이디와 패스워드를 입력하시오.");
		System.out.println("ID 입력 : ");
		String id = scan.nextLine();
		System.out.println("패스워드 입력 : ");
		String password = scan.nextLine();
		int returnValue=0;
		
		if((!account.containsKey(id))||(!account.get(id).getPassword().equals(password)))
		{
			//해킹시도시, 아이디가 틀렸는지 패스워드가 틀렸는지 확인방지.
			System.out.println("아이디 또는 패스워드가 틀렸습니다.");
			returnValue = -1;
		}
		else if (account.get(id).getPassword().equals(password)) {
			returnValue = account.get(id).getStatus();
		}

		return returnValue;
	}

	@Override
	public void delete() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resetPassword() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void save(){
		try {
			fos = new FileOutputStream(file);
			bos = new BufferedOutputStream(fos);
			out = new ObjectOutputStream(bos);
			
			out.writeObject(account);
			System.out.println(out);
		} catch (Exception e) {
			System.out.println(e);
		}finally {
			try {
				out.close();
				bos.close();
				fos.close();
			} catch (Exception e2) {
				System.out.println(e2);
			}
		}
	}
	@Override
	public void load() {
		//역질렬화로 계정을 정보를 읽음.

		try {
			// 파일이 없을경우 생성.
			if (!file.exists())
				file.createNewFile();

				fis = new FileInputStream(file);
//				if (fis.read() == -1) {
				if (fis.getChannel().size() == 0) {
					admin_check = false;
					signUP();
					// 관리자 계정이 없을경우 생성을 해주며 아래 fis를 계정이 있는 상태의 파일로 읽으므로서 예외발생 x
					fis = new FileInputStream(file);
				}
				bis = new BufferedInputStream(fis);
				in = new ObjectInputStream(bis);
				
				account = (HashMap)in.readObject();
//				System.out.println(account);
//				Set<String> test = account.keySet();
				
//				for(String value : test) {
//					String test1 = account.get(value).toString(); 
//				}
				
			
		} catch (FileNotFoundException e) {
			//User 클래스 생성자때 파일 자체를 만들지만 폴더 접근 권한이나 다른 이상현상으로 파일 생성이 안될경우 메세지 출력
			System.out.println("파일이 존재하지 않아요.");
		} catch (EOFException e) {
			System.out.println("끝 " + e.getMessage());
		} catch (IOException e) {
			System.out.println("파일을 읽을 수 없어요."+ e.getMessage());	
		}  catch (Exception e) {
			System.out.println("나머지 예외 : " + e.getMessage());
		}finally {
			try {
				in.close();
				bis.close();
				fis.close();
			}catch (Exception e) {
			}
		}
		/*
		 * 내꺼에서 안써지는데?
		 * catch (IOException e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); }
		 */	
	}
}
