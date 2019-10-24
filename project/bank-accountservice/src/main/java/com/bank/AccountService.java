package com.bank;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.util.JSONPObject;

@Service
public class AccountService {

	@Autowired
	AccountRepository accountRepository;
	
	public List<Accounts> getAccount(int userid) {
		return accountRepository.getAccountsByUserid(userid);
	}
	
	public String addAccount(Accounts accounts) {
		if (accounts != null) {
			accountRepository.save(accounts);
			return "Account Added Successfully";
		} else {
			return "Account Details cannot be empty";
		}
	}
	
	public String deleteAccount(int accountnum) {
		accountRepository.deleteById(accountnum);
		return "Account Deleted Successfully";
 	}
}
