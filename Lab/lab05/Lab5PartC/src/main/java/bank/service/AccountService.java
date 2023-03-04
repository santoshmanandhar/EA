package bank.service;


import bank.domain.Account;
import bank.domain.AccountEntry;
import bank.domain.Customer;
import bank.dto.AccountDTO;
import bank.dto.CustomerDTO;
import bank.dto.adapter.AccountAdapter;
import bank.dto.adapter.AccountEntryAdapter;
import bank.dto.adapter.CustomerAdapter;
import bank.jms.IJMSSender;
import bank.jms.JMSSender;
import bank.logging.ILogger;
import bank.logging.Logger;
import bank.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class AccountService implements IAccountService {

	@Autowired
	private ICurrencyConverter currencyConverter;
	@Autowired
	private IJMSSender jmsSender;
	@Autowired
	private ILogger logger;
	
	@Autowired
	AccountRepository accountRepository;
	
//	public AccountService(){
//		accountRepository=new accountRepository();
//		currencyConverter= new CurrencyConverter();
//		jmsSender =  new JMSSender();
//		logger = new Logger();
//	}

	public AccountDTO createAccount(long accountNumber, String customerName) {
		Account account = new Account(accountNumber);
		Customer customer = new Customer(customerName);
		account.setCustomer(customer);
		AccountDTO accountDTO = AccountAdapter.getAccountDTOFromAccount(account);
//		accountDTO.setCustomer(CustomerAdapter.getCustomerDTOFromCustomer(customer));
		accountRepository.save(account);
		logger.log("createAccount with parameters accountNumber= "+accountNumber+" , customerName= "+customerName);
		return accountDTO;
	}

	public void deposit(long accountNumber, double amount) {
		Account account = accountRepository.findAccountByAccountnumber(accountNumber);
		account.deposit(amount);
		accountRepository.save(account);
		logger.log("deposit with parameters accountNumber= "+accountNumber+" , amount= "+amount);
		if (amount > 10000){
			jmsSender.sendJMSMessage("Deposit of $ "+amount+" to account with accountNumber= "+accountNumber);
		}
	}

	public AccountDTO getAccount(long accountNumber) {
		Account account = accountRepository.findAccountByAccountnumber(accountNumber);
		return AccountAdapter.getAccountDTOFromAccount(account);
	}

	public Collection<AccountDTO> getAllAccounts() {
		List<Account> accounts = accountRepository.findAll();
		Collection<AccountDTO> accountDTOS = new ArrayList<>();
		for (Account account:accounts){
			AccountDTO accountDTO = AccountAdapter.getAccountDTOFromAccount(account);
			accountDTO.setCustomer(CustomerAdapter.getCustomerDTOFromCustomer(account.getCustomer()));
			accountDTO.setEntryList(AccountEntryAdapter.getAccountEntryDTOsFromAccountEntries((List<AccountEntry>) account.getEntryList()));
			accountDTOS.add(accountDTO);
		}
		return accountDTOS;
	}

	public void withdraw(long accountNumber, double amount) {
		Account account = accountRepository.findAccountByAccountnumber(accountNumber);
		account.withdraw(amount);
		accountRepository.save(account);
		logger.log("withdraw with parameters accountNumber= "+accountNumber+" , amount= "+amount);
	}

	public void depositEuros(long accountNumber, double amount) {
		Account account = accountRepository.findAccountByAccountnumber(accountNumber);
		double amountDollars = currencyConverter.euroToDollars(amount);
		account.deposit(amountDollars);
		accountRepository.save(account);
		logger.log("depositEuros with parameters accountNumber= "+accountNumber+" , amount= "+amount);
		if (amountDollars > 10000){
			jmsSender.sendJMSMessage("Deposit of $ "+amount+" to account with accountNumber= "+accountNumber);
		}
	}

	public void withdrawEuros(long accountNumber, double amount) {
		Account account = accountRepository.findAccountByAccountnumber(accountNumber);
		double amountDollars = currencyConverter.euroToDollars(amount);
		account.withdraw(amountDollars);
		accountRepository.save(account);
		logger.log("withdrawEuros with parameters accountNumber= "+accountNumber+" , amount= "+amount);
	}

	public void transferFunds(long fromAccountNumber, long toAccountNumber, double amount, String description) {
		Account fromAccount = accountRepository.findAccountByAccountnumber(fromAccountNumber);
		Account toAccount = accountRepository.findAccountByAccountnumber(toAccountNumber);
		fromAccount.transferFunds(toAccount, amount, description);
		accountRepository.save(fromAccount);
		accountRepository.save(toAccount);
		logger.log("transferFunds with parameters fromAccountNumber= "+fromAccountNumber+" , toAccountNumber= "+toAccountNumber+" , amount= "+amount+" , description= "+description);
		if (amount > 10000){
			jmsSender.sendJMSMessage("TransferFunds of $ "+amount+" from account with accountNumber= "+fromAccount+" to account with accountNumber= "+toAccount);
		}
	}
}
