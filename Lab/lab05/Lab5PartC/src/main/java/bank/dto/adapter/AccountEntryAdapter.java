package bank.dto.adapter;


import bank.domain.Account;
import bank.domain.AccountEntry;
import bank.dto.AccountDTO;
import bank.dto.AccountEntryDTO;

import java.util.ArrayList;
import java.util.List;

public class AccountEntryAdapter {
    public static AccountEntry getAccountFromAccountEntityDTO(AccountEntryDTO accountEntryDTO){
        return new AccountEntry(accountEntryDTO.getDate(),
                accountEntryDTO.getAmount(),
                accountEntryDTO.getDescription(),
                accountEntryDTO.getFromAccountNumber(),
                accountEntryDTO.getFromPersonName());

    }
    public static List<AccountEntryDTO> getAccountEntryDTOsFromAccountEntries(List<AccountEntry> accountEntries){
        List<AccountEntryDTO> accountEntryDTOS= new ArrayList<>();
        for (AccountEntry accountEntry: accountEntries){
            accountEntryDTOS.add(getAccountEntryDTOFromAccountEntry(accountEntry));
        }
        return accountEntryDTOS;
    }

    private static AccountEntryDTO getAccountEntryDTOFromAccountEntry(AccountEntry accountEntry) {
        return new AccountEntryDTO(accountEntry.getDate(),
                accountEntry.getAmount(),
                accountEntry.getDescription(),
                accountEntry.getFromAccountNumber(),
                accountEntry.getFromPersonName());
    }
}
