package Day5;

public class VendingMachine {
	public boolean power;
	private int change;

	public void ch_up() {
		change++;
	}

	public void ch_dn() {
		change--;
	}
	
	public void vd() {
		System.out.println("잔돈은"+change);
	}
}
