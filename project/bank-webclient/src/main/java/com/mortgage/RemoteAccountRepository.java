package com.mortgage;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

/**
 * @author Dinesh.Rajput
 *
 */
public class RemoteAccountRepository implements ClientAccountService {
	
	
	protected String serviceUrl;
	
	public RemoteAccountRepository(String serviceUrl) {
		this.serviceUrl = serviceUrl.startsWith("http") ? serviceUrl
				: "http://" + serviceUrl;
	}

	@Override
	public String addAccount(Accounts accounts) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteAccount(int accountnum) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Accounts> getAccount(int userid) {
		// TODO Auto-generated method stub
		return null;
	}
	
//	@Override
//	public List<Account> getAllAccounts() {
//		Account[] accounts = restTemplate.getForObject(serviceUrl+"/accounts", Account[].class);
//		return Arrays.asList(accounts);
//	}
//
//	@Override
//	public Account getAccount(String number) {
//		return restTemplate.getForObject(serviceUrl + "/accounts/{id}",
//				Account.class, number);
//	}

}
