/**
 * 
 */
package com.saikumar.ms.accounts;

import java.util.List;

/**
 * @author epuri.kumar
 *
 */
public interface AccountRepository {
	
	List<Account> getAllAccounts();
	
	Account getAccount(String number);
}
