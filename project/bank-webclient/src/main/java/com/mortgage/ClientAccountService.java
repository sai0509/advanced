package com.mortgage;

import java.util.List;

public interface ClientAccountService {
	
	public String addAccount(Accounts accounts);
	
	public String deleteAccount(int accountnum);
	
	public List<Accounts> getAccount(int userid);
}
