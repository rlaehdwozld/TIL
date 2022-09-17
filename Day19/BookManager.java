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