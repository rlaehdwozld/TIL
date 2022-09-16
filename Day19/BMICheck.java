package kr.or.data.object;




import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;
import java.io.*;
import kr.or.data.object.BMI;

public class BMICheck {
	//*******************************************************
	//POINT
	static HashMap<Integer, BMI> map = new HashMap<Integer, BMI>();//실무에서 가장많이 사용하는 코드 중요하다!!!!!!!!
	//아까는 홍길동 이순신 객체를 각각직렬화 해서 썼지만 각각을 하나씩 직렬화 하면 귀찮으니깐 map하나에 모든 객체를 담고 map을 직렬화 하면 된다.!!!!!!
	static int count = 1;
	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		BMICheck bc = new BMICheck();
		while(true){
		System.out.println("비만도 측정합니다!!!!");
		System.out.print("<1>추가 <2>삭제 <3>출력 <4>저장 <5>로드 <6>종료 : ");

		switch (scan.nextInt()) {
		case 1:
			bc.add();
			break;
		case 2:
			bc.delete();
			break;
		case 3:
			bc.print();
			break;
		case 4 :
			bc.save();
			break;
		case 5:
			bc.load();
			break;
		case 6:
			bc.exit();
			break;

		}// switch
		}//while
	}// main

	private void save() {
		File file = new File("bmi.txt");
		
		try{
			FileOutputStream fos = new FileOutputStream(file);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			
			oos.writeObject(map); //map 안에는  (1,new BMI) (2,new BMI) (3, new BMI)
			
			oos.close();
			fos.close();
		}catch(Exception e){
			System.out.println("에러발생!!!");
			e.printStackTrace();
		}
		System.out.println("저장되었습니다.");
	}

	private void exit() {
		System.out.println("시스템을 종료합니다.");
		System.exit(0);
		scan.close();
	}

	private void print() {
		Set<Integer> set = map.keySet();
		System.out.println("번호\t키\t몸무게\t결과\t판정");
		for (Integer number : set) {
			double length = map.get(number).getLength();
			double weight = map.get(number).getWeight();
			double result = map.get(number).getResult();
			String you = map.get(number).getYou();

			System.out.printf("%s\t%.2f\t%.2f\t%.2f\t%s\n", number, length, weight, result, you);
		}
	}

	private void delete() {
		System.out.print("삭제하실 넘버를 입력해 주세요 : ");
		int num = scan.nextInt();
		if (map.containsKey(num)) {
			map.remove(num);
			System.out.println("삭제되었습니다.");
		} else {
			System.out.println("고객넘버를 잘못입력하셨습니다. 해당 정보가 없습니다.");
		}
	}

	private void add() {
		BMI bmi = new BMI();
		map.put(count, bmi.input(bmi));
		count++;
	}
	
	private void load() {
		File file = new File("bmi.txt");
		try{
			FileInputStream fis = new FileInputStream(file);
			ObjectInputStream oos = new ObjectInputStream(fis);
			
			map = (HashMap)oos.readObject();
			//읽어올때도 map을 부르는 방식 
			
			Set<Integer> set = map.keySet();
			//set에 저장해서 불러온다.
			System.out.println("번호\t키\t몸무게\t결과\t판정");
			for (Integer number : set) {
				double length = map.get(number).getLength();
				double weight = map.get(number).getWeight();
				double result = map.get(number).getResult();
				String you = map.get(number).getYou();

				System.out.printf("[%s]\t%.2f\t%.2f\t%.2f\t%s\n", number, length, weight, result, you);
			}
			oos.close();
			fis.close();
			
		}catch(Exception e){
			System.out.println("불러오는데 실패하였습니다.");
			e.printStackTrace();
		}
	}
}// class