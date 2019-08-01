package pwater.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import pwater.model.Account;

@Repository
public interface AccountRepo extends CrudRepository<Account, Long> {
	public Account findByEmail(String email);
}

