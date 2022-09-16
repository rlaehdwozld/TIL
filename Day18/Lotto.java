package kr.or.kosa;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Set;
import java.util.TreeSet;

class Lotto2 {
	Calendar cal = Calendar.getInstance();
	SimpleDateFormat dateformat = new SimpleDateFormat("yyyy년MM월 dd일 HH:mm");
	Set<Integer> lotto = new TreeSet<Integer>();
	FileReader fr = null;
	FileWriter fw = null;
	BufferedReader br = null;
	BufferedWriter bw = null;
	String time;

	public Lotto2() {

		for (int i = 0; lotto.size() < 6; i++) {
			lotto.add((int) (Math.random() * 45 + 1));
		}
	}

	void read() {
		try {
			fr = new FileReader("Lotto.txt");

			int data = 0;
			while ((data = fr.read()) != -1) {
				System.out.print((char) data);
			}

		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			try {
				fr.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}

	}

	void write() {
		try {
			this.Time();
			this.number();

			fw = new FileWriter("Lotto.txt", true);
			bw = new BufferedWriter(fw);
			bw.write("로또번호: " + lotto.toString() + " " + time);
			bw.newLine();
			bw.flush();

		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			try {
				fw.close();
				bw.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}

	}

	void number() {

		for (int i = 0; lotto.size() < 6; i++) {
			lotto.add((int) (Math.random() * 45 + 1));
		}
	}

	void Time() {
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy년mm월dd일 hh:mm");
		time = dateFormat.format(cal.getTime());
	}
}

public class Lotto {

	public static void main(String[] args) {
		Lotto2 lotto2 = new Lotto2();
		lotto2.write();
		lotto2.read();

	}

}
