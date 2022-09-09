package kr.or.kosa;

import java.util.List;

public class BankStarter {

	public static void main(String[] args) {
	Bank bank = new Bank();
	bank.addAccount("1111", "kim");
	System.out.println(bank.getTotalAccount());
	System.out.println(bank.getAccount("1111"));
		
		
	}

}
