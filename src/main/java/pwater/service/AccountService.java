package pwater.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pwater.model.Account;
import pwater.repo.AccountRepo;

import java.util.ArrayList;
import java.util.List;


@Service
public class AccountService {
	
	@Autowired
    private AccountRepo accountRepo;
	
	public List<Account> findAll() {

		Iterable<Account> it = accountRepo.findAll();

        List<Account> accounts = new ArrayList<Account>();
        it.forEach(e -> accounts.add(e));

        return accounts;
    }

    public Long count() {

        return accountRepo.count();
    }

    public void deleteById(Long userId) {

    	accountRepo.deleteById(userId);
    }
    
    public void saveAccount(Account account) {
    	
    	accountRepo.save(account);
    }
    
    public Account findAccById(String email) {
    	
    	Account acc = accountRepo.findByEmail(email);
    	return acc;
    }
   
}
