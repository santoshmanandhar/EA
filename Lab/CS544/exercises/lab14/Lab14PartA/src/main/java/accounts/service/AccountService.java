package accounts.service;

import accounts.domain.Account;
import accounts.repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AccountService {
	@Autowired
	AccountRepository repository;
		
	public AccountDTO getAccount(String acountNumber) {
		Optional<Account> accountOptional = repository.findById(acountNumber);
		if (accountOptional.isPresent()) {
			Account account = accountOptional.get();
			AccountDTO accountDto = AccountAdapter.getAccountDto(account);
			return accountDto;
		}
		return null;
	}
	
	public void createAccount(String accountNumber, double amount, String accountHolder) {
		repository.save(new Account(accountNumber, amount, accountHolder));
	}
	

}
