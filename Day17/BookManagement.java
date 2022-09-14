package kr.or.kosa;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

class Book {
	private String bISBN;
	private String bname;
	private int bprice;

	public Book() {
	}

	public Book(String bISBN, String bname, int bprice) {
		this.bISBN = bISBN;
		this.bname = bname;
		this.bprice = bprice;
	}

	public String getBISBN() {
		return bISBN;
	}

	public String getBname() {
		return bname;
	}

	public int getBprice() {
		return bprice;
	}

	@Override
	public String toString() {
		return "Book [ISBN=" + bISBN + ", 책이름=" + bname + ", 책가격=" + bprice + "]";
	}

}

public class BookManagement {
	String ISBN = "";
	String bname = "";
	int bprice = 0;

	String inputISBN = "";
	String inputName = "";
	int inputPrice;

	String compareISBN = "";
	String compareName = "";
	int comparePrice = 0;

	int searchItem;

	int menuNum;

	HashMap<String, Book> hs;
	Scanner sc = new Scanner(System.in);

	public void menu() {

		while (true) {
			System.out.println("도서관리 프로그램");
			System.out.println("1. 책 추가");
			System.out.println("2. 책 삭제");
			System.out.println("3. 책 검색");
			System.out.println("4. 책 목록");
			System.out.println("5. 일련번호 목록");
			System.out.println("0. 종료");
			menuNum = sc.nextInt();

			switch (menuNum) {
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
				printBookList();
				break;
			case 5:
				printISBNList();
				break;
			case 0:
				return;
			default:
				System.out.println("정해진 번호만 누르세요");
				break;
			}
		}
	}

	public BookManagement() {
		hs = new HashMap<String, Book>();
		ISBN = "";
		bname = "";
		bprice = 0;

		inputISBN = "";
		inputName = "";
		inputPrice = 0;

		compareISBN = "";
		compareName = "";
		comparePrice = 0;

		hs.put("1235", new Book("1235", "수학책", 6000));
//		hs.put("1236", new Book("1236", "과학책", 7000));
//		hs.put("1237", new Book("1237", "영어책", 8000));
//		hs.put("1238", new Book("1238", "국어책", 9000));
//		hs.put("2234", new Book("2234", "이순신 위인전", 6000));
//		hs.put("2235", new Book("2235", "나폴레옹 위인전", 7000));
//		hs.put("2236", new Book("2236", "장영실 위인전", 8000));
//		hs.put("3234", new Book("3234", "자바의 정석", 6000));
//		hs.put("3235", new Book("3235", "혼공자", 7000));
//		hs.put("3236", new Book("3236", "자바100제", 8000));
	}

	@Override
	public String toString() {
		return "BookManagement [ISBN=" + ISBN + ", bname=" + bname + ", bprice=" + bprice + "]";
	}

	public void addBook() {
		inputISBN = "";
		inputName = "";
		inputPrice = 0;

		System.out.println("고교 교과서 번호 1xxx");
		System.out.println("위인전 번호 : 2xxx");
		System.out.println("it 교재 : 3xxx");
		System.out.println("책 번호 입력");
		inputISBN = sc.next();
		System.out.println("책 이름 입력");
		inputName = sc.next();
		System.out.println("책 가격 입력");
		inputPrice = sc.nextInt();
		System.out.println("숫자를 입력하세요");
		sc.nextLine();
		hs.put(inputISBN, new Book(inputISBN, inputName, inputPrice));
		System.out.printf("ISBN : %s 이름 : %s 가격 : %d", inputISBN, inputName, inputPrice);
		System.out.println();
	}

	public void searchBook() {
		System.out.println("검색할 책 번호를 입력하세요");
		String inputCompareISBN = sc.next();
		Book compareBook = hs.get(inputCompareISBN);
		if (compareBook == null) {
			System.out.println("그런 책 없습니다.");
		} else {
			System.out.println("찾으신 책은");
			System.out.println("책번호" + compareBook.getBISBN());
			System.out.println("책이름" + compareBook.getBname());
			System.out.println("책가격" + compareBook.getBprice());
		}
	}

	public void removeBook() {
		System.out.println("삭제할 책 번호를 입력하세요");
		String inputCompareISBN = sc.next();
		Book compareBook = hs.get(inputCompareISBN);
		if (compareBook == null) {
			System.out.println("그런 책 없습니다.");
		} else {
			if (compareBook.equals(inputCompareISBN)) {
				hs.remove(compareBook);
			}
		}
		System.out.println("삭제할 도서 :" + inputCompareISBN);
		System.out.println("책이 삭제되었습니다");
	}

	public void printBookList() {
		for (int i = 0; i < hs.size(); i++) {
			Set set = hs.keySet();
			Object[] obj = set.toArray();

			System.out.println("ISBN" + obj[i]);
			System.out.println(hs.get(obj[i]));
		}
		System.out.println();

	}

	public void printISBNList() {
		for (int i = 0; i < hs.size(); i++) {
			Set set = hs.keySet();
			Object[] obj = set.toArray();

			System.out.println("Key : " + obj[i]);
		}
	}

	public static void main(String[] args) {
		BookManagement book = new BookManagement();
		book.menu();

	}

}
