package Day5;
import kr.or.kosa.Mouse;
import kr.or.kosa.NoteBook;
import kr.or.kosa.VendingMachine;

public class Ex04_Modifier {

	public static void main(String[] args) {
		NoteBook notebook = new NoteBook();
		notebook.setYear(2022);//마이너스 값은 못 넣는다.
		int year=notebook.getYear();
		System.out.println("year :"+year);
		
//	notebook.mouse.x=5;
//	notebook.mouse.y=4;
		
		Mouse mouse = new Mouse();//마우스가 heap메모리에 올라감
		System.out.println(mouse.x+":"+mouse.y);
		
		notebook.handle(mouse);
		System.out.println(mouse.x+":"+mouse.y);
		
		VendingMachine vs= new VendingMachine();
		vs.ch_up();
		vs.ch_up();
		vs.ch_up();
		vs.ch_up();
		vs.ch_up();
		
		vs.vd();
	}
	
	
	
	
}
