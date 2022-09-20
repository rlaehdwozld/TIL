package com.victoree2.system;


import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

import com.victoree2.common.AccountData;
import com.victoree2.common.SerializableInterface;
import com.victoree2.common.ReturnMessage;
import com.victoree2.main.ReadingRoom;

public class AccountSystem extends ReturnMessage implements SerializableInterface{
	
	Scanner scan = new Scanner(System.in);
	ReadingRoom room = new ReadingRoom();
	
	//key 값으로 id 값을 줄것이며 id값은 중복이 불가능하다.
	private HashMap<String, AccountData> account = new HashMap<String, AccountData>();
	
	boolean adminCheck = true;
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
	
	String filename = "C:\\KOSA_IT\\login\\UserDB1.txt";	
	File file = new File(filename);
	
	
	public HashMap<String, AccountData> getAccount() {
		return account;
	}

	public void signUP(){ //회원가입
		String regex = "^[a-zA-Z]{1}[a-zA-Z0-9_]{4,11}";
		boolean regexCheck;
		if(!adminCheck) {
			System.out.println(message(room.language, "0007")+" "+message(room.language, "0005")+message(room.language, "0006"));
			System.out.println(message(room.language, "0008")+" " + message(room.language, "0009") + " : ");
			String id = scan.nextLine();
			System.out.println(message(room.language, "0010") + " " + message(room.language, "0009") + " : ");
			String password = scan.nextLine();
			AccountData ac = new AccountData(id, "관리자", password, "00000000", 9);
			account.put(id, ac); 
			
			System.out.println(message(room.language, "0007")+" " +message(room.language, "0011"));
			adminCheck = true;
		}
		else {
			System.out.println(message(room.language, "0022"));
			System.out.println(message(room.language, "0008")+" " + message(room.language, "0009") + " : ");
			String id = scan.nextLine();
			System.out.println(message(room.language, "0023") + " " + message(room.language, "0009") + " : ");
			String name = scan.nextLine();
			System.out.println(message(room.language, "0010") + " " + message(room.language, "0009") + " : ");
			String password = scan.nextLine();
			System.out.println(message(room.language, "0024") + " " + message(room.language, "0009") + " : ");
			String birthday = scan.nextLine();
			System.out.println(message(room.language, "0025") + " " + message(room.language, "0009") + " : ");
			String phonenumber = scan.nextLine();
			AccountData ac = new AccountData(id, name, password, birthday,phonenumber);
			account.put(id, ac);
		}
		System.out.println(message(room.language, "0011"));
		save();
	}

	public AccountData login() { //로그인
		System.out.println(message(room.language, "0012"));
		System.out.println(message(room.language, "0008")+" " + message(room.language, "0009") + " : ");
		String id = scan.nextLine();
		System.out.println(message(room.language, "0010") + " " + message(room.language, "0009") + " : ");
		String password = scan.nextLine();
		AccountData returnValue=null;
		
		if((!account.containsKey(id))||(!account.get(id).getPassword().equals(password)))
		{
			//해킹시도시, 아이디가 틀렸는지 패스워드가 틀렸는지 확인방지.
			System.out.println(message(room.language, "0013"));
			returnValue = null;
		}
		else if (account.get(id).getPassword().equals(password)) {
			returnValue = account.get(id);
		}

		return returnValue;
	}

	public void delete(HashMap<String, AccountData> account) {//계정삭제
		this.account = account;	
	}

	public void resetPassword() {//패스워드초기화
		// TODO Auto-generated method stub
		
	}
	@Override
	public void save(){
		try {
			fos = new FileOutputStream(file);
			bos = new BufferedOutputStream(fos);
			out = new ObjectOutputStream(bos);
			
			out.writeObject(account);
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
					adminCheck = false;
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
			System.out.println(message(room.language, "0014"));
		} catch (EOFException e) {
			System.out.println(message(room.language, "0015") + e.getMessage());
		} catch (IOException e) {
			System.out.println(message(room.language, "0016")+ e.getMessage());	
		}  catch (Exception e) {
			System.out.println(message(room.language, "0017") + e.getMessage());
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
