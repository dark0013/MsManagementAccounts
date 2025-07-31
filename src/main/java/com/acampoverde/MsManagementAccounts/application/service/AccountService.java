
package com.acampoverde.MsManagementAccounts.application.service;

import com.acampoverde.MsManagementAccounts.application.exception.AccountNotFoundException;
import com.acampoverde.MsManagementAccounts.domain.model.Account;
import com.acampoverde.MsManagementAccounts.domain.port.in.IAccountServicePort;
import com.acampoverde.MsManagementAccounts.domain.port.out.IAccountRepositoryPort;
import java.util.List;
import java.util.Optional;

public class AccountService implements IAccountServicePort {

    private final IAccountRepositoryPort accountRepository;

    public AccountService(IAccountRepositoryPort accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public List<Account> findAllAccount() {
        return this.accountRepository.findAllAccount();
    }

    @Override
    public Account findAccountById(Integer id) {
        return this.accountRepository.findAccountById(id).orElseThrow(() -> new AccountNotFoundException("NO ACCOUNT FOUND"));
    }

    @Override
    public Account findAccountNumberById(String accountNumber) {
        return this.accountRepository.findAccountNumberById(accountNumber).orElseThrow(() -> new AccountNotFoundException("NO ACCOUNT FOUND"));

    }

    @Override
    public Account saveAccount(Account account) {
        return this.accountRepository.saveAccount(account);
    }

    @Override
    public Account updateAccount(Account account) {
        return this.accountRepository.updateAccount(account);
    }

    @Override
    public void deleteAccount(Integer id) {
        this.accountRepository.deleteAccount(id);
    }

}
