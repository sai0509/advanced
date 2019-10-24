package com.bank;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/account")
public class AccountController {

	@Autowired
	AccountService accountService;
	
	@RequestMapping("/add")
	public String addAccount(@RequestBody Accounts accounts) {
		return accountService.addAccount(accounts);
	}
	
	@GetMapping("/getAccount/{id}")
	public List<Accounts> getAccount(@PathVariable("id") int userid) {
		return accountService.getAccount(userid);
	}
	
	@RequestMapping("/deleteAccount/{id}")
	public String deleteAccount(@PathVariable("id") int accountnum) {
		return accountService.deleteAccount(accountnum);
	}
}
