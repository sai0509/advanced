package com.bank;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends CrudRepository<Accounts, Integer>{

	public List<Accounts> getAccountsByUserid(int userid);
}
