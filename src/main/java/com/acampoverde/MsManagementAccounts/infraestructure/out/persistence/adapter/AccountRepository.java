/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.acampoverde.MsManagementAccounts.infraestructure.out.persistence.adapter;

import com.acampoverde.MsManagementAccounts.domain.model.Account;
import com.acampoverde.MsManagementAccounts.domain.port.out.IAccountRepositoryPort;
import com.acampoverde.MsManagementAccounts.infraestructure.out.persistence.entity.AccountEntity;
import com.acampoverde.MsManagementAccounts.infraestructure.out.persistence.repository.IAccountRepository;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.stereotype.Repository;
import com.acampoverde.MsManagementAccounts.infraestructure.out.persistence.mapper.IAccountRepositoryMapper;


@Repository
public class AccountRepository implements IAccountRepositoryPort {

    private final IAccountRepository accountRepository;
    private final IAccountRepositoryMapper accountMapper;

    public AccountRepository(IAccountRepository accountRepository, IAccountRepositoryMapper accountMapper) {
        this.accountRepository = accountRepository;
        this.accountMapper = accountMapper;
    }

    @Override
    public List<Account> findAllAccount() {
        List<AccountEntity> accountEntity = accountRepository.findAll();
        return accountEntity.stream()
                .map(accountMapper::toDomain)
                .collect(Collectors.toList());

    }

    @Override
    public Optional<Account> findAccountById(Integer idCuenta) {
        Optional<AccountEntity> accountEntity = accountRepository.findById(idCuenta);
        return accountEntity.map(accountMapper::toDomain);
    }

    @Override
    public Optional<Account> findAccountNumberById(String accountNumber) {
        Optional<AccountEntity> accountEntity = accountRepository.findByAccountNumber(accountNumber);
        return accountEntity.map(accountMapper::toDomain);
    }

    @Override
    public Account saveAccount(Account account) {
        AccountEntity accountEntity = accountMapper.toEntity(account);
        AccountEntity saveEntity = accountRepository.save(accountEntity);
        return accountMapper.toDomain(saveEntity);
    }

    @Override
    public Account updateAccount(Account account) {
        Optional<AccountEntity> existingEntity = accountRepository.findById(account.getIdCuenta());
        if (existingEntity.isPresent()) {
            AccountEntity updateEntity = existingEntity.get();
            updateEntity.setAccountNumber(account.getAccountNumber());
            updateEntity.setAccountType(account.getAccountType());
            updateEntity.setInitialBalance(account.getInitialBalance());
            updateEntity.setStatus(account.getStatus());

            accountRepository.save(updateEntity);
            return accountMapper.toDomain(updateEntity);
        } else {
            throw new UnsupportedOperationException("ACCOUNT NOT FOUND.");
        }

    }

    @Override
    public void deleteAccount(Integer idCuenta) {
        accountRepository.deleteById(idCuenta);
    }

}
