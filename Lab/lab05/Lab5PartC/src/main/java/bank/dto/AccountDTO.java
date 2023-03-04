package bank.dto;

import bank.domain.AccountEntry;
import bank.domain.Customer;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

public class AccountDTO {
    private long accountNumber;

    Collection<AccountEntryDTO> entryList = new ArrayList<>();
    CustomerDTO customer;

    public AccountDTO(long accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getBalance() {
        double balance=0;
        for (AccountEntryDTO entry : entryList) {
            balance+=entry.getAmount();
        }
        return balance;
    }
    public long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(long accountNumber) {
        this.accountNumber = accountNumber;
    }

    public Collection<AccountEntryDTO> getEntryList() {
        return entryList;
    }

    public void setEntryList(Collection<AccountEntryDTO> entryList) {
        this.entryList = entryList;
    }

    public CustomerDTO getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerDTO customer) {
        this.customer = customer;
    }
}
