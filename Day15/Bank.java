package kr.or.kosa;

import java.util.ArrayList;
import java.util.List;

public class Bank {
	private List<Account> accounts =new ArrayList<Account>(); ;
	private int totalAccount;

	
	
	public void addAccount(String accountNo, String name) {
		Account account = new Account(accountNo, name);
		this.accounts.add(account);
		totalAccount++;
		
	}

	public Account getAccount(String accountNo) {
		//accountNo를 파라미터로 받아서 해당 파라미터의 값을 가지는 계좌를 찾아 반환
//		Account value = new Account(accountNo, accountNo); //파라미터를 이렇게 해야되나????
		for(Account value1 : accounts) {
			if(value1.getAccountNo().equals(accountNo))
			{
				return value1;
			}
		}
		return null;
	}

	public List<Account> findAccount(String name) {
		List<Account> nameList= new ArrayList<Account>();
		for(Account value:accounts) {
			if(value.getName().equals(name)) {
				nameList.add(value);
				
			}
		}
		return nameList;
	}

	public List<Account> getAccount() {
		return accounts;
	}
	
	
	public int getTotalAccount() {
		return totalAccount;
	}

}
