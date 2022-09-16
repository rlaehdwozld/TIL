package kr.or.kosa;

import java.io.BufferedReader;
import java.io.FileReader;

public class lottoReader {
	public static void main(String[] args) {
		FileReader fr = null;
		BufferedReader br = null;

		try {
			fr = new FileReader("Lotto1.java");
			br = new BufferedReader(fr);
			String line = "";
			for (int i = 0; (line = br.readLine()) != null; i++) {
				// System.out.println(line);
				if (line.indexOf(";") != -1) {
					System.out.println(line);
				}
			}
		} catch (Exception e) {
		} finally {
			try {
				br.close();
				fr.close();
			} catch (Exception e2) {
			}

		}
	}
}
