package 명품자바;

class Song {
	String title;
	String artist;
	int year;
	String country;

	Song() {
	}

	Song(String title, String artist, int year, String country) {
		this.artist = artist;
		this.country = country;
		this.year = year;
		this.title = title;
	}

	void show() {
		System.out.printf("%d년 %s국적의 %s가 부른 %s", year, country, artist, title);
	}
}

public class Class_3 {
	public static void main(String[] args) {
		Song song = new Song("Dancing Queen","ABBA",1978,"스웨덴");
		song.show();
		

	}

}
